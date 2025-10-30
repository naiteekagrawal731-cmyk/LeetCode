class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long m1 = m;
        long k1 = k;
        if(m1*k1 > bloomDay.length){
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i : bloomDay){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }
        int left = min;
        int right = max;
        int res = max;
        while (left <= right){
            int middle = left + (right-left)/2;
            int gotBouquets = 0;
            int flower = 0;
            for(int i : bloomDay){
                if(middle >= i){
                    flower++;
                }else{
                    gotBouquets += flower/k;
                    flower = 0;
                }
            }
            gotBouquets += flower/k;
            if(gotBouquets < m){
                left = middle+1;
            }else if(gotBouquets >= m){
                if(middle < res){
                    res = middle;
                }
                right = middle-1;
            }
        }
        return res;
    }
}
