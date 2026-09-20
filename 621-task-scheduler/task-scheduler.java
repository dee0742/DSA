class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26]; 

        for(char task : tasks){
            freq[task - 'A']++;
        }
      
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }
        int time = 0;

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while(cycle > 0 && !pq.isEmpty()){
                int current = pq.poll();
                current--;
                if(current > 0){
                    temp.add(current);
                }
                time++;
                cycle--;
            }
            for(int remaining : temp){
                pq.offer(remaining);
            }
            if(!pq.isEmpty()){
                time += cycle;
            }
        }
        return time;
    }
}