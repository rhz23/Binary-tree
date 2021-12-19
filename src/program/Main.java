package program;

import entities.BinNode;
import entities.BinaryTree;
import entities.Obj;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Obj> myTree = new BinaryTree<>();

        myTree.insert(new Obj(13));
        myTree.insert(new Obj(10));
        myTree.insert(new Obj(25));
        myTree.insert(new Obj(2));
        myTree.insert(new Obj(12));
        myTree.insert(new Obj(20));
        myTree.insert(new Obj(31));
        myTree.insert(new Obj(29));

        myTree.printInOrder();
        myTree.printPreOrder();
        myTree.printPosOrder();
    }
}
