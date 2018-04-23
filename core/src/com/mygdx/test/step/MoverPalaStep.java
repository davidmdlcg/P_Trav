package com.mygdx.test.step;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.game.Pong;
import com.mygdx.game.gameworld.GameRenderer;
import com.mygdx.game.gameworld.GameWorld;
import com.mygdx.game.screens.GameScreen;

import org.junit.Assert;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;
import sun.java2d.pipe.SpanShapeRenderer;

import static org.mockito.Mockito.when;


public class MoverPalaStep {

    private GameWorld gameWold;
    private GameRenderer gameRenderer;
    private int screenWidth=1440;
    private int screenHeight=2560;
    private int desplazamientoDesdeCentro=500;
    private float bordeDerecho=1f;
    private float bordeIzquierdo=screenWidth;
    private float bordeInferior=1f;
    private float bordeSuperior=screenHeight;
    private Vector2 screenCenter;

    private void mockGL(){
        if (Gdx.gl20 == null) {
            Gdx.gl20 = Mockito.mock(GL20.class);
            Gdx.gl = Gdx.gl20;
            Gdx.graphics = Mockito.mock(Graphics.class);
            when(Gdx.graphics.getWidth()).thenReturn(screenWidth);
            when(Gdx.graphics.getHeight()).thenReturn(screenHeight);
        }

        Gdx.files = Mockito.mock(Files.class);

        Gdx.app = Mockito.mock(Application.class);
        Gdx.input = Mockito.mock(Input.class);


    }

    private OrthographicCamera mockCamera(){
        return Mockito.mock(OrthographicCamera.class);
    }

    private void inicializarMundo(){
        mockGL();
        gameWold =new GameWorld();
        gameRenderer = new GameRenderer(gameWold, screenWidth, screenHeight,mockCamera(),Mockito.mock(ShapeRenderer.class), Mockito.mock(SpriteBatch.class), Mockito.mock(BitmapFont.class),Mockito.mock(Texture.class), Mockito.mock(Drawable.class),Mockito.mock(TextureRegionDrawable.class), Mockito.mock(Stage.class));
    }

    private void accederAKnob(Touchpad touchpad) throws NoSuchFieldException, IllegalAccessException {
        Field field = Touchpad.class.getDeclaredField("knobPercent");
        field.setAccessible(true);
        field.set(touchpad, new Vector2(100,100));

    }

    private void moverJoystick(int x,int y){

        InputEvent inputEvent = new InputEvent();

        inputEvent.setType(InputEvent.Type.touchDown);

        inputEvent.setStageX(x);
        inputEvent.setStageY(y);

        gameRenderer.touchpad.layout();

        try {
            gameRenderer.touchpad.fire(inputEvent);
        }catch (NullPointerException ex){

        }

    }

    private boolean seHaMovidoALaIzquierda(Vector2 anterior,Vector2 actual){
        return anterior.x<actual.x;
    }

    private boolean seHaMovidoALaDerecha(Vector2 anterior,Vector2 actual){
        return anterior.x>actual.x;
    }

    private boolean seHaMovidoHaciaArriba(Vector2 anterior,Vector2 actual){
        return anterior.y>actual.y;
    }

    private boolean seHaMovidoHaciaAbajo(Vector2 anterior,Vector2 actual){
        return anterior.y<actual.y;
    }


    @Given("^un palo en el centro de la pantalla$")
    public void un_palo_en_el_centro_de_la_pantalla() {
        screenCenter = new Vector2(screenWidth/2,screenHeight/2);
        inicializarMundo();
        gameWold.getBar().setPosition(screenCenter);
    }

    @When("^muevo el joystick hacia la izquierda$")
    public void muevo_el_joystick_hacia_la_izquierda() throws Exception {
        moverJoystick(desplazamientoDesdeCentro,0);
    }

    @Then("^el palo se desplaza hacia la izquierda$")
    public void el_palo_se_desplaza_hacia_la_izquierda() {
        Vector2 posicionAnterior;
        Vector2 posicionFinal;

        posicionAnterior=gameWold.getBar().getPosition().cpy();
        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();

        Assert.assertTrue(seHaMovidoALaIzquierda(posicionAnterior,posicionFinal));

    }

    @When("^muevo el joystick hacia la derecha$")
    public void muevo_el_joystick_hacia_la_derecha() {
        moverJoystick(-desplazamientoDesdeCentro,0);
    }

