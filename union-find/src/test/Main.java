package test;

import union_find.DisjointSets;

public class Main
{
    public static void main(String[] args)
    {
        DisjointSets sets = new DisjointSets(5);

        //join sets 0/1 and 2/3
        sets.union(0, 1);
        sets.union(2, 3);
        sets.union(0, 3);

        //determine if set ownership is working
        System.out.println("Does 1 and 0 belong to the same set? " + (sets.find(0) == sets.find(1)));
        System.out.println("Does 1 and 2 belong to the same set? " + (sets.find(1) == sets.find(2)));
        System.out.println("Does 2 and 3 belong to the same set? " + (sets.find(2) == sets.find(3)));
        System.out.println("Does 0 and 3 belong to the same set? " + (sets.find(0) == sets.find(3)));
    }
}