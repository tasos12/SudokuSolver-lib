import java.util.ArrayList;

public class Board {
	
	private int board[][] = new int[9][9];
	
	public Board(int board[][]) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	public int getBox(int i, int j) {
		return this.board[i][j];
	}

	public int[][] getSquare(int r, int c){
		int[][] Square = new int[3][3];
		int row = (int)Math.floor((r/3))*3;
		int col = (int)Math.floor((c/3))*3;
		
		for(int i=0;i<3;i++) 
			for(int j=0;j<3;j++) 
				Square[i][j] = getBox(row+i, col+j);
		
		return Square;
	}
	
	public int[] getRow(int r){
		int[] Row = new int[9];
		for(int i=0;i<9;i++) 			
			Row[i] = getBox(r, i);
		
		return Row;
	}
	
	public int[] getCol(int c){
		int[] Col = new int[9];
		for(int i=0;i<9;i++) 			
			Col[i] = getBox(i, c);
		
		return Col;
	}
	
	public ArrayList<Integer> getAvailableInput(int r, int c) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		if(getBox(r, c) == 0) {
			for(int i=0;i<9;i++) {
				numberList.add(i);
			}
			int[][] square = getSquare(r, c);
			int[] 	row = getRow(r);
			int[]	col = getCol(c);
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					numberList.remove((Integer)square[i][j]);
					System.out.println("ok");
				}	
			}
			for(int i=0;i<9;i++) {
				numberList.remove((Integer)row[i]);
				numberList.remove((Integer)col[i]);
			}
		}
		return numberList;
	}
	
	/*public boolean solve() {
		
	}*/
	
	public void printBoard() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]);
				if((j+1)%3 == 0 && j!=8) System.out.print("|");
			}
			System.out.println();
			if((i+1)%3 == 0 && i!=8) System.out.println("-------------");
		}
	}
	
	public void printSquare(int r, int c) {
		int square[][] = getSquare(r, c);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(square[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printRow(int r) {
		int[] Row = getRow(r);
		for(int i=0;i<9;i++) 			
			System.out.print(Row[i]);
		System.out.println();
	}
	
	public void printCol(int c) {
		int[] Col = getCol(c);
		for(int i=0;i<9;i++) 			
			System.out.print("[" + Col[i] + "]");
		System.out.println();
	}
}
