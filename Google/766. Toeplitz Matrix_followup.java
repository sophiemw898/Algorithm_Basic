class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
//follow up
//Solution 2: Load one row each time, store,compare (with the crietria stored in Queue) and update it row by row.

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length <= 1 || matrix[0].length <= 1) return true;
        Queue<Integer> q = new LinkedList<>();
        for (int i=matrix[0].length-1; i>=0; i--){ //set criteria
            q.add(matrix[0][i]);
        }
        for (int j=1; j<matrix.length; j++){ 
            q.poll();
            for (int k=matrix[j].length-1; k>0; k--){
                if (matrix[j][k] == q.poll()) // compare
                    q.add(matrix[j][k]);
                else
                    return false; 
            }
            q.add(matrix[j][0]);
        }
        return true;
    }
//Solution 3: Load a partial row/column each time, the length of "piece" is defined as variable 'step'

    public int min(int a, int b){
        return((a>b)?b:a);
    }
    
    public int max(int a, int b){
        return((a<b)?b:a);
    }
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        int width = matrix[0].length; 
        int height = matrix.length; 
        int step = 3; //This step indicates the maximum length of 'piece' which can be loaded at one time.
        int size = 1;
        int index = width - 1; 
        
        while (index >= 0){ 
            size = min(index+1, step); 
            int[] memory = new int[size];
            for (int i=0; i<size; i++){
                memory[size-i-1] = matrix[0][index-i]; //set memory
            }
            for(int j=1; j<min(height,width); j++){ //check the related pieces of rows
                //set boundary 
                int rightbound = min(index+j, width-1);
                int leftbound = max(index-step+1+j, j);
                for(int m=0, n=leftbound; m<size&&n<=rightbound; m++, n++)
                    if(matrix[j][n] != memory[m])
                        return false;
            }
        index -= step;
        }
        
        index = 0;
        while (index < height){ //for the purpose of completeness, the criteria should include two sides of the matrix
            size = min(height-1-index, step);
            int[] memory = new int[size];
            for (int i=0; i<size; i++){
                memory[size-1-i] = matrix[height-index-1-i][0];
            }
            for (int j=1; j<min(height,width); j++){ 
                int upperbound = max(height-index-step+j,j+1);
                int lowerbound = min(height-index-1+j,height-1);
                for(int m=0, n=upperbound; m<size&&n<=lowerbound; m++, n++)
                    if(matrix[n][j] != memory[m])
                        return false;
            }
            index+=step;
        }
        
        return true;
    }
