package duega.algo;

public class knightMove {

	private static void knighttMoveLogic(int[][] board, int N) {
		board[0][0] = 1;
		if( ! knighttMove(board, N, 0, 0, 1))
		{
			System.out.println("Can't solve, Do it yourself");
		}
		else {
			displayBoard(board, N);
		}
	}
	
	private static boolean knighttMove(int[][] board, int N, int row, int col, int knightNum) {
		displayBoard(board, N);
		System.out.println("==================================");
		if(knightNum == (N*N))
		{
			return true;
		}

		int rowDir[] = {-2,-2, 2, 2,  1, -1 ,1 ,-1};
		int colDir[] = {-1, 1, -1,1, -2, -2, 2 , 2};

		for(int i = 0; i<8; i++) {
			int nextRow = row+rowDir[i];
			int nextCol = col+colDir[i];
			if(canKnightPlacedHere(board, N, nextRow,nextCol)) {
				board[nextRow][nextCol] = knightNum+1; // apply
				boolean isSuccess = knighttMove(board, N, nextRow, nextCol, knightNum+1);
				if(isSuccess) return true;
				board[nextRow][nextCol] = 0;         // erasing, Backtracking
			}
		}
		return false;
	}

	private static void displayBoard(int board[][], int N) {
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(board[i][j]+"  ");
    		}
    		System.out.print("\n");
    	}
    }

	private static boolean canKnightPlacedHere(int[][] board, int N, int r, int c) {
		return (r>=0 && r<N) && (c>=0 && c<N) && board[r][c] == 0 ; 
	}

	public static void main(String[] args) {
		int n = 8;
		int board[][] = new int[n][n];
		knighttMoveLogic(board,n);
	}
}
