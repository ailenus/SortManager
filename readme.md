# Sort Manager

This is a collection of sorting algorithms.

Currently, there are seven sorting algorithms implemented: bubble sort,
heapsort, insertion sort, merge sort, quicksort, selection sort, and tree sort.

## Organisation

The repository consists of several packages, of which `com.spartaglobal.ymao` is
the root. The `main` package consists of the main class `App` containing the
main method, a `Sort` enum, and a `SortTime` class for testing execution time.
The `sorter` package consists of the sorting algorithms, as well as an abstract
class `Sort` which is the superclass of all sorting classes, and the `Sorter`
interface, which `Sort` implements. The `util` package consists of the `Utility`
class, which hosts auxiliary methods that are used by the unit tests.

The unit test repository consists of one package `sorter`, which contains an
abstract `SortTest` class which is the superclass of all other unit test
classes.

## The `main` package

The `Sort` enum has seven elements, corresponding to the seven sorting
algorithms implemented in this repository. The enum is used by the `SortTime`
class, which contains a single static method `executionTime`, used to time each
sorting algorithm, using the `nanoTime` method from the `java.lang.System` class
in the standard library. The main class `App` prints the results of the execution time tests to the standard output.

## The `sorter` package

The `Sorter` interface contains a single `sort` method, which takes an array and
returns an array that is sorted and contains the exact elements as in the passed
array.

The abstract `Sort` class, implementing the `Sorter` interface, overrides the
`sort` method as final and invokes a protected abstract method `sortHelper`
that is overridden using different sorting algorithms by its seven subclasses.
The `sort` method in this class simply makes a copy of the input array and
invokes the `sortHelper` method and passing it the array copy before returning
it. The `sortHelper` method additionally takes the length of the array as an
integer parameter, since all sorting algorithms make use of the array length.
This abstraction eliminates duplicate code of accessing the array length in its
subclasses.

There are currently seven different sorting algorithms contained in this
package: bubble sort, heapsort, insertion sort, merge sort, quicksort, selection
sort, and tree sort. Each of the sorting algorithms has its own class that
extends the abstract `Sort` class and overrides the protected `sortHelper`
method, using the named sorting algorithm.

The `BubbleSort`, `InsertionSort`, and `SelectionSort` classes are
straightforward, containing only the protected overridden `sortHelper` method.

The `Heapsort` class uses in addition a private `heapify` method for
implementing a heap, which is invoked by its implementation of the `sortHelper`
method.

The `MergeSort` class contains two additional private methods, `mergeSort` and
`merge`. The `mergeSort` method recurses and invokes the `merge` method, and the
`merge` method merges two sorted arrays. Its implementation of `sortHelper`
simply invokes the `mergeSort` method.

The `Quicksort` class also contains two private methods, `quicksort` and
`partition`. The `quicksort` method recurses and invokes the `partition` method,
and the `partition` method returns the index of the partition. Its
implementation of `sortHelper` invokes the `quicksort` method.

The `TreeSort` class contains a private nested class `BinaryTree`, which
furthermore contains a private nested class `Node`. The `Node` class contains
three private fields, an integer `key` as well as a `left` and a `right`
reference of `Node`. The `Node` class has one private constructor which simply
initialises `key` as the passed integer.

The `BinaryTree` class contains one private field `root` which stores a `Node`
object. It also contains three overloaded methods named `insert`, taking an
integer array, an integer primitive, and a `Node` object and an integer
primitive respectively. The `insert` method taking an integer array invokes the
`insert` method taking an integer primitive, which in turn invokes the `insert`
method taking a `Node` object and an integer primitive. These methods construct
a binary tree data structure. Additionally, it has a private `traverseInOrder`
method, which does a depth-first in-order traversal of the constructed binary
tree and assigns its node keys to the passed array.

## The `util` package

The `Utility` class contains several methods used for unit testing. It contains
two private fields of arrays of integers named `input` and `result`. Both
private fields have a public accessor method, `getInput` and `getResult`. It
also contains a public method `random` for generating an array of random
integers, using the `java.util.IntStream` and `java.util.Random` classes from
the standard library. It also has a public `initialise` method for initialising
the two private fields of integer arrays, which is used for unit tests.

The `random` class used for generating an array of random integers has a brief
Javadoc written.

## Unit tests

The abstract `SortTest` is the superclass for all other classes of unit tests,
which contains two final methods, `initialiseLarge` and `initialiseZero`, both
of which invoke the `initialise` method from the `Utility` class using different
arguments, for testing large arrays of large elements and testing empty arrays.
It also contains three abstract methods to be overridden by each unit test
class, named `testLarge`, `testZero`, and `testSorted`. The `testLarge` method
is the unit test for testing each of the sorting algorithms with large values,
and the `testZero` method is that with empty values. The `testSorted` is used
for testing sorting an array that is already sorted.

Each of the seven testing classes implements the three abstract classes by
invoking either the `initialiseLarge` or the `initialiseZero` method of the
superclass and then using the `assertArrayEquals` method from the
`org.junit.Assert` class.
