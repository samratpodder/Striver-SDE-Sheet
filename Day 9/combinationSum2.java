class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        func(0,target,candidates,res,new ArrayList<>());
        return List.copyOf(res);
    }
    public void func(int idx,int sum, int[] arr, Set<List<Integer>> res, List<Integer> temp){
        if(idx==arr.length||sum<=0)
        {
            if(sum==0)
            {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            if(i>idx&&arr[i]==arr[i-1])continue;
            if(arr[i]>sum)break;
            temp.add(arr[i]);
            func(i+1,sum-arr[i],arr,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}