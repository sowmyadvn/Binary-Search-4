class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int i = 0, n = citations.length, count = 0;
        for(int c: citations) {
            if(c >= n-i) return n-i;
            else i++;
        }
        return 0;
    }
}


class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int low = 0, high = citations.length-1, n = citations.length;
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(citations[mid] == n - mid) 
                return n - mid;
            else if(citations[mid] > n - mid) {
                high = mid - 1;
            }
            else 
                low = mid + 1;
        }
        return n - low;
    }
}

