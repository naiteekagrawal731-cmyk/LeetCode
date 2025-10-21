class Solution {
    public void nextPermutation(int[] nums) {
        boolean a1 =false;
        for(int i = nums.length-2;i >= 0;i--){
            if(nums[i] <  nums[i+1]){
                for(int j = nums.length-1;j >= 0;j--){
                    if(nums[j] > nums[i]){
                        int a = nums[i];
                        nums[i] = nums[j];
                        nums[j] = a;
                        int k = i+1;
                        int x = nums.length-1;
                        int middle = (k+ nums.length-1)/2;
                        while (k <= middle){
                            int b = nums[k];
                            nums[k] = nums[x];
                            nums[x] = b;
                            k++;
                            x--;
                        }
                        break;
                    }
                }
                a1 = true;
                break;
            }
        }
        if(!a1){
            int i = 0;
            int j = nums.length-1;
            int max = (nums.length-1)/2;
            while (i <= max){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}
