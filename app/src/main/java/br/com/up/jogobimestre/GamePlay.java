package br.com.up.jogobimestre;


import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

class GamePlay extends SurfaceView implements SurfaceHolder.Callback {
    MainThread mainThread;
    public GamePlay(Context context) {
        super(context);
        SurfaceHolder myHolder = getHolder();
        myHolder.addCallback(this);
        mainThread = new MainThread(myHolder);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        mainThread.setIsRunning(true);
        mainThread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {}

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        boolean retry = true;
        while (retry){
            try {
                mainThread.setIsRunning(false);
                mainThread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        AppHolder.getGameManager().gameState = 1;
        AppHolder.getGameManager().nave.setVelocity(AppHolder.JUMP_VELOCITY);
        return true;
    }
}
