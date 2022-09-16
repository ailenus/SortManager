# Sort Manager

This project is a collection of sorting algorithms, meant to demonstrate
software development principles such as unit testing, design patterns, logging,
and object-oriented design principles.

## Organisation

The repository consists of several packages, the root whereof
is `com.spartaglobal.ymao`. The root directory contains three
subdirectories, `controller`, `model`, and `view`, conforming to the
model&#8211;view&#8211;controller (MVC) architecture.

The `controller` package consists of two additional packages, `exceptions`
and `start`, and a class `SortManager`. The `exceptions` package consists of two
classes, `ModeException` and `SortException`. The `start` package consists of
the main class `Main`, the `Starter` class, and the `SorterFactory` class.

The `model` package consists of another package `sorters`, an abstract
class `Sort`, an interface `Sorter`, and an enum `SorterType`. The `sorters`
package consists of seven classes: `BubbleSort`, `Heapsort` , `InsertionSort`
, `MergeSort`, `Quicksort`, `SelectionSort`, and `TreeSort`. 

The `view` package consists of another package `display`, and a
class `DisplayManager`. The `display` package consists of three
classes: `InputProcessor`, `InputPrompter`, and `OutputPrinter`.

Additionally, unit tests are contained in the `com.spartaglobal.ymao.sorters`
package, which consists of an abstract class `SortTest` and seven
classes: `BubbleSortTest`, `HeapsortTest`, `InsertionSortTest`, `MergeSortTest`
, `QuicksortTest`, `SelectionSortTest`, and `TreeSortTest`.

Finally, at the root of the repository, there is a `resources` directory, which
is the root of resources and consists of the `.properties` file for the Log4j 2
logging framework, and any log files generated will be stored here. Log files
are not uploaded to the remote repository on GitHub by their inclusion in
the `.gitignore` file.

## The `controller` package

The `SortManager` class contains one public static method, `getRandomArray`,
which takes two integer primitive parameters, `length` and `bound`, and returns
an array of integer primitives. The method invokes the public static `generate`
method of the `java.util.stream.IntStream` class and passes it a lambda
expression containing the public static `nextInt` method of
the `java.util.Random` class, and then invokes the `limit` and the `toArray`
methods on the generated `IntStream`. The `length` parameter is passed to
the `limit` method to specify the length of the array, and the `bound` parameter
is passed to the `nextInt` method to specify the upper bound of the integer
primitives to be randomly generated. 

The `ModeException` class of the `exceptions` package extends
the `java.lang.Exception` class and contains one public constructor which takes
one string parameter `message` and invokes the constructor of the superclass
with the `message` parameter.

The `SortException` class extends the `java.lang.RuntimeException` class and
contains one public constructor which takes one string parameter `message` and
invokes the constructor of the superclass with the `message` parameter.

It is noted that `ModeException` is a checked exception, while `SortException`
is unchecked.

The `Main` class of the `starter` package contains the main method, which
invokes the public static method `start` of the `Starter` class.

The `SorterFactory` class contains one public static method `getSorter`, which
takes one `SorterType` parameter `sorterType` and returns a `Sorter`. The method
uses a switch lambda expression and matches the `sorterType` to one of the seven
members of the `SorterType` enum before returning the instance of the
corresponding class by invoking the `getInstance` method of each of the seven
sorting classes.

It is noted that `SorterFactory` implements the factory design pattern.

The `Starter` class contains the bulk of the program execution logic. It
contains several private static final fields, several private static fields,
and three private static methods, `input`, `process`, and `output`, in addition
to the public static method `start`. The `start` method invokes the `input`
, `process`, and `output` methods in sequence.

It is noted that the `input` and `output` methods throw and
catch `ModeException`, and that the `process` method throws and
catches `SortException`. The class also uses
the `org.apache.logging.log4j.LogManager` and
the `org.apache.logging.log4j.Logger` classes from the Log4j 2 library to log
these exceptions when they are caught in addition to handling them.
The `ModeException`, when caught, induces a fatal-level log and causes the
program to terminate with exist status `1`, and the `SortException`, when
caught, induces a warn-level log.

The application starts by prompting the user to choose between selecting a
sorting algorithm to sort a randomly generated array and selecting two sorting
algorithms to compare their performance in sorting a randomly generated array.
The program then asks the user to choose one or two sorting algorithms among the
seven options: bubble sort, heapsort, insertion sort, merge sort, quicksort,
selection sort, and tree sort. The user is then asked to enter the length of the
array to be randomly generated. The program then prints the randomly generated
array, the sorted array, the chosen sorting algorithm, and the execution time of
the sorting algorithm. If the user selected comparing two algorithms, the second
chosen algorithm and the execution time thereof are printed as well.

## The `model` package

The abstract `Sort` class implements the `Sorter` interface, overrides
the `sort` method of the `Sorter` interface as public final, and contains one
more protected abstract method `sortHelper`, which takes an array of integer
primitives `array` and an integer primitive `length` and returns nothing. The
concrete implementations of `sortHelper` sorts the passed array in ascending
order. The overridden `sort` method makes a copy of the passed array using the
public static `copyOf` method of the `java.util.Array` class and invokes
the `sortHelper` method with the array copy and the length of the array before
returning the array copy.

