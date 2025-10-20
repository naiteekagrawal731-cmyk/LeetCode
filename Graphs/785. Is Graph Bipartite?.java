class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        for(int i = 0;i < colour.length;i++){
            if(colour[i] == 0){
                colour[i] = 1;
                bipart(colour,graph,i);
            }
        }
        return res;
        
    }void bipart(int[] colour,int[][] graph,int i){
        if(colour[i] == 1){
            for(int j : graph[i]){
                if(colour[j] == 1){
                    res = false;
                }
                if(colour[j] == 0){
                    colour[j] = -1;
                    bipart(colour,graph,j);
                }
            }
        }else if(colour[i] == -1){
            for(int j : graph[i]){
                if(colour[j] == -1){
                    res = false;
                }
                if(colour[j] == 0){
                    colour[j] = 1;
                    bipart(colour,graph,j);
                }
            }
        }
    }
}
