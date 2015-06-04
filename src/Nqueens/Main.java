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
		Queue queue = new Queue();//�ŧi queue
		for(int i=0;i<N;i++){//�ˬd�C��Square
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
	static Tuple Union(Square T,Tuple tuple)//S�p��T
	{
		Vector<String> newS=new Vector<String>();//�s�������d��
		newS.add(T.row);
		newS.add(T.column);
		newS.add(T.leftDiagonal);
		newS.add(T.rightDiagonal);
		for(int i=0;i<tuple.S.size();i++){//�ª������d��
			if(tuple.S.get(i)!="emptySet"){
				newS.add(tuple.S.get(i));
			}
		}
		Tuple IntersectionTuple =new Tuple(newS,tuple.getIndex());
		return IntersectionTuple;
	}
	static void DoTheAlgorithm(Square T,Queue queue){//�Nsquare��queue�̭����C��tuple���ˬd		
		Vector<Tuple> tuples=queue.tuples;
		
		for(int i=0;i<tuples.size();i++){//��queue���C��tuple���X�Ӥ��
			Tuple tuple=(Tuple)tuples.get(i);//�qqueue���X�@��tuple
			if(tuple.SIntersectionT(T)==false)//�p�G�o��square��T(�����d��)��tuple�S���涰
			{
				Tuple newTuple=Union(T,tuple);
				if(queue.isInQueue(newTuple))//�ˬdT�p��S�O�_�bQueue�̭� 
				{		 
					//�p���Უ�ͽĬ�ҥH����J
				}
				else{
					queue.addTuple(newTuple);//T�p��Tuple��S�ܦ��@��tuple��Jqueue
				}			
			}		
		}
	}

		
	
	

}


