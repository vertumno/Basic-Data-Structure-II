import java.util.Comparator;

public class ComparatorClass implements Comparator<Object>
{
    public int compare (Object a, Object b)
    {
        // Here you cast to wherever object you want and implements its comparation logic
        if ( ((User)a).id < ((User)b).id ) return -1;
        if ( ((User)a).id > ((User)b).id ) return 1;
        return 0;
    }

    public int compareKeys (Object a, int key)
    {
        // Here you cast the Object to whatever you want and implements the comparation logic
        if ( ((User)a).id < key ) return -1;
        if ( ((User)a).id > key ) return 1;
        return 0;
    }
}