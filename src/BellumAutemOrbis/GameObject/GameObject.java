package BellumAutemOrbis.GameObject;

import BellumAutemOrbis.BellumAutemOrbis;
import BellumAutemOrbis.GraphicObject.GraphicObject;

public abstract class GameObject extends GraphicObject
{
    public GameObject(BellumAutemOrbis bao, int x, int y, int w, int h)
    {
        super(bao, x, y, w, h);
    }
}
