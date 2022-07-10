class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        func(0,res,new ArrayList<>(),nums,false);
        return List.copyOf(res);
    }
    public void func(int idx, Set<List<Integer>> res,List<Integer> temp,int[] nums,boolean choosePre){
        if(idx==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        func(idx+1,res,temp,nums,false);
        if(idx>=1&&nums[idx]==nums[idx-1]&&!choosePre) return;
        temp.add(nums[idx]);
        func(idx+1,res,temp,nums,true);
        temp.remove(temp.size()-1);
        
    }
}