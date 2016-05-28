package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.GraphicObject;
import BellumAutemOrbis.GraphicObject.World;
import processing.core.PImage;

public abstract class GameObject extends GraphicObject
{
    protected int type;
    protected PImage[][] tabSprite;
    
    public GameObject(BellumAutemOrbis bao, int type, int cx, int cy, int cw, int ch, String imgPath, String datPath)
    {
        super(bao, cx*World.C + World.C/2, cy*World.C + World.C/2, World.C, World.C, imgPath, datPath);
        this.type = type;
    }
    
    @Override
    public void init()
    {
        tabSprite = cut(tabImg[type], tabDat[0][type][0], tabDat[0][type][1]);
    }
}
