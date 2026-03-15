class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int prefer0 = 0, prefer1 = 0;
        
       
        for (int student : students) {
            if (student == 0) prefer0++;
            else prefer1++;
        }
        
       
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && prefer0 > 0) {
                prefer0--;
            } else if (sandwich == 1 && prefer1 > 0) {
                prefer1--;
            } else {
               
                break;
            }
        }
        
        return prefer0 + prefer1; 
    }
}