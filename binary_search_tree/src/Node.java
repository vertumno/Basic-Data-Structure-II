public class Node
{
    Object data;
    Node left;
    Node right;

    public Node (Object data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public Node getLeft () { return left; }

    public void setLeft (Node left) { this.left = left; }

    public Node getRight () { return right; }

    public void setRight (Node right) { this.right = right; }
}