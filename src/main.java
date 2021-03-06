import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	
	static int[][] b= new int[9][9];
	static Board board;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		fileToBoard("tests\\expert1");
		board = new Board(b);
		//board.printBoard();
		//board.printSquare(7, 4);
		//System.out.println(board.getAvailableInput(7, 4));
		//System.out.println(board.isThereSingleSolution(1, 2));
		board.solve();
	}
	
	public static void fileToBoard(String filename) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line = br.readLine();
		    int j = 0;
		    
		    while(line != null) {
		    	String line2[] = line.trim().split(" ");
		    	for(int i=0;i<9;i++) {
		    		b[j][i] = Integer.parseInt(line2[i]);
		    	}
		    	line = br.readLine();
		    	j++;
		    }  
		}
	}
}
