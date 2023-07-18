//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
package Other.Challenges.Hackerrank.Arrays;

public class HourglassSum {

	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3, 0, 0}, 
						{0, 0, 0, 0, 0}, 
						{2, 1, 4, 0, 0}, 
						{0, 0, 0, 0, 0}, 
						{1, 1, 0, 1, 0},
						{1, 1, 0, 1, 0} };
		int max_sum = Integer.MIN_VALUE;
		System.out.println("No of Rows : "+mat.length);
		System.out.println("No of Cols : "+mat[0].length);
		for(int i=0; i<mat.length-2 ;i++)
			for(int j=0; j<mat[0].length-2; j++)
			{
				int sum = (mat[i][j] + mat[i][j+1] + mat[i][j+2])
							+ mat[i+1][j+1] +
						(mat[i+2][j] + mat[i+2][j+1] + mat[i+2][j+2]) ;
				
				max_sum = Math.max(max_sum, sum );
			}
		System.out.println(max_sum);
	}//main
}//class
