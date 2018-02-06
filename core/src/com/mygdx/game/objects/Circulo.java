package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Circulo {
    private Vector2 position;
    private Vector2 velocity;
    private int radio;
    private int height;
    private int widht;
    private Color balColor = Color.GREEN;


    public Circulo(int radio) {


        this.position =new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);    //la posicion actual de la bola --el centro de la pantalla--
        velocity = new Vector2((Gdx.graphics.getWidth()+Gdx.graphics.getHeight())/8,(Gdx.graphics.getWidth()+Gdx.graphics.getHeight())/10); //pone velocidad aleatoria

        this.radio= radio;      //radio de la bola
        this.height=Gdx.graphics.getHeight();     //altura de la pantalla
        this.widht = Gdx.graphics.getWidth();     //anchura de la pantalla
    }

    public void update(float delta) {

        //no chocar en el y
        if (this.position.y > 0) {//si la parte de arriba de la bola es menor que 0 pinta la bola
            if (this.velocity.y < 0) {//si la bola se mueve que la pinte
                this.position.y = 1;
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.velocity.y = -this.velocity.y;
            position.add(velocity.cpy().scl(delta));
        }


        if (this.position.y + this.radio < this.height) {//si la parte de abajo de la bola es amyor que la altura la pinta
            if (this.velocity.y > 0) {//si la bola se mueve pinta la bola
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.velocity.y = -this.velocity.y;
            position.add(velocity.cpy().scl(delta));
        }

        //no chocar en el X
        if (this.position.x > 0) {//si la bola esta a la izquierda de la pala la pinta
            if (this.velocity.x < 0) {//si la bola se mueve la pinta
                this.position.x = 1;
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.velocity.x = -this.velocity.x;
            position.add(velocity.cpy().scl(delta));

        }
        if (this.position.x + this.radio < this.widht) {// si la bola esta a la derecha de la pala la pinta
            if (this.velocity.x > 0) {//si la bola se mueve la pinta
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.velocity.x = -this.velocity.x;
            position.add(velocity.cpy().scl(delta));
        }

    }

    public void setBalColor(Color balColor) {
        this.balColor = balColor;
    }

    public Color getBalColor() {
        return balColor;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getRadio() {
        return radio;
    }
}
