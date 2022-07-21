//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int tc = scan.nextInt();
    
            while (tc-- > 0) {
                int N = scan.nextInt();
                int M = scan.nextInt();
                int E = scan.nextInt();
    
                boolean graph[][] = new boolean[N][N];
    
                for (int i = 0; i < E; i++) {
                    int u = scan.nextInt() - 1;
                    int v = scan.nextInt() - 1;
                    graph[u][v] = true;
                    graph[v][u] = true;
                }
    
                System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class solve {
        // Function to determine if graph can be coloured with at most M colours
        // such
        // that no two adjacent vertices of graph are coloured with same colour.
        public boolean graphColoring(boolean graph[][], int m, int n) {
            // Your code here
            int colors[] = new int[n];
            Arrays.fill(colors,0);
            return func(graph,colors,0,n,m);
        }
        public static boolean func(boolean[][] graph, int[] colors, int node, int n, int m){
            if(node==n) return true;
            for(int i =1;i<=m;i++){
                if(isSafe(graph,colors,node,i)){
                    colors[node] = i;
                    if(func(graph, colors, node+1, n, m)) return true;
                    colors[node]=0;
                }
            }
            return false;
        }
        public static boolean isSafe(boolean[][] graph, int[] colors, int node, int color){
            boolean[] arr = graph[node];
            for(int i =0;i<arr.length;i++)
            {
                if(arr[i]==true){
                    if(colors[i]==color){
                        return false;
                    }
                }
            }
            return true;
        }
    }