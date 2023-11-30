#include "stdafx.h"
#include "Keys.h"
#include "TextureHolder.h"
#include <iostream>

Keys::Keys()
{
	// Associate a texture with the sprite
	m_Sprite = Sprite(TextureHolder::GetTexture("graphics/key.png"));
}

