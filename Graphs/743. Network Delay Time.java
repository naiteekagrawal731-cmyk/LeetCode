class Solution {
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n,int dist){
            this.node = n;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,List<List<Integer>>> map = new HashMap<>();
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        for(int i = 1;i <dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[k] = 0;
        for(int i = 0;i < times.length;i++){
            if(map.containsKey(times[i][0])){
                List<List<Integer>> l1 = map.get(times[i][0]);
                List<Integer> l2 = new ArrayList<>();
                l2.add(times[i][1]);
                l2.add(times[i][2]);
                l1.add(l2);
                map.replace(times[i][0],l1);
            }else{
                List<List<Integer>> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                l2.add(times[i][1]);
                l2.add(times[i][2]);
                l1.add(l2);
                map.put(times[i][0],l1);
            }
        }
        pq.add(new Pair(k,0));
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                if(map.get(curr.node) == null)continue;
                for(int i = 0;i < map.get(curr.node).size();i++){
                    if(dis[curr.node]+map.get(curr.node).get(i).get(1) < dis[map.get(curr.node).get(i).get(0)]){
                        dis[map.get(curr.node).get(i).get(0)] = dis[curr.node]+map.get(curr.node).get(i).get(1);
                    }
                    pq.add(new Pair(map.get(curr.node).get(i).get(0),dis[map.get(curr.node).get(i).get(0)]));
                }
            }
        }int res = 0;
        for(int i : dis){
            System.out.println(i);
            if(i == Integer.MAX_VALUE){
                return -1;
            }else{
                if(i > res){
                    res = i;
                }
            }
        }
        return res;
    }
}
