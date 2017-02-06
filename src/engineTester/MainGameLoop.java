package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

/**
 * Created by Toph on 2/4/2017.
 */
public class MainGameLoop {


    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0,        //v0
                -0.5f, -0.5f, 0,
                0.5f,  -0.5f, 0f,
                0.5f, 0.5f, 0f,     //v3

        };

        int[]indicies = {
                0,1,3, //top left triangle
                3,1,2  //bottom right triangle
        };


        RawModel model = loader.loadToVAO(vertices,indicies);


        while(!Display.isCloseRequested()){

            renderer.prepare();
            //game logic
            shader.start();
            renderer.render(model);
            shader.stop();
            //render
            DisplayManager.updateDisplay();

        }
        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
}
