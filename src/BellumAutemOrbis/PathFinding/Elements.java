package BellumAutemOrbis.PathFinding;

public class Elements
{
    private final int x, y;
    private int prio;
    private int heuristique;

    public Elements(int prio, int heuristique, int x, int y)
    {
        this.prio = prio;
        this.x = x;
        this.y = y;
        this.heuristique = heuristique;
    }

    //Getters 
    public int getHeuristique()
    {
        return this.heuristique;
    }

    public int getCout(){return prio;}

    public int getX(){return x;}

    public int getY(){return y;}

    //Setters
    public void setCout(int prio){this.prio = prio;}

    public void setHeuristique(int heur){this.heuristique = heur;}
}
