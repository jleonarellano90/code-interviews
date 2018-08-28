package arrays_and_strings;

public class MatrixRotation {

	/**
	 * MAIN
	 */
	public static void main(String[] args) {
        int[][] matrix = {
            { 1,  2,  3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10,  9,  8, 7}
        };
        
        System.out.println("Matrix:");
        displayMatrix(matrix);
        
        rotateMatrixL(matrix);
        System.out.println("\nLeft Rotation:");
        displayMatrix(matrix);
        /** Left Rotation
         *  4,  5,  6, 7
         *  3, 14, 15, 8
         *  2, 13, 16, 9
         *  1, 12, 11, 10
         */
        
        rotateMatrixR(matrix);
        rotateMatrixR(matrix);
        System.out.println("\nRight Rotation:");
        displayMatrix(matrix);
        /** Right Rotation
         * 10, 11, 12, 1
         *  9, 16, 13, 2
         *  8, 15, 14, 3
         *  7,  6,  5, 4
         */
	}

	/**
	 * Rotate to left
	 * @param matrix
	 */
	public static void rotateMatrixL(int[][] matrix) {
		int N = matrix.length - 1;
        for (int i = 0; i < (N+1)/ 2; 
        		i++) {
            for (int j = i; j < N-i; j++) {
            	// save top
                int temp = matrix[j][i];
                // top to left
                matrix[j][i] = matrix[i][N-j];
                // right to top
                matrix[i][N-j] = matrix[N-j][N-i];
                // bottom to right
                matrix[N-j][N-i] = matrix[N-i][j];
                // left to bottom
                matrix[N-i][j] = temp;
            }
        }
    }
	
	/**
	 * Rotate to right
	 * @param matrix
	 */
	public static void rotateMatrixR(int[][] matrix) {
		int N = matrix.length - 1;
        for (int i = 0; i < (N+1)/2; i++) {
            for (int j = i; j < N-i; j++) {
            	// save top
                int temp = matrix[i][j];
                // left to top
                matrix[i][j] = matrix[N-j][i];
                // bottom to left
                matrix[N-j][i] = matrix[N-i][N-j];
                // right to bottom
                matrix[N-i][N-j] = matrix[j][N-i];
                // top to right
                matrix[j][N-i] = temp;
            }
        }
    }

	/**
	 * Print result
	 * @param matrix
	 */
	public static void displayMatrix(int[][] matrix) {
		int length = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++){
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
	
}
