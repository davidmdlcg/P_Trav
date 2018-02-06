package com.mygdx.game.game;


import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;

public class Pong extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());

    }
}
