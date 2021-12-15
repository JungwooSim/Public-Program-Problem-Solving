package section1.seven_recursive_tree_graph.ten;

/*
Tree 말단 노드까지의 가장 짧은 경로

출력
1
 */

import java.util.LinkedList;
import java.util.Queue;

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

        System.out.println(main.BFS(0, main.root));
    }

    private int BFS(int L, Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i=0; i < len; i++) {
                Node node = Q.poll();

                if (node.lt == null && node.rt == null) return L;

                if (node.lt != null) Q.offer(node.lt);
                if (node.rt != null) Q.offer(node.rt);
            }

            L++;
        }
        return 0;
    }
}
