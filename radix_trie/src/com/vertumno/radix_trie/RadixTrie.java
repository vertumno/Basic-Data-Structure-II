package com.vertumno.radix_trie;

import java.util.ArrayList;

public class RadixTrie
{
    public static Node root;

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

    public boolean searchWord(String word)
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

    public void printTrie()
    {
        ArrayList<String> words = new ArrayList<>();
        for ( String e : getWords(root, words, "") ) { System.out.println(e); }
    }
}