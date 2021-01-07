package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
    private final int AST_COUNT = 10;
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;

    private SpriteBatch batch;
    private Texture img;
    private Asteroid[] ast;

	private float kx = 3.0f;
    private float ky = 3.0f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        ast = new Asteroid[AST_COUNT];
		Random rand = new Random();

        Asteroid.setMyTexture(new Texture("Asteroid1_64x64.png"));

        for (int i = 0; i < AST_COUNT; i++) {
            ast[i] = new Asteroid(
                    new Vector2(rand.nextInt(SCREEN_WIDTH), rand.nextInt(SCREEN_HEIGHT)),
                    new Vector2((rand.nextFloat() - 0.5f) * kx, (rand.nextFloat() - 0.5f) * ky)
			);
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for (int i = 0; i < AST_COUNT; i++) {
            ast[i].render(batch);
        }
        batch.end();
    }

    public void update() {
        for (int i = 0; i < AST_COUNT; i++) {
            ast[i].update();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
