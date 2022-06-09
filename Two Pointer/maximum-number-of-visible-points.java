class Solution {
    //https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window
    
    //Sliding window
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles=new ArrayList<>();
        
        int x=location.get(0);
        int y=location.get(1);
        
        int dx=0,dy=0;
        int count=0;
        
        for(List<Integer> pair:points){
            dx=pair.get(0)-x;
            dy=pair.get(1)-y;
            if(dx==0&&dy==0){
                count++;
                continue;
                
            }
            angles.add(Math.atan2(dx,dy)*180/Math.PI);
        }
        
        Collections.sort(angles);
        int size=angles.size();
        
        
        //Explanation for adding 360
        //https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window/720209
        for(int i=0;i<size;i++){
            angles.add((angles.get(i)+360));
        }
        
        size=angles.size();
        int ans=count;
        int i=0;
        
        for(int j=0;j<size;j++){
            while(angles.get(j)-angles.get(i)>angle){
                ++i;
            }
            ans=Math.max(ans,j-i+1+count);
        }
        return ans;
        
    }
}
