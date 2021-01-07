package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private final Vector2 position;
    private final Vector2 velocity;
    private static Texture myTexture;

    public static void setMyTexture(Texture myTexture) {
        Asteroid.myTexture = myTexture;
    }

    public Asteroid(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    private final int textureWidth = myTexture.getWidth();
    private final int textureHeight = myTexture.getHeight();
    private final int ScreenWidth = Gdx.graphics.getWidth();
    private final int ScreenHeight = Gdx.graphics.getHeight();

    public void update() {
        position.add(velocity);

        if(position.x > ScreenWidth) position.x = -textureWidth;
        if(position.x < -textureWidth) position.x = ScreenWidth;
        if(position.y > ScreenHeight) position.y = -textureHeight;
        if(position.y < -textureHeight) position.y = ScreenHeight;

    }

    public void render(SpriteBatch batch) {
        batch.draw(myTexture, position.x, position.y);
    }
}
