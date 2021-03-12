package ch06;

import java.util.Scanner;

public class TestGraph {

    public static void main(String[] args) throws Exception{
        MGraph mg = new MGraph();
        mg.createGraph();
        // 打印邻接矩阵
        System.out.println("邻接矩阵:");
        mg.printArcs();
        // 深度优先搜索序列
        DTraverser dt = new DTraverser();
        System.out.print("深度优先搜索序列为:");
        dt.DFSTraverser(mg);
        System.out.println();
        // 广度优先搜索
        BFSTraverser bfs = new BFSTraverser();
        System.out.print("广度优先搜索序列为:");
        bfs.BFSTraverse(mg);

    }
}
