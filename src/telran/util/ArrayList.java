package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size = 0;
	
	private class ArrayListIterator implements Iterator<T>{
		int currentIndex = 0;
		boolean isNext = false;
		@Override
		public boolean hasNext() {
			
			return currentIndex < size;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			isNext = true;
			return array[currentIndex++];
		}
		@Override
		public void remove() {
			if(!isNext) {
				throw new IllegalStateException();
			}
			ArrayList.this.remove(--currentIndex);
			isNext = false;
		}
		
	}
	
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size++] = obj;
		return true;
	}

	private void reallocate() {
		Arrays.copyOf(array, array.length * 2);		
	}
	@Override
	public boolean remove(Object pattern) {
		int index = indexOf(pattern);
		boolean res = false;
		if(index >= 0) {
			res = true;
			remove(index);
		}
		return res;
	}

	@Override
	public T[] toArray(T[] ar) {
		T[] res = ar.length < size ? Arrays.copyOf(ar, size) : ar;
		int index = 0;
		for(T obj: this) {
			res[index++] = obj;
		}
		if(res.length > size) {
			res[size] = null;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		Iterator<T> it = iterator();
		int oldSize = size;
		while(it.hasNext()) {
			if(predicate.test(it.next())) {
				it.remove();
			}
		}
		return oldSize > size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean addAll(Collection<T> collection) {
		for(T obj: collection) {
			add(obj);
		}
		return collection.size() > 0;
	}

	@Override
	public boolean removeAll(Collection<T> collection) {
		int oldSize = size;
		for(T obj: collection) {
			remove(obj);
		}
		return oldSize > size;
	}

	@Override
	public Iterator<T> iterator() {
		
		return  new ArrayListIterator();
	}

	@Override
	public void add(int index, T obj) {
		indexValidatuion(index, true);
		if(size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
		
	}

	@Override
	public T get(int index) {
		indexValidatuion(index, false);
		return array[index];
	}

	@Override
	public T set(int index, T obj) {
		T res = get(index);
		array[index] = obj;
		return res;
	}

	@Override
	public T remove(int index) {
		indexValidatuion(index, false);
		T res = array[index];
		size--;
		System.arraycopy(array, 0, array, 0, index);
		System.arraycopy(array, index + 1, array, index, size - index);
		array[size] = null;
		return res;
	}

	private void indexValidatuion(int index, boolean sizeIncluzive) {
		
		int bounder = sizeIncluzive ? size : size -1; 
		if(index < 0 || index > bounder) {
			throw new IndexOutOfBoundsException(index);
		}
		
	}
	@Override
	public int indexOf(Object pattern) {
		
		return indexOf(Predicate.isEqual(pattern));
	}

	@Override
	public int lastIndexOf(Object pattern) {
		
		return lastIndexOf(Predicate.isEqual(pattern));
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while(index < size && res == -1) {
			if(predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int res = -1;
		int index = size - 1;
		while(index >= 0 && res == -1) {
			if(predicate.test(array[index])) {
				res = index;
			}
			index--;
		}
		return res;
	}

}
