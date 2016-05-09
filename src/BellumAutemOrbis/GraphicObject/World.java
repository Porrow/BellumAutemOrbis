package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;

public class World extends GraphicObject
{
    public World(BellumAutemOrbis bao, int x, int y, int w, int h) 
    {
        super(bao, x, y, w, h);
    }

    @Override
    public void init(){}

    @Override
    public void draw()
    {
        bao.g.fill(0);
        rect(0,0,20,20);
    }

    @Override
    public void mousePressed(int x, int y) {}

    @Override
    public void mouseMoved(int x, int y) {}
}
