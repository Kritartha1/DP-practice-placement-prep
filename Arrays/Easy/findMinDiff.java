//practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1/#
class Solution
{
  //taking windows
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        long minDiff=Long.MAX_VALUE;
        for(int i=0;i<(int)(n-m+1);i++){
            int j=i+(int)m-1;
            minDiff=Math.min(a.get(j)-a.get(i),minDiff);
        }
        return minDiff;
    }
}
