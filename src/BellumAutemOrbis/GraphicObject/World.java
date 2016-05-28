package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import processing.core.PGraphics;

public class World extends GraphicObject
{
    private static final String IMGPATH = "res/img/world/";
    private static final String DATPATH = "res/dat/world/";
    public static final int C = 40;
    public final int SCALE = 3;
    public final int W = 100 * C;
    public final int H = 100 * C;
    public int posX;
    public int posY;
    public int moveX;
    public int moveY;
    private PGraphics img;
    
    public World(BellumAutemOrbis bao, int x, int y) 
    {
        super(bao, 0, 0, bao.W, bao.H, IMGPATH, DATPATH);
        this.posX = x;
        this.posY = y;
    }

    @Override
    public void init()
    {
        img = bao.createGraphics(W, H);
        img.beginDraw();
        int[][] world = tabDat[0];
        for(int i = 0; i < world.length; i++)
            for(int j = 0; j < world[i].length; j++)
                img.image(tabImg[world[i][j]], j*C, i*C);
        img.endDraw();
    }

    @Override
    public void draw()
    {
        bao.g.copy(img, posX, posY, w, h, x, y, w, h);
    }

    @Override
    public void mousePressed(int x, int y) {}

    @Override
    public void mouseMoved(int x, int y) 
    {
        x = getRX(x);
        y = getRY(y);
        if     (x <= 0)     moveX = -1;
        else if(x >= w-1)   moveX = +1;
        else                moveX = 0;
        if     (y <= 0)     moveY = -1;
        else if(y >= h-1)   moveY = +1;
        else                moveY = 0;
    }
}
