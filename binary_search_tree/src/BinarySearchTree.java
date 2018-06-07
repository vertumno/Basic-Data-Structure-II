public class BinarySearchTree
{
    public static Node root;

    public BinarySearchTree ()
    {
        root = null;
    }

    public void insert (Object data)
    {
        // Creates a node with the given data
        Node next = new Node(data);

        // Insertion on null Tree
        if ( root == null )
        {
            root = next;
            return;
        }

        // If it gets here, the Tree is not empty and we must check where to insert

        // This is the Node that will always "make the jump" (i.e. go down to the left or right node)
        Node jumper = root;

        // This is the Node that will keep the position before the jump, so we can go back on the Tree
        Node beforeJumper = null;

        // Instantiates a custom ComparatorClass class
        ComparatorClass comparator = new ComparatorClass();

        while (true)
        {
            beforeJumper = jumper;

            // The value will be inserted at left or right?
            if ( comparator.compare( next.data, beforeJumper.data ) == -1 )
            {
                jumper = jumper.left;

                // This is an available position to be inserted?
                if ( jumper == null )
                {
                   beforeJumper.left = next;
                   return;
                }
            }
            else
            {
                jumper = jumper.right;

                // This is an available position to be inserted?
                if ( jumper == null )
                {
                    beforeJumper.right = next;
                    return;
                }
            }
        }
    }

    public Object find (int key)
    {
        ComparatorClass compare = new ComparatorClass();
        Node jumper = root;
        while (jumper != null)
        {
            int result = compare.compareKeys(jumper.data, key);
            if ( result == 0 ) return jumper.data;
            else if ( result == -1 ) jumper = jumper.left;
            else jumper = jumper.right;
        }
        return null;
    }

    public void printTree()
    {

    }
}