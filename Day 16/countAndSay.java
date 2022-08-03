class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String ans = "11";
        for(int k =3;k<=n;k++){
            int count = 1;
            ans=ans+"&";
            String temp = "";
            for(int i=1;i<ans.length();i++){
                if(ans.charAt(i-1)==ans.charAt(i)){
                    count++;
                }
                else{
                    temp = temp + Integer.toString(count);
                    temp = temp + ans.charAt(i-1);
                    count=1;
                }
            }
            ans = temp;
        }
        return ans;
        
    }
}