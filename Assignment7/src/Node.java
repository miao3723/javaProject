
public class Node {
	public int id;
	public Object data;
	public Node parent;
	public Node lchild;
	public Node rchild;
	public int lSubTreeHeight;
	public int rSubTreeHeight;
	public int balanceFactor;
	public boolean empty(){
		if(id==0){return false;}
		else return true;
	}
	public Node(){}
	public Node(int id,Node parent){}
	public String toString(){
		return "id="+id+" BF="+balanceFactor;
	}
    
}
