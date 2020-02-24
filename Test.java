import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> treeArr = new ArrayList<>();
        BinaryTree binaryTree = new BinaryTree();

        boolean fg = true;
        while (fg){

            System.out.println("1) input tree\n2) check BST\n3) check AVL\n4) three depth\n5) quit\n\n");

            switch (input.nextInt()){

                case 1:
                    System.out.println("enter the BST survey of the tree\nif there is no leaf before and the left of a specific leaf, enter -1 instead.\nenter a \",\" after each node.\nSAMPLE: 10,2,20,1,2,-1,15");

                    String[] nodesChars = input.next().split(",");
                    for (String node:nodesChars) {
                        treeArr.add(Integer.valueOf(node));
                    }

                    binaryTree.setBSTnodesArray(treeArr);
                    binaryTree.makeTree();

                    break;
                case 2:
                    System.out.println(binaryTree.checkBST(binaryTree.getRoot())? "this tree is BST" : "this tree is not BST");
                    break;
                case 3:
                    System.out.println(binaryTree.checkAVL(binaryTree.getRoot())? "this tree is AVL" : "this tree is not AVL");
                    break;
                case 4:
                    System.out.println("tree depth is:" + binaryTree.depth(binaryTree.getSize()));
                    break;
                case 5:
                    fg = false;
                    break;

            }

        }


//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(10);
//        arrayList.add(2);
//        arrayList.add(20);
//        arrayList.add(1);
//        arrayList.add(3);
//        arrayList.add(15);
//
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.setBSTnodesArray(arrayList);
//        binaryTree.makeTree();
//
//        System.out.println(binaryTree.getNode(2).getLeft().getData() );
//
//        //size
//        System.out.println(binaryTree.getSize());
//
//        //check bst
//        System.out.println("BST " + binaryTree.checkBST(binaryTree.getRoot()));
//
//        System.out.println("AVL " + binaryTree.checkAVL(binaryTree.getRoot()));
//
//        //main depth
//        System.out.println(binaryTree.depth(binaryTree.getSize()));
//
//        //sunTreeNodes
//        System.out.println(binaryTree.subTreeNodes(binaryTree.getRoot()));
//
//        binaryTree.myToString();

    }
}
