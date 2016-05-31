package BellumAutemOrbis.GraphicObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GameObject.*;
import processing.core.PApplet;
import processing.core.PFont;

public class UI extends GraphicObject
{
    private static final String IMGPATH = "res/img/ui/";
    private static final String FONTPATH = "res/font/";
    public static PFont font, font1, font2;
    public static int ui = 0;
    
    public UI(BellumAutemOrbis bao, int x, int y, int w, int h) 
    {
        super(bao, x, y, w, h, IMGPATH);
    }

    @Override
    public void init() 
    {
        this.font1 = bao.createFont(FONTPATH + "Miama.ttf", 55);
        this.font2 = bao.createFont(FONTPATH + "OldLondon.ttf", 35);
    }

    @Override
    public void draw() 
    {
        bao.g.imageMode(PApplet.CORNER);
        image(tabImg[ui], -1, 0);
        bao.textFont(font);
        bao.g.fill(0);
        if(GameObject.selec != null)
        {
            text("Vie : "+GameObject.selec.hp+" / "+GameObject.selec.tabDat[1][Unit.selec.type][0], bao.W/2-20, 90);
            if(GameObject.selec.cw == 1)
            {
                Unit u = (Unit)GameObject.selec;
                text("Attaque : "+u.att, bao.W/2 - 20, 130);
                image(tabImg[Unit.selec.type+2], 150, 40);
            }
            else
            {
                Building b = (Building)GameObject.selec;
                image(b.tabImg[b.type], 150, 40);
            
            }
        }
    }

    @Override
    public void mousePressed(int x, int y, int type) 
    {}

    @Override
    public void mouseMoved(int x, int y) 
    {}
    
}
