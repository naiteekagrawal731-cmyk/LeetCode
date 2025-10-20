class Solution {
    Set<Integer> s1 = new HashSet<>();
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        for(int i = 0;i < isConnected.length;i++){
            List<Integer> l1 = new ArrayList<>();
            for(int j = 0; j < isConnected[0].length;j++){
                if(i == j)continue;
                if(isConnected[i][j] == 1){
                    l1.add(j);
                }
            }
            s1.add(i);
            map.put(i,l1);
        }
        for(int i : map.keySet()){
            if(s1.contains(i)){
                res += 1;
                proviences(i);
            }
        }
        return res;
    }public void proviences(int i){
        s1.remove(i);
        for(int j : map.get(i)){
            if(s1.contains(j)){
                proviences(j);
            }
        }
    }
}
