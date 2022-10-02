package br.com.up.jogobimestre;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppHolder {
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCRN_WIDTH_X;
    static int SCRN_HEIGHT_Y;
    static int gravityPull;
    static int JUMP_VELOCITY;
    static int tubeGap;
    static int tube_numbers;
    static int tubeVelocity;
    static int minimumTubeCollection_Y;
    static int maximunTubeCollection_Y;
    static int tubeDistance;

    public static void assign(Context context){
        //the mapScreenSize method should be the first in the assign method.
        //o método mapScreenSize deve ser o primeiro no método assign.
        mapScreenSize(context);
        bitmapControl = new BitmapControl(context.getResources());
        holdGameVariables();
        gameManager = new GameManager();
    }

    public static void holdGameVariables(){
        AppHolder.gravityPull = 5;
        AppHolder.JUMP_VELOCITY = -50;
        AppHolder.tubeGap = 650;
        AppHolder.tube_numbers = 2;
        AppHolder.tubeVelocity = 12;
        AppHolder.minimumTubeCollection_Y = (int)(AppHolder.tubeGap) / 2;
        AppHolder.maximunTubeCollection_Y = AppHolder.SCRN_HEIGHT_Y - AppHolder.minimumTubeCollection_Y - AppHolder.tubeGap;
        AppHolder.tubeDistance = AppHolder.SCRN_WIDTH_X+2/3;
    }

    public static BitmapControl getBitmapControl(){
        return bitmapControl;
    }
    public static GameManager getGameManager(){
        return gameManager;
    }

    private static void mapScreenSize(Context context){
        @SuppressLint("ServiceCast") WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display disp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        disp.getMetrics(dMetrics);
        int width = dMetrics.widthPixels;
        int height = dMetrics.heightPixels;
        AppHolder.SCRN_WIDTH_X = width;
        AppHolder.SCRN_HEIGHT_Y = height;



    }
}
