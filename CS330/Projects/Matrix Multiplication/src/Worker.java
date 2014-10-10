/**
 * Creates a Worker thread that will compute Matrix Product for a Given Point
 */
public class Worker implements Runnable
{
	private int row;
	private int col;
	private int[][] matrixA; // input
	private int[][] matrixB; // input
	private int[][] matrixC; // result

	public Worker(int row, int col, int[][] matrixA, int[][] matrixB, int[][] matrixC)
	{
		this.row = row;
		this.col = col;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixC = matrixC;
	}

	public void run()
	{
	    for(int i = 0; i < matrixA[0].length; i++)
	    {
	        matrixC[row][col] += matrixA[row][i] * matrixB[i][col];
	    }
		System.out.println("{" + String.valueOf(this.row) + ", " + String.valueOf(this.col) + "}\n");
	}
}
