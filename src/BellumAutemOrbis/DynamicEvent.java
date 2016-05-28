package BellumAutemOrbis;

import BellumAutemOrbis.GraphicObject.World;
import BellumAutemOrbis.View.Game;

public class DynamicEvent extends Thread
{
    private final Game g;
    public static boolean stop = false;
    private static final int tic = 5;                                           //Une période en ms
    
    public DynamicEvent(Game g)
    {
        this.g = g;
    }
    
    @Override
    public void run() 
    {
        while (!stop)                                                           //Executé tic fois par seconde
        {
            moveWorld();
            moveUnit();
            animUnit();
            try {sleep(tic);} 
            catch (InterruptedException e) {}   
        }
    }
    
    private void moveWorld()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        World w = (World)g.getTabGrO().get(0);
        w.posX += w.moveX * w.SCALE;
        if      (w.posX < 0)                w.posX = 0;
        else if (w.posX > (w.W - bao.W))    w.posX = w.W - bao.W;
        
        w.posY += w.moveY * w.SCALE;
        if      (w.posY < 0)                w.posY = 0;
        else if (w.posY > (w.H - bao.H))    w.posY = w.H - bao.H;
    }
    
    private void moveUnit()
    {
        
    }

    private void animUnit()
    {
        
    }
}
