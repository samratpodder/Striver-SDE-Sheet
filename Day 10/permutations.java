class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] picked = new boolean[nums.length];
        // Arrays.fill(picked,false);
        func(nums,new LinkedList<>(), res,picked);
        return res;
    }
    public void func(int[] nums, List<Integer> temp, List<List<Integer>> res,boolean[] picked){
        if(temp.size()==nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }
        for(int i =0;i<nums.length;i++)
        {
            if(!picked[i]){
                temp.add(nums[i]);
                picked[i]=true;
                func(nums,temp,res,picked);
                picked[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}