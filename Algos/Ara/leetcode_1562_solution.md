**issue**
Given an array arr that represents a permutation of numbers from 1 to n. You have a binary string of size n that initially has all its bits set to zero.
At each step i (assuming both the binary string and arr are 1-indexed) from 1 to n, the bit at position arr[i] is set to 1. You are given an integer m and you need to find the latest step at which there exists a group of ones of length m. A group of ones is a contiguous substring of 1s such that it cannot be extended in either direction.
Return the latest step at which there exists a group of ones of length exactly m. If no such group exists, return -1.

**example**
![image](https://user-images.githubusercontent.com/48666611/117671397-b8242080-b1e3-11eb-96d3-3a0f7db6fc7f.png)


**solution**
//  in java

```java
class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        TreeMap<Integer,Integer> intervals = new TreeMap<>();
        intervals.put(0,arr.length-1);
        
        if(m == arr.length) return arr.length;
        int step = arr.length-1;
        
        for(int i=arr.length-1; i>=0;i--){
            int index = arr[i]-1;
            Integer floorKey = intervals.floorKey(index);
            Integer val = intervals.get(floorKey);
            
            if(index-floorKey ==m || val-index ==m) return step;
             intervals.remove(floorKey);
            
            if(floorKey<index) intervals.put(floorKey,index-1);
            if(val>index) intervals.put(index+1,val); 
            step--;
        }
        return -1;
    }
}
```
