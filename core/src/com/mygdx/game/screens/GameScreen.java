package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.gameworld.GameRenderer;
import com.mygdx.game.gameworld.GameWorld;
import com.mygdx.game.helper.InputHandler;
import com.mygdx.game.objects.Barra;
import com.mygdx.game.objects.Circulo;

import java.util.LinkedList;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;
    private InputHandler inputHandler;

    public GameScreen() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        world = new GameWorld();
        renderer = new GameRenderer(world,screenWidth,screenHeight);

        LinkedList<Barra> barras = world.getBarrasList();

        Barra bar = world.getBar();
        Circulo bol = world.getBol();
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
