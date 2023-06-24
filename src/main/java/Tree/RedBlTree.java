public class RedBlTree {
   // class RBTree{
/*
        Node root;

        class Node {
            int value;
            Node left;
            Node right;
            Color color;

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", color=" + color +
                        '}';
            }

 */
/*
            public void insert(int value) {
                if (root == null) {
                    root = new Node();
                    root.value = value;
                } else {
                    insert(root, value);
                }
                root.color = Color.BLACK;
            }

            private void insert(Node node, int value) {
                if (node.value != value) {
                    if (node.value < value) {
                        // right
                        if (node.right == null) {
                            node.right = new Node();
                            node.right.value = value;
                            node.right = rebalance(node.right);
                            node.right.color = Color.RED;
                        } else {
                            insert(node.right, value);
                        }
                    } else {
                        // left
                        if (node.left == null) {
                            node.left = new Node();
                            node.left.value = value;
                            node.left = rebalance(node.left);
                            node.left.color = Color.RED;
                        } else {
                            insert(node.left, value);
                        }
                    }
                }
                }
            }

            public Node find(int value) {
                return  find(root, value);
            }

            private Node find(Node node, int value) {
                if(node == null) {
                    return null;
                }
                if (node.value == value) {
                    return node;
                }
                if(node.value < value) {
                    return find(node.right, value);
                } else {
                    return find(node.left, value);
                }
            }
        }
   // }*/

    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    
    public boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }


    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private Color color;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color {
        RED, BLACK
    }




    /*
    public boolean contains(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            if (node.value == value > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }
   */
}
