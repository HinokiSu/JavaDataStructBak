package ch05;


public interface IBiTree {

    public BiTreeNode getRoot();			// 获取根结点
    public void setRoot(BiTreeNode root);	// 设置根节点
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2);		// 判断两棵树是否相等

    // 采用递归方法
    public void preRootTraverse(BiTreeNode T);		// 先根遍历二叉树的递归算法
    public void inRootTraverse(BiTreeNode T);		// 中根遍历二叉树的递归算法
    public void postRootTraverse(BiTreeNode T);		// 后根遍历二叉树的递归算法
}
