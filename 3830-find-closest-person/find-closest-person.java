class Solution {
    public int findClosest(int x, int y, int z) {
        int space = 0;
        if(Math.abs(z-x) > Math.abs(z-y)) return 2;
        else if(Math.abs(z-x) < Math.abs(z-y)) return 1;
        else return 0;
    }
}