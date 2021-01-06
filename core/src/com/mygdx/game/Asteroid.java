package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroid {
    private int x;
    private int y;
    private float vx;
    private float vy;
    private static Texture myTexture;

    public static void setMyTexture(Texture myTexture) {
        Asteroid.myTexture = myTexture;
    }

    public Asteroid(int x, int y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
        x += vx;
        y += vy;

        if(x > 800) x = -256; // - texture resolution
        if(x < -256) x = 800; // - texture resolution
        if(y > 600) x = -256; // - texture resolution        if(x > 800) x = -256; // - texture resolution
        if(y < -256) x = 600; // - texture resolution
    }

    public void render(SpriteBatch batch) {
        batch.draw(myTexture, x, y);
    }
}
