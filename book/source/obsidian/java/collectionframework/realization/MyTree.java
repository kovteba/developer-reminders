package kovteba.collection;

public class MyTree {

    private Node head;
    private Node tail;


    static class Node {

        String key;
        Integer value;
        Node left = null;
        Node right = null;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public void put(String key, Integer value) {

        var newNode = new Node(key, value);

        if (head == null) {
            head = newNode;
        }

        if (tail == null) {
            tail = newNode;
        }

    }

    public Node min() {
        Node minNode = head;

        Node currentNode1 = head;

        while (currentNode1.left != null) {
            if (currentNode1.left.getValue() < minNode.getValue()) {
                minNode = currentNode1.left;
            }
            currentNode1 = currentNode1.left;
        }

        Node currentNode2 = head;

        while (currentNode2.right != null) {
            if (currentNode2.right.getValue() < minNode.getValue()) {
                minNode = currentNode2.right;
            }
            currentNode2 = currentNode2.right;
        }

        return minNode;
    }


}
