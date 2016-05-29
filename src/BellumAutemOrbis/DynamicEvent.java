package BellumAutemOrbis;

import BellumAutemOrbis.GameObject.Unit;
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
        while(!stop)                                                           //Executé tic fois par seconde
        {
            moveWorld();
            moveUnit();
            animUnit();
            try{sleep(tic);}
            catch(InterruptedException e){}
        }
    }

    private void moveWorld()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        World w = (World) g.getTabGrO().get(0);
        World.posX += w.moveX * w.SCALE;
        if(World.posX < 0)
            World.posX = 0;
        else if(World.posX > (w.W - bao.W))
            World.posX = w.W - bao.W;

        World.posY += w.moveY * w.SCALE;
        if(World.posY < 0)
            World.posY = 0;
        else if(World.posY > (w.H - bao.H))
            World.posY = w.H - bao.H;
    }

    private void moveUnit()
    {
        BellumAutemOrbis bao = BellumAutemOrbis.bao;
        for(Unit u : Unit.units)
        {
            if(u.path.isEmpty())
                continue;
            //System.out.println(u.y - (bao.height-bao.H)/2 + "; " + (u.cy+1) * World.C);
            //System.out.println(u.direc);
            switch(u.direc)
            {
                case 0:
                    u.y += (float) (u.speed) / BellumAutemOrbis.FPS;
                    if(u.y - (bao.height-bao.H)/2 >= (u.cy+1) * World.C + World.C/2)
                        u.changeDirection();
                    break;
                case 1:
                    u.x -= (float) (u.speed) / BellumAutemOrbis.FPS;
                    if(u.x - (bao.width-bao.W)/2 <= u.cx * World.C - World.C/2)
                        u.changeDirection();
                    break;
                case 2:
                    u.x += (float) (u.speed) / BellumAutemOrbis.FPS;
                    if(u.x - (bao.width-bao.W)/2 >= (u.cx+1) * World.C + World.C/2)
                        u.changeDirection();
                    break;
                case 3:
                    u.y -= (float) (u.speed) / BellumAutemOrbis.FPS;
                    if(u.y - (bao.height-bao.H)/2 <= u.cy * World.C - World.C/2)
                        u.changeDirection();
                    break;
            }
        }
    }

    private void animUnit()
    {

            /*if(Unit.tabAnim[u.type][u.img] <= (int) (u.time))
            {
                u.time -= Unit.tabAnim[u.type][u.img];
                u.img = (u.img + 1) % Unit.tabAnim[u.type].length;
            }
            u.time += tisl;*/
    }
}
