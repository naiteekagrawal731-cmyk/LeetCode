class Solution {
    static class stationData{
        int station;
        int price;

        stationData(int station,int price){
            this.station = station;
            this.price = price;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<stationData> que = new LinkedList<>();
        int[] dp = new int[n];
        HashMap<Integer,Set<List<Integer>>> map = new HashMap<>();
        for(int[] i : flights){
            int from = i[0];
            int to = i[1];
            int price = i[2];
            if(map.containsKey(from)){
                List<Integer> l1 = new ArrayList<>(Arrays.asList(to,price));
                map.get(from).add(l1);
            }else{
                List<Integer> l1 = new ArrayList<>(Arrays.asList(to,price));
                Set<List<Integer>> s1 = new HashSet<>();
                s1.add(l1);
                map.put(from,s1);
            }
        }
        Arrays.fill(dp,-1);
        dp[src] = 0;
        que.add(new stationData(src,0));
        int stopes = 0;
        while (!que.isEmpty() && stopes <= k){
            stopes++;
            Queue<stationData> que2 = new LinkedList<>();
            for(stationData data : que){
                int station = data.station;
                int price = data.price;
                if(map.get(station) == null)continue;
                for(List<Integer> l1 : map.get(station)){
                    int to = l1.get(0);
                    int nextStationPrice = price + l1.get(1);
                    if(dp[to] == -1){
                        dp[to] = nextStationPrice;
                        que2.add(new stationData(to,nextStationPrice));
                    }else if(dp[to] > nextStationPrice){
                        dp[to] = nextStationPrice;
                        que2.add(new stationData(to,nextStationPrice));
                    }
                }
            }
            que = que2;
        }
        return dp[dst];
    }
}
