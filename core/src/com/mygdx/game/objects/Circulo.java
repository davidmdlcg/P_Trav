package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Circulo extends FiguraGrafica{

    private int radio;
    private Color balColor = Color.GREEN;



    public Circulo(int radio) {
        super();
        this.setPosition(new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2));    //la posicion actual de la bola --el centro de la pantalla--
        this.setVelocity( new Vector2((Gdx.graphics.getWidth()+Gdx.graphics.getHeight())/8,(Gdx.graphics.getWidth()+Gdx.graphics.getHeight())/10)); //pone velocidad aleatoria

        this.radio= radio;      //radio de la bola
    }

    protected void chocarEnX(float delta) {
        if (this.getX() > 0) {//si la bola esta a la izquierda de la pala la pinta
            if (this.getVelocity().x < 0) {//si la bola se mueve la pinta
                this.setX(1);
                this.getPosition().add(this.getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getVelocity().x = -this.getVelocity().x;
            this.getPosition().add(getVelocity().cpy().scl(delta));

        }
        if (this.getPosition().x + this.radio < Gdx.graphics.getWidth()) {// si la bola esta a la derecha de la pala la pinta
            if (this.getVelocity().x > 0) {//si la bola se mueve la pinta
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getVelocity().x = -this.getVelocity().x;
            getPosition().add(getVelocity().cpy().scl(delta));
        }
    }

    protected void chocarEnY(float delta) {
        if (this.getPosition().y > 0) {//si la parte de arriba de la bola es menor que 0 pinta la bola
            if (this.getVelocity().y < 0) {//si la bola se mueve que la pinte
                this.getPosition().y = 1;
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getVelocity().y = -this.getVelocity().y;
            getPosition().add(getVelocity().cpy().scl(delta));
        }


        if (this.getPosition().y + this.radio < Gdx.graphics.getHeight()) {//si la parte de abajo de la bola es amyor que la altura la pinta
            if (this.getVelocity().y > 0) {//si la bola se mueve pinta la bola
                getPosition().add(getVelocity().cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.getVelocity().y = -this.getVelocity().y;
            getPosition().add(getVelocity().cpy().scl(delta));
        }
    }

    public void setBalColor(Color balColor) {
        this.balColor = balColor;
    }

    public Color getBalColor() {
        return balColor;
    }

    public int getRadio() {
        return radio;
    }
}
