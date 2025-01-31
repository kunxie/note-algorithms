package io.github.kunxie.note.notealgorithms.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BreadFirstSearch {

    public static Map<Character, Node> BFS(Map<Character, Set<Character>> G, Character s) {
        Map<Character, Node> V = G.keySet().stream()
            .collect(HashMap::new, (m, k) -> m.put(k, new Node()), HashMap::putAll);

        for (Character v : G.keySet()) {
            if (!v.equals(s)) {
                V.get(v).key = v;
                V.get(v).color = Colors.WHITE;
                V.get(v).distance = Integer.MAX_VALUE;
                V.get(v).parent = null;
            }
        }

        V.get(s).key = s;
        V.get(s).color = Colors.GRAY;
        V.get(s).distance = 0;
        V.get(s).parent = null;
        var queue = new ArrayDeque<Character>();
        queue.add(s);
        while (!queue.isEmpty()) {
            var u = queue.poll();
            for (Character v : G.get(u)) {
                if (V.get(v).color == Colors.WHITE) {
                    V.get(v).color = Colors.GRAY;
                    V.get(v).distance = V.get(u).distance + 1;
                    V.get(v).parent = V.get(u);
                    queue.add(v);
                }
            }
            V.get(u).color = Colors.BLACK;
        }
        return V;
    }

    public static void printPath(Map<Character, Node> V, Character s, Character v) {
        if (v.equals(s)) {
            System.out.printf("%s", v);
        } else if (V.get(v).parent == null) {
            System.out.printf("no path from %s to %s", s, v);
        } else {
            printPath(V, s, V.get(v).parent.key);
            System.out.printf(" -> %s", v);
        }
    }

    public static class Node {
        public Character key;
        public Colors color;
        public Integer distance;
        public Node parent;
    }

    public enum Colors {
        WHITE, GRAY, BLACK;
    }

    public static void main(String[] args) {
        var G = GraphProviders.graph_20_3();
        var V = BFS(G, 's');
        printPath(V, 's', 'z');
    }
}
