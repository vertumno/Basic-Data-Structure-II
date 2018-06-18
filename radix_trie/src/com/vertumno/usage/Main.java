package com.vertumno.usage;

import com.vertumno.radix_trie.RadixTrie;

public class Main
{
    public static void main(String[] args)
    {
        RadixTrie rt = new RadixTrie();
        String[] toInsert = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        for(String e : toInsert) rt.insert(e);
        rt.print();
    }
}