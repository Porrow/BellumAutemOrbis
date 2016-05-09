package BellumAutemOrbis;

import BellumAutemOrbis.GraphicObject.GraphicObject;
import BellumAutemOrbis.View.*;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class BellumAutemOrbis extends PApplet
{
    private final int W = 1280;
    private final int H = 720;
    private final int FPS = 60;
    private final String TITLE = "Bellum Autem Orbis";
    
    public static BellumAutemOrbis bao;
    private int view;
    private View[] tabView;
    
    public static void main(String[] args) 
    {
        PApplet.main(new String[]{BellumAutemOrbis.class.getName()});
    }
    
    public void initViews()
    {
        tabView = new View[2];
        tabView[0] = new Menu();
        tabView[1] = new Game();
    }
    
    public void initGraphicObjects()
    {
        for(GraphicObject gro : tabView[view].getTabGrO())
            gro.init();
    }
    
    @Override
    public void settings()                                                      //Paramétrage (appelé en premier)
    {
        bao = this;
        size(W, H);                                                             //Taille de la fenêtre
        //fullScreen();
    }
    
    @Override
    public void setup()
    {
        surface.setTitle(TITLE);
        frameRate(FPS);                                                         //Nombre d'images par seconde max
        initViews();
        setView(0);
    }
    
    @Override
    public void draw()
    {
        for(GraphicObject gro : tabView[view].getTabGrO())
            gro.draw();
    }

    @Override
    public void mousePressed(MouseEvent event) 
    {
        for(GraphicObject gro : tabView[view].getTabGrO())
            gro.mousePressed(event.getX(), event.getY());
    }

    @Override
    public void mouseMoved(MouseEvent event)
    {
        for(GraphicObject gro : tabView[view].getTabGrO())
            gro.mouseMoved(event.getX(), event.getY());
    }
    
    /*Getters*/
    public int getView(){return view;}
    
    /*Setters*/
    public void setView(int nView)
    {
        view = nView;
        initGraphicObjects();
    }
}
