class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      findSS(0, nums, new ArrayList<>(), res);
      return res;  
    }
    private void findSS(int idx, int[] nums, List<Integer> ds, List<List<Integer>> res){
        res.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i-1])continue;
            ds.add(nums[i]);
            findSS(i+1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}