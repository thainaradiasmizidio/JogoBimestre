package br.com.up.jogobimestre;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class BitmapControl {
    Bitmap background;
    Bitmap[] FlyingNave;
    Bitmap upTube;
    Bitmap downTube;
    public BitmapControl(Resources res){
        background = BitmapFactory.decodeResource(res,R.drawable.backgorund);
        background = imageScale(background);
        FlyingNave = new Bitmap[3];
        FlyingNave[0] = BitmapFactory.decodeResource(res,R.drawable.nave0);
        FlyingNave[1] = BitmapFactory.decodeResource(res,R.drawable.nave1);
        FlyingNave[2] = BitmapFactory.decodeResource(res,R.drawable.nave2);
        upTube = BitmapFactory.decodeResource(res, R.drawable.obstaculo_1);
        downTube = BitmapFactory.decodeResource(res, R.drawable.obstaculo_2);

    }

    public Bitmap getUpTube() {
        return upTube;
    }

    public Bitmap getDownTube() {
        return downTube;
    }
    public int getTubeWidth() {
        return upTube.getWidth();
    }
    public int getTubeHeigh() {
        return upTube.getHeight();
    }

    public Bitmap getNave(int frame){
        return FlyingNave[frame];
    }
    public int getNaveWidth(){
        return FlyingNave[0].getWidth();
    }
    public int getNaveHeight() {
        return FlyingNave[0].getHeight();
    }

    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }
    public int getBackgroundHeight(){
        return background.getHeight();
    }
    public Bitmap imageScale(Bitmap bitmap){
        float width_heightRatio = getBackgroundWidth() / getBackgroundHeight();
        int bgScaleWidth = (int) width_heightRatio*AppHolder.SCRN_WIDTH_X;
        return Bitmap.createScaledBitmap(bitmap, bgScaleWidth, AppHolder.SCRN_HEIGHT_Y, false);
    }
}
