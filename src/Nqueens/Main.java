package Nqueens;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Main {	
	public static void main(String[] args) throws IOException {
		final int N=5;
		String filePath="D:\\outputfile.txt";
		Square board[][]=new Square[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[i][j]=new Square("C"+j,"R"+i,"LD"+(i+j),"RD"+((N-1)-j+i));			
			}
		}
		Queue queue = new Queue();//宣告 queue
		for(int i=0;i<N;i++){//檢查每個Square
			for(int j=0;j<N;j++){			
				Square T=(Square)board[i][j];											
				DoTheAlgorithm(T,queue);
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter(filePath)); 
		queue.showQueue(out);
		queue.showQueue();
		out.close();
		System.out.println("Q("+N+")="+queue.getNumberOfSolution(N));
		
	}
	static Tuple Union(Square T,Tuple tuple)//S聯集T
	{
		Vector<String> newS=new Vector<String>();//新的攻擊範圍
		newS.add(T.row);
		newS.add(T.column);
		newS.add(T.leftDiagonal);
		newS.add(T.rightDiagonal);
		for(int i=0;i<tuple.S.size();i++){//舊的攻擊範圍
			if(tuple.S.get(i)!="emptySet"){
				newS.add(tuple.S.get(i));
			}
		}
		Tuple IntersectionTuple =new Tuple(newS,tuple.getIndex());
		return IntersectionTuple;
	}
	static void DoTheAlgorithm(Square T,Queue queue){//將square跟queue裡面的每個tuple做檢查		
		Vector<Tuple> tuples=queue.tuples;
		
		for(int i=0;i<tuples.size();i++){//把queue的每個tuple拿出來比對
			Tuple tuple=(Tuple)tuples.get(i);//從queue取出一個tuple
			if(tuple.SIntersectionT(T)==false)//如果這個square的T(攻擊範圍)跟此tuple沒有交集
			{
				Tuple newTuple=Union(T,tuple);
				if(queue.isInQueue(newTuple))//檢查T聯集S是否在Queue裡面 
				{		 
					//聯集後產生衝突所以不放入
				}
				else{
					queue.addTuple(newTuple);//T聯集Tuple的S變成一組tuple放入queue
				}			
			}		
		}
	}

		
	
	

}


