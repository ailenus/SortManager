# Sorter

Task for Engineering 149 at Sparta Global.

This is a collection of sorting algorithms.

## Organisation

The repository consists of several of which the `com.spartaglobal.ymao` is the
root. The `main` package consists of the main class `App`, containing the main
method, and a `Sort` enum and a `SortTime` class for testing execution time.
The `sorter` package consists of the sorting algorithms, as well as an abstract
class `Sort` which is the superclass of all sorting classes, and the `Sorter`
interface, which `Sort` implements. The `util` package consists of the `Utility`
class, which hosts auxiliary methods that are used by the unit tests.

The unit test repository consists of one package `com.spartaglobal.ymao.sorter`,
which contains an abstract `SortTest` class that is the superclass of all the
other unit test classes contained therein.

## The `main` package

The `Sort` enum has six elements, corresponding to the six sorting algorithms
implemented in this repository. The enum is used by the `SortTime` class, which
contains a single static method `executionTime`, used to time each of the six
sorting algorithms, using the `nanoTime` method from the `java.lang.System`
class in the standard library. The main class `App` prints the result of the
execution time test to the standard output.

## The `sorter` package

The `Sorter` interface contains a single `sort` method, which takes an array and
returns an array that is sorted and contains the exact elements as in the passed
array.

The abstract `Sort` class, implementing the `Sorter` interface, overrides the
`sort` method as `final` and calls a protected abstract method `sortHelper` that
is overridden by its subclasses using different sorting algorithms. The `sort`
method in this abstract class simply makes a copy of the input array and calls
the abstract `sortHelper` method on the copy before returning it.

There are currently six different sorting algorithms contained in this package:
bubble sort, insertion sort, merge sort, quicksort, selection sort, and tree
sort. Each of the sorting algorithms has its own class that extends the abstract
`Sort` class and overrides the protected `sortHelper` method, using the named
sorting algorithm.

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

