package Nqueens;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Vector;
public class Tuple {
	Vector<String> S=new Vector<String>();//Candidate��closelines
	int index;//�X�ر��p
	public Tuple(Vector<String> S,int index){
		this.S=S;
		this.index=index;
	}
	void setIndex(int index){
		this.index=index;
	}
	int getIndex(){
		return this.index;
	}	
	void showTupleCloseLine(PrintWriter out) throws IOException//�ɮ׿�X
	{									
				out.print("<");	
				for(int i=0;i<S.size();i++){					
					out.print(this.S.get(i)+",");
				}					
				out.println(this.index+">");		
	}
	void showTupleCloseLine() //console��X
	{
		System.out.print("<");
		for (int i = 0; i < S.size(); i++) {
			System.out.print(this.S.get(i) + ",");
		}
		System.out.println(this.index + ">");
	}
	Boolean SIntersectionT(Square T){//	
		HashSet<String> Tuple_closeLine=new HashSet<String>();
		for(int i=0;i<S.size();i++){
			Tuple_closeLine.add((String) S.get(i));		 		
		}
		if(Tuple_closeLine.contains(T.column)||Tuple_closeLine.contains(T.leftDiagonal)||Tuple_closeLine.contains(T.row)||Tuple_closeLine.contains(T.rightDiagonal))
		{
			return true;
		}else{	
			return false;
		}
	}	
}
