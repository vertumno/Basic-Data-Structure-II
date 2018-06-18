package com.vertumno.binary_search_tree;

/**
 * @author Lucas Gomes Dantas
 * @date June the 18th, 2018
 * My implementation of a simple Node for a Binary Search Tree, developed while studying at UFRN, Brazil.
 */
public class Node
{
    /**
     * Data that will be stored inside the Node.
     */
    Object data;

    /**
     * Reference to the left element of this Node.
     */

    Node left;
    /**
     * Reference to the right element of this Node.
     */
    Node right;

    /**
     * Reference to the parent of this Node.
     */
    Node parent;

    /**
     * Flag that indicates whether this Node is a left child.
     */
    boolean isLeftChild;

    /**
     * Instantiates a new Node.
     *
     * @param data Data to be stored.
     */
    public Node (Object data)
    {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }

    /**
     * Gets parent Node.
     *
     * @return the parent
     */
    public Node getParent() { return parent; }

    /**
     * Sets parent Node.
     *
     * @param parent The Node that will be parent of this Node.
     */
    public void setParent(Node parent) { this.parent = parent; }

    /**
     * Gets left node.
     *
     * @return The left Node.
     */
    public Node getLeft () { return left; }

    /**
     * Sets left Node.
     *
     * @param left Node that will be at left of this Node.
     */
    public void setLeft (Node left) { this.left = left; }

    /**
     * Gets right Node.
     *
     * @return The right Node.
     */
    public Node getRight () { return right; }

    /**
     * Sets right Node.
     *
     * @param right Node that will be at right of this Node.
     */
    public void setRight (Node right) { this.right = right; }

    /**
     * Calls method toString of the Object stored inside this Node.
     *
     * @return The result of toString.
     */
    public String getText() { return this.data.toString(); }

    /**
     * Sets data.
     *
     * @param data New data that will be stored inside this Node.
     */
    public void setData(Object data) { this.data = data; }
}