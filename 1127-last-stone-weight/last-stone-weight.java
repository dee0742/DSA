class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
       for(int num : stones){
        MaxHeap.add(num);
       }
       while(MaxHeap.size() > 1){
        int y = MaxHeap.poll();
        int x = MaxHeap.poll();

        if(y != x){
            MaxHeap.add(y - x);
        }

        if(MaxHeap.isEmpty()){
            return 0;
        }
       }
       return MaxHeap.peek();
    }
}