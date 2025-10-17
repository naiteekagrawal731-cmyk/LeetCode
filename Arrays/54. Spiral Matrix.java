class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int x = 0;
        int y = 0;
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        for(int i = 0;i < matrix.length*matrix[0].length;i++){
            if(x >= matrix[0].length){
                x -= 1;
                y += 1;
                right = false;
                down = true;
            }else if(y >= matrix.length){
                y -= 1;
                x -= 1;
                down = false;
                left = true;
            }else if(x < 0){
                x += 1;
                y -= 1;
                left = false;
                up = true;
            }else if(y < 0){
                y += 1;
                x += 1;
                up = false;
                right = true;
            }else if(matrix[y][x] == 101 && right == true){
                x -= 1;
                y += 1;
                right = false;
                down = true;
            }else if(matrix[y][x] == 101 && down == true){
                y -= 1;
                x -= 1;
                down = false;
                left = true;
            }else if(matrix[y][x] == 101 && left == true){
                x += 1;
                y -= 1;
                left = false;
                up = true;
            }else if(matrix[y][x] == 101 && up == true){
                y += 1;
                x += 1;
                up = false;
                right = true;
            }
            res.add(matrix[y][x]);
            matrix[y][x] = 101;



            if(right == true){
                x += 1;
            }else if(down == true){
                y += 1;
            }else if(left == true){
                x -= 1;
            }else if(up == true){
                y -= 1;
            }
        }
        return res;
    }
}
