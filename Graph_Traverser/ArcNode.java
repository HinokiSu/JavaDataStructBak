package ch06;

public class ArcNode {
	public int adjVex;			// 该弧所指向的顶点位置
	public int value;			// 边(或弧)的权值
	public ArcNode nextArc;		// 指向下一条弧

	// 边(或弧)结点类的构造方法--初始化
	public ArcNode() {
		this(-1, 0, null);
	}

	// 边(或弧)结点类的构造方法--带顶带你位置的初始化
	public ArcNode(int adjVex) {
		this(adjVex, 0, null);
	}

	// 边(或弧)结点类的构造方法--带顶点位置及边的权值的初始化
	public ArcNode(int adjVex, int value) {
		this(adjVex, value, null);
	}

	// 边(或弧)结点类的构造方法--带全参初始化
	public ArcNode(int adjVex, int value, ArcNode nextArc) {
		this.adjVex = adjVex;
		this.value = value;
		this.nextArc = nextArc;
	}
}
