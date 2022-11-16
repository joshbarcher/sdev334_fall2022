package union_find;

public class DisjointSets
{
    private int[] sets;

    public DisjointSets(int numSets)
    {
        sets = new int[numSets];

        for (int i = 0; i < sets.length; i++)
        {
            sets[i] = -1;
        }
    }

    //accepts an element and finds the set identifier for the element
    public int find(int element)
    {
        if (sets[element] < 0) //is this the root of the set
        {
            return element;
        }
        else //recursively move up the tree to find the root
        {
            return find(sets[element]);
        }
    }

    //join together the roots of two sets (union by height)
    public boolean union(int first, int second)
    {
        if (first == second)
        {
            return false;
        }

        int firstRoot = find(first);
        int secondRoot = find(second);

        if (sets[firstRoot] < sets[secondRoot]) //first root has a larger height
        {
            sets[secondRoot] = firstRoot;
        }
        else if (sets[secondRoot] < sets[firstRoot]) //second root has a larger height
        {
            sets[firstRoot] = secondRoot;
        }
        else //the roots are the same height (set the first root to be the new root of both)
        {
            sets[secondRoot] = firstRoot;
            sets[firstRoot]--; //increase the height of the tree
        }

        return true;
    }
}
