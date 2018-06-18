package com.vertumno.usage;

/**
 * @author Lucas Gomes Dantas
 * @date June the 18th, 2018
 * Main class to only call a few functions and check how it works.
 */

import com.vertumno.radix_trie.RadixTrie;

/**
 * The type Main.
 */
public class Main
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        RadixTrie rt = new RadixTrie();
        String[] toInsert = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        for(String e : toInsert) rt.insert(e);
        for(String j : rt.getWordsFromPrefix("the")) System.out.println(j);
    }
}