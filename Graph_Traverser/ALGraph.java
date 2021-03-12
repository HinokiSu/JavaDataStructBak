package ch06;

import java.util.Scanner;

public class ALGraph implements IGraph {
	public enum GraphKind {
		UDG,
		DG,
		UDN,
		DN;
	}
	private GraphKind kind;			// 图的种类标志
	private int vexNum, arcNum;		// 图的当前顶点数和边数
	private  VNode[] vexs;			// 顶点

	// 邻接表构造方法--初始化
	public ALGraph() {
		this(null, 0, 0, null);
	}
	// 邻接表构造方法--带全参数的初始化
	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	// 创建图
	@Override
	public void createGraph() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入图的类型:");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch (kind) {
		case UDG:
			createUDG();
			return;
		case DG:
			createDG();
			return;
		case UDN:
			createUDN();
			return;
		case DN:
			createDN();
			return;
		}
		sc.close();
	}

	//
	@Override
	public int getVexNum() {
		return vexNum;
	}

	@Override
	public int getArcNum() {
		return arcNum;
	}

	@Override
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v].getData();
	}

	// 给定顶点的值vex，返回其在图中的位置，若图中不包含此顶点，则返回-1
	@Override
	public int locateVex(Object vex) throws Exception {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.equals(vex))
				return v;
		return -1;
	}

	@Override
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;
		else
			return -1;
	}

	@Override
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];
		ArcNode arcvw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc)
			if (arc.adjVex == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.nextArc != null)
			return arcvw.nextArc.adjVex;
		else
			return -1;
	}
	
	// 在位置为v、u的顶点之间，添加一条弧，其权值为value
	public void addArc(int v, int u, int value) {
		ArcNode arc = new ArcNode(u, value);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}
	
	// 获取顶点
	public VNode[] getVexs() {
		return vexs;
	}
	
	// 获取图的类型
	public GraphKind getKind() {
		return kind;
	}
	
	// 创建各种类型的图
	// 创建无向图
	private void createUDG() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点: ");
		// 构造顶点向量
		for (int v = 0; v < vexNum; v++)
			vexs[v] = new VNode(sc.next());
		System.out.println("请输入各边的顶点及其权值: ");
		for (int k =0; k < arcNum; k++) {
			int v = locateVex(sc.next());		// 弧尾
			int u = locateVex(sc.next());		// 弧尾
			addArc(v, u, 1);				// 权值设为1
			addArc(u, v, 1);
		}
		sc.close();
	}
	
	// 创建有向图
	private void createDG() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点: ");
		// 构造顶点向量
		for (int v = 0; v < vexNum; v++)
			vexs[v] = new VNode(sc.next());
		System.out.println("请输入各边的顶点及其权值: ");
		for (int k =0; k < arcNum; k++) {
			int v = locateVex(sc.next());		// 弧尾
			int u = locateVex(sc.next());		// 弧尾
			addArc(v, u, 1);				// 权值设为1
		}
		sc.close();
	}
	// 创建无向网
	private void createUDN() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点: ");
		// 构造顶点向量
		for (int v = 0; v < vexNum; v++)
			vexs[v] = new VNode(sc.next());
		System.out.println("请输入各边的顶点及其权值: ");
		for (int k =0; k < arcNum; k++) {
			int v = locateVex(sc.next());		// 弧尾
			int u = locateVex(sc.next());		// 弧尾
			int value = sc.nextInt();
			addArc(v, u, value);
			addArc(u, v, value);

		}
		sc.close();
	}
	// 创建有向网
	private void createDN() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数、图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点: ");
		// 构造顶点向量
		for (int v = 0; v < vexNum; v++)
			vexs[v] = new VNode(sc.next());
		System.out.println("请输入各边的顶点及其权值: ");
		for (int k =0; k < arcNum; k++) {
			int v = locateVex(sc.next());		// 弧尾
			int u = locateVex(sc.next());		// 弧尾
			int value = sc.nextInt();
			addArc(v, u, value);
		}
		sc.close();
	}

}
