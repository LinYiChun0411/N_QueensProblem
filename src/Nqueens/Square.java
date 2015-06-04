package Nqueens;

public class Square {
	public String column;
	public String row;
	public String leftDiagonal;
	public String rightDiagonal;
	
	public Square(String row,String column,String leftDiagonal,String rightDiagonal){
		this.row=row;
		this.column=column;
		this.leftDiagonal=leftDiagonal;
		this.rightDiagonal=rightDiagonal;
	}
	void showSquareLine(){
		System.out.println("T:{"+this.row+","+this.column+","+this.leftDiagonal+","+this.rightDiagonal+"}");
	}
}
