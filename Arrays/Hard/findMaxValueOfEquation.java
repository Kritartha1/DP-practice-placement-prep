//leetcode.com/problems/max-value-of-equation/
//Approach 1: Priority Queue solution ....O(nlogn)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //priorityQueue....O(nlogn)
        int m=points.length;
        int ans=Integer.MIN_VALUE;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];//important condition...it helps in the poll condition of the priority queue....|xj-xi|<=k
                }
                return b[0]-a[0];
            }
        });
        
        for(int j=0;j<m;j++){
            //priority queue is not storing x coordinate in increasing order..
            //so polling doesn't guwarantee that after the peek point, there can't be any points that violates the condition xj-x1<=k,
            //but the peek point will always guarantee xj-x1<=k and yi-x1 =max..
            //so yi-xi+yj+xj is max at peek point only, the below points donot contribute to max value of equation..
            
            //so we only care about the peek poit in the next line...
            while(!pq.isEmpty()&&points[j][0]-pq.peek()[1]>k){
                
                pq.poll();
            }
            
            if(!pq.isEmpty()){
                ans=Math.max(pq.peek()[0]+points[j][0]+points[j][1],ans);
            }
            
            pq.add(new int[]{points[j][1]-points[j][0],points[j][0]});
            
            
        }
        
        return ans;
    }
}

//Approach 2: Deque.
////Time: O(n). We process each element twice at most.
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //Time O(n)
        Deque<int[]> pq=new ArrayDeque<>();
        int ans=Integer.MIN_VALUE;
        for(int[] point:points){
            while(!pq.isEmpty()&&point[0]-pq.peekFirst()[1]>k){
                pq.pollFirst();
            }
            if(!pq.isEmpty()){
               ans= Math.max(pq.peekFirst()[0]+point[0]+point[1],ans);
            }
            while(!pq.isEmpty()&&point[1]-point[0]>pq.peekLast()[0]){
                pq.pollLast();
            }
            pq.add(new int[]{point[1]-point[0],point[0]});
        }
        return ans;
    }
}
