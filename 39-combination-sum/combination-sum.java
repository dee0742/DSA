class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
       findCombinations(0, candidates, target, result, new ArrayList<>());
       return result;
    }

    private void findCombinations(int idx, int[] arr, int target, List<List<Integer>> result, List<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx] <= target){
            ds.add(arr[idx]);
            findCombinations(idx, arr, target - arr[idx], result, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(idx + 1, arr, target, result, ds);
    }
}