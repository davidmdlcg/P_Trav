package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Barra {
    private Vector2 position;
    private Vector2 velocity;
    private int width;
    private int height;
    private int heightT;
    private int widhtT;


    
    public Barra(int width, int height) {
        this.position =new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);     //la posicion de las palas
        velocity = new Vector2(0,0);    //la velociadad de las pals
        this.width = width;             //la anchura de la pala
        this.height = height;           //la altura de la pala
        this.heightT = Gdx.graphics.getHeight();     //la altura de la pantalla
        this.widhtT= Gdx.graphics.getWidth();
    }

    public void update(float delta) {

        //no chocar en el y
        if (this.position.y >= -1) {//si la parte de arriba de la pala es menor que 0 pinta la bola
            if (this.velocity.y < 0) {//si la pala se mueve que la pinte
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.position.y = Gdx.graphics.getHeight()-this.height;
            position.add(velocity.cpy().scl(delta));
        }


        if (this.position.y + this.height < this.heightT) {//si la parte de abajo de la pala es amyor que la altura la pinta
            if (this.velocity.y > 0) {//si la pala se mueve pinta la bola
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.position.y = 1;
            position.add(velocity.cpy().scl(delta));
        }

        //no chocar en el X
        if (this.position.x > -1) {//si la pala esta a la izquierda de la pala la pinta
            if (this.velocity.x < 0) {//si la pala se mueve la pinta
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.position.x =this.widhtT - this.width;
            position.add(velocity.cpy().scl(delta));

        }
        if (this.position.x + this.width < this.widhtT) {// si la pala esta a la derecha de la pala la pinta
            if (this.velocity.x > 0) {//si la pala se mueve la pinte
                position.add(velocity.cpy().scl(delta));
            }
        } else {//si no es ninguna la velocidad actual se convierte en la contraria y la pinta
            this.position.x = 1;
            position.add(velocity.cpy().scl(delta));
        }

        if(this.position.y == 0){
            this.position.y =this.widhtT - this.width;
            position.add(velocity.cpy().scl(delta));
        }

    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void dispose(){
        velocity.y=0;
    }

    public void setX(float x) {

        this.position.x = x;
    }

    public void setY(float y) {
        this.position.y = y;
    }

    public void setVelocity(int x, int y) {
        this.velocity.x = x;
        this.velocity.y = y;
    }
}
