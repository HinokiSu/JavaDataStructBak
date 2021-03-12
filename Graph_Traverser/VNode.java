package ch06;

public class VNode {
	public Object data;			// 顶点信息
	public ArcNode firstArc;	// 指向第一条依附于该顶点的弧

	// 顶点结点类的构造方法--初始化
	public VNode() {
		this(null, null);
	}

	// 顶点结点类的构造方法--带顶点信息的初始化
	public VNode(Object data) {
		this(data, null);
	}

	// 顶点结点类的构造方法--带全参的初始化
	public VNode(Object data, ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}

	// 获取顶点信息方法
	public Object getData() {
		return data;
	}

}
