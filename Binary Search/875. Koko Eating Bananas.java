class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = piles[0];
        for(int i : piles){
            if(i > right)right = i;
        }
        long res = right;
        while (left <= right){
            long middle = left + (right-left)/2;
            long timeTaken = 0;
            for(int i : piles){
                timeTaken += i/middle;
                if(i%middle != 0)timeTaken++;
            }
            if(timeTaken > h){
                left = middle+1;
            }else if(timeTaken <= h){
                if(middle < res){
                    res = middle;
                }
                right = middle-1;
            }
        }
        return (int) res;
    }
}
