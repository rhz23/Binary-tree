package entities;

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> rootNode;

    public BinaryTree(){
        this.rootNode = null;
    }

    public void insert(T data){
        BinNode<T> newNode = new BinNode<T>(data);
        rootNode = insert(rootNode, newNode);
    }

    private BinNode<T> insert(BinNode<T> actual, BinNode<T> newNode){
        if (actual == null){
            return newNode;
        }else if(newNode.getData().compareTo(actual.getData()) < 0){
            actual.setLeftNode(insert(actual.getLeftNode(), newNode));
        }else{
            actual.setRightNode(insert(actual.getRightNode(), newNode));
        }
        return actual;
    }

    public void printInOrder(){
        System.out.println("\n Showing InOrder:");
        printInOrder(this.rootNode);
    }

    private void printInOrder(BinNode<T> actual){
        if(actual != null){
            printInOrder(actual.getLeftNode());
            System.out.print(actual.getData() + ", ");
            printInOrder(actual.getRightNode());
        }
    }

    public void printPosOrder(){
        System.out.println("\n Showing PosOrder:");
        printPosOrder(this.rootNode);
    }

    private void printPosOrder(BinNode<T> actual){
        if(actual != null){
            printPosOrder(actual.getLeftNode());
            printPosOrder(actual.getRightNode());
            System.out.print(actual.getData() + ", ");

        }
    }

    public void printPreOrder(){
        System.out.println("\n Showing PreOrder:");
        printPreOrder(this.rootNode);
    }

    private void printPreOrder(BinNode<T> actual){
        if(actual != null){
            System.out.print(actual.getData() + ", ");
            printPreOrder(actual.getLeftNode());
            printPreOrder(actual.getRightNode());
        }
    }

    public void remove(T data){
        try{
            BinNode<T> actualNode = this.rootNode;
            BinNode<T> fatherNode = null;
            BinNode<T> sonNode = null;
            BinNode<T> tempNode = null;

            while (actualNode != null && !actualNode.getData().equals(data)){
                fatherNode = actualNode;
                if(data.compareTo(actualNode.getData()) < 0){
                    actualNode = actualNode.getLeftNode();
                }
                else{
                    actualNode = actualNode.getRightNode();
                }
            }
            if(actualNode  == null){
                System.out.println("Data not found. Try Block");
            }

            if(fatherNode == null){
                if(actualNode.getRightNode() == null){
                    this.rootNode = actualNode.getLeftNode();
                }else if(actualNode.getLeftNode() == null){
                    this.rootNode = actualNode.getRightNode();
                }else{
                    for (tempNode = actualNode, sonNode = actualNode.getLeftNode();
                         sonNode.getRightNode() != null;
                         tempNode = sonNode, sonNode = sonNode.getLeftNode()){
                        if(sonNode != actualNode.getLeftNode()){
                            tempNode.setRightNode(sonNode.getLeftNode());
                            sonNode.setLeftNode(rootNode.getLeftNode());
                        }
                    }
                    sonNode.setRightNode(rootNode.getRightNode());
                    rootNode = sonNode;
                }
            }else if(actualNode.getRightNode() == null){
                if(fatherNode.getLeftNode() == actualNode){
                    fatherNode.setLeftNode(actualNode.getLeftNode());
                }else{
                    fatherNode.setLeftNode(actualNode.getLeftNode());
                }
            }else if(actualNode.getLeftNode() == null){
                if(fatherNode.getLeftNode() == actualNode){
                    fatherNode.setLeftNode(actualNode.getRightNode());
                }else{
                    fatherNode.setRightNode(actualNode.getRightNode());
                }
            }else{
                for(tempNode = actualNode, sonNode = actualNode.getLeftNode();
                    sonNode.getRightNode() != null;
                    tempNode = sonNode, sonNode = sonNode.getRightNode()
                ){
                     if(sonNode != actualNode.getLeftNode()){
                         tempNode.setRightNode(sonNode.getLeftNode());
                         sonNode.setLeftNode(actualNode.getLeftNode());
                     }
                     sonNode.setRightNode(actualNode.getRightNode());
                     if(sonNode.getLeftNode() == actualNode){
                         fatherNode.setLeftNode(sonNode);
                     }else{
                         fatherNode.setRightNode(sonNode);
                     }
                }
            }

        }catch(NullPointerException e){
            System.out.println("Data not found. Catch Block");
        }
    }
}
