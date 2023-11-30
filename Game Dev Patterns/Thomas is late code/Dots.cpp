#include "stdafx.h"
#include "Dots.h"
#include "TextureHolder.h"
#include <iostream>

Dots::Dots()
{
	// Associate a texture with the sprite
	 /* m_Sprite = Sprite(TextureHolder::GetTexture(
		"graphics/player.png")); */
	m_Sprite = Sprite(TextureHolder::GetTexture(
		"graphics/pacman-spritesheet-resized-810-730.png"));
	m_Sprite.setTextureRect(sf::IntRect{ 12,472,29,29 });

}



