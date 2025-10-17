class Solution {
    public void rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix.length];
        int x = 0;
        int y = matrix.length-1;
        int x2 = 0;
        int y2 = 0;
        while (x < matrix[0].length){
            if(y < 0){
                x += 1;
                y = matrix.length-1;
            }
            if(x >= matrix.length) {
                break;
            }
            if(x2 >= matrix.length){
                x2 = 0;
                y2 += 1;
            }
            if(y2 >= matrix.length){
                break;
            }
            res[y2][x2] = matrix[y][x];

            x2 += 1;
            y -= 1;
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix.length;j++){
                matrix[i][j] = res[i][j];
            }
        }
    }
}
