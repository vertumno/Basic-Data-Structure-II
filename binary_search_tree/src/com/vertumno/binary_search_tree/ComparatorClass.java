package com.vertumno.binary_search_tree;

import com.vertumno.usage.User;
import java.util.Comparator;

public class ComparatorClass implements Comparator<Object>
{
    public int compare (Object a, Object b)
    {
        // Here you cast to wherever object you want and implements its comparation logic
        if ( ((User)a).getId() < ((User)b).getId() ) return -1;
        if ( ((User)a).getId() > ((User)b).getId() ) return 1;
        return 0;
    }

    public int compareKeys (Object a, int key)
    {
        // Here you cast the Object to whatever you want and implements the comparation logic
        if ( key < ((User)a).getId() ) { return -1; }
        else if ( key > ((User)a).getId() ) { return 1; }
        else { return 0; }
    }
}