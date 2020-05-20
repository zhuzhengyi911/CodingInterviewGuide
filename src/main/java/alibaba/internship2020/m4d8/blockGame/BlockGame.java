package alibaba.internship2020.m4d8.blockGame;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BlockGame {

    public static Graph createGraph(int[][] map, int k) {
        Graph graph = new Graph();
        process(map, graph, 0, 0, k, null);
        return graph;
    }

    public static Node process(int[][] map, Graph graph, int x, int y, int k, Node parent) {
        String id = String.valueOf(x) + "_" + String.valueOf(y);
        Node currentNode;
        if (graph.nodes.containsKey(id)) {
            currentNode = graph.nodes.get(id);
        } else {
            currentNode = new Node(map[x][y]);
            graph.nodes.put(id, currentNode);

            // 向右
            for (int i = x, j = y + 1; j < Math.min(y + k + 1, map[0].length); j++) {
                if (map[x][y] < map[i][j]) {
                    Node child = process(map, graph, i, j, k, currentNode);
                    currentNode.nexts.add(child);
                    currentNode.out++;
                }
            }

            // 向下
            for (int i = x + 1, j = y; i < Math.min(x + k + 1, map.length); i++) {
                if (map[x][y] < map[i][j]) {
                    Node child = process(map, graph, i, j, k, currentNode);
                    currentNode.nexts.add(child);
                    currentNode.out++;
                }
            }

            // 向左
            for (int i = x, j = y - 1; j > Math.max(y - k - 1, -1); j--) {
                if (map[x][y] < map[i][j]) {
                    Node child = process(map, graph, i, j, k, currentNode);
                    currentNode.nexts.add(child);
                    currentNode.out++;
                }
            }

            // 向上
            for (int i = x - 1, j = y; i > Math.max(x - k - 1, -1); i--) {
                if (map[x][y] < map[i][j]) {
                    Node child = process(map, graph, i, j, k, currentNode);
                    currentNode.nexts.add(child);
                    currentNode.out++;
                }
            }
        }

        if (parent != null) {
            currentNode.in++;
            currentNode.pres.add(parent);
        }


        return currentNode;
    }

    public static int getMax(Graph graph){
        int res = 0;
        // 拓扑排序
        Queue<Node> zeroInQueue = new LinkedList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
        }
        zeroInQueue.add(graph.nodes.get("0_0"));
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            int max = 0;
            for (Node pre : cur.pres) {
                max = Math.max(max, pre.value);
            }
            cur.value = cur.value + max;
            res = Math.max(res, cur.value);

            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }

    public static int maxValueSum(int[][] map, int k) {
        if (map == null || map.length == 0 || map[0].length == 0 || k < 0) {
            return 0;
        }
        if (k == 0) {
            return map[0][0];
        }

        Graph graph = createGraph(map, k);

        int res = getMax(graph);

        return res;
    }

    public static void main(String[] args) {
//        int[][] map = new int[][]{
//                {1, 4, 2, 3, 0, 6},
//                {0, 3, 7, 8, 2, 4},
//                {6, 7, 5, 9, 4, 3},
//                {4, 5, 0, 10, 5, 2}
//        };
//        int k = 3;

        int[][] map = new int[][]{
                {1, 0, 0, 3},
                {2, 3, 0, 4},
                {3, 4, 0, 0},
                {0, 5, 0, 0},
        };
        int k = 2;

        System.out.println(maxValueSum(map, k));
    }

}
