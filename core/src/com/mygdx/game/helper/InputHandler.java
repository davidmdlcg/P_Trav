package com.mygdx.game.helper;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.objects.Barra;

public class InputHandler implements InputProcessor {
    private Barra myBar;
    private int hieght;
    private Touchpad touchpad;
    private float blockSpeed;
    public InputHandler(Barra bar ){
        blockSpeed =50;
        myBar = bar;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //Move blockSprite with TouchPad;


        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
