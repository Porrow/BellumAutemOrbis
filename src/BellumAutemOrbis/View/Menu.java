package BellumAutemOrbis.View;

import BellumAutemOrbis.*;
import BellumAutemOrbis.GraphicObject.*;

public class Menu extends View
{
    public Menu()
    {
        tabGrO = new GraphicObject[1];
        tabGrO[0] = new World(BellumAutemOrbis.bao,0,0,20,20);
    }
}
