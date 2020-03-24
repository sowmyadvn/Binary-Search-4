
// ========================= Approach-1 =================================
// Time: O(M+N) Space:O(M) (can be O(min(M,N)) if map is used on the smallest array)
/*
Approach:
========
1. Add one of the array's elements and counts to hashmap
2. Iterate through second array and if value found, decrement count and add element to result list
3. Space can be improved by storing the elements of the smallest array in map
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();  // number, count of occurrence of number 
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++) 
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1); // add elements and their counts of nums1 to map
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {    // iterate through second array and look for common element
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);       // if common element found, add to templist and decrement count
            }
        }
       int[] r = new int[list.size()];
       for(int i = 0; i < list.size(); i++)
       {
           r[i] = list.get(i);
       }
    
       return r;
            
    }
}

// ========================= Approach-2 =================================
// Time: O(MlogM+NlogN) Space: O(K) where K is number of common elements between both arrays
/*
Approach:
========
1. Sort the arrays
2. Now, use two pointers, one on each array to check for common element and if smaller element is not found in another, increment pointer
3. If common element found, add the element to list
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        List<Integer> result = new ArrayList<>();
        int one = 0, two = 0; 
        //sort arrays
        Arrays.sort(nums1);        
        Arrays.sort(nums2);
        
        int m = nums1.length, n = nums2.length;
        while(one < m && two < n) {
            if(nums1[one] < nums2[two])     // nums1 value not in nums2
                one++;
            else if(nums1[one] > nums2[two])    //nums2 value not in nums1
                two++;
            else {      //equal value
                result.add(nums1[one]);
                one++;
                two++;
            }
        }
        
        int[] array = new int[result.size()];
        int idx = 0;
        for(int num: result) {
            array[idx++] = num;
        }
        return array;
    }
}