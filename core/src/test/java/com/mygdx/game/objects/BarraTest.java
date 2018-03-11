package com.mygdx.game.objects;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by david_000 on 27/02/2018.
 */
class BarraTest {


    Barra barraParaTest;

    float tiempoEntreCiclo = 100;


    // Before running any tests, initialize the application with the headless backend
    @BeforeAll
    public static void inicializarPantalla_1440x2560() {

        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(1440);
        when(Gdx.graphics.getHeight()).thenReturn(2560);
    }

    @BeforeEach
    void setUp() {

        barraParaTest = new Barra(200, 100);
    }



    @Test
    @DisplayName("Comprueba que la pala no cambia de posicion si no toca ningun borde de la pantalla")
    void siLaBarraNoTocaBordeDePantallaNoCambiaSuPosicion(){
        Vector2 posicionDondeTocaElBordeX = new Vector2(400,400);
        Vector2 moverDireccionAbajo = new Vector2(100,0);

        barraParaTest.setPosition(posicionDondeTocaElBordeX);
        barraParaTest.setVelocity(moverDireccionAbajo);

        barraParaTest.update(tiempoEntreCiclo);

        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionDondeTocaElBordeX, posicionActual);
    }


    @Test
    @DisplayName("Comprueba que la pala no cambia de posicion si toca ningun borde de la pantalla")
    void siLaBarraTocaBordeDePantallaNoCambiaSuPosicion(){
        Vector2 posicionDondeTocaElBordeX = new Vector2(0,0);
        Vector2 moverDireccionAbajo = new Vector2(-100,-100);

        barraParaTest.setPosition(posicionDondeTocaElBordeX);
        barraParaTest.setVelocity(moverDireccionAbajo);

        barraParaTest.update(tiempoEntreCiclo);

        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionDondeTocaElBordeX, posicionActual);
    }

    @Test
    @DisplayName("Comprueba que la pala no cambia de posicion si toca ningun borde de la pantalla")
    void siLaBarraCasiTocaBordeDePantallaNoCambiaSuPosicion(){
        Vector2 posicionDondeTocaElBordeX = new Vector2(15,15);
        Vector2 moverDireccionAbajo = new Vector2(-100,-100);

        barraParaTest.setPosition(posicionDondeTocaElBordeX);
        barraParaTest.setVelocity(moverDireccionAbajo);

        barraParaTest.update(tiempoEntreCiclo);

        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionDondeTocaElBordeX, posicionActual);
    }

    @Disabled
    @Test
    @DisplayName("Comprueba que la pala no cambia de posicion si toca ningun borde de la pantalla")
    void FALLAsiLaBarraCasiTocaBordeDePantallaNoCambiaSuPosicion(){
        Vector2 posicionDondeTocaElBordeX = new Vector2(15,15);
        Vector2 moverDireccionAbajo = new Vector2(-100,-100);

        barraParaTest.setPosition(posicionDondeTocaElBordeX);
        barraParaTest.setVelocity(moverDireccionAbajo);

        barraParaTest.update(tiempoEntreCiclo);

        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionDondeTocaElBordeX, -574);
    }

}


