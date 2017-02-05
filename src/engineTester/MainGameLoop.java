package engineTester;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;

/**
 * Created by Toph on 2/4/2017.
 */
public class MainGameLoop {


    public static void main(String[] args) {
        DisplayManager.createDisplay();

        while(!Display.isCloseRequested()){


            //game logic
            //render
            DisplayManager.updateDisplay();

        }
        DisplayManager.closeDisplay();

    }
}
