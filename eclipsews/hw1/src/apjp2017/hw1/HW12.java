package apjp2017.hw1;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import apjp2017.hw1.HW12.EightQueenPosition;
import static apjp2017.hw1.HW12.EightQueenPosition.*;

public class HW12 {
	
	
	public enum EightQueenPosition	{
		P00, P01, P02, P03, P04, P05, P06, P07,
		P10, P11, P12, P13, P14, P15, P16, P17,
		P20, P21, P22, P23, P24, P25, P26, P27,
		P30, P31, P32, P33, P34, P35, P36, P37,
		P40, P41, P42, P43, P44, P45, P46, P47,
		P50, P51, P52, P53, P54, P55, P56, P57,
		P60, P61, P62, P63, P64, P65, P66, P67,
		P70, P71, P72, P73, P74, P75, P76, P77;
	
	 //Every position is indexed by its row and column value.  
	 int row, col ;	
	 
	 
	 static { // use static initializer to fill in (row, col) for every literal PXX.
		
		EightQueenPosition[] all = EightQueenPosition.values() ;
		int k = 0 ;
	   	for(int r =0; r < 8; r++ ){
	   		for(int c = 0; c < 8; c++){
	   	      all[k].row = r;
	   	      all[k].col = c;
	   	      k++ ;
	   		}
	   	}		 
	 }
	 
	 
	 /** TODO-method:
	  *  Given a set of board positions, return a string displaying
	  *  the layout and content of the board.
	  */
	 public static String displayQBoard(EnumSet<EightQueenPosition> queens) {
		 // replace following code with your implementation
		 int[][] a = new int[8][8];
		 for(EightQueenPosition q : queens) {
			 a[q.row][q.col]++;
		 }
		 boolean isEmptyRow = true;
		 String s = "";
		 for(int r=0;r<8;r++) {
			 
			 
			 for(int c=0;c<8;c++) {
				 if(a[r][c]>0) {//queen at Position r,c
					 if(isEmptyRow) {
						 for(int i=0;i<c;i++) {
							 s += "| ";
						 }
						 s += "|X";
					 }
					 else {
						 //wrong!
					 }
					isEmptyRow = false;
				 }
				 else {
					 if(isEmptyRow) {
						 
					 }else {
						 s += "| ";
					 }
				 }
			 }
			 
			 
			 if (isEmptyRow) {
				 s += "-----------------\n";
			 }
			 else {
				 s += "|\n";
			 }
			 isEmptyRow = true;
		 }
		 return s;
	}
		
		
	
	/**TODO-method: 
	 * Given a set of board positions, determine if it is a solution of the 8-Queen problem.
	 *  @param board  a set of positions
	 *  @return true if it is a solution of 8 queens.
	 */ 
	public static boolean isSolution(EnumSet<EightQueenPosition> queens ){
		// replace following code with your implementation
		int[][] ban = new int[8][8];
		for(EightQueenPosition q : queens) {
			if(ban[q.row][q.col]>0) {
				return false;
			}
			else {
				ban = banUpdate(ban,q);
			}
		}
			return true;
	}
	
	
	/** TODO-method: 
	 * Given a set of board positions, determine if we can get a solution of 8 Queens problem by adding additional positions
	 *  to the input board. Return any such extension of the input board if it is possible and return an empty set if
	 *  there is no such solution.  
	 *  @param  board  a set of positions . 
	 *  @return all solution boards which are extensions of the inpout board, or Emptyset.none() 
	 *          if there is no solution.
	 */
	public static Set<EnumSet<EightQueenPosition>> getAllSolutions(EnumSet<EightQueenPosition> queens ){
		// replace following code with your implementation
		Set<EnumSet<EightQueenPosition>> ans = new HashSet();	 	 
		for(EightQueenPosition newQ: EightQueenPosition.values()) {
			if(!queens.contains(newQ)) {
				queens.add(newQ);
				if(isSolution(queens)) {
					ans.add(queens); 
				}
				queens.remove(newQ);
			}
		}
		return ans;
	}



	////////////////////////////////////////////////////////////
	////// Add any additional methods/fields  from here      ///
	///////////////////////////////////////////////////////////	
	
	//add positions that are invalid anymore.
	public static int[][] banUpdate(int[][] ban,EightQueenPosition q){
		for(int c=0;c<8;c++) {// |
			ban[c][q.col]++;
		}
		for(int c=0;c<8;c++) {// 一
			ban[q.row][c]++;
		}
		for(int c=0;c<8;c++) {
			if(q.row+c<0||q.col-c<0||q.row+c>7||q.col-c>7){// /			
			}
			else {
				ban[q.row+c][q.col-c]++;
			}
			if(q.row-c<0||q.col+c<0||q.row-c>7||q.col+c>7){		
			}
			else {
				ban[q.row-c][q.col+c]++;
			}		
			if(q.row-c<0||q.col-c<0||q.row-c>7||q.col-c>7){// \	
			}
			else {
				ban[q.row-c][q.col-c]++;
			}
			if(q.row+c<0||q.col+c<0||q.row+c>7||q.col+c>7){				
			}
			else {
				ban[q.row+c][q.col+c]++;
			}
		}
		ban[q.row][q.col]-=3;
		return ban;
	}
	
	
}
	
	
	static int nTests = 0;   // each test may produce multiple errors!
	static int nErrors = 0;
	static int nTestErrors = 0;
	static boolean newTest = true;

