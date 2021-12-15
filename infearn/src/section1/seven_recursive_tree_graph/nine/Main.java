package section1.seven_recursive_tree_graph.nine;

/*
Tree 말단 노드까지의 가장 짧은 경로

출력
1
 */

class Node {
    Node lt, rt;
    int data;

    public Node(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
public class Main {
    Node root;
    public static void main(String[] args) {
        Main main = new Main();

        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);

        System.out.println(main.DFS(0, main.root));
    }

    public int DFS(int L, Node node) {
        if (node.lt == null && node.rt == null) return L;
        else {
            return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
        }
    }
}
