package com.vertumno.radix_trie;

import java.util.HashMap;
import java.util.Map;

public class Node
{
    String data;
    Node parent;
    boolean endWord;

    Map<String, Node> children;

    public Map<String, Node> getChildren() { return children; }

    public String getData() { return data; }

    public Node(String data)
    {
        this.data = data;
        parent = null;
        endWord = false;
        children = new HashMap<String, Node>();
    }

    public boolean hasChild(String data)
    {
        return children.containsKey(data);
    }

    public Node getChild(String data)
    {
        return children.get(data);
    }

    public void addChild(String data, Node child)
    {
        children.put(data, child);
    }

    public boolean hasChildren()
    {
        return !children.isEmpty();
    }
}