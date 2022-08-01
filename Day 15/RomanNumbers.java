class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] arr = s.toCharArray();
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1 && arr[i]=='I'&&(arr[i+1]=='V'||arr[i+1]=='X')){
                if(arr[i+1]=='V')ans+=4;
                if(arr[i+1]=='X')ans+=9;
                i++;
            }
            else if(i<arr.length-1 && arr[i]=='X'&&(arr[i+1]=='L'||arr[i+1]=='C')){
                if(arr[i+1]=='L')ans+=40;
                if(arr[i+1]=='C')ans+=90;
                i++;
            }
            else if(i<arr.length-1 && arr[i]=='C'&&(arr[i+1]=='D'||arr[i+1]=='M')){
                if(arr[i+1]=='D')ans+=400;
                if(arr[i+1]=='M')ans+=900;
                i++;
            }
            else
            ans+=map.get(arr[i]);
        }
        return ans;
    }
}