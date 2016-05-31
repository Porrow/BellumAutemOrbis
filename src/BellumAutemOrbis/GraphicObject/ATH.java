package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;

public class ATH extends GraphicObject
{
    private static final String IMGPATH = "res/img/ath/";
    
    public ATH(BellumAutemOrbis bao, int x, int y, int w, int h) {
        super(bao, x, y, w, h, IMGPATH);
    }

    @Override
    public void init() 
    {}

    @Override
    public void draw() 
    {
        bao.g.fill(255);
        image(tabImg[0], 0, 0);
    }

    @Override
    public void mousePressed(int x, int y, int type)
    {}

    @Override
    public void mouseMoved(int x, int y) 
    {}
    
}
