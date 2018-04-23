package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Barra extends FiguraGrafica {
    private int width;
    private int height;

    public Barra(int width, int height) {
        super();
        this.setPosition(new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2));     //la posicion de las palas
        setVelocity(new Vector2(0,0));    //la velociadad de las pals

        this.height = height;           //la altura de la pala
        this.width = width;             //la anchura de la pala
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void update(float delta){
        super.update(delta);
        cambiarPosicionYSiLimite(delta);
    }

    protected void chocarEnX(float delta) {
        if (this.getPosition().x > -1) {//si la pala esta a la izquierda de la pala la pinta
            if (this.getVelocity().x < 0) {//si la pala se mueve la pinta
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getPosition().x =(float)Gdx.graphics.getWidth() - this.width;
            getPosition().add(getVelocity().cpy().scl(delta));

        }
        if (this.getPosition().x + this.width < Gdx.graphics.getWidth()) {// si la pala esta a la derecha de la pala la pinta
            if (this.getVelocity().x > 0) {//si la pala se mueve la pinte
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getPosition().x = 1;
            getPosition().add(getVelocity().cpy().scl(delta));
        }
    }

    protected void chocarEnY(float delta) {
        if (this.getY() >= -1) {//si la parte de arriba de la pala es menor que 0 pinta la bola
            if (this.getVelocity().y < 0) {//si la pala se mueve que la pinte
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.setY((float) Gdx.graphics.getHeight()-this.height);
            getPosition().add(getVelocity().cpy().scl(delta));
        }
        if (this.getY() + this.height < Gdx.graphics.getHeight()) {//si la parte de abajo de la pala es amyor que la altura la pinta
            if (this.getVelocity().y > 0) {//si la pala se mueve pinta la bola
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.setY(1);
            getPosition().add(getVelocity().cpy().scl(delta));
        }
    }

    private void cambiarPosicionYSiLimite(float delta) {
        if(this.getPosition().y == 0){
            this.getPosition().y =(float)Gdx.graphics.getWidth() - this.width;
            getPosition().add(getVelocity().cpy().scl(delta));
        }
    }





}
