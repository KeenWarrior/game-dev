package com.codingblocks.jungle.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codingblocks.jungle.JungleGame;


public class PlayScreen implements Screen {

    TmxMapLoader loader;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;

    OrthographicCamera camera;
    Viewport viewport;

    public PlayScreen() {
        loader = new TmxMapLoader();
        map = loader.load("jungle.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        viewport = new StretchViewport(600, 400, camera);
        camera.translate(300, 200);
    }

    @Override public void show() {

    }

    @Override public void render(float delta) {

        update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //JungleGame.batch.setProjectionMatrix(camera.combined);
        renderer.setView(camera);
        renderer.render();
    }

    public void update(){

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            camera.translate(10, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            camera.translate(0, 10);
        }

        camera.update();
    }

    @Override public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override public void hide() {

    }

    @Override public void dispose() {

    }
}
