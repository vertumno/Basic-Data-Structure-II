package com.vertumno.usage;

import com.vertumno.binary_search_tree.BinarySearchTree;

public class Main
{
    public static void main (String[] args)
    {
        User u1 = new User(50);
        User u2 = new User(30);
        User u3 = new User(20);
        User u4 = new User(40);
        User u5 = new User(70);
        User u6 = new User(60);
        User u7 = new User(80);

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(u1);
        bst.insert(u2);
        bst.insert(u3);
        bst.insert(u4);
        bst.insert(u5);
        bst.insert(u6);
        bst.insert(u7);

        bst.printTree();

        System.out.println("");
        bst.delete(20);
        bst.printTree();

        System.out.println("");
        bst.delete(30);
        bst.printTree();

        System.out.println("");
        bst.delete(50);
        bst.printTree();
    }
}