import java.util.Scanner;

public class MatrixMultiplication
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int[][] matrix1 = null;
		int[][] matrix2 = null;
		for (int i = 0; i < 2; i++)
		{
			System.out.print("Rows for Matrix " + String.valueOf(i) + ": ");
			int rows = Integer.parseInt(scanner.nextLine());
			System.out.print("Columns for Matrix " + String.valueOf(i) + ": ");
			int cols = Integer.parseInt(scanner.nextLine());
			if (i == 0)
				matrix1 = new int[rows][cols];
			else
				matrix2 = new int[rows][cols];

			for (int j = 0; j < rows; j++)
			{
				for (int k = 0; k < cols; k++)
				{
					System.out.print("Number at [" + String.valueOf(j) + ", " + String.valueOf(k) + "]: ");
					if (i == 0)
						matrix1[j][k] = Integer.parseInt(scanner.nextLine());
					else
						matrix2[j][k] = Integer.parseInt(scanner.nextLine());
				}
			}
		}
		System.out.println(matrix1);
		System.out.println(matrix2);
	}
}
