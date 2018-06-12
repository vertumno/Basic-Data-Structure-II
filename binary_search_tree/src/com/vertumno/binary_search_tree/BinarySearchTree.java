package com.vertumno.binary_search_tree;

public class BinarySearchTree
{
    public static Node root;
    private int size;

    public BinarySearchTree ()
    {
        root = null;
        size = 0;
    }

    public void insert (Object data)
    {
        // Creates a node with the given data
        Node next = new Node(data);

        // Insertion on null Tree
        if ( root == null )
        {
            root = next;
            this.size++;
            return;
        }

        // If it gets here, the Tree is not empty and we must check where to insert

        // This is the com.vertumno.binary_search_tree.Node that will always "make the jump" (i.e. go down to the left or right node)
        Node jumper = root;

        // This is the com.vertumno.binary_search_tree.Node that will keep the position before the jump, so we can go back on the Tree
        Node beforeJumper = null;

        // Instantiates a custom com.vertumno.binary_search_tree.ComparatorClass class
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
                   next.parent = beforeJumper;
                   next.isLeftChild = true;
                   this.size++;
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
                    next.parent = beforeJumper;
                    next.isLeftChild = false;
                    this.size++;
                    return;
                }
            }
        }
    }

    public Node findNode(int key)
    {
        ComparatorClass compare = new ComparatorClass();
        Node jumper = root;
        while (jumper != null)
        {
            int result = compare.compareKeys(jumper.data, key);
            if ( result == 0 ) { return jumper; }
            else if ( result == -1 ) { jumper = jumper.left; }
            else { jumper = jumper.right; }
        }
        return null;
    }

    public Object find (int key)
    {
        Node found = findNode(key);
        if (found != null)
            return found.data;
        return null;
    }

    public void printTree()
    {
        TreePrinter.print(root);
    }

    public Node findSuccessor(Node current)
    {
        // You only need to go right once, then you go down the tree by the left
        current = current.right;
        while(current.left != null) current = current.left;
        return current;
    }

    public void delete(int key)
    {
        // Finding the Object to be deleted
        Node toDelete = findNode(key);
        if (toDelete == null) { return; }

        // We have to see if this deletion falls in which of the three cases.

        // Case 1 = Node to be deleted is leaf - simply delete the node
        if ( (toDelete.left == null) && (toDelete.right == null) )
        {
            if ( toDelete.isLeftChild ) { toDelete.parent.left = null; }
            else { toDelete.parent.right = null; }
        }

        // Case 2 = Node to be deleted has one child - replace value with its child and delete the node
        else if (toDelete.left == null)
        {
            if ( toDelete.isLeftChild ) { toDelete.parent.left = toDelete.right; }
            else { toDelete.parent.right = toDelete.right; }
        }
        else if (toDelete.right == null)
        {
            if ( toDelete.isLeftChild ) { toDelete.parent.left = toDelete.left; }
            else { toDelete.parent.right = toDelete.left; }
        }

        // Case 3 = Node to be deleted has two childs - replace with the lesser of the righmost nodes
        else
        {
            Node successor = findSuccessor(toDelete);
            toDelete.data = successor.data;
            successor.parent.left = null;
        }
    }
}