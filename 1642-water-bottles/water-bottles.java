class Solution {
    public int numWaterBottles(int bottles, int exchange) {
        int drinked = 0;
        int eb = 0;
        
        while (bottles > 0) {
            drinked += bottles;   
            eb += bottles;        
            
            bottles = eb / exchange; 
            eb = eb % exchange;         
        }
        return drinked;
    }
}