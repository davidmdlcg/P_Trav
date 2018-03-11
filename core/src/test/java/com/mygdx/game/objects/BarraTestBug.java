package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by david_000 on 27/02/2018.
 */
class BarraTestBug {


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

        barraParaTest = new Barra(10, 80);
    }

    // ESTE ES EL QUE FALLA
    @Test
    @DisplayName("La pala al pasarse del inferior de la pantalla de mueve a la y=1.0")
    void siLaBarraTocaBordeInferiorDePantallaMueveHaciaBordeSuperior(){
        Vector2 posicionInicialDondeTocaElBordeY = new Vector2(700,0);
        Vector2 posicionEsperada = new Vector2(700,1);
        barraParaTest.setPosition(posicionInicialDondeTocaElBordeY.cpy());
        barraParaTest.update(tiempoEntreCiclo);
        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionActual, posicionEsperada);
    }


    @Test
    @DisplayName("La pala al pasarse del borde superior de la pantalla de mueve a la y=1.0")
    void siLaBarraTocaBordeSuperiorDePantallaMueveHaciaBordeInferior(){
        Vector2 posicionInicialDondeTocaElBordeY = new Vector2(700,2500);
        Vector2 posicionEsperada = new Vector2(700,1);
        barraParaTest.setPosition(posicionInicialDondeTocaElBordeY.cpy());
        barraParaTest.update(tiempoEntreCiclo);
        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionActual, posicionEsperada);
    }

    // EL que falla
    @Test
    @DisplayName("La pala al pasarse del borde Derecho (x=-1) de la pantalla se queda donde esta (x=0)")
    void siLaBarraTocaBordeDerechoDePantallaMueveHaciaBordeIzquierdo(){
        Vector2 posicionInicialDondeTocaElBordeX = new Vector2(-1,1200);
        Vector2 posicionEsperada = new Vector2(1,1200);
        barraParaTest.setPosition(posicionInicialDondeTocaElBordeX.cpy());
        barraParaTest.update(tiempoEntreCiclo);
        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionActual, posicionEsperada);
    }

    @Test
    @DisplayName("La pala al pasarse del borde Izquierdo (x=1440) de la pantalla de mueve al borde derecho (x=1)")
    void siLaBarraTocaBordeIzquierdoDePantallaMueveHaciaBordeDerecho(){
        Vector2 posicionInicialDondeTocaElBordeX = new Vector2(1440,1200);
        Vector2 posicionEsperada = new Vector2(1,1200);
        barraParaTest.setPosition(posicionInicialDondeTocaElBordeX.cpy());
        barraParaTest.update(tiempoEntreCiclo);
        Vector2 posicionActual = barraParaTest.getPosition();
        assertEquals(posicionActual, posicionEsperada);
    }





}


