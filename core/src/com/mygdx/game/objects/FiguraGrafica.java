package com.mygdx.game.objects;

import com.badlogic.gdx.math.Vector2;


abstract class FiguraGrafica {


    private Vector2 position;
    private Vector2 velocity;

    FiguraGrafica() {

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
