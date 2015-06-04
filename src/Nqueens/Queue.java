package Nqueens;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Vector;


public class Queue {
	Vector<Tuple> tuples=new Vector<Tuple>();
	
	public Queue()
	{
		//放入一個closeLine為空集合的tuple
		Vector<String> S=new Vector<String>();
		S.add("emptySet");
		tuples.add(new Tuple(S,1));
	}
	void addTuple(Tuple tuple){			
		tuples.add(tuple);//將新的tuple放入queue
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
	
	Boolean isInQueue(Tuple SintersectionT){//檢查此SUT後的Result有沒有在queue裡出現過
		HashSet<String> SUT=new HashSet<String>();
		for(int i=0;i<SintersectionT.S.size();i++){
			SUT.add(SintersectionT.S.get(i));
		}

		for(int i=0;i<tuples.size();i++){//從Queue取出每個tuple來檢查
			Tuple tuple=(Tuple)tuples.get(i);
			HashSet<String> tupleSet=new HashSet<String>();//Tuple的closeLine
			for(int j=0;j<tuple.S.size();j++){
				tupleSet.add(tuple.S.get(j));
			}
			if(tupleSet.equals(SUT))//檢查SUT的close是否在Queue裡面的Tuple重複
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
		for(int i=0;i<tuples.size();i++){//從Queue取出每個tuple來檢查
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
	void showQueue(PrintWriter out) throws IOException{//檔案輸出
		for(int i=0;i<tuples.size();i++){
			Tuple tuple=(Tuple)tuples.get(i);
			tuple.showTupleCloseLine(out);		
		}
		
	}
	void showQueue( ){//console輸出
		for(int i=0;i<tuples.size();i++){
			Tuple tuple=(Tuple)tuples.get(i);			
				tuple.showTupleCloseLine();		
		}
	}
	
	

}
