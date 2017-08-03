package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;


public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private TextureAtlas ballrotation;
    private Animation animate_balls;
	private float time_passed = 0;
    private ArrayList<ShapeRenderer> shapeRenderer;
    private OrthographicCamera camera;
private Viewport viewport;
    private DrawWalls drawwalls;
	//SpriteBatch batch;

	
	@Override
	public void create () {
        int rooms = 9;
		batch = new SpriteBatch();
		ballrotation = new TextureAtlas(Gdx.files.internal("BallRotations.atlas"));
        animate_balls = new Animation(1/10f, ballrotation.getRegions());
        shapeRenderer = new ArrayList<ShapeRenderer>();
        drawwalls = new DrawWalls();
        for(int i=0; i<rooms; i++) {
          //  ShapeRenderer obj1 =
            shapeRenderer.add(new ShapeRenderer());


        }

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
       // img = new Texture("BEEBEE.jpg");
	}
    @Override
    public void dispose () {
        batch.dispose();
       ballrotation.dispose();
    }

    public void handleInput()
    {
        int touchX=Gdx.input.getX();
        int touchY=Gdx.input.getY();
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        time_passed += Gdx.graphics.getDeltaTime();

        int x =10;
        int y =10;
      //  batch.draw(img, 0, 0);
        //animate_balls.getKeyFrame(time_passed,true);

       // batch.draw((TextureRegion) animate_balls.getKeyFrame(time_passed, true), x, y,Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() /8);
        //use below if code to get the touch coordinates
       //if(Gdx.input.isTouched()) {
           x = Gdx.input.getX()-100;
           //Bacause of lib gdx coordinate system, there is a need to flip the Y axis below to get correct touch motion
           y = Gdx.graphics.getHeight()-Gdx.input.getY()-100;
           //System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
           batch.draw((TextureRegion) animate_balls.getKeyFrame(time_passed, true),x, y,Gdx.graphics.getWidth() / 10, Gdx.graphics.getHeight() /8);


        // Lets try to repel ball when it touches wall
            batch.end();

        if(Gdx.input.isTouched()){
            Gdx.input.getX();
            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
        }
        int x_point = 100;
        int y_point = 200;
for(int i=0; i<8;i++) {
    //Rect box creation below

    shapeRenderer.get(i).setProjectionMatrix(batch.getProjectionMatrix());
    shapeRenderer.get(i).setTransformMatrix(batch.getTransformMatrix());

    shapeRenderer.get(i).begin(ShapeRenderer.ShapeType.Line);
    shapeRenderer.get(i).setColor(Color.WHITE);
  //  shapeRenderer.get(i).line(x_point, 200, x_point, 800);
    // from here shape renderer should be returned from a method  with new  coordinates (that are not equal to old coordinates)
    //like --- DrawWalls.generateShaperender(shaperenderer, old_x, old_y) --> return value will be a new line with new coordinates.
    drawwalls.getShapeRenderer(shapeRenderer.get(i),x_point,y_point);
    Gdx.gl.glLineWidth(500 / camera.zoom);

    System.out.println(shapeRenderer.get(i).getProjectionMatrix());
    shapeRenderer.get(i).end();
   x_point = x_point+100;
    y_point= y_point+100;
  //  x_point= x_point+50;
}

    }

	

}
