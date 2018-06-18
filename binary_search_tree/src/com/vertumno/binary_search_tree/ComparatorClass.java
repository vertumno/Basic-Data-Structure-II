package com.vertumno.binary_search_tree;

/**
 * @author Lucas Gomes Dantas
 * @date June the 18th, 2018
 * ComparatorClass that should be modified by the client, developed while studying at UFRN, Brazil.
 */

import com.vertumno.usage.User;
import java.util.Comparator;

/**
 * This ComparatorClass defines the order (i.e. less than, greater than and equals to) of two
 * objects stored on the Node.
 * It should be modified by the client to meet his needs. The only criterion is that the return
 * must be respected.
 * When one object is greater than other, return is 1.
 * When is lesser than the other, return is -1.
 * If they are equal, return is 0.
 * Also, you must cast the type from Object to the class you want. In this case, for this implementation,
 * I am casting to class User, where I've implemented a method called getId().
 */
public class ComparatorClass implements Comparator<Object>
{
    public int compare (Object a, Object b)
    {
        // Here you cast to wherever object you want and implements its comparation logic
        if ( ((User)a).getId() < ((User)b).getId() ) return -1;
        if ( ((User)a).getId() > ((User)b).getId() ) return 1;
        return 0;
    }

    /**
     * Establishes the order of comparation of an Object with a given key.
     *
     * @param a   The object to be compared
     * @param key The key to be compared
     * @return -1 if key is lesser than the Object's key, 1 if it's greater and 0 if it's equal.
     */
    public int compareKeys (Object a, int key)
    {
        // Here you cast the Object to whatever you want and implements the comparation logic
        if ( key < ((User)a).getId() ) { return -1; }
        else if ( key > ((User)a).getId() ) { return 1; }
        else { return 0; }
    }
}