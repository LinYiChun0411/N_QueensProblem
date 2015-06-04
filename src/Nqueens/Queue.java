package Nqueens;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Vector;


public class Queue {
	Vector<Tuple> tuples=new Vector<Tuple>();
	
	public Queue()
	{
		//��J�@��closeLine���Ŷ��X��tuple
		Vector<String> S=new Vector<String>();
		S.add("emptySet");
		tuples.add(new Tuple(S,1));
	}
	void addTuple(Tuple tuple){			
		tuples.add(tuple);//�N�s��tuple��Jqueue
	}
	int getNumberOfSolution(int N){
		int sum=0;
		for(int i=0;i<tuples.size();i++){
			Tuple tuple=(Tuple)tuples.get(i);
			if(tuple.S.size()==N*4)
			{
				sum += tuple.index;
			}
		}
		return sum;
	}
	
	Boolean isInQueue(Tuple SintersectionT){//�ˬd��SUT�᪺Result���S���bqueue�̥X�{�L
		HashSet<String> SUT=new HashSet<String>();
		for(int i=0;i<SintersectionT.S.size();i++){
			SUT.add(SintersectionT.S.get(i));
		}

		for(int i=0;i<tuples.size();i++){//�qQueue���X�C��tuple���ˬd
			Tuple tuple=(Tuple)tuples.get(i);
			HashSet<String> tupleSet=new HashSet<String>();//Tuple��closeLine
			for(int j=0;j<tuple.S.size();j++){
				tupleSet.add(tuple.S.get(j));
			}
			if(tupleSet.equals(SUT))//�ˬdSUT��close�O�_�bQueue�̭���Tuple����
			{		
				int j=tuple.getIndex();
				tuple.setIndex(j+SintersectionT.getIndex());
				return true;
			}	
		}
		return false;
	}
	
	void j_replace_iaddj(Tuple SintersectionT){
		HashSet<String> SintersectionTSet =new HashSet<String>();
		for(int i=0;i<SintersectionT.S.size();i++)
		{
			SintersectionTSet.add((String)SintersectionT.S.get(i));		
		}		
		for(int i=0;i<tuples.size();i++){//�qQueue���X�C��tuple���ˬd
			Tuple tuple=(Tuple)tuples.get(i);
			HashSet<String> tupleSet =new HashSet<String>();
			for(int j=0;j<tuple.S.size();j++){
				tupleSet.add((String)tuple.S.get(j));			
			}
			if(tupleSet.containsAll(SintersectionTSet))
			{							
				tuple.setIndex(tuple.getIndex()+SintersectionT.getIndex());
				
			}		
		}	
	}
	void showQueue(PrintWriter out) throws IOException{//�ɮ׿�X
		for(int i=0;i<tuples.size();i++){
			Tuple tuple=(Tuple)tuples.get(i);
			tuple.showTupleCloseLine(out);		
		}
		
	}
	void showQueue( ){//console��X
		for(int i=0;i<tuples.size();i++){
			Tuple tuple=(Tuple)tuples.get(i);			
				tuple.showTupleCloseLine();		
		}
	}
	
	

}
