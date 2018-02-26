package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.gameworld.GameRenderer;
import com.mygdx.game.gameworld.GameWorld;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        world = new GameWorld();
        renderer = new GameRenderer(world,screenWidth,screenHeight);

    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        // No es necesario hacer nada es este estado de la aplicacion

    }

    @Override
    public void resize(int width, int height) {
        // No es necesario hacer nada es este estado de la aplicacion

    }

    @Override
    public void pause() {
        // No es necesario hacer nada es este estado de la aplicacion

    }

    @Override
    public void resume() {
        // No es necesario hacer nada es este estado de la aplicacion

    }

    @Override
    public void hide() {
        // No es necesario hacer nada es este estado de la aplicacion

    }

    @Override
    public void dispose() {
        // No es necesario hacer nada es este estado de la aplicacion

    }
}
