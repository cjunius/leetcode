// https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        //return generatePascalTriangleIterative(numRows);
        return generatePascalTriangleFormula(numRows);
    }

    public List<List<Integer>> generatePascalTriangleIterative(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++) {
            List<Integer> previous = pascal.get(i-1);

            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1; j<previous.size(); j++) {
                row.add(previous.get(j)+previous.get(j-1));
            }
            row.add(1);
            pascal.add(row);
        }
        return pascal;
    }

    public List<List<Integer>> generatePascalTriangleFormula(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(Arrays.asList(1));

        for(int i=1; i<numRows; i++) {
            pascal.add(calculatePascalRow(i));
        }
        return pascal;
    }

    private List<Integer> calculatePascalRow(int rowNum) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int last = 1;

        for(int i=1; i<=rowNum; i++) {
            last = last * (rowNum+1-i)/i;
            row.add(last);
        }
       
        return row;
    }
}
