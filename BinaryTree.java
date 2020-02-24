import java.util.ArrayList;

public class BinaryTree {

    private ArrayList<Node> BSTnodesArray;
    private Node root;
    private int size;

    public BinaryTree(){
        BSTnodesArray = new ArrayList<>();
        size = 0;
    }

    private Node creatNode(Node left, int data, int index,Node right){
        Node newNode = new Node(left, data,index,right);
        newNode.setIndex(size);
        return newNode;
    }

    public void setBSTnodesArray(ArrayList<Integer> bstSurvey){
        int i = 0;
        for (Integer integer:bstSurvey) {
            BSTnodesArray.add(new Node(null, integer, i, null));
            i++;
        }
    }

    private Node validate(int index) throws Exception {
        for (Node node : BSTnodesArray) {
            if (node.getIndex() == index)
                return node;
        }
        throw new Exception("there is no such node with this index");
    }

    private Node addRoot() throws Exception {
        this.root = validate(0);
        this.root.setIndex(size);
        size = 1;
        return root;
    }

    private Node addLeft(int parentIndex , int childIndex) throws Exception {
        Node parent = validate(parentIndex);
        Node leftChild = validate(childIndex);
        leftChild.setIndex(size);
        size++;
        if (parent.getLeft() != null)
            throw new Exception("this parent already has a left child");

        if(leftChild.getData() == -1)
            parent.setLeft(null);
        else
            parent.setLeft(leftChild);

        return leftChild;
    }

    private Node addRight(int parentIndex , int childIndex) throws Exception {
        Node parent = validate(parentIndex);
        Node rightChild = validate(childIndex);
        rightChild.setIndex(size);
        size++;
        if (parent.getRight() != null)
            throw new Exception("this parent already has a right child");

        if (rightChild.getData() == -1)
            parent.setRight(null);
        else
            parent.setRight(rightChild);

        return rightChild;
    }

    public void makeTree() throws Exception {

        int i = 0;
        addRoot();
        while (i<BSTnodesArray.size()){

            try {
                i++;
                addLeft(i/2, i);
                i++;
                addRight(i/2-1, i);
            } catch (Exception e) {
                System.out.println("Binary tree is ready");
            }


        }

    }

    public void myToString() throws Exception {

        int j, start = 0;
        for (int i = 0; i < depth(getSize()) ; i++) {
            for (j = start; j <start+Math.pow(2,i) && j<getSize() ; j++) {

                if (getNode(j) != null)
                    System.out.println(getNode(j).getData());
                else
                    System.out.print(" ");

            }
            start = j;
            System.out.println();
        }

    }

    public Node getNode(int index) throws Exception {
        return validate(index);
    }

    public int getSize(){
        return size;
    }

    public Node getRoot(){
        return root;
    }

    public boolean checkBST(Node root){

        boolean flage = true;
        boolean r = true;
        boolean l = true;

        Node left = root.getLeft();
        Node right = root.getRight();

        if (root == null)
            return true;

        if (left != null){
            if (left.getData() < root.getData()) {
                l = checkBST(left);
            }else
                flage = false;
        }
        if (right != null) {
            if (right.getData() > root.getData()){
                r = checkBST(right);
            }else
                flage = false;
        }

        return flage&&r&&l;

    }

    private long round(double num){
        if(Math.round(num) < num)
            return Math.round(num) + 1;
        return Math.round(num);
    }

    public long depth(int n){
        return round(Math.log(n - 1)) +1;
    }

    public int subTreeNodes(Node root){
        int nodes = 1;

        if (root == null)
            return 0;

        nodes += subTreeNodes(root.getLeft()) + subTreeNodes(root.getRight());

        return nodes;
    }

    public boolean checkAVL(Node root){

        long hL = 0;
        long hR = 0;

        if(checkBST(root)){

            for (Node subRoot:BSTnodesArray) {
                if (subRoot.getLeft() != null)
                    hL = depth(subTreeNodes(subRoot.getLeft()));
                if (subRoot.getRight() != null)
                    hR = depth(subTreeNodes(subRoot.getRight()));

                if (Math.abs(hL - hR) > 1)
                    return false;

            }

        }else
            return false;
        return true;
    }

}
