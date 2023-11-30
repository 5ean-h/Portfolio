#pragma once
#include "PlayableCharacter.h"

class Bob : public PlayableCharacter
{
private:
	bool m_IsMoving;
public:
	void barrier();
	Vector2f barrierPoint;
	void setBarrierPoint(Vector2f barrierPoint2);

	bool moving = true;
	bool barrierEnd = false;

	// A constructor specific to Bob
	Bob();

	// The overriden input handler for Bob
	bool handleInput();
};

