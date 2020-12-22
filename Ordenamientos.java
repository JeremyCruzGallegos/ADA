package Sorts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenamientos {

	public static void main(String[] args) {
		
		
		int[] CUIS = {20120856,20172128,20193192,20140891,20182317,20173378,20130860,20193197,
					  20173367,20130456,20142957,20192191,20153589,20190626,20190643,20163299,
					  20190630,20150948,20190642,20192179,20190648,20140886,20161967,20161966,
					  20143379,20193202,20182825,20193193,20111454,20172139,20173376,20182824,
					  20193199,20061529,20180582,20161925,20182836,20180558,20190639,20193200,
					  20192175,20190634,20163296,20071084,20142708,20180562,20190646,20150949,
					  20192184,20192186,20192178,20190629,20182831,20172136,20190632,20181698,
					  20193198,20190637,20111457,20190622,20192192,20190624,20103260,20120280,
					  20192174,20193190,20190627,20190645,20180557,20181702,20182833,20130897,
					  20181695,20063599,20190635,20140874,20182943,20190633,20190636,20161968};
		int x = maxValue(CUIS);
		
		long t,T1,tiempo;
		t=System.nanoTime();
		Burbuja(CUIS);
		T1 = System.nanoTime();
	    tiempo = T1 - t;
		System.out.println("Bubblesort:\t"+tiempo);
		
		long t2,T2,tiempo2;
		t2=System.nanoTime();
		Insercion(CUIS);
		T2= System.nanoTime();
	    tiempo2 = T2 - t2;
		System.out.println("Insertion Sort:\t"+tiempo2);
		
		long t3,T3,tiempo3;
		t3=System.nanoTime();
		Seleccion(CUIS);
		T3= System.nanoTime();
	    tiempo3 = T3 - t3;
		System.out.println("Selection Sort:\t"+tiempo3);
		
		long t4,T4,tiempo4;
		t4=System.nanoTime();
		mergeSort(CUIS,80);
		T4= System.nanoTime();
	    tiempo4 = T4 - t4;
		System.out.println("Merge Sort:\t"+tiempo4);
		
		long t5,T5,tiempo5;
		t5=System.nanoTime();
		radixSort(CUIS,80);
		T5= System.nanoTime();
	    tiempo5 = T5 - t5;
		System.out.println("Radix Sort:\t"+tiempo5);
		
		long t6,T6,tiempo6;
		t6=System.nanoTime();
		countSort(CUIS,80);
		T6= System.nanoTime();
	    tiempo6 = T6 - t6;
		System.out.println("Countsort:\t"+tiempo6);
		
		long t7,T7,tiempo7;
		t7=System.nanoTime();
		Quick(CUIS,0,0);
		T7= System.nanoTime();
	    tiempo7 = T7 - t7;
		System.out.println("Quick Sort:\t"+tiempo7);
		
		long t8,T8,tiempo8;
		t8=System.nanoTime();
		heapSort(CUIS);
		T8= System.nanoTime();
	    tiempo8 = T8 - t8;
		System.out.println("Heapsort:\t"+tiempo8);
		
		long t9,T9,tiempo9;
		t9=System.nanoTime();
		bucket_sort(CUIS,x);
		T9= System.nanoTime();
	    tiempo9 = T9 - t9;
		System.out.println("Bucket Sort:\t"+tiempo9);

	}
	
	public static void Burbuja(int[]matrix){
        int temp;
        for(int i=1;i < matrix.length;i++){
            for (int j=0 ; j < matrix.length- 1; j++){
                if (matrix[j] > matrix[j+1]){
                    temp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = temp;
                }
            }
        }
    }
	
	public static void Insercion (int[] vector) {
	      for (int i=1; i < vector.length; i++) {
	         int aux = vector[i];
	         int j;
	         for (j=i-1; j >=0 && vector[j] > aux; j--){
	              vector[j+1] = vector[j];
	          }
	         vector[j+1] = aux;
	      }
	}
	
	public static void Seleccion(int[]matrix){
        int i, j, k, p, buffer, limit = matrix.length-1;
        for(k = 0; k < limit; k++){
            p = k;
            for(i = k+1; i <= limit; i++){
                if(matrix[i] < matrix[p]) p = i;
                if(p != k){
                    buffer = matrix[p];
                    matrix[p] = matrix[k];
                    matrix[k] = buffer;
                }
            }
        }
    }
	public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
	}
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {
			 
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
		    if (l[i] <= r[j]) {
		       a[k++] = l[i++];
		    }
		    else {
		       a[k++] = r[j++];
		    }
		}
		while (i < left) {
		    a[k++] = l[i++];
		}
		while (j < right) {
		    a[k++] = r[j++];
		}
	}
	
	public static void Quick(int matrix[], int a, int b){
	    matrix = new int[matrix.length];
	    int buf;
	    int from = a;
	    int to = b;
	    int pivot = matrix[(from+to)/2];
	    do{
	        while(matrix[from] < pivot){
	            from++;
	        }
	        while(matrix[to] > pivot){
	            to--;
	        }
	        if(from <= to){
	            buf = matrix[from];
	            matrix[from] = matrix[to];
	            matrix[to] = buf;
	            from++; to--;
	        }
	    }while(from <= to);
	    if(a < to){
	        Quick(matrix, a, to);
	    }
	    if(from < b){
	        Quick(matrix, from, b);
	    }
	} 
	
	public static void countSort(int array[], int size) {
	    int[] output = new int[size + 1];

	    // Find the largest element of the array
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];

	    // Initialize count array with all zeros.
	    for (int i = 0; i < max; ++i) {
	      count[i] = 0;
	    }

	    // Store the count of each element
	    for (int i = 0; i < size; i++) {
	      count[array[i]]++;
	    }

	    // Store the cummulative count of each array
	    for (int i = 1; i <= max; i++) {
	      count[i] += count[i - 1];
	    }

	    // Find the index of each element of the original array in count array, and
	    // place the elements in output array
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[array[i]] - 1] = array[i];
	      count[array[i]]--;
	    }

	    // Copy the sorted elements into original array
	    for (int i = 0; i < size; i++) {
	      array[i] = output[i];
	    }
	}
	
	public static void countingSort(int array[], int size, int place) {
	    int[] output = new int[size + 1];
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];

	    for (int i = 0; i < max; ++i)
	      count[i] = 0;

	    // Calculate count of elements
	    for (int i = 0; i < size; i++)
	      count[(array[i] / place) % 10]++;

	    // Calculate cummulative count
	    for (int i = 1; i < 10; i++)
	      count[i] += count[i - 1];

	    // Place the elements in sorted order
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[(array[i] / place) % 10] - 1] = array[i];
	      count[(array[i] / place) % 10]--;
	    }

	    for (int i = 0; i < size; i++)
	      array[i] = output[i];
	  }

	  // Function to get the largest element from an array
	  public static int getMax(int array[], int n) {
	    int max = array[0];
	    for (int i = 1; i < n; i++)
	      if (array[i] > max)
	        max = array[i];
	    return max;
	  }

	  // Main function to implement radix sort
	 public static void radixSort(int array[], int size) {
	   // Get maximum element
	   int max = getMax(array, size);

	   // Apply counting sort to sort elements based on place value.
	   for (int place = 1; max / place > 0; place *= 10)
	     countingSort(array, size, place);
	 }
	 
	 public static void bucketSort(int[] arr, int n) {
		if (n <= 0)
		  return;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] bucket = new ArrayList[n];

		// Create empty buckets
		for (int i = 0; i < n; i++)
		bucket[i] = new ArrayList<Integer>();

		// Add elements into the buckets
		for (int i = 0; i < n; i++) {
		  int bucketIndex = (int) arr[i] * n;
		  bucket[bucketIndex].add(arr[i]);
		}

		// Sort the elements of each bucket
		for (int i = 0; i < n; i++) {
		  Collections.sort((bucket[i]));
		}

		// Get the sorted array
		int index = 0;
		for (int i = 0; i < n; i++) {
		  for (int j = 0, size = bucket[i].size(); j < size; j++) {
		    arr[index++] = bucket[i].get(j);
		  }
		}
	}
	
	 public static void heapSort(int[] v) {
	    final int N = v.length;
	    for(int nodo = N/2; nodo>=0; nodo--) hacerMonticulo(v, nodo, N-1);
	    for(int nodo = N-1; nodo>=0; nodo--) {
	       int tmp = v[0];
	       v[0]    = v[nodo];
	       v[nodo] = tmp;
	       hacerMonticulo(v, 0, nodo-1);
	    }
	}

	public static void hacerMonticulo(int[] v, int nodo, int fin) {
	   int izq = 2*nodo+1;
	   int der = izq+1;
	   int may;
	   if(izq>fin) return;
	   if(der>fin) may=izq;
	   else may= v[izq]>v[der]?izq:der;
	   if(v[nodo] < v[may]) {
	      int tmp = v[nodo];
	      v[nodo] = v[may];
	      v[may]  = tmp;
	      hacerMonticulo(v, may, fin);
	   }
	} 
	
	public static void bucket_sort(int[] arr, int max_value) {
        int[] bucket = new int[max_value + 1];
        int[] sorted_arr = new int[arr.length];
 
        for (int i= 0; i <arr.length; i++)
            bucket[arr[i]]++;
 
        int pos = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                sorted_arr[pos++] = i;
         
    }
 
 
    public static int maxValue(int[] arr) {
        int max_value = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max_value)
                max_value = arr[i];
        return max_value;
    }	
	
	
}
