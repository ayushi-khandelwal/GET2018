/**
 * @author Ayushi Khandelwal
 *
 */
final class SparseMatrix {
	
	/**
	 * @param matrix
	 * @return matrix having non-zero elements 
	 */
	int[][] sparseRepresentation(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int size = 0;	
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] != 0){
					size++;				//size represents number of non-zero elements in a matrix
				}	
			}
		}
		
		int[][] nonZeroSparseMatrix = new int[size][3]; 
		int k = 0;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] != 0){
					nonZeroSparseMatrix[k][0] = i;
					nonZeroSparseMatrix[k][1] = j;
					nonZeroSparseMatrix[k][2] = matrix[i][j];
					k++;
				}	
			}
		}
		
		return nonZeroSparseMatrix;
	}
	
	/**
	 * @param matrix
	 * @return transpose matrix of given matrix
	 * 
	 * Time Complexity is O(row*column)
	 */
	public int[][] transpose(int[][] matrix) {
		if(matrix.length <=0 || matrix[0].length <= 0)
			throw new AssertionError();
		
		int row = matrix.length; 
		int col = matrix[0].length;
		int[][] nonZeroMatrix =  sparseRepresentation(matrix) ;
		
		int[][] transposedMatrix = new int[col][row];
		
		try{
			for(int i = 0; i < nonZeroMatrix.length; i++){
				row = nonZeroMatrix[i][0];
				col = nonZeroMatrix[i][1];
				transposedMatrix[col][row] = nonZeroMatrix[i][2];
			}	
		}
		
		catch(AssertionError e){
			e.printStackTrace();
		}
		
		return transposedMatrix;
	}
	
	/**
	 * @param matrix
	 * @return symmetric matrix of given matrix
	 * 
	 * Time Complexity is O(n*n)
	 */
	public boolean symmetry(int[][] matrix){
		
		try{
			if(matrix.length <=0 || matrix[0].length <= 0)
				throw new AssertionError();
		}
		
		catch(AssertionError e){
			e.printStackTrace();
			return false;
		}
		
		if(matrix.length != matrix[0].length ) {
			return false;
		}
		
		int[][] transposeMatrix = transpose(matrix);
		for (int i=0; i<matrix.length; i++) {
			for(int j = 0; j<matrix.length; j++) {
				if(transposeMatrix[i][j] != matrix[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * @param matrix1
	 * @param matrix2
	 * @return addition matrix of given two matrices matrix1 and matrix2
	 * 
	 * Time Complexity is O(n*n)
	 */
	public int[][] addition(int[][] matrix1, int[][] matrix2) {
		if(matrix1.length <= 0 || matrix2.length <= 0) {
			throw new AssertionError();
		}
		
		if(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
			int[][] matrixAdd1 = sparseRepresentation(matrix1);
			int[][] matrixAdd2 = sparseRepresentation(matrix2);
			int[][] additionMatrix = new int [matrix1.length][matrix1[0].length];
			
			try{
				for(int i = 0; i < matrixAdd1.length; i++) {
					additionMatrix[matrixAdd1[i][0]][matrixAdd1[i][1]] += matrixAdd1[i][2];
				}
				
				for(int i = 0; i < matrixAdd2.length; i++) {
						additionMatrix[matrixAdd2[i][0]][matrixAdd2[i][1]] += matrixAdd2[i][2];
				}
			}
			
			catch(AssertionError e){
				e.printStackTrace();
			}
			
			return additionMatrix;
		}
		else
			throw new AssertionError();
	}
	
	/**
	 * @param matrix1
	 * @param matrix2
	 * @return multiplication matrix of given two matrices matrix1 and matrix2
	 * 
	 * Time Complexity is O(n*n)
	 */
	public int[][] multiply(int[][] matrix1, int[][] matrix2) {
		if(matrix1.length <= 0 || matrix2.length <= 0) {
			throw new AssertionError();
		}
		
		if(!(matrix1[0].length == matrix2.length)) {
			throw new AssertionError();
		}
		
		int[][] matrixMul1 = sparseRepresentation(matrix1);
		int[][] matrixMul2 = sparseRepresentation(matrix2);
		int[][] MulMatrix = new int [matrix1.length][matrix2[0].length];
		
		for (int i = 0; i < matrixMul1.length; i++) {
           for (int j = 0; j < matrixMul2.length; j++) {
               if (matrixMul1[i][1] == matrixMul2[j][0]) {
            	   MulMatrix[matrixMul1[i][0]][matrixMul2[j][1]] += matrixMul1[i][2] * matrixMul2[j][2];
               }
           }
       }
		
       return MulMatrix;
	}
}