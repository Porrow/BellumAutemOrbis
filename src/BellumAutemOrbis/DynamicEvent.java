package BellumAutemOrbis;

import BellumAutemOrbis.GraphicObject.World;
import BellumAutemOrbis.View.Game;

public class DynamicEvent extends Thread
{
    private Game g;
    public static boolean stop = false;
    private static final int tic = 10;                                          //Une période en ms
    
    public DynamicEvent(Game g)
    {
        this.g = g;
    }
    
    @Override
    public void run() 
    {
        while (!stop)
        {
            moveWorld();
            try {sleep(tic);} 
            catch (InterruptedException e) {}   
        }
    }
    
    private void moveWorld()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        World w = (World)g.getTabGrO()[0];
        w.posX += w.moveX * 10;
        if      (w.posX < 0)                w.posX = 0;
        else if (w.posX > (w.W - bao.W))    w.posX = w.W - bao.W;
        System.out.print(w.posX);
        w.posY += w.moveY * 10;
        if      (w.posY < 0)                w.posY = 0;
        else if (w.posY > (w.H - bao.H))    w.posY = w.H - bao.H;
        System.out.println("; " +w.posY);
    }
}
