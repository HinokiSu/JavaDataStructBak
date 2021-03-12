package ch06;

import ch3.LinkQueue;

public class BFSTraverser {
    private static boolean[] visited;       // 访问标志数组

    public static void BFSTraverse(IGraph G) throws Exception {
        visited = new boolean[G.getVexNum()];           // 访问标志数组
        for (int v = 0; v < G.getVexNum(); v++)
            visited[v] = false;         // 访问标志数组初始化
        for (int v = 0; v < G.getVexNum(); v++)
            if (!visited[v])        // v尚未访问
                BFS(G, v);
    }

    public static void BFS(IGraph G, int v) throws Exception {
        visited[v] = true;
        System.out.print(G.getVex(v).toString() + " ");
        LinkQueue Q = new LinkQueue();          // 辅助队列Q
        Q.offer(v);             // v入队列
        while (!Q.isEmpty()) {
            int u = (Integer)Q.poll();      // 队头元素出队列并赋值给u
            for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
                if (!visited[v]) {
                    visited[w] = true;
                    System.out.print(G.getVex(w).toString() + " ");
                    Q.offer(w);
                }
        }
    }
}
