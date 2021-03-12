package ch05;

public class BiTree implements IBiTree{
    private BiTreeNode root;		// 树的根结点

    // 构造一棵空树
    public BiTree()
    {
        this.root = null;
    }

    // 构造一棵树
    public BiTree(BiTreeNode root)
    {
        this.root = root;
    }

    @Override
    public BiTreeNode getRoot() {
        return root;
    }

    @Override
    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    @Override
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
        if (T1 == null && T2 == null)
            return true;
        else
        if (T1.data.equals(T2.data))
            if (isEqual(T1.lchild, T2.lchild))
                if (isEqual(T1.rchild, T2.rchild))
                    return true;
        return false;
    }

    @Override
    public void preRootTraverse(BiTreeNode T) {
        if (T != null) {
            System.out.print(T.data);		// 访问根结点
            preRootTraverse(T.lchild);		// 先根遍历左子树
            preRootTraverse(T.rchild);		// 先根遍历右子树
        }
    }

    @Override
    public void inRootTraverse(BiTreeNode T) {
        if (T != null)
        {
            inRootTraverse(T.lchild);		// 中根遍历左子树
            System.out.print(T.data);		// 访问根结点
            inRootTraverse(T.rchild);		// 中根遍历右子树
        } else {
            System.out.println("树为空!");
        }
    }

    @Override
    public void postRootTraverse(BiTreeNode T) {
        if (T != null) {
            postRootTraverse(T.lchild);			// 后根遍历左子树
            postRootTraverse(T.rchild);			// 后根遍历右子树
            System.out.print(T.data);			// 访问根结点
        } else {
            System.out.println("树为空!");
        }
    }
}
