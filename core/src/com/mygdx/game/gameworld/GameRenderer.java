package com.mygdx.game.gameworld;

    import com.badlogic.gdx.ApplicationAdapter;
    import com.badlogic.gdx.Gdx;
    import com.badlogic.gdx.assets.loaders.AssetLoader;
    import com.badlogic.gdx.graphics.Color;
    import com.badlogic.gdx.graphics.GL20;
    import com.badlogic.gdx.graphics.OrthographicCamera;
    import com.badlogic.gdx.graphics.Texture;
    import com.badlogic.gdx.graphics.g2d.BitmapFont;
    import com.badlogic.gdx.graphics.g2d.SpriteBatch;
    import com.badlogic.gdx.graphics.g2d.TextureRegion;
    import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
    import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
    import com.badlogic.gdx.scenes.scene2d.Event;
    import com.badlogic.gdx.scenes.scene2d.EventListener;
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
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private int width;
    private int hieght;
    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;
    private Stage stage;
    private ImageButton button;
    private TextureRegion TextureRegion;
    private TextureRegionDrawable TexRegionDrawable;
    private Texture myTexture;
    private SpriteBatch batch;
    private BitmapFont font;



    public GameRenderer(GameWorld world, int width, int hieght){
        this.width=width;
        this.hieght=hieght;
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, width, hieght);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = new SpriteBatch();
        font = new BitmapFont();



        //Create a touchpad skin
        touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture("data/touchBackground.png"));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture("data/touchKnob.png"));
        //Create TouchPad Style
        touchpadStyle = new Touchpad.TouchpadStyle();
        //Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(20, 20, 300, 300);

        //make button
        myTexture = new Texture("data/boton.png");
        TextureRegion = new TextureRegion(myTexture);
        TexRegionDrawable = new TextureRegionDrawable(TextureRegion);
        button = new ImageButton(TexRegionDrawable); //Set the button up
        button.setBounds(width-150,20,150,150);

        //disparar
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("", "Click");
                myWorld.Disparo();
                return true;
            }
        });

        //Create a Stage and add TouchPad and button
        stage = new Stage();
        stage.addActor(touchpad);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);



    }
    public void render() {
        //dibujamos el fondo negro
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //dibujamos el rectangulo
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        //dibujamos el rectangulo desde world
        shapeRenderer.rect(myWorld.getBar().getX(), myWorld.getBar().getY(), myWorld.getBar().getWidth(), myWorld.getBar().getHeight());
        //seleccionamos el color y la dibujamos la bola
        shapeRenderer.setColor(myWorld.getBol().getBalColor());
        shapeRenderer.circle(myWorld.getBol().getPosition().x,myWorld.getBol().getPosition().y,myWorld.getBol().getRadio());
        //dibujamos la bala
        shapeRenderer.setColor(Color.RED);
        for (Barra bar: myWorld.getBarrasList()){
            shapeRenderer.rect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());

        }

        shapeRenderer.end();
        String vidas = myWorld.getVida() + "";
        batch.begin();
        font.setColor(Color.GREEN);
        font.getData().setScale(3,3);
        font.draw(batch,"DisparosLeft "+vidas,width/(5/2),50);
        batch.end();

        //dibujamos le pad
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        //Move pala with TouchPad
        myWorld.getBar().setX(myWorld.getBar().getX() + touchpad.getKnobPercentX()*this.width/80);
        myWorld.getBar().setY(myWorld.getBar().getY() - touchpad.getKnobPercentY()*this.width/80);
    }

}

