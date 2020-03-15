package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q64 {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums); // 오름차순 정렬
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return; // target < 0 이면 합이 target으로 제대로 됐다는게 아니니깐 return
	    else if(remain == 0) list.add(new ArrayList<>(tempList)); // target 에 도달했다는 거니깐 list 추가
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1); // 
	        }
	    }
	}
}