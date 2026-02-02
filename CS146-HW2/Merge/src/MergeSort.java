/**
 * Merge two sorted Arrays
 * @author Kevin Thai
 */
public class MergeSort {
    /**
     * Combines two sorted int arrays in one sorted int array
     * @param left a sorted array of ints
     * @param right a second sorted array of ints
     * @return An array of sorted ints from two sorted arrays
     */
    public static int[] mergeArray(int[] left, int[] right){

        int[] sorted = new int[left.length+right.length]; //Create a new array that combine the size of both arrays

        int leftIndex= 0; //Keep track of position on the left array
        int rightIndex= 0;//Keep track of position on the right array

        for(int i= 0; i< sorted.length; ++i){ //Loop to fill the new array with the two sorted array
            if(leftIndex< left.length && rightIndex< right.length){//Check to see if there are any comparison left between the two array
                
                if(left[leftIndex]> right[rightIndex]){ //Check if left is larger number
                    sorted[i]= right[rightIndex];// Add right array number to new array
                    rightIndex+= 1;// Increment the right array
                }
                else{
                    sorted[i]= left[leftIndex]; //Add left array number to new array
                    leftIndex+= 1;// Increment the left array
                }
            }
            else if (leftIndex < left.length ) {// Add remaining left array numbers to the new array
                sorted[i]= left[leftIndex];
                leftIndex+= 1;
            }
            else{//Add remaining right array numbers to new array
                sorted[i]= right[rightIndex];
                rightIndex+= 1;
            }
        }
        return sorted;
    }

    public static void main(String[] args){
        //Unit testing
        System.out.println();
        //Test 1
        System.out.println("Test 1: Same size array");
        int left[] = {1,15,26};
        int right[] ={1,3,7};
        
        int[] sortedNums = mergeArray(left,right);
        System.out.println("Before: L{1,15,26} R{1,3,7}");
        System.out.println("Expected: 1, 1, 3, 7, 15, 26, ");
        System.out.print("Results:  ");
        for(int i: sortedNums){
            System.out.print(i+ ", ");
        }

        System.out.println();
        System.out.println("Length of new Array: " + sortedNums.length);
        System.out.println();

        //Test 2
        System.out.println("Test 2: Right array larger");
        int[] testL = {2,7,8};
        int[] testR ={0,4,5,9};
        int[] testArray = mergeArray(testL,testR);
       
        System.out.println("Before: L{2,7,8} R{0,4,5,9}");
        System.out.println("Expected: 0, 2, 4, 5, 7, 8, 9, ");
        System.out.print("Results:  ");
        for(int i: testArray){
            System.out.print(i+ ", ");
        }
        System.out.println();
        System.out.println("Length of new Array: " + testArray.length);

        System.out.println();

        //Test 3
        System.out.println("Test 3: Left array larger");
        int testL2[] = {0,1,4,7,8};
        int testR2[] = {2,5,9};

        System.out.println("Before: L{0,1,4,7,8} R{2,5,9}");
        System.out.println("Expected: 0, 1, 2, 4, 5, 7, 8, 9, ");
        System.out.print("Results:  ");
        for(int num: mergeArray(testL2,testR2)){
        System.out.print(num+ ", ");
        }
         
        System.out.println();
        System.out.println("Length of new Array: " + (testL2.length + testR2.length));
        System.out.println();

        //Test 4
        System.out.println("Test 4: Right Array filled with one value");
        int testL4[] = {0,1,4,7,8};
        int testR4[] = {5,5,5,5,5};

        System.out.println("Before: L{0,1,4,7,8} R{5,5,5,5,5}");
        System.out.println("Expected: 0, 1, 4, 5, 5, 5, 5, 5, 7, 8, ");
        System.out.print("Results:  ");

        for(int num: mergeArray(testL4,testR4)){
            System.out.print(num+ ", ");
        }
        System.out.println();
        System.out.println("Length of new Array: " + (testL4.length+ testR4.length));
        
        /*
        The length of new array is the total length of the two array left.length+right.length.
         */
    }
}
