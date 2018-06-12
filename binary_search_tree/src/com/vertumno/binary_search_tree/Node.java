package com.vertumno.binary_search_tree;

public class Node
{
    Object data;
    Node left;
    Node right;
    Node parent;
    boolean isLeftChild;

    public Node (Object data)
    {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }

    public Node getParent() { return parent; }

    public void setParent(Node parent) { this.parent = parent; }

    public Node getLeft () { return left; }

    public void setLeft (Node left) { this.left = left; }

    public Node getRight () { return right; }

    public void setRight (Node right) { this.right = right; }

    public String getText() { return this.data.toString(); }

    public void setData(Object data) { this.data = data; }
}