//https://leetcode.com/problems/zigzag-conversion/
class Solution {
    public String convert(String s, int numRows) {
        
        HashMap<Integer,ArrayList<Character>> mp=new HashMap<>();
        
        for(int i=0;i<s.length();i++){

            int k=0;
            int j=i;
            for(;j<Math.min(i+numRows,s.length());j++){
                mp.putIfAbsent(k,new ArrayList<Character>());
                mp.get(k).add(s.charAt(j));
                ++k;
            }
            if(j<s.length()){
                k=numRows-2;
                for(int t=0;t<numRows-2&&j<s.length();t++){
                    mp.get(k).add(s.charAt(j++));
                    --k;
                }
            }
            i=j-1;
            
            
        }
        
        StringBuilder ans=new StringBuilder();
        for(Map.Entry<Integer,ArrayList<Character>> entry:mp.entrySet()){
            for(Character ch:entry.getValue()){
                ans.append(ch);
            }
        }
        
        return ans.toString();
        
    }
}
