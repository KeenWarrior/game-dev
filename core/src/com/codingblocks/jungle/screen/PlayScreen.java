package com.codingblocks.jungle.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codingblocks.jungle.JungleGame;
import com.codingblocks.jungle.scene.ParallaxBackground;


public class PlayScreen implements Screen {

    TmxMapLoader loader;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;

    ParallaxBackground background;

    OrthographicCamera camera;
    Viewport viewport;

    Stage stage;

    public PlayScreen() {
        loader = new TmxMapLoader();
        map = loader.load("jungle.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();
        viewport = new StretchViewport(600, 400, camera);
        camera.translate(300, 200);

        stage = new Stage();

        Array<Texture> textures = new Array<Texture>();

        for (int i = 1; i < 6; i++) {
            textures.add(new Texture("plx-"+i+".png"));
        }

        background = new ParallaxBackground(textures);

        stage.addActor(background);

    }

    @Override public void show() {

    }

    @Override public void render(float delta) {

        update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        JungleGame.batch.setProjectionMatrix(stage.getCamera().combined);

        stage.draw();

        //JungleGame.batch.setProjectionMatrix(camera.combined);
        renderer.setView(camera);
        renderer.render();
    }

    public void update(){

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            background.step(1);
            camera.translate(10, 0);

        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            background.step(-1);
            camera.translate(-10, 0);

        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){

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
