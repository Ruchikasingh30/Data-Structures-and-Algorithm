class Solution {
    public boolean hasAlternatingBits(int num) {
        List<Integer> list= new ArrayList <>();
        while(num>0){
            int rem= num%2;
            list.add(rem);
            num= num/2;
        }
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)== list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}