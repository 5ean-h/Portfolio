#include "stdafx.h"
#include "Engine.h"
#include <SFML/Graphics.hpp>
#include <sstream>
#include <iostream>

using namespace sf;

void Engine::update(float dtAsSeconds)
{
	if (m_NewLevelRequired)
	{
		// These calls to spawn will be moved to a new
		// LoadLevel function soon
		// Spawn Thomas and Bob
		//m_Thomas.spawn(Vector2f(0,0), GRAVITY);
		//m_Bob.spawn(Vector2f(100, 0), GRAVITY);

		// Make sure spawn is called only once
		//m_TimeRemaining = 10;
		//m_NewLevelRequired = false;

		// Load a level
		loadLevel();
		
	}

	if (m_Playing)
	{
		ScoreText.setString(scoreStream.str());
		// Update Thomas
		m_Thomas.update(dtAsSeconds);

		// Update Bob
		m_Bob.update(dtAsSeconds);

		// Detect collisions and see if characters have reached the goal tile
		// The second part of the if condition is only executed
		// when thomas is touching the home tile
		if (detectCollisions(m_Thomas))
		{
			// New level required
			m_NewLevelRequired = true;

			// Play the reach goal sound
			m_SM.playReachGoal();

		}
		
		//erase dots if they intersect with thomas
		
		std::list<PlayableCharacter>::iterator it;

		for (it = m_DotsList.begin(); it != m_DotsList.end();) 
		{

			if (m_Thomas.getPosition().intersects((it)->getPosition()))
			{
				//Dec 14th 2021 calc distance d between the 2 points
				//if distance close remove the dot
				int x1 = m_Thomas.getPosition().left;
				int y1 = m_Thomas.getPosition().top;
				int x2 = (it)->getPosition().left;
				int y2 = (it)->getPosition().top;
				int xsquared = (x2 - x1) * (x2 - x1);
				int ysquared = (y2 - y1) * (y2 - y1);
				double d = sqrt(xsquared + ysquared);
				
				if (d < 1000)
				{
					cout << " dot x2 is " << x2 << " dot y2 is " << y2 << "\n";
					m_DotsList.erase(it++);
					Score++;
					cout << "Erasing dot score is" << Score << "\n";
					scoreStream.str("");
					scoreStream << "Score : " << Score;


				}
				else
				{
					++it;
				}
			}
			else
			{
				++it;
			}

		}

		for (it = m_CoinsList.begin(); it != m_CoinsList.end();)
		{

			if (m_Thomas.getPosition().intersects((it)->getPosition()))
			{
				//Dec 14th 2021 calc distance d between the 2 points
				//if distance is  close remove the coin
				int x1 = m_Thomas.getPosition().left;
				int y1 = m_Thomas.getPosition().top;
				int x2 = (it)->getPosition().left;
				int y2 = (it)->getPosition().top;
				int xsquared = (x2 - x1) * (x2 - x1);
				int ysquared = (y2 - y1) * (y2 - y1);
				double d = sqrt(xsquared + ysquared);

				if (d < 1000)
				{
					cout << " coin x2 is " << x2 << " coin y2 is " << y2 << "\n";
					m_CoinsList.erase(it++);
					Score = Score + 10;
					cout << "Erasing coin score is" << Score << "\n";
					scoreStream.str("");
					scoreStream << "Score : " << Score;


				}
				else
				{
					++it;
				}
			}
			else
			{
				++it;
			}

		}

		for (it = m_KeysList.begin(); it != m_KeysList.end();)
		{

			if (m_Thomas.getPosition().intersects((it)->getPosition()))
			{
				//Dec 14th 2021 calc distance d between the 2 points
				//if distance is  close remove the key
				int x1 = m_Thomas.getPosition().left;
				int y1 = m_Thomas.getPosition().top;
				int x2 = (it)->getPosition().left;
				int y2 = (it)->getPosition().top;
				int xsquared = (x2 - x1) * (x2 - x1);
				int ysquared = (y2 - y1) * (y2 - y1);
				double d = sqrt(xsquared + ysquared);

				if (d < 1000)
				{
					cout << " Key x2 is " << x2 << " Key y2 is " << y2 << "\n";
					m_KeysList.erase(it++);
					Score = Score + 20;
					cout << "Erasing Key score is" << Score << "\n";
					scoreStream.str("");
					scoreStream << "Score : " << Score;


				}
				else
				{
					++it;
				}
			}
			else
			{
				++it;
			}

		}

		
		// Count down the time the player has left
		m_TimeRemaining -= dtAsSeconds;

		// Have Thomas and Bob run out of time?
		if (m_TimeRemaining <= 0)
		{
			m_NewLevelRequired = true;
		}

	}// End if playing



	// Check if a fire sound needs to be played
	vector<Vector2f>::iterator it;

	// Iterate through the vector of Vector2f objects
	for (it = m_FireEmitters.begin(); it != m_FireEmitters.end(); it++)
	{
		// Where is this emitter?
		// Store the location in pos
		float posX = (*it).x;
		float posY = (*it).y;

		// is the emiter near the player?
		// Make a 500 pixel rectangle around the emitter
		FloatRect localRect(posX - 250, posY - 250, 500, 500);

		// Is the player inside localRect?
		if (m_Thomas.getPosition().intersects(localRect))
		{
			// Play the sound and pass in the location as well
			m_SM.playFire(Vector2f(posX, posY), m_Thomas.getCenter());
		}
	}
		
	// Set the appropriate view around the appropriate character
	if (m_SplitScreen)
	{
		m_LeftView.setCenter(m_Thomas.getCenter());
	}
	else
	{
		// Centre full screen around appropriate character
		if (m_Character1)
		{
			m_MainView.setCenter(m_Thomas.getCenter());
		}
		
	}

	// Time to update the HUD?
	// Increment the number of frames since the last HUD calculation
	m_FramesSinceLastHUDUpdate++;

	// Update the HUD every m_TargetFramesPerHUDUpdate frames
	if (m_FramesSinceLastHUDUpdate > m_TargetFramesPerHUDUpdate)
	{
		// Update game HUD text
		stringstream ssTime;
		stringstream ssLevel;

		// Update the time text
		ssTime << (int)m_TimeRemaining;
		m_Hud.setTime(ssTime.str());

		// Update the level text
		ssLevel << "Level:" << m_LM.getCurrentLevel();
		m_Hud.setLevel(ssLevel.str());

		m_FramesSinceLastHUDUpdate = 0;
	}

	// Update the particles
	if (m_PS.running())
	{
		m_PS.update(dtAsSeconds);
	}
}// End of update function