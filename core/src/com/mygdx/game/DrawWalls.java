package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by SAI KIRAN on 7/28/2017.
 */

public class DrawWalls {
    public ShapeRenderer getShapeRenderer(ShapeRenderer shaprender, int old_xvalue, int old_yvalue) {

        shaprender.line(old_xvalue,200, old_xvalue, 800);
      //  Gdx.gl.glLineWidth(500 / camera.zoom);

        return  shaprender;
    }
}
