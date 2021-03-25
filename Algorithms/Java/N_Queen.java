package duega.algo;

import java.util.Scanner;

public class N_Queen {
    
    static void displayBoard(int board[][], int N) {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(board[i][j]+"  ");
    		}
    		System.out.print("\n");
    	}
    }
    
    private static boolean canQueenPlaceInThisRow(int[][] board, int N, int row, int col) {
	
    	// row and column check
    	for(int i=0; i<N;i++)
    	{
    		if(board[row][i] > 0) return false;
    		if(board[i][col] > 0) return false;
    	}
    	
    	// diagonal check
    	int diagRow[] = {1,-1, 1,-1};
    	int diagCol[] = {1,-1,-1, 1};
    	
    	for(int i=0;i<4;i++) {
    		int r = row;
    		int c = col;
    		while((r>=0 && r < N) && (c>=0 && c<N)) {
    			if(board[r][c] > 0) return false;
    			r = r + diagRow[i];
    			c = c + diagCol[i];
    		}
    	}
    	
		return true;
	}
    
    static boolean NQueen(int board[][], int N, int row, int queenNum) {
    	if(row == N) {
    		displayBoard(board, N);
    		return true;
    	}
    	int x = 1;
    	 // just to start with random col
    	int col = (int) (Math.random() * (N - 1));
    	for(;(x++)<=N; col = ((++col) % N)) {
    		if(canQueenPlaceInThisRow(board,N,row,col)) {
    			board[row][col] = queenNum;
    			boolean isSuccess = NQueen(board, N, row+1, queenNum+1);
    			if(isSuccess) return true;
    			board[row][col] = 0;
    		}
    	}
    	
    	return false;
    }

	static void NQueenLogic(int board[][], int N) {
		NQueen(board, N, 0,1);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		NQueenLogic(new int[N][N],N);
	}
}
