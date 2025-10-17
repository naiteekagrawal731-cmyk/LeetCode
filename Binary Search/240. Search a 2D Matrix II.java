class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (target >= matrix[0][i]){
            int top = 0;
            int bottom = matrix.length-1;
            while (top <= bottom){
                int middle = (top+bottom)/2;
                if(matrix[middle][i] == target){
                    return true;
                }else if(matrix[middle][i] > target){
                    bottom = middle-1;
                }else if(matrix[middle][i] < target){
                    top = middle+1;
                }
            }
            i += 1;
            if(i >= matrix[0].length){
                break;
            }

        }
        return false;
    }
}
