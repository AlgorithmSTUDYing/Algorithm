package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums); // �������� ����
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return; // target < 0 �̸� ���� target���� ����� �ƴٴ°� �ƴϴϱ� return
	    else if(remain == 0) list.add(new ArrayList<>(tempList)); // target �� �����ߴٴ� �Ŵϱ� list �߰�
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // �����̹Ƿ� ���� �ٽ� ���� �����ϹǷ� i+1�� �ƴ� i�� �ٽ� ����
	            tempList.remove(tempList.size() - 1); // ���ǿ� �ɷ� ��͸� ���߰� ���ƿ����Ƿ� ������ ���Ҵ� �����ش�
	        }
	    }
	}
}
