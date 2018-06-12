public class Main
{
    public static void main (String[] args)
    {
        User u1 = new User(10);
        User u2 = new User(15);
        User u3 = new User(5);
        User u4 = new User(6);

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(u1);
        bst.insert(u2);
        bst.insert(u3);
        bst.insert(u4);

        bst.printTree();
    }
}