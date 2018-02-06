package com.mygdx.game.gameworld;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.objects.Barra;
import com.mygdx.game.objects.Circulo;

import java.util.LinkedList;

public class GameWorld extends ApplicationAdapter{

    private int width;
    private int height;
    private Barra bar;
    private Circulo bol;
    private int vida=5;
    private LinkedList<Barra> barras = new LinkedList<Barra>();
    int anchoB;
    int anchoH;



    public GameWorld(){
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        anchoB=this.width/70;
        anchoH=this.height/6;

        //



//crea una barra le pasa --orden-- (la posicion en x, posicion y, ancho de la pala, altura de la pala,altura de la pantalla)
        this.bar = new Barra(anchoB,anchoH);

/*crea la bola le pasa --orden-- (radio de la bola, la pala, altura de la pala*/
        this.bol= new Circulo((this.height+this.width)/80);
    }

    public void update(float delta) {

        for (Barra bar: barras){
            bar.update(delta);
        }

        bar.update(delta);
        bol.update(delta);

        for (Barra bar: barras) {
            bar.update(delta);

            comprobarColicion(bar, this.bol);
        }
    }

    public void Disparo(){
        barras.addLast(new Barra(this.anchoB/2,this.anchoH/3));
        barras.getLast().setX(bar.getX());
        barras.getLast().setY(bar.getY()+anchoB);
        barras.getLast().setVelocity(0,-((Gdx.graphics.getWidth()+Gdx.graphics.getHeight())/8));
        this.vida = this.vida - 1;
    }


    public void comprobarColicion(Barra Bala, Circulo bola) {
        if ((colicion(bola, Bala))) {
            bol.setBalColor(Color.RED);



        } else if ((vida <= 0) && ((barras.getLast().getY()) < 5)) {
            bol.setBalColor(Color.GREEN);
            vida = 5;
        } else if (((barras.getLast().getY()) < 5) || (((barras.getLast().getY()) > height - 5))) {
            barras.remove(barras.getFirst());

        }
    }

    public boolean colicion(Circulo bal, Barra bar){
        //no chocar en el con la barra
        return Intersector.overlaps(new Circle(bal.getPosition().x, bal.getPosition().y, bal.getRadio()), new Rectangle(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight()));
    }

    public int getVida() {
        return vida;
    }

    public Circulo getBol() {
        return bol;
    }

    public Barra getBar(){
        return bar;
    }

    public LinkedList<Barra> getBarrasList(){
        return barras;
    }

}


