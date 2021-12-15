package section1.seven_recursive_tree_graph.seven;

/*
이진트리 순회(넓이우선탐색 : 레벨탐색)

출력
1 2 3 4 5 6 7
 */

import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node lt, rt;
    int data;

    public Node(int data) {
        this.lt = null;
        this.rt = null;
        this.data = data;
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

        tree.BFS(tree.root);
    }

    private void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            if (cur.lt != null) Q.offer(cur.lt);
            if (cur.rt != null) Q.offer(cur.rt);
            System.out.print(cur.data + " ");
        }
    }
}
