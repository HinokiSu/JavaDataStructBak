package ch05;

public class TestBiTree {
    public BiTree createBiTree_1() {
        BiTreeNode c = new BiTreeNode('C');
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode f = new BiTreeNode('F');
        BiTreeNode b = new BiTreeNode('B', c, d);
        BiTreeNode e = new BiTreeNode('E', null, f);
        BiTreeNode a = new BiTreeNode('A', b, e);
        return new BiTree(a);			// 创建根节点为a的二叉树
    }
    public BiTree createBiTree_2() {
        BiTreeNode c = new BiTreeNode('C');
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode f = new BiTreeNode('F');
        BiTreeNode b = new BiTreeNode('B', c, d);
        BiTreeNode e = new BiTreeNode('E', null, f);
        BiTreeNode a = new BiTreeNode('A', b, e);
        return new BiTree(a);			// 创建根节点为a的二叉树
    }

    public BiTree createBiTree_3() {
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode e = new BiTreeNode('E');
        BiTreeNode f = new BiTreeNode('F');
        BiTreeNode b = new BiTreeNode('B', d, null);
        BiTreeNode c = new BiTreeNode('C', e, f);
        BiTreeNode a = new BiTreeNode('A', b, c);
        return new BiTree(a);			// 创建根节点为a的二叉树
    }

    public static void main(String[] args) {
        TestBiTree testBiTree = new TestBiTree();
        // 创建树1
        BiTree biTree_1 = testBiTree.createBiTree_1();
        BiTreeNode root_1 = biTree_1.getRoot();
        // 创建树2
        BiTree biTree_2 = testBiTree.createBiTree_2();
        BiTreeNode root_2 = biTree_2.getRoot();
        // 创建树3
        BiTree biTree_3 = testBiTree.createBiTree_3();
        BiTreeNode root_3 = biTree_3.getRoot();

        System.out.print("Tree_1 pre: ");
        biTree_1.preRootTraverse(root_1);
        System.out.println();
        System.out.print("Tree_2 pre: ");
        biTree_2.preRootTraverse(root_2);
        System.out.println();
        System.out.print("Tree_3 pre: ");
        biTree_3.preRootTraverse(root_3);
        System.out.println();

        System.out.print("\nTree_1 与 Tree_2 判断是否相等:");
        if (biTree_1.isEqual(root_1, root_2))
            System.out.print("是");
        else
            System.out.print("否");

        System.out.print("\nTree_1 与 Tree_3 判断是否相等:");
        if (biTree_1.isEqual(root_1, root_3))
            System.out.print("是");
        else
            System.out.print("否");


    }
}
