# Sort Manager

This is a collection of sorting algorithms.

Currently, there are seven sorting algorithms implemented: bubble sort,
heapsort, insertion sort, merge sort, quicksort, selection sort, and tree sort.

## Organisation

The repository consists of several packages, of which `com.spartaglobal.ymao` is
the root. The `main` package consists of the main class `Main` containing the
main method. The `sorter` package consists of the sorting algorithms, as well as
an abstract class `Sort` which is the superclass of all sorting classes, and the
`Sorter` interface, which `Sort` implements. The `util` package contains several
auxiliary classes, including the `InputProcessor` class for processing user
input, the `RandomArray` class for generating an array of random integers, and
the `SortType` enum which helps processing the various sorting algorithms.

The unit test repository consists of one package `sorter`, which contains an
abstract `SortTest` class which is the superclass of all other unit test
classes.

## The `main` package

The main program is presented with a number of sorting algorithms to choose from
and prompted to enter their choice via the standard input. The user is then
asked for the desired length of the array to be randomly generated. The
auxiliary method `inputInteger` of the class `InputProcessor` from the `util`
package is invoked for processing these user inputs to ensure robustness.

The program then prints the randomly generated array, the sorting algorithm
chosen by the user, the sorted array, and the execution time in nanoseconds.
Various classes are used to accomplish these tasks, including the `SortType`
enum and the `RandomArray` class from the `util` package, as well as the
`Sorter` interface from the `sorter` package.

It is of note that none of the individual sorting classes of the `sorter`
package is accessed in any way, fulfilling the abstraction and encapsulation
principles.

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

The `InputProcessor` class consists of a single public static method
`inputInteger`, which takes a string parameter `prompt` and an integer parameter
`bound` and returns an integer. The method uses a `java.util.BufferedReader`,
which takes an `java.util.InputStreamReader` that uses the standard input
stream. It then initialises the return value `input` as $-1$ before entering an
infinite loop including a `try`&#8211;`catch` block that catches the
`java.lang.NumberFormatException` thrown by the `parseInt` method of the
`java.lang.Integer` class when the user does not enter an integer. An `if`
statement is then used to ensure the user enters an integer between $0$ and
`bound`. Each loop iteration also prints the passed string `prompt` to the
standard output. The method then returns the `input` value as entered by the
user when they enters a valid input.

The `RandomArray` class consists of a single public `getRandomArray` method for
generating an array of random integers, which uses `java.util.IntStream` and
`java.util.Random` to generate an array of specified length of integers between
$0$ and the specified upper bound, including $0$ and excluding the upper bound.

The `SortType` enum contains seven objects corresponding to the seven sorting
algorithms. It also has a public `getSorter` method that takes an object of this
enum and returns a corresponding instance of the `Sorter` interface.

## Unit tests

The abstract `SortTest` is the superclass for all other classes of unit tests,
which contains two private static fields of arrays of integers named `input` and
`result`. Both private static fields have protected static accessor methods,
`getInput` and `getResult`. It also has a private `initialise` method for
initialising the two private fields of integer arrays, storing a randomly
generated array in `input`, invoking the `getRandomArray` method from the
`RandomArray` class in the `util` package, and storing the sorted array in
`result`, invoking the `sort` method from the `java.util.Arrays` class in the
standard library.

The class also contains two protected final static methods, `initialiseLarge`
and `initialiseZero`, both of which invoke the `initialise` method using
different arguments, for testing large arrays of large elements and testing
empty arrays.  It also contains three public abstract methods using the `@Test`
annotation from `org.junit` to be overridden by each unit test class, named
`testLarge`, `testZero`, and `testSorted`. The `testLarge` method is the unit
test for testing each of the sorting algorithms with large values, and the
`testZero` method is that with empty values. The `testSorted` is used for
testing sorting an array that is already sorted.

Each of the seven testing classes implements the three abstract classes by
invoking either the `initialiseLarge` or the `initialiseZero` method of the
superclass and then using the `assertArrayEquals` method from the
`org.junit.Assert` class.
