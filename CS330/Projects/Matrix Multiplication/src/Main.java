/**
 * Created by Nick on 10/9/14.
 */
public class Main
{
	public static void main(String[] args)
	{
		int[][] matrixA = {
				{1, 4},
				{2, 5},
				{3, 6}
		};

		int[][] matrixB = {
				{8, 7, 6},
				{5, 4, 3}
		};
		final int ROWS = matrixA.length;
		final int COLS = matrixB[0].length;
		int[][] matrixC = new int[ROWS][COLS];

		Thread[] workerThreads = new Thread[(ROWS*COLS)];
		int index = 0;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				Worker worker = new Worker(row, col, matrixA, matrixB, matrixC);
				workerThreads[index] = new Thread(worker, "Worker Thread " + String.valueOf(index));
				System.out.print(workerThreads[index].getName() + ":\t");
				worker.run();
				index++;
			}
		}

		for (Thread workerThread : workerThreads)
		{
			try
			{
				workerThread.join();
			} catch (InterruptedException interrupt)
			{
				System.out.println("Interrupt Exception Occurred");
				System.out.println(interrupt.getMessage());
			}
		}

		System.out.print(printMatrix(matrixA));
		System.out.println();
		System.out.print(printMatrix(matrixB));
		System.out.println();
		System.out.print(printMatrix(matrixC));
	}

	private static String printMatrix(int[][] matrix)
	{
		String matrixString = "";
		for (int i = 0; i < matrix.length; i++)
		{
			for (int k = 0; k < matrix[0].length; k++)
			{
				String str = (k != matrix[0].length - 1) ? String.valueOf(matrix[i][k]) + " | " : String.valueOf(matrix[i][k]);
				matrixString += str;
			}
			matrixString += "\n";
		}
		return matrixString;
	}
}