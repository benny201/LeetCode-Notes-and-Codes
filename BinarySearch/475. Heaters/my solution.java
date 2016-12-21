public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return -1;
        }
        
        if (heaters == null || heaters.length == 0) {
            return -1;
        }
        
        Arrays.sort(heaters);
        Arrays.sort(houses);
        
        int start = 0;


        //find the end position
        int end = 0;
        if (Math.abs(heaters[0] - houses[0]) >= (heaters[heaters.length-1] - heaters[0])) {
            if (Math.abs(heaters[0] - houses[0]) >= Math.abs(heaters[heaters.length-1] - houses[houses.length-1])) {
                end = Math.abs(heaters[0] - houses[0]);
            } else {
                end = Math.abs(heaters[heaters.length-1] - houses[houses.length-1]);
            }
        } else {
            if ((heaters[heaters.length-1] - heaters[0]) >= Math.abs(heaters[heaters.length-1] - houses[houses.length-1])) {
                end = heaters[heaters.length-1] - heaters[0];
            } else {
                end = Math.abs(heaters[heaters.length-1] - houses[houses.length-1]);
            }
        }

        //find the first position of valid radiu by BinarySearch
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (isValidRadiu(houses,heaters,mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isValidRadiu(houses,heaters,start)) {
            return start;
        }
        
        if (isValidRadiu(houses,heaters,end)) {
            return end;
        }
        
        return -1;
    }
    
    //test the validation of the radiu
    public boolean isValidRadiu(int[] houses, int[] heaters, int radiu) {
        int heatersLen = heaters.length;
        int heaterIndex = 0;
        for (int i=0; i < houses.length; ) {
    // see whether the houses[i] is in the range of (heaters[heaterIndex] - radiu,heaters[heaterIndex] + radiu) or not
            if (houses[i] >= (heaters[heaterIndex] - radiu) && houses[i] <= (heaters[heaterIndex] + radiu)) {
                i++;
            } else {
                if (heaterIndex + 1 < heatersLen) {
                    heaterIndex++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
