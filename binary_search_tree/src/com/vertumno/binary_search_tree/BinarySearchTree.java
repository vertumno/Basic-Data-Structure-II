package com.vertumno.binary_search_tree;

/**
 * @author Lucas Gomes Dantas
 * @date June the 18th, 2018
 * My implementation of a simple Binary Search Tree, developed while studying at UFRN, Brazil.
 */
public class BinarySearchTree
{
    private Node root;

    /**
     * Instantiates a new Binary Search Tree.
     */
    public BinarySearchTree () { root = null; }

    /**
     * Insert a new element at this Tree, after finding its proper position (e.g. at the left or right of an element)
     *
     * @param data Object to be inserted at the Tree
     * @return True if insertion goes well, false otherwise
     */
    public boolean insert (Object data)
    {
        // Creates a node with the given data
        Node next = new Node(data);

        // Insertion on null Tree
        if ( root == null )
        {
            root = next;
            return true;
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
                    return true;
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
                    return true;
                }
            }
        }
    }

    /**
     * Find the object inside the Tree that matches a given key.
     *
     * @param key Key that should match an object
     * @return The found object, or null if not found
     */
    public Object find (int key)
    {
        Node found = findNode(key);
        if (found != null)
            return found.data;
        return null;
    }

    /**
     * Call method print of class TreePrinter and it will print all elements stored in this Tree.
     */
    public void printTree() { TreePrinter.print(root); }

    /**
     * Deletes an element that matches the given key. It treats and observes the four deletion cases:
     * 1 - No element matches the given key
     * 2 - Node to be deleted is leaf
     * 3 - Node to be deleted has one child
     * 4 - Node to be deleted has two children
     *
     * @param key Key to search an element to be matched
     * @return True if deletion goes well, false otherwise
     */
    public boolean delete(int key)
    {
        // Finding the Object to be deleted
        Node toDelete = findNode(key);
        if (toDelete == null) { return false; }

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

        return true;
    }

    private Node findSuccessor(Node current)
    {
        // You only need to go right once, then you go down the tree by the left
        current = current.right;
        while(current.left != null) current = current.left;
        return current;
    }

    private Node findNode(int key)
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
}