class Solution {
    public static class Pair implements Comparable<Pair>{
        int node;
        int dst;
        public Pair(int node,int dst){
            this.node = node;
            this.dst = dst;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dst-p2.dst;
        }

    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Set<Integer> ses = new HashSet<>();
        for(int i = 0;i < n;i++){
            ses.add(i);
        }
        HashMap<Integer,List<List<Integer>>> map = new HashMap<>();

        for(int i = 0;i < edges.length;i++){
            if(ses.contains(edges[i][0]))ses.remove(edges[i][0]);
            if(ses.contains(edges[i][1]))ses.remove((edges[i][1]));
            if(map.containsKey(edges[i][0])){
                List<List<Integer>> l1 = map.get(edges[i][0]);
                List<Integer> l2 = new ArrayList<>();
                l2.add(edges[i][1]);
                l2.add(edges[i][2]);
                l1.add(l2);
            }else{
                List<List<Integer>> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                l2.add(edges[i][1]);
                l2.add(edges[i][2]);
                l1.add(l2);
                map.put(edges[i][0],l1);
            }
            if(map.containsKey(edges[i][1])){
                List<List<Integer>> l1 = map.get(edges[i][1]);
                List<Integer> l2 = new ArrayList<>();
                l2.add(edges[i][0]);
                l2.add(edges[i][2]);
                l1.add(l2);
            }else{
                List<List<Integer>> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                l2.add(edges[i][0]);
                l2.add(edges[i][2]);
                l1.add(l2);
                map.put(edges[i][1],l1);
            }
        }
        if(!ses.isEmpty()){
            List<Integer> l4 = new ArrayList<>(ses);
            l4.sort(null);
            System.out.println(l4);
            return l4.get(l4.size()-1);
        }
        HashMap<Integer,List<Integer>> res = new HashMap<>();
        int tes = Integer.MAX_VALUE;
        for(int i : map.keySet()){
            int kea = city(map,i,distanceThreshold,n);
            if(kea < tes){
                tes = kea;
            }
            if(res.containsKey(kea)){
                List<Integer> l2 = res.get(kea);
                l2.add(i);
                res.replace(kea,l2);
            }else{
                List<Integer> l2 = new ArrayList<>();
                l2.add(i);
                res.put(kea,l2);
            }
        }
        System.out.println(res);
        List<Integer> l3 = res.get(tes);
        l3.sort(null);
        return l3.get(l3.size()-1);
    }public int city(HashMap<Integer,List<List<Integer>>> map,int src,int distanceThreshold,int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        int[] dis = new int[n];
        boolean[] viss = new boolean[n];
        for(int i = 0;i < dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!viss[curr.node]){
                viss[curr.node] = true;
                for(int i = 0;i < map.get(curr.node).size();i++){
                    int node = map.get(curr.node).get(i).get(0);
                    int dit = map.get(curr.node).get(i).get(1);
                    if(dis[curr.node]+dit < dis[node]){
                        dis[node] = dis[curr.node]+dit;
                        pq.add(new Pair(node,dis[node]));
                    }
                }
            }
        }
        int res = 0;
        for(int i : dis){
            if(i <= distanceThreshold){
                res += 1;
            }
        }
        return res;
    }
}
