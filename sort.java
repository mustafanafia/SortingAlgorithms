public class sort {


  public static void main(String[] args) {              //main method
    int SIZE = 200000;                              //array size 200000
    int[] list = new int[SIZE];                     //creating arrays list and listhold with 200000 size
    int[] listHold = new int[SIZE];
    //makeArray(list);
    listHold = list.clone();            //listhold for bubble sort
    System.out.println("Array size: " + SIZE);              //printing array size
    long startTIME = System.nanoTime();                 //start time
    long elapsedTime = System.nanoTime() - startTIME;
    System.out.printf("Time: %3.10f\n",elapsedTime / (Math.pow(10,9)));    //printing time
    System.out.println("Bubble sort");    
    System.out.println("***********************");
    
    //makeArray(list);
    listHold = list.clone();            //listhold for selection sort
    System.out.println("Array size: " + SIZE);           //printing array size
    startTIME = System.nanoTime();                          //start time
    elapsedTime = System.nanoTime() - startTIME;
    System.out.printf("Time: %3.10f\n",elapsedTime / (Math.pow(10,9)));    //printing time
    System.out.println("Selection sort");    
    System.out.println("***********************");
    
    listHold = list.clone();            //listhold for insertion sort
    System.out.println("Array size: " + SIZE);              //printing array size
    startTIME = System.nanoTime();                              //start time
    elapsedTime = System.nanoTime() - startTIME;
    System.out.printf("Time: %3.10f\n",elapsedTime / (Math.pow(10,9)));     //printing time
    System.out.println("insertion sort");    
    System.out.println("***********************");
        
    listHold = list.clone();            //listhold for Merge sort
    System.out.println("Array size: " + SIZE);              //printing array size
    startTIME = System.nanoTime();                  //start time
    elapsedTime = System.nanoTime() - startTIME;
    System.out.printf("Time: %3.10f\n",elapsedTime / (Math.pow(10,9)));    //printing time
    System.out.println("Merge sort");           
    System.out.println("***********************");
    
    listHold = list.clone();                        //listhold for quick sort
    System.out.println("Array size: " + SIZE);       //printing array size
    startTIME = System.nanoTime();                   //start time
    elapsedTime = System.nanoTime() - startTIME;
    System.out.printf("Time: %3.10f\n",elapsedTime / (Math.pow(10,9)));    //printing time
    System.out.println("Quick sort");    
    System.out.println("***********************");

    
    
}    //main method
  
  
  
      public static void bubbleSort(int[] list) {               //bubble sort method
    boolean needNextPass = true;
    
    for (int k = 1; k < list.length && needNextPass; k++) {
      // Array may be sorted and next pass not needed
      needNextPass = false;
      for (int i = 0; i < list.length - k; i++) {
        if (list[i] > list[i + 1]) {
          // Swap list[i] with list[i + 1]
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          
          needNextPass = true; // Next pass still needed
        }   //if
      } //for
    } //for
    
    
    
}     //bubble sort


  public static void selectionSort(double[] list) {             //selection sort method
    for (int i = 0; i < list.length - 1; i++) {
      // Find the minimum in the list[i..list.length-1]
      double currentMin = list[i];
      int currentMinIndex = i;

      for (int j = i + 1; j < list.length; j++) {
        if (currentMin > list[j]) {
          currentMin = list[j];
          currentMinIndex = j;
        } //if
      } //for

      // Swap list[i] with list[currentMinIndex] if necessary;
      if (currentMinIndex != i) {
        list[currentMinIndex] = list[i];
        list[i] = currentMin;
      } //if
} //for
}  //selection sort


  public static void insertionSort(int[] list) {                //insertion sort method
    for (int i = 1; i < list.length; i++) {
      /** insert list[i] into a sorted sublist list[0..i-1] so that
           list[0..i] is sorted. */
      int currentElement = list[i];
      int k;
      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
        list[k + 1] = list[k];
      }

      // Insert the current element into list[k+1]
      list[k + 1] = currentElement;
    }  //for
  }   //insertion fort 


  public static void mergeSort(int[] list) {                //merge sort method
    if (list.length > 1) {
      // Merge sort the first half
      int[] firstHalf = new int[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      // Merge sort the second half
      int secondHalfLength = list.length - list.length / 2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length / 2,
        secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge firstHalf with secondHalf into list
      merge(firstHalf, secondHalf, list);
    }   //if
  }  //merge sort

 
  public static void merge(int[] list1, int[] list2, int[] temp) {             
    int current1 = 0; // Current index in list1
    int current2 = 0; // Current index in list2
    int current3 = 0; // Current index in temp

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2])
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }   //while

    while (current1 < list1.length)
      temp[current3++] = list1[current1++];

    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }  


  
    public static void quickSort(int[] list) {          //quick sort method
    quickSort(list, 0, list.length - 1);
  }

  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }  //if
  }   //quick sort

  /** Partition the array list[first..last] */
  private static int partition(int[] list, int first, int last) {
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot)
        low++;

      // Search backward from right
      while (low <= high && list[high] > pivot)
        high--;

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }   //if
    }  //while

    while (high > first && list[high] >= pivot)
      high--;

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }


}

