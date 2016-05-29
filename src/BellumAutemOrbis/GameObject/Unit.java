package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.World;
import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;

public class Unit extends GameObject
{
    private static final String IMGPATH = "res/img/unit/";
    private static final String DATPATH = "res/dat/unit/";
    public static ArrayList<Unit> units = new ArrayList<>();
    public LinkedList<int[]> path = new LinkedList<>();
    public int direc = 2;
    public int anim = 0;
    public long time = 0;
    public int hp;
    public int att;
    public int gold;
    public int speed;
    
    public Unit(BellumAutemOrbis bao, int type, int cx, int cy)
    {
        super(bao, type, cx, cy, 0, 0, IMGPATH, DATPATH);
        hp = tabDat[1][type][0];
        att = tabDat[1][type][1];
        gold = tabDat[1][type][2];
        speed = tabDat[1][type][3];
        int[] p1 = {1, 0};
        int[] p2 = {1, 1};
        int[] p3 = {2, 1};
        //int[] p4 = {3, 1};
        path.add(p1);
        path.add(p2);
        path.add(p3);
        //path.add(p4);
        changeDirection();
        units.add(this);
    }
    
    public void changeDirection()
    {
        if(path.isEmpty())return;
        int[] coord = path.remove(0);
        int xc = coord[0] - cx;
        int yc = coord[1] - cy;
        if(xc == 1)
        {
            direc = 2;
            cx += 1;
        }
        if(xc == -1)
        {
            direc = 1;
            cx -= 1;
        }
        if(yc == 1)
        {
            direc = 0;
            cy += 1;
        }
        if(yc == -1)
        {
            direc = 3;
            cy -= 1;
        }
    }
    
    @Override
    public void draw()
    {
        if(isOutside())
        {
            bao.g.imageMode(PApplet.CENTER);
            image(tabSprite[direc][anim], -World.posX, -World.posY);
        }
    }

    @Override
    public void mousePressed(int x, int y)
    {}

    @Override
    public void mouseMoved(int x, int y)
    {}
}
