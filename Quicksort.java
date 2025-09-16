import java.util.Random;
public class Quicksort {

    public static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pi = split(arr, low, high);
            quicksort(arr, low, pi-1);
            quicksort(arr, pi+1, high);
        }
    }

    
    static int split(int[] arr, int low, int high) {
        int pivot = arr[low];
        System.out.println("Pivot: " + pivot);
        int i = low + 1;
    
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                //swap: arr[i] <-> arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    
        // Place pivot in its correct position
        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;
      
        return i - 1; // New pivot index
    }
    

    public static void main(String[] args) {
        int size = 6; // 100k elements
        int[] arr = new int[size];
       
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(20); // values between 0 and 999,999
        }   
        System.out.println("Unsorted array");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        long startTime = System.nanoTime();
        quicksort(arr, 0, size-1);   
        long stopTime = System.nanoTime();

        System.out.println("\nSorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        double durationSeconds = (stopTime - startTime) / 1_000_000_000.0;
        System.out.println(durationSeconds);
    }
}
