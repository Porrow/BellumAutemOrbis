package BellumAutemOrbis.PathFinding;

import java.util.ArrayList;

public final class PriorityQueue
{
    ArrayList<Elements> list;

    public PriorityQueue()
    {
        list = new ArrayList<>();
    }

    public PriorityQueue(Elements n)
    {
        this();
        add(n);
    }

    public void add(Elements n)
    {
        int pos = searchPos(n.getHeuristique());
        if(pos != -1)
            list.add(pos, n);
        else
            list.add(n);

    }

    /**
     * return the head WITHOUT deleting it
     *
     * @return the first element
     */
    public Elements pop()
    {
        if(!list.isEmpty())
            return list.get(0);
        return null;
    }

    /**
     * Same as pop but remove the head
     *
     * @return return the first element of the list
     */
    public Elements popOut()
    {
        if(!list.isEmpty())
        {
            Elements n = list.get(0);
            list.remove(n);
            return list.get(0);

        }
        return null;
    }

    public boolean del(Elements n)
    {
        return list.remove(n);
    }

    public boolean del(int x)
    {
        return (null != list.remove(x)); //à vérifier
    }

    private int searchPos(int prio)
    {
        for(int i = 0; i < list.size(); ++i)
            if(list.get(i).getHeuristique() > prio)
                return i;
        return -1;
    }

    //Getters
    public Elements get(int x, int y)
    {
        for(Elements e : list)
            if(e.getX() == x && e.getY() == y)
                return e;
        return null;
    }

    public boolean exist(int x, int y)
    {
        for(Elements p : list)
            if(p.getX() == x && p.getY() == y)
                return true;
        return false;
    }

    public Elements getElt(int x, int y)
    {
        for(Elements e : list)
            if(e.getX() == x && e.getY() == y)
                return e;
        return null;

    }

    public boolean isEmpty(){return list.isEmpty();}

}