	static void error() {
		error("");
	}

	static void error(String s) {
		nErrors++;
		if(newTest){
			nTestErrors ++ ;
			newTest = false;
			System.out.println(">>> new TestError! <<< ");
		}
		System.out.println("*** error " + nErrors + "*** :" + s);
	}
	
	static void error(String s, Object ... args){
		error( String.format(s, args));
	}

	static void test() {
		nTests++;
		newTest = true ;
	}
	
//	static void test(int k) {
//		nTests += k ;
//	}

	static String summary() {

		StringBuilder sb = new StringBuilder();
		sb.append("There are totally " + nTests + " full tests! \n");
		sb.append("There are " + nTestErrors + " test errors! \n");
		sb.append("There are " + nErrors + " detailed errors! \n");
		sb.append(" The passing rate is " + (nTests - nTestErrors) + "/" + nTests + "="
				+ ((nTests - nTestErrors) * 100 / nTests) + "!\n");

		int score = (nTests - nTestErrors) * 50 / nTests + 50 ;

		sb.append("The score is " + score + " provided your source passes compilation!");

		return sb.toString();

	}

	
	public static void mainTest(String... args) {
		
		HW12 hw12 = new HW12();
		
				
		hw12.testDisplayQBoard();
		hw12.testIsSolution();
		hw12.testGetAllSolutions();
	

	}
	
	
	/**
	 * 
	 * @param args
	 */
	public void testDisplayQBoard() {
		// write your test code here!
		test();
		EnumSet<EightQueenPosition> queens = EnumSet.of(EightQueenPosition.P00);
		String rlt = "|X| | | | | | | |\n" + 
				"-----------------\n" + 
				"-----------------\n" + 
				"-----------------\n" + 
				"-----------------\n" + 
				"-----------------\n" + 
				"-----------------\n" + 
				"-----------------\n";
		String ans = displayQBoard(queens);
		if(!rlt.equals(ans)) {
			error("DisplayQBoard() is not correct!\nRequire:\n"+rlt+"\nYours:\n"+ans);
		}
		else {
			System.out.println("DisplayQBoard() is correct!");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public  void testIsSolution() {//test data used from wiki https://en.wikipedia.org/wiki/Eight_queens_puzzle
		// write your test code here!
		test();
		EnumSet<EightQueenPosition> queens = EnumSet.of(EightQueenPosition.P60,EightQueenPosition.P41,EightQueenPosition.P22,EightQueenPosition.P03,EightQueenPosition.P54,EightQueenPosition.P75,EightQueenPosition.P16,EightQueenPosition.P37);
		boolean ans = isSolution(queens);
		if(!ans) {
			error("isSolution() is not correct!\nRequire:\n"+true+"\nYours:\n"+ans);
		}
		else {
			System.out.println("isSolution() is correct!");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public  void testGetAllSolutions() {
		// write your test code here!
		test();
		EnumSet<EightQueenPosition> queens = EnumSet.of(EightQueenPosition.P60,EightQueenPosition.P41,EightQueenPosition.P22,EightQueenPosition.P03,EightQueenPosition.P54,EightQueenPosition.P75,EightQueenPosition.P16);
		Set<EnumSet<EightQueenPosition>> ans = getAllSolutions(queens);
		Set<EnumSet<EightQueenPosition>> rlt = new HashSet(EnumSet.of(EightQueenPosition.P60,EightQueenPosition.P41,EightQueenPosition.P22,EightQueenPosition.P03,EightQueenPosition.P54,EightQueenPosition.P75,EightQueenPosition.P16,EightQueenPosition.P37));
		if(ans.isEmpty()) {
			error("Your answer from getAllSolutions() are null\n");
		}
		else if(ans.contains(rlt)) {
			error("getAllSolutions() is not correct!\nRequire:\n"+rlt+"\nYours:\n"+ans);
		}
		else {
			System.out.println("getAllSolutions() is correct!");
		}
	}		 
	 
	
	
	 public static void main(String... args) {

			// write your own test here!
			
			
			 
			System.out.println("=====Begin of Test======");
			// test with tests given by the instructor!
			mainTest(args);
			System.out.println("=====End of Test=========");
			System.out.println(summary());
		}
	
	

}