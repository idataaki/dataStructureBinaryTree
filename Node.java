public class Node {

    int data;
    int index;
    Node left;
    Node right;

    public Node(){

    }

    public Node(Node left, int data, int index,Node right) {
        this.data = data;
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
