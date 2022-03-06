package exp.libs.algorithm.pathfinding.ispa;

import exp.libs.struct.graph.Node;

import java.util.LinkedList;
import java.util.List;


/**
 * <PRE>
 * ISPA问题的可行解
 * </PRE>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class ISPARst {

	/** 是否为可行解 */
	private boolean isVaild;
	
	/** 求解过程的一些提示信息 */
	private String tips;
	
	/** 解的总开销 */
	private int cost;
	
	/** 移动轨迹路由 */
	private List<Node> routes;
	
	protected ISPARst() {
		this.isVaild = false;
		this.tips = "";
		this.cost = -1;
		this.routes = new LinkedList<Node>();
	}

	public boolean isVaild() {
		return isVaild;
	}

	protected void setVaild(boolean isVaild) {
		this.isVaild = isVaild;
	}

	public String getTips() {
		return tips;
	}

	protected void setTips(String tips) {
		this.tips = tips;
	}

	public int getCost() {
		return cost;
	}

	protected void setCost(int cost) {
		this.cost = cost;
	}

	public List<Node> getRoutes() {
		return new LinkedList<Node>(routes);
	}

	protected void setRoutes(List<Node> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[vaild] : ").append(isVaild);
		sb.append("\r\n[tips] : ").append(tips);
		sb.append("\r\n[cost] : ").append(cost);
		sb.append("\r\n[route] : ");
		int size = routes.size();
		if(size > 0) {
			for(int i = 0; i < size - 1; i++) {
				sb.append(routes.get(i)).append(" -> ");
			}
			sb.append(routes.get(size - 1));
		} else {
			sb.append("null");
		}
		return sb.toString();
	}
	
}
