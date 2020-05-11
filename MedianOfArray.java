// Time: O(log(min(M,N))), Space: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if( nums1 == null && nums2 == null) return 0.0; 
        if(nums1.length == 0 && nums2.length == 0) return 0.0; 
        
        int len1 = nums1.length, len2 = nums2.length; 
        
        // improves efficiency of code by doing binarysearch on smaller array
        if(len1 > len2)
            return findMedianSortedArrays(nums2, nums1); 
        
        int left = 0, right = len1; 
        int partition1 = 0, partition2 = 0; 
        int maxLeft1 = 0, maxLeft2 = 0, minRight1 = 0, minRight2 = 0; 
        
        while(left <= right) {
            //partitions in first and second arrays
            partition1 = left + (right - left)/2; 
            partition2 = (len1 + len2 + 1)/2 - partition1; 
            
            //finding whether partition is right by comparing values at partition
            maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1-1];
            maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2-1];
            minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];
            minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                //even partition
                if((len1+len2)%2 == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2.0;
                //odd partition -> left has one extra element which is mid
                else
                    return Math.max(maxLeft1, maxLeft2);
            }
            else if( maxLeft1 > minRight2) 
                right = partition1 - 1;
            else
                left = partition1 + 1;
        }
        
        return 0.0;
    }
}