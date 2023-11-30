#include "stdafx.h"
#include "Engine.h"

void Engine::loadLevel()
{
	m_Playing = false;

	// Delete the previously allocated memory
	for (int i = 0; i < m_LM.getLevelSize().y; ++i)
	{
		delete[] m_ArrayLevel[i];

	}
	delete[] m_ArrayLevel;

	// Load the next 2d array with the map for the level
	// And repopulate the vertex array as well
	m_ArrayLevel = m_LM.nextLevel(m_VALevel);

	for (int i = 0; i < m_LM.getLevelSpawningPointsSize().y; ++i)
	{
		delete[] m_ArraySpawningPointsLevel[i];

	}
	delete[] m_ArraySpawningPointsLevel;

	// load spawning points data
	//analyse 2d array for location of dots
	//add dots to a list
	// each dot is an allocated object with a vector2f position
	// e.g. if a dot is in cell 6,8 then its x loc is 6*50+ 11 = 311
	// its y value is 8*50+11=411
	m_ArraySpawningPointsLevel = m_LM.nextLevelSpawningPoints();
	for (int x = 0; x < m_LM.getLevelSpawningPointsSize().x; x++)
	{
		for (int y = 0; y < m_LM.getLevelSpawningPointsSize().y; y++)
		{


			// check to see if its a dot (type 6)
			int artefact = m_ArraySpawningPointsLevel[y][x];
			if (artefact == 6)
			{
				//create a dot object , this calls the Dot constructor
				Dots t_Dot;
				int locx = (x * 50) + 11;
				int locy = (y * 50) + 11;

				//set the Dot location
				t_Dot.spawn(Vector2f(locx, locy), GRAVITY);

				//add to the list
				m_DotsList.push_back(t_Dot);
			}

			// check to see if its a dot (type 7)
			if (artefact == 7)
			{
				//create a dot object , this calls the Dot constructor
				Coins t_Coin;
				int locx = (x * 50) + 11;
				int locy = (y * 50) + 11;

				//set the Dot location
				t_Coin.spawn(Vector2f(locx, locy), GRAVITY);

				//add to the list
				m_CoinsList.push_back(t_Coin);
			}

			// check to see if its a dot (type 8)
			if (artefact == 8)
			{
				//create a dot object , this calls the Dot constructor
				Keys t_Key;
				int locx = (x * 50) + 11;
				int locy = (y * 50) + 11;

				//set the Dot location
				t_Key.spawn(Vector2f(locx, locy), GRAVITY);

				//add to the list
				m_KeysList.push_back(t_Key);
			}

		}
	}

	// Prepare the sound emitters
	populateEmitters(m_FireEmitters, m_ArrayLevel);

	// How long is this new time limit
	m_TimeRemaining = m_LM.getTimeLimit();

	// Spawn Thomas and Bob
	m_Thomas.spawn(m_LM.getStartPosition(), GRAVITY);
	m_Bob.spawn(m_LM.bobPosition(), GRAVITY);

	// Make sure this code isn't run again
	m_NewLevelRequired = false;
}