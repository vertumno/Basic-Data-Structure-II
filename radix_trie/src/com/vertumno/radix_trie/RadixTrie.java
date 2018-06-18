package com.vertumno.radix_trie;

import java.util.ArrayList;

public class RadixTrie
{
    private static Node root;

    public RadixTrie() { root = new Node(""); }

    public void insert(String data)
    {
        String[] chars = data.split("");
        Node current = root;
        int count = 0;
        for (String e : chars)
        {
            // Create a new node with the character and checks if he already exists on trie
            Node newNode = new Node(e);
            if ( ! current.hasChild(e) )
            {
                current.addChild(e, newNode);
                newNode.parent = current;
            }
            // Advances node
            current = current.getChild(e);
            // If it is the last char of the string, it needs to have its flag active
            if ( count++ == chars.length - 1 ) { newNode.endWord = true; }
        }
    }

    public boolean search(String word)
    {
        String[] chars = word.split("");
        int count = 0;
        Node current = root;
        for (String e : chars)
        {
            if( current.hasChild(e) )
            {
                current = current.getChild(e);
                count++;
            }
        }
        return (count == chars.length) && (current.endWord);
    }

    public void print()
    {
        ArrayList<String> words = new ArrayList<>();
        for ( String e : getWords(root, words, "") ) { System.out.println(e); }
    }

    public boolean delete(String word)
    {
        Node current = searchNodeEnd(word);

        // The word is not on the trie and we cannot delete her
        if (current == null) { return false; }

        /*
            Now there are three cases we must check

            1 - Node does not have any children
            2 - Node has more children
            3 - Nodes parents have children
        */

        // Case 2 is easier to deal with, so we begin with it
        if ( current.hasChildren() ) { current.endWord = false; return true; }

        // Case 1 and 3 are quite similar on implementation, so now is their turn
        while ( current != root )
        {
            // Checks if parent has more children (fork) - if so, stops deleting there
            if ( current.parent.hasFork() ) { current.parent.removeChild(current.data); return true; }

            // Removes child from the trie
            if ( !current.hasChildren() ) { current.parent.removeChild(current.data); }

            current = current.parent;
        }
        return true;
    }

    private Node searchNodeByPrefix(String prefix)
    {
        String[] chars = prefix.split("");
        Node current = root;
        int count = 0;
        for (String e : chars)
        {
            if ( current.hasChild(e) )
            {
                current = current.getChild(e);
                count++;
            }
        }
        return count == chars.length ? current : null;
    }

    private Node searchNodeEnd(String prefix)
    {
        String[] chars = prefix.split("");
        Node current = root;
        int count = 0;
        for (String e : chars)
        {
            if ( current.hasChild(e) )
            {
                current = current.getChild(e);
                count++;
            }
        }
        return count == chars.length && current.endWord ? current : null;
    }

    private ArrayList<String> getWords(Node current, ArrayList<String> words, String data)
    {
        for ( Node child : current.getChildren().values() )
        {
            if (child.endWord) { words.add(data + child.data); }
            if ( child.hasChildren() ) { getWords(child, words, data + child.data); }
        }
        return words;
    }

    public void getWordsFromPrefix(String prefix)
    {
        Node current = searchNodeByPrefix(prefix);
        if (current != null)
        {
            ArrayList<String> wordsFromPrefix = new ArrayList<>();
            wordsFromPrefix = getWords(current, wordsFromPrefix, "");
        }
    }
}