    @Then("^el palo se desplaza hacia la derecha$")
    public void el_palo_se_desplaza_hacia_la_derecha() {

        Vector2 posicionAnterior;
        Vector2 posicionFinal;

        posicionAnterior=gameWold.getBar().getPosition().cpy();
        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();

        Assert.assertTrue(seHaMovidoALaDerecha(posicionAnterior,posicionFinal));

    }

    @When("^muevo el joystick hacia la arriba$")
    public void muevo_el_joystick_hacia_la_arriba() {
        // Write code here that turns the phrase above into concrete actions
        moverJoystick(0,desplazamientoDesdeCentro);
    }

    @Then("^el palo se desplaza hacia la arriba$")
    public void el_palo_se_desplaza_hacia_la_arriba() {
        Vector2 posicionAnterior;
        Vector2 posicionFinal;

        posicionAnterior=gameWold.getBar().getPosition().cpy();
        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();

        Assert.assertTrue(seHaMovidoHaciaArriba(posicionAnterior,posicionFinal));

    }

    @When("^muevo el joystick hacia la abajo$")
    public void muevo_el_joystick_hacia_la_abajo() {
        // Write code here that turns the phrase above into concrete actions
        moverJoystick(0,-desplazamientoDesdeCentro);
    }

    @Then("^el palo se desplaza hacia la abajo$")
    public void el_palo_se_desplaza_hacia_la_abajo() {
        Vector2 posicionAnterior;
        Vector2 posicionFinal;

        posicionAnterior=gameWold.getBar().getPosition().cpy();
        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();

        Assert.assertTrue(seHaMovidoHaciaAbajo(posicionAnterior,posicionFinal));
    }

    @Given("^un palo en el limite izquierdo de la pantalla$")
    public void un_palo_en_el_limite_izquierdo_de_la_pantalla() {
        screenCenter = new Vector2(screenWidth/2,screenHeight/2);
        inicializarMundo();
        gameWold.getBar().setPosition(new Vector2(bordeIzquierdo,screenHeight/2));
    }

    @Then("^el palo se desplaza hacia el borde derecho de la pantalla$")
    public void el_palo_se_desplaza_hacia_el_borde_derecho_de_la_pantalla() {
        Vector2 posicionFinal;

        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();
        Assert.assertEquals((float)bordeDerecho,(float)posicionFinal.x,0);
    }

    @Given("^un palo en el limite derecho de la pantalla$")
    public void un_palo_en_el_limite_derecho_de_la_pantalla() {
        screenCenter = new Vector2(screenWidth/2,screenHeight/2);
        inicializarMundo();
        gameWold.getBar().setPosition(new Vector2(bordeDerecho,screenHeight/2));
    }

    @Then("^el palo se desplaza hacia el borde izquierdo de la pantalla$")
    public void el_palo_se_desplaza_hacia_el_borde_izquierdo_de_la_pantalla() {
        Vector2 posicionFinal;

        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();
        Assert.assertEquals((float)bordeIzquierdo,(float)posicionFinal.x,0);

    }

    @Given("^un palo en el limite superior de la pantalla$")
    public void un_palo_en_el_limite_superior_de_la_pantalla() {
        screenCenter = new Vector2(screenWidth/2,screenHeight/2);
        inicializarMundo();
        gameWold.getBar().setPosition(new Vector2(screenWidth/2,bordeSuperior));
    }

    @Then("^el palo se desplaza hacia el borde inferior de la pantalla$")
    public void el_palo_se_desplaza_hacia_el_borde_inferior_de_la_pantalla() {
        Vector2 posicionFinal;

        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();
        Assert.assertEquals((float)bordeInferior,(float)posicionFinal.y,0);
    }

    @Given("^un palo en el limite inferior de la pantalla$")
    public void un_palo_en_el_limite_inferior_de_la_pantalla() {
        screenCenter = new Vector2(screenWidth/2,screenHeight/2);
        inicializarMundo();
        gameWold.getBar().setPosition(new Vector2(screenWidth/2,bordeInferior));
    }

    @Then("^el palo se desplaza hacia el borde superior de la pantalla$")
    public void el_palo_se_desplaza_hacia_el_borde_superior_de_la_pantalla() {
        Vector2 posicionFinal;

        gameRenderer.moverPalaSegunPad();
        gameWold.getBar().update(100);
        posicionFinal=gameWold.getBar().getPosition().cpy();
        Assert.assertEquals(bordeSuperior,posicionFinal.y,0);

    }

}
