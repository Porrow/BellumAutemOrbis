package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import processing.core.PApplet;

public class Unit extends GameObject
{
    private static final String IMGPATH = "res/img/unit/";
    private static final String DATPATH = "res/dat/unit/";
    
    public Unit(BellumAutemOrbis bao, int type, int cx, int cy)
    {
        super(bao, type, cx, cy, 0, 0, IMGPATH, DATPATH);
    }

    @Override
    public void draw()
    {
        bao.g.imageMode(PApplet.CENTER);
        image(tabSprite[0][0], 0, 0);
    }

    @Override
    public void mousePressed(int x, int y)
    {}

    @Override
    public void mouseMoved(int x, int y)
    {}
    
}
