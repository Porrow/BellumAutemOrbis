package BellumAutemOrbis.View;

import BellumAutemOrbis.*;
import BellumAutemOrbis.GraphicObject.*;

public class Game extends View 
{
    public Game()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        tabGrO = new GraphicObject[1];
        tabGrO[0] = new World(bao, 30, 30);
    }
}
