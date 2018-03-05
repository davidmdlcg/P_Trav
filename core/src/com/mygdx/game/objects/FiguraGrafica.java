package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by DvdMACAir on 26/2/18.
 */

abstract class FiguraGrafica {

    protected int heightT;
    protected int widhtT;
    private Vector2 position;
    private Vector2 velocity;

    FiguraGrafica() {
        this.widhtT= Gdx.graphics.getWidth();
        this.heightT = Gdx.graphics.getHeight();     //la altura de la pantalla
    }


    public void update(float delta) {
        chocarEnY(delta);
        chocarEnX(delta);

    }


    protected abstract void chocarEnX(float delta);

    protected abstract void chocarEnY(float delta);

    public float getX() {
        return getPosition().x;
    }

    public float getY() {
        return getPosition().y;
    }


    public void setX(float x) {

        this.getPosition().x = x;
    }

    public void updateX(float x) {
        this.getPosition().x += x;
    }

    public void setY(float y) {
        this.getPosition().y = y;
    }

    public void setVelocity(int x, int y) {
        this.getVelocity().x = x;
        this.getVelocity().y = y;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
