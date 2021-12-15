package section1.seven_recursive_tree_graph.five;

/*

1 2 3 4 5 6 7

전위순회 : 1 2 4 5 3 6 7
중위순회 : 4 2 5 1 6 3 7
후위순회 : 4 5 2 6 7 3 1
 */
class Node {
    Node lt, rt;
    int data;

    public Node(int data) {
        this.lt = null;
        this.rt = null;
        this.data = data;
    }

    public void setLt(Node lt) {
        this.lt = lt;
    }

    public void setRt(Node rt) {
        this.rt = rt;
    }

    public Node getLt() {
        return lt;
    }

    public Node getRt() {
        return rt;
    }

    public int getData() {
        return data;
    }
}

public class Main {
    Node root;
    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }

    private void DFS(Node node) {
        if (node == null) return;
        else {
//            System.out.print(node.data + " "); // 전위 순회
            DFS(node.lt);
//            System.out.print(node.data + " "); // 중위 순회
            DFS(node.rt);
            System.out.print(node.data + " "); // 후위 순회
        }
    }
}
