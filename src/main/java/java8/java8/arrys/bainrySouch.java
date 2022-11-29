package java8.java8.arrys;

public class bainrySouch {
    //fromIndex =0;
    //toIndex=a.length
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
            int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
