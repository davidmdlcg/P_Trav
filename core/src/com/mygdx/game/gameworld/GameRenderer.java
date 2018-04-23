package com.mygdx.game.gameworld;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.objects.Barra;

public class GameRenderer extends ApplicationAdapter{
    private GameWorld myWorld;
    private ShapeRenderer shapeRenderer;
    private int width;
    public Touchpad touchpad;
    private Stage stage;
    private SpriteBatch batch;
    private BitmapFont font;



    public GameRenderer(GameWorld world, int width, int hieght){
        this.width=width;
        myWorld = world;
        TextureRegion textureRegion;
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(true, width, hieght);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = new SpriteBatch();
        font = new BitmapFont();



        //Create a touchpad skin
        Skin touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture("data/touchBackground.png"));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture("data/touchKnob.png"));
        //Create TouchPad Style
        Touchpad.TouchpadStyle touchpadStyle = new Touchpad.TouchpadStyle();
        //Create Drawable's from TouchPad skin
        Drawable touchBackground = touchpadSkin.getDrawable("touchBackground");
        Drawable touchKnob = touchpadSkin.getDrawable("touchKnob");
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(20, 20, 300, 300);

        //make button
        Texture myTexture = new Texture("data/boton.png");
        textureRegion = new TextureRegion(myTexture);
        TextureRegionDrawable texRegionDrawable = new TextureRegionDrawable(textureRegion);
        ImageButton button = new ImageButton(texRegionDrawable); //Set the button up
        button.setBounds((float)width-150,20,150,150);

        //disparar
        button.addListener(new InputListener() {
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("", "Click");
                myWorld.disparo();
                return true;
            }
        });

        //Create a Stage and add TouchPad and button
        stage = new Stage();
        stage.addActor(touchpad);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);



    }

    public GameRenderer(GameWorld world, int width, int hieght,OrthographicCamera mockCam,ShapeRenderer mockShapeRenderer,SpriteBatch mockSpriteBatch,BitmapFont mockBitMap,Texture mockTexture,Drawable mockDrawable,TextureRegionDrawable mockTextureRegion,Stage mockStage){
        this.width=width;
        myWorld = world;
        TextureRegion textureRegion;
        OrthographicCamera cam = mockCam;
        cam.setToOrtho(true, width, hieght);
        shapeRenderer = mockShapeRenderer;
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = mockSpriteBatch;
        font = mockBitMap;



        //Create a touchpad skin
        Skin touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", mockTexture);
        //Set knob image
        touchpadSkin.add("touchKnob", mockTexture);
        //Create TouchPad Style
        Touchpad.TouchpadStyle touchpadStyle = new Touchpad.TouchpadStyle();
        //Create Drawable's from TouchPad skin
        Drawable touchBackground = mockDrawable;
        Drawable touchKnob = mockDrawable;
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(20, 20, 300, 300);

        //make button
        Texture myTexture = mockTexture;
        TextureRegionDrawable texRegionDrawable = mockTextureRegion;
        ImageButton button = new ImageButton(texRegionDrawable); //Set the button up
        button.setBounds((float)width-150,20,150,150);

        //disparar
        button.addListener(new InputListener() {
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("", "Click");
                myWorld.disparo();
                return true;
            }
        });

        //Create a Stage and add TouchPad and button
        stage = mockStage;
        stage.addActor(touchpad);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);



    }


    @Override
    public void render() {
        ponerFondoNegro();
        pintarGraficos();
        moverPalaSegunPad();
    }

    public void moverPalaSegunPad() {
        myWorld.getBar().setX(myWorld.getBar().getX() + touchpad.getKnobPercentX()*this.width/80);
        myWorld.getBar().setY(myWorld.getBar().getY() - touchpad.getKnobPercentY()*this.width/80);
    }

    private void pintarGraficos() {
        shapeRenderer.begin(ShapeType.Filled);
        pintarPala();
        pintarPelota();
        pintarBalas();
        shapeRenderer.end();
        pintarTextos();
        pintarVirtualPad();
    }

    private void pintarVirtualPad() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private void pintarTextos() {
        String vidas = myWorld.getVida() + "";
        batch.begin();
        font.setColor(Color.GREEN);
        font.getData().setScale(3,3);
        font.draw(batch,"DisparosLeft "+vidas,(float)width/((float)5/2),50);
        batch.end();
    }

    private void pintarBalas() {
        shapeRenderer.setColor(Color.RED);
        for (Barra bar: myWorld.getBarrasList()){
            shapeRenderer.rect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());

        }
    }

    private void pintarPelota() {
        shapeRenderer.setColor(myWorld.getBol().getBalColor());
        shapeRenderer.circle(myWorld.getBol().getPosition().x,myWorld.getBol().getPosition().y,myWorld.getBol().getRadio());
    }

    private void pintarPala() {
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        //dibujamos el rectangulo desde world
        shapeRenderer.rect(myWorld.getBar().getX(), myWorld.getBar().getY(), myWorld.getBar().getWidth(), myWorld.getBar().getHeight());
    }

    private void ponerFondoNegro(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}

