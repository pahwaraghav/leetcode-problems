// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    ArrayList<Integer> arr;
    Iterator it;
    int i = 0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    arr = new ArrayList<>();
        it = iterator;
        it.forEachRemaining((num) -> arr.add((int)num));
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return arr.get(i);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int num = arr.get(i);
        i++;
        return num;
	}
	
	@Override
	public boolean hasNext() {
	    return i < arr.size();
	}
}