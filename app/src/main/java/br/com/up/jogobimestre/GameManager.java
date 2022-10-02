package br.com.up.jogobimestre;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    BgImage bgImage;
    FlyingNave nave;
    static int gameState;
    ArrayList<TubeCollection>tubeCollections;
    Random rand;
    //construtor
    public GameManager(){
        bgImage = new BgImage();
        nave = new FlyingNave();
        gameState = 0;
        tubeCollections = new ArrayList<>();
        rand  = new Random();
        generateTubeObject();
    }

    public void generateTubeObject(){
        for (int j = 0; j< AppHolder.tubeGap; j++){
            int tubeX = AppHolder.SCRN_WIDTH_X + j+AppHolder.tubeDistance;
            int upTubeCollectionY = AppHolder.minimumTubeCollection_Y;
            rand.nextInt(AppHolder.maximunTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);
            TubeCollection tubeCollection = new TubeCollection(tubeX, upTubeCollectionY);
            tubeCollections.add(tubeCollection);
        }
    }

    public void scrollingTube(Canvas can){
        if (gameState ==1){
            for(int j = 0; j<AppHolder.tube_numbers; j++){
                if (tubeCollections.get(j).getxTube()<-AppHolder.getBitmapControl().getTubeWidth()){
                    tubeCollections.get(j).setXtube(tubeCollections.get(j).getxTube()
                    +AppHolder.tube_numbers*AppHolder.tubeDistance);
                    int upTubeCollectionY = AppHolder.minimumTubeCollection_Y +
                        rand.nextInt(AppHolder.maximunTubeCollection_Y - AppHolder.minimumTubeCollection_Y+1);
                    tubeCollections.get(j).setUpTubeCollection_Y(upTubeCollectionY);
                }
                tubeCollections.get(j).setXtube(tubeCollections.get(j).getxTube() - AppHolder.tubeVelocity);
                can.drawBitmap(AppHolder.getBitmapControl().getUpTube(), tubeCollections.get(j).getxTube(), tubeCollections.get(j).getUpTube_Y(), null);
                can.drawBitmap(AppHolder.getBitmapControl().getDownTube(), tubeCollections.get(j).getxTube(),tubeCollections.get(j).getDownTube_Y(), null);
            }
        }
    }

    public void naveAnimation(Canvas canvas){
        if(gameState == 1){
        if (nave.getY() <(AppHolder.SCRN_HEIGHT_Y - AppHolder.getBitmapControl().getNaveHeight()) || nave.getVelocity()<0 ) {
            nave.setVelocity(nave.getVelocity() + AppHolder.gravityPull);
            nave.setY(nave.getY() + nave.getVelocity());
            }
        }
        int currentFrame = nave.getCurrentFrame();
        canvas.drawBitmap(AppHolder.getBitmapControl().getNave(currentFrame), nave.getX(), nave.getY(), null);
        currentFrame++;
        if (currentFrame > FlyingNave.maximumFrame){
            currentFrame = 0;
        }
        nave.setCurrentFrame(currentFrame);
    }

    public void backgroundAnimation(Canvas canvas){
        bgImage.setX(bgImage.getX() - bgImage.getVelocity());
        if (bgImage.getX() <-AppHolder.getBitmapControl().getBackgroundWidth())
        {
            bgImage.setX(0);
        }
        canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX(), bgImage.getY(), null);
        if (bgImage.getX() <-(AppHolder.getBitmapControl().getBackgroundWidth() - AppHolder.SCRN_WIDTH_X)){
            canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX() +
                    AppHolder.getBitmapControl().getBackgroundWidth(), bgImage.getY(), null);
        }
    }

}
