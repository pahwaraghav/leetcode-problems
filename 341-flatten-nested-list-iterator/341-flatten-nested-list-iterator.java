/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> arr;
    int curr;
    public NestedIterator(List<NestedInteger> nestedList) {
        arr = new ArrayList<>();
        curr = 0;
        create(nestedList);
    }
    
    private void create(List<NestedInteger> nestedList){
        for(int j=0;j<nestedList.size();j++){
             if(nestedList.get(j).isInteger()){
                 arr.add(nestedList.get(j).getInteger());
             }
             else{
                 List<NestedInteger> li = nestedList.get(j).getList();
                 create(li);
             }
        }   
    }

    @Override
    public Integer next() {
        if(!this.hasNext()){
            return null;
        }
        return arr.get(curr++);
    }

    @Override
    public boolean hasNext() {
        if(curr < arr.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */