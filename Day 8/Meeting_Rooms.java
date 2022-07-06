// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    import java.lang.*;
    
    class GFG {
        public static void main(String args[]) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
    
            while (t-- > 0) {
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
    
                int start[] = new int[n];
                int end[] = new int[n];
    
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++)
                    start[i] = Integer.parseInt(inputLine[i]);
    
                inputLine = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) 
                    end[i] = Integer.parseInt(inputLine[i]);
                    
                int ans = new Solution().maxMeetings(start, end, n);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution 
    {
        //Function to find the maximum number of meetings that can
        //be performed in a meeting room.
        public static int maxMeetings(int start[], int end[], int n)
        {
            // List<IntervalPair> schedule = new LinkedList<>();
            IntervalPair[] schedule = new IntervalPair[start.length];
            for (int i = 0; i < n; i++) schedule[i] = new IntervalPair(start[i],end[i]);
            Arrays.sort(schedule, (a,b)->(a.end-b.end));
            int prevEnd = schedule[0].end,totalMeetings=1;
    
            // while (currStart<start.length) {
            //     while(currStart<n-1 && schedule.get(currStart+1).start<=prevEnd) currStart++;
            //     currStart++;
            //     prevEnd = schedule.get(currStart).end;
            //     totalMeetings++;
            // }
            for (int i = 0; i < start.length; i++) {
                if(schedule[i].start>prevEnd){
                    totalMeetings++;
                    prevEnd = schedule[i].end;
                } 
            }
            return totalMeetings;
        }
    }
    class PairComparator implements Comparator<Integer>{
        public int compare(Integer p1, Integer p2)
        {
            if(p1<p2) return -1;
            else if(p2<p1) return 1;
            else return 0;
        }
    }
    class IntervalPair{
        int start;
        int end;
        IntervalPair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }