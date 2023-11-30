#include "stdafx.h"
#include "Bob.h"
#include "TextureHolder.h"

Bob::Bob()
{
	// Associate a texture with the sprite
	m_Sprite = Sprite(TextureHolder::GetTexture(
		"graphics/bob.png"));

	m_JumpDuration = .25;
}

void Bob::setBarrierPoint(Vector2f barrierPoint2)
{
	barrierPoint = barrierPoint2;
}

void Bob::barrier()
{
	if(moving && !barrierEnd && m_Position.x > barrierPoint.x + 300)
	{
		barrierEnd = true;
	}

	if(moving && barrierEnd && m_Position.x < barrierPoint.x - 300)
	{
		barrierEnd = false;
	}

}

bool Bob::handleInput()
{
	barrier();

	if (moving && barrierEnd)
	{
		m_LeftPressed = true;
	}
	else
	{
		m_LeftPressed = false;
	}
	
	if (moving && !barrierEnd)
	{
		m_RightPressed = true;
	}
	else
	{
		m_RightPressed = false;
	}
	

	return m_JustJumped;
}