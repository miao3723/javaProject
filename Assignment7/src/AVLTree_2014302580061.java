import javax.swing.JTree;
import java.util.LinkedList;
import java.util.Scanner;
public class AVLTree_2014302580061 implements IAVLTree{
private static final int LHigher = 1;    //���  
private static final int EHigh = 0;    //�ȸ�  
private static final int RHigher = -1;   //�Ҹ�  
private Node root;
private int TreeSize;

public int size(){  
    return TreeSize;  
 }

public AVLTree_2014302580061(){
	root=null;
	TreeSize=0;
}

@Override
public Node get(int id) {
	Node first = root;    
    while (first != null) {    
      if (id == first.id) {    
        return first;    
    } else if (id<first.id) {    
        first = first.lchild;    
    } else {    
        first = first.rchild;    
    }    
}    
     return null;
	// TODO Auto-generated method stub
}

@Override
public void insert(int id, Node newNode) {
	 int i=0;
	 Node t = root;  
	        if(t == null){  
	            root = newNode;
	            newNode.parent=null;
	            TreeSize = 1;  
	             
	        }  
	        else{
	        Node parent;  //����t�ĸ��ڵ�  
	       
	        //�Ӹ��ڵ������������ҵ�����λ��  
	        do {  
	            parent = t;       
	            if(id<parent.id){  
	                t = t.lchild;  
	            }else if(id>parent.id){  
	               t = t.rchild;  
	            }else{  
	                 System.out.println("idΪ"+id+"�Ľڵ��Ѿ����ڣ�����ʧ��"); 
	                 i=1;
	                 t=null;
	           }  
	       } while (t!=null);  
	   if(i==0) {      
	        Node child = newNode; 
	        newNode.parent=parent;
	        if(id<parent.id){  
	            parent.lchild = child;  
	             }else{  
	           parent.rchild = child;     
	        }  
	         
	        while(parent!=null){  
	             if(id < parent.id){    //�½ڵ��Ϊ���������� 
	                parent.balanceFactor++;  
	                }else{           //�½ڵ��Ϊ�������Һ���
	                parent.balanceFactor--;  
	           }  
	           if(parent.balanceFactor == 0){    //�˽ڵ��balanceFactorΪ0���������ϵ���BFֵ���Ҳ���Ҫ��ת  
	               break;  
	           }  
	           if(parent.balanceFactor == 2||parent.balanceFactor == -2){  //�ҵ���ƽ��ĸ��ڵ㣬���е��� 
	               adjustAfterInsertion(parent);  
	                break;                  
	           }  
	           parent = parent.parent;  
	       } 
	       
	        TreeSize ++;  
	   }
	        }// TODO Auto-generated method stub
	}

private void adjustAfterInsertion(Node q){  
    if(q.balanceFactor == 2){  
        leftBalance(q);  
    }  
    if(q.balanceFactor == -2){  
        rightBalance(q);  
    }  
} 

private boolean leftBalance(Node b){ //��ƽ�� 
    boolean heightLower = true;  
     Node first = b.lchild;  
     switch (first.balanceFactor) {  
     case LHigher:            //t����������������  
         b.balanceFactor = first.balanceFactor = EHigh;  
       RR(b);  
         break;   
     case RHigher:            //t����������������                                            
        Node newChild = first.rchild;  
        switch (newChild.balanceFactor) {   //���������ڵ��BF  
        case LHigher:       
            b.balanceFactor = RHigher;  
             first.balanceFactor = EHigh;  
             break;  
           
         case RHigher:     
             b.balanceFactor = EHigh;  
             first.balanceFactor = LHigher;  
             break; 
         case EHigh:      
             b.balanceFactor = first.balanceFactor = EHigh;  
             break;
         }  
         newChild.balanceFactor = EHigh;  
         RL(b.lchild);  
         RR(b);  
         break;  
     case EHigh:       
         first.balanceFactor = RHigher;  
         b.balanceFactor = LHigher;  
         RR(b);  
         heightLower = false;  
         break;  
     }  
     return heightLower;  
 } 

private boolean rightBalance(Node b){  //�Ҳ�ƽ��
    boolean hL = true;  
    Node r = b.rchild;  
    switch (r.balanceFactor) {  
    case LHigher:            //��ߣ����������  
        Node ld = r.lchild;  
        switch (ld.balanceFactor) {   //���������ڵ��BF  
        case LHigher:     
            b.balanceFactor= EHigh;  
            r.balanceFactor = RHigher;  
            break;  
        case EHigh:       
            b.balanceFactor = r.balanceFactor = EHigh;  
            break;  
        case RHigher:      
            b.balanceFactor = LHigher;  
            r.balanceFactor = EHigh;  
            break;  
        }  
        ld.balanceFactor = EHigh;  
        RR(b.rchild);  
       RL(b);  
        break;  
    case RHigher:            //�Ҹߣ���������  
        b.balanceFactor = r.balanceFactor = EHigh;  
        RL(b);  
        break;  
    case EHigh:        
        r.balanceFactor = LHigher;  
        b.balanceFactor = RHigher;  
        RL(b);  
        hL = false;  
        break;  
   }  
    return hL;  
}  
  
   
@Override
public void delete(int id) {
	Node e = get(id);  
    if(e!=null){  
         deleNode(e); 
           
    }  
     // TODO Auto-generated method stub
    }

private void deleNode(Node deleteNode){  //ɾ������ʵ��
    TreeSize --;  
    //���p������������Ϊ�գ��ҵ���ֱ�Ӻ�̣��滻p��֮��pָ��s��ɾ��p��ʵ��ɾ��s  
      
    if (deleteNode.lchild != null && deleteNode.rchild != null) {  
         Node s = fLNode(deleteNode);  
         deleteNode.id = s.id;  
         deleteNode = s;  
    }  
    Node insteadNode = (deleteNode.lchild != null ? deleteNode.lchild : deleteNode.rchild);  

    if (insteadNode != null) {      
        insteadNode.parent = deleteNode.parent;  
        if (deleteNode.parent == null)    
            root = insteadNode;  
        else if (deleteNode == deleteNode.parent.lchild)     
            deleteNode.parent.lchild  = insteadNode;     
        else                              
            deleteNode.parent.rchild = insteadNode;  

        deleteNode.lchild = deleteNode.rchild = deleteNode.parent = null;      
           adjustAfterDeletion(insteadNode);    

     } else if (deleteNode.parent == null) {  
         root = null;  
     } else {   
        adjustAfterDeletion(deleteNode);   
         if (deleteNode.parent != null) {  
            if (deleteNode == deleteNode.parent.lchild)  
                 deleteNode.parent.lchild = null;  
             else if (deleteNode == deleteNode.parent.rchild)  
                 deleteNode.parent.rchild = null;  
            deleteNode.parent = null;  
      }  
     }     
 } 

static Node fLNode(Node t) {  
     Node p = t.rchild;  
        while (p.lchild != null)  
            p = p.lchild;  
        return p;  
 }  

private void adjustAfterDeletion(Node p){  //��ɾ���Ժ���е���
    boolean heightLower = true;     
    Node z = p.parent;  
       while(z!=null && heightLower){  
        if(p.id >= z.id ){     
            z.balanceFactor ++;  
        }else{  
            z.balanceFactor--;  
        }  
        if(z.balanceFactor == 1||z.balanceFactor==-1){     
            break;  
        }  
        Node u = z;  
        
        if(z.balanceFactor == 2){  
            heightLower = leftBalance(u);  
        }else if(z.balanceFactor==-2){  
            heightLower = rightBalance(u);  
        }  
        z = z.parent;  
    }  
}  

 
@Override
public JTree printTree(AVLTree_2014302580061 AVLTree) {
	// TODO Auto-generated method stub
	Node a=AVLTree.root;
	LinkedList<Node> queue=new LinkedList<Node>();
	System.out.print("�ö���ƽ������"+a.id+" ");
	while(a!=null){
		if(a.lchild!=null){
			queue.addLast(a.lchild);
		}
		if(a.rchild!=null){
			queue.addLast(a.rchild);
		}
		a=null;
		if(!queue.isEmpty()){
			a=queue.getFirst();
			System.out.print(a.id+" ");
			queue.removeFirst();
	}
	
	}
	return null;
} 

private void RL(Node unBalancedNode) { //����ת 
     
    if(unBalancedNode!=null){  
       Node r = unBalancedNode.rchild;  
      unBalancedNode.rchild = r.lchild;   //��p����������ڵ�޽ӵ�p���ҽڵ㣬����ͼ����BL��ΪA�����ӽڵ�  
       if (r.lchild != null) //���B����ڵ�BL��Ϊ�գ���BL�ĸ��ڵ���ΪA  
           r.lchild.parent = unBalancedNode;  
       r.parent = unBalancedNode.parent;    
       if (unBalancedNode.parent == null)         
           root = r;                   
      else if (unBalancedNode.parent.lchild == unBalancedNode)  
    	  unBalancedNode.parent.lchild = r;         
        else                          
unBalancedNode.parent.lchild = r;         
      r.lchild= unBalancedNode;                    
       unBalancedNode.parent = r;                 
    }  
}  

private void RR(Node reRoot){ //����ת 
    if(reRoot!=null){  
       Node left = reRoot.lchild;    
         reRoot.lchild = left.rchild;    //��reRoot�������ӵ��Һ���ת��p��������  
         if (left.rchild != null)   //���ԭ��reRoot�������ӵ��Һ��Ӳ�Ϊ�գ����丸���Ϊp  
             left.rchild.parent = reRoot;  
         left.parent = reRoot.parent;  
         if (reRoot.parent == null)   
        	 root = left;            
         else if (reRoot.parent.rchild == reRoot) 
             reRoot.parent.rchild = left;     
        else                        
        	reRoot.parent. lchild = left;        
        left.rchild = reRoot;                
        reRoot.parent = left;                 
     }  
 }  

public static void main(String[] args){
	AVLTree_2014302580061 tree=new AVLTree_2014302580061();
	for(int i=0;i<10;i++){  
        int id = (int)(Math.random() * 100);
        Node newNode = new Node();
        newNode.id=id;
        tree.insert(id,newNode);  
    } 
	
	tree.printTree(tree);
	System.out.println();
	System.out.println();
	int choice=0;
    do{
    	System.out.println("����������ѡ�����ǰ������");
    	System.out.println("1.������ƽ�����в���һ���½��");
    	System.out.println("2.�Ӷ���ƽ������ɾ��һ�����");
    	System.out.println("3.���������");
    	System.out.println("4.����ض����");
    	System.out.println("5.�˳�����");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	choice=input.nextInt();
    	 Node choiceNode=new Node();
    	 int idNum=0;
    	switch(choice){
    	case 1:System.out.println("������������id");
    	    	choiceNode.id=input.nextInt();
    	        tree.insert(choiceNode.id, choiceNode);
    	    	break;
    	case 2:System.out.println("������ɾ������id");
    	        idNum=input.nextInt();
    	        tree.delete(idNum);
    	    	break;
    	case 3: tree.printTree(tree);
    	        System.out.println();
    	    	break;
    	case 4:System.out.println("�������ȡ����id");
    	       idNum=input.nextInt();
    	       Node getTree=tree.get(idNum);
    	        
    	       System.out.println(getTree);
    	       
    	   	break;
    	}
    	System.out.println();
    }while(choice!=5);
}
}
 