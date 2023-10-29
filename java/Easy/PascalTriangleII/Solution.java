// https://leetcode.com/problems/pascals-triangle-ii
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        Long last = 1L;

        for(int i=1; i<=rowIndex; i++) {
            last = last * (rowIndex+1-i)/i;
            row.add(last.intValue());
        }
       
        return row;
    }
}
