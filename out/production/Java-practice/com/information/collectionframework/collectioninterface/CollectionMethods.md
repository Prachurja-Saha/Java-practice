
# Collection Method
1) boolean add(e)
2) boolean addAll(Collection<? extends E> c) -> [ ? -> wildcard means any type which extends E) ]
   It is used to insert the specified collection elements in the invoking collection.
3) boolean remove(Object element)
4) boolean public boolean removeAll(Collection<?> c)
5) default boolean removeIf(Predicate<? super E> filter) //-> later 
6) public boolean retainAll(Collection<?> c) ->It is used to delete all the elements of invoking collection 
                                               except the specified collection.
7) int Size(), void clear, boolean contains(Object element), boolean containsAll(Collection<?> c),  isEmpty()
8) public Iterator iterator() -> It returns an iterator. 

// Later below 
9) public Object[] toArray() -> It converts collection into array.
10) public <T> T[] toArray(T[] a) -> It converts collection into array. 
Here, the runtime type of the returned array is that of the specified array.
11) default Stream<E> parallelStream()
12) default Stream<E> stream()
13) public boolean equals(Object element) -> It matches two collections.

# Iterator interface
1) boolean hasNext(), Object next(), void remove()