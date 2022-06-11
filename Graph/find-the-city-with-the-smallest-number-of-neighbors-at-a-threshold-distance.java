//Floyd warshall
//leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
class Solution {
    int INT_MAX;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        INT_MAX=distanceThreshold+1;
        int[][] graph=new int[n][n];
        
        buildGraph(graph,edges,n);
        floyd_warshall(graph,n);
        
        int ans=n+1;
        int city=-1;
        
        for(int i=0;i<n;i++){
            int temp=0;
            for(int j=0;j<n;j++){
                if(i!=j&&graph[i][j]!=INT_MAX){
                    ++temp;
                }
            }
            if(temp<ans){
                ans=temp;
                city=i;
            }else if(temp==ans){
                city=i;//if previous cities have same required threshold neighbouring cities
                //then as per qsn we have to take the city having the greatest index with same number of neighbouring cities.
            }
        }
        return city;
    }
    
    void buildGraph(int[][] graph,int[][] edges,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                graph[i][j]=INT_MAX;
                graph[j][i]=INT_MAX;
            }
        }
        
        for(int[] edge:edges){
            graph[edge[0]][edge[1]]=edge[2];
            graph[edge[1]][edge[0]]=edge[2];
        }
        
        
    }
    void floyd_warshall(int[][] graph,int n){
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //Math.min(graph[i][k]+graph[k][j],INT_MAX)--> means if any edge weight is greater than treshold , then we are saying it as infinity..means unreachable...
                    //so in the end when we traverse for each nodes.if a edge wt is infinity , then we can say that it's weight> treshold..so don't count that edge
                    graph[i][j]=Math.min(graph[i][j],Math.min(INT_MAX,graph[i][k]+graph[k][j]));
                }
            }
        }
    }
}
