#include "stdafx.h"
#include "Coins.h"
#include "TextureHolder.h"
#include <iostream>

Coins::Coins()
{
	// Associate a texture with the sprite
	m_Sprite = Sprite(TextureHolder::GetTexture(
		"graphics/coin.png"));
}



