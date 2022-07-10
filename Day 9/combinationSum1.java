class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        func(0,target,candidates,res,new ArrayList<>());
        return res;
    }
    public void func(int idx, int sum,int[] arr, List<List<Integer>> res, List<Integer> temp){
        if(idx==arr.length){
            if(sum==0)
            {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[idx]<=sum){
            temp.add(arr[idx]);
            func(idx,sum-arr[idx],arr,res,temp);
            temp.remove(temp.size()-1);
        }
        
        
        func(idx+1,sum,arr,res,temp);
    }
}