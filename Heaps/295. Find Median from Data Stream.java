class MedianFinder {
    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {

    }

    public void addNum(int num) {
        left.add(num);
        while(right.size() > 0 && left.peek() > right.peek()){
            right.add(left.poll());
        }
        if(left.size() > right.size()+1){
            right.add(left.poll());
        }
        while (left.size()+1 < right.size()){
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if(left.size() > right.size())return left.peek();
            else if(right.size() > left.size()) return right.peek();
        else{
            double res = ((double)right.peek() + (double)left.peek())/2.0;
            return res;
        }
    }
}
