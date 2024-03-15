
package csci2010.dotylab6;

/**
 *CSCI 2011 Lab 6
 * 
 * @author Jason Doty
 * 
 *  Displays the contents of an array using recursion.
 *  Displays a string in reverse order using recursion.
 *  Calculates the factorial of a number using recursion.
 *  Performs a binary search on a sorted array using recursion, including visual indicators of the search process.
 */
public class DotyLab6 {

    public static void main(String[] args) {

        // Test code for displayArray
        int[] array = {68, 24, 93, 98, 11, 54, 19, 36};
        System.out.println("Displaying array with 8 items");
        displayArray(array);

        // Test code for displayReverse
        String testString = "Hello World!";
        System.out.println("Calling displayReverse(\"" + testString + "\")");
        displayReverse(testString);
        System.out.println();

        // Test code for factorial
        System.out.println("Calling factorial(5)");
        System.out.println("result: " + factorial(5));
        System.out.println("Calling factorial(20)");
        System.out.println("result: " + factorial(20));

        // Test code for binarySearch
        int[] sortedArray = {3, 6, 11, 14, 19, 23, 28, 33, 37};
        int itemToSearch = 14;
        System.out.println("Calling binarySearch to search for " + itemToSearch);
        
        // Capture the result of the binary search
        int resultIndex = binarySearch(sortedArray, itemToSearch);
        
        // Display the result index
        System.out.println("result: " + resultIndex);
    }

    // Recursive method to display the contents of an array
    private static void displayArray(int[] arr, int index) {
        if (index == arr.length) {
            System.out.println();
        } else {
            System.out.printf("%3d ", arr[index]);
            displayArray(arr, index + 1);
        }
    }

    public static void displayArray(int[] arr) {
        displayArray(arr, 0);
    }

    // Recursive method to display a string in reverse
    public static void displayReverse(String str) {
        if (str.length() == 0) return;
        displayReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    // Recursive method to calculate the factorial of a number
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Recursive method to perform a binary search
    private static int binarySearch(int[] arr, int item, int first, int last) {
        if (first > last) {
        return -1; // Item not found
        }
        int middle = first + (last - first) / 2;
        // Display array and indexes
        displayArray(arr);
        displayArrayIndexes(first, middle, last, arr.length);

        if (arr[middle] == item) {
        return middle; // Item found
        } else if (arr[middle] > item) {
        return binarySearch(arr, item, first, middle - 1);
        } else {
        return binarySearch(arr, item, middle + 1, last);
        }
    }

    public static int binarySearch(int[] arr, int item) {
        return binarySearch(arr, item, 0, arr.length - 1);
    }

    private static void displayArrayIndexes(int first, int middle, int last, int length) {
        for (int i = 0; i < length; i++) {
            if (i == first && first == middle && middle == last) {
                System.out.print("FML ");
            } else if (i == first && first == middle) {
                System.out.print("FM ");
            } else if (i == middle && middle == last) {
                System.out.print("ML ");
            } else if (i == first && first == last) {
                System.out.print("FL ");
            } else if (i == first) {
                System.out.print("F ");
            } else if (i == middle) {
                System.out.print("M ");
            } else if (i == last) {
                System.out.print("L ");
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
    }
}