The `Sorter` interface contains the one method `sort`, which takes an array of
integer primitives `array` and returns an array of integer primitives.

It is noted that the parameter `array` is not modified and the returned array is
sorted and contains the exact elements of `array`.

The `SorterType` enum contains seven members, corresponding to the seven sorting
classes: `BUBBLE_SORT`, `HEAPSORT`, `INSERTION_SORT`, `MERGE_SORT` , `QUICKSORT`
, `SELECTION_SORT`, and `TREE_SORT`.

The seven sorting classes in the `sorters` package each extend the `Sort` class
and overrides the protected `sortHelper` method using the sorting algorithm
corresponding to the name of the class.

It is noted that each sorting class contains a private static
final `org.apache.logging.log4j.Logger`, which generates an info-level log at
the very start of the `sortHelper` method.

Each sorting class also contains a private static final instance of the class,
has its default constructor private with no other constructors, and contains a
public static `getInstance` method which returns the private static final
instance.

As such, each sorting class implements the singleton design pattern.

Of the seven sorting classes, `BubbleSort`, `InsertionSort`, and `SelectionSort`
do not contain anything else. The `Heapsort` class additionally contains a
private static `heapify` method. The `MergeSort` class contains two private
static methods, `mergeSort` and `merge`, of which `mergeSort` is recursive.
The `Quicksort` class contains two private static methods, `quicksort`
and `partition`, of which `quicksort` is recursive. The `TreeSort` class
contains a private static nested class `BinaryTree`, which contains another
private static nested class `Node`. The `Node` nested class contains a private
final field of integer primitive `key`, two private fields of `Node`, `left`
and `right`, and a private constructor which takes an integer primitive `key`.
The `BinaryTree` nested class contains a private field of `Node`, `root`, three
overloaded private methods `insert`, one of which is recursive, and a private
method `traverseInOrder` which performs an in-order traversal of the binary
tree.

It is noted that all classes in the `model` package are used only by
the `Starter` and the `SorterFactory` classes outside this package, and all
classes of this package uses no classes from the other packages of this project,
making this package self-contained.

## The `view` package

The `DisplayManager` class contains several public static methods for printing
prompts to the standard output stream, getting user input from the standard
input stream, and printing program output to the standard output stream. Most
methods invoke public static methods of the classes contained in the `display`
package.

The `DisplayManager` class also contains several printing methods for printing
to the standard output stream, which are used by all classes in the `display`
package. This encapsulation is for ease of modification, in case the program
needs to print to other streams such as files, where only these printing methods
of the `DisplayManager` class require change.

The `InputProcessor` class of the `display` package contains one private static
final `org.apache.logging.log4j.Logger` and one public static
method `inputInteger` which takes a string `prompt` and an integer
primitive `bound` and returns an integer primitive. The method `inputInteger`
uses a `java.io.BufferedReader` which takes an `java.io.InputStreamReader`
taking the `java.lang.System.in` input stream. Then in an infinite loop it
ensures that the user enters a correct integer within the specified bound. When
catching an `java.io.IOException` thrown from the buffered reader, the logger
generates an error-level log and the system exits with exit status `1`.

The `InputPrompter` class contains several public static methods for printing
user prompts. Each method invokes the a printing method of the `DisplayManager`
class.

The `OutputPrinter` class contains two public static methods, `printOutput0`
and `printOutput1`, which invokes printing methods from the `DisplayManager` and
prints the program output corresponding.

It is noted that all classes in the `view` package are used only by
the `Starter` class outside this package, and all classes of this package uses
no classes from the other packages of this project, making this package
self-contained.

## Unit testing

The abstract `SortTest` class contains the following members:

- four private static final fields of integer primitives, `LARGE_LENGTH`
  , `LARGE_BOUND`, `ZERO_LENGTH`, and `ZERO_BOUND`;
- two private static fields of integer primitive arrays, `input` and `result`;
- one private static method `initialise`;
- four protected static methods, `initialiseLarge`, `initialiseZero`, `getInput`
  , and `getResult`; and
- three public abstract methods, `testLarge`, `testZero`, and `testSorted`.

It is noted that the three public abstract methods are annotated using
the `org.junit.jupiter.api.Test` interface.

Each of the seven sorting testing classes extends the abstract `SortTest` class
and overrides the `testLarge`, `testZero`, and `testResult` methods. Each method
invokes either the `initialiseLarge` or the `initialiseZero` method of the
superclass before invoking the public static `assertArrayEquals` method of
the `org.junit.jupiter.api.Assertions` class.

## Summary

The project demonstrates several key concepts in software development.
Object-oriented principles including abstraction and encapsulation, design
patterns including the factory pattern and the singleton pattern, the MVC
architecture, and development practices such as logging and unit testing are
exemplified. Additionally, language features such as recursion, exception
handling, streams, nested classes, lambda expressions, and many classes from the
standard library are utilised.
