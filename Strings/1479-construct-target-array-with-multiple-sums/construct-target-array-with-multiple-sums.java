class Solution {
    public boolean isPossible(int[] target) {
      if(target.length == 1 ) {
        return target[0] == 1; 
      }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a);
    long sum = 0;

    for(int num : target){
        pq.add(num);
        sum += num;
    }
    while(pq.peek() > 1){
        int largest = pq.poll();
        long sumOfOthers = sum - largest;
        if(sumOfOthers <= 0){
            return false;
        }

        long prev = largest % sumOfOthers;

        if(prev == 0){
            prev = sumOfOthers;
            
        }
        if(prev == largest){
            return false;
        }

        pq.add((int) prev );
        sum = sumOfOthers + prev;
    }
    return true;
    }
}