package br.com.up.jogobimestre;

import java.util.Random;

public class TubeCollection {
    private int xTube;
    private int upTubeCollection_Y;
    private Random rand;
    public TubeCollection(int xTube, int upTubeCollection_Y){
        this.xTube = xTube;
        this.upTubeCollection_Y = upTubeCollection_Y;
        rand = new Random();
    }
    public int getUpTubeCollection_Y(){
        return upTubeCollection_Y;
    }

    public int getxTube() {
        return xTube;
    }
    public int getUpTube_Y(){
        return upTubeCollection_Y - AppHolder.getBitmapControl().getNaveHeight();
    }
    public int getDownTube_Y(){
        return upTubeCollection_Y + AppHolder.tubeGap;
    }
    public void setXtube(int x_Tube){
        this.xTube = x_Tube;
    }
    public void setUpTubeCollection_Y(int upTubeCollection_Y){
        this.upTubeCollection_Y = upTubeCollection_Y;
    }
}
