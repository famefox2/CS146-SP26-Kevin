/**
 * The partition method of lomuto and hoare
 * @author Kevin Thai
 */
public class Partition {

    /**
     * Partition the array using the hoare partition method using index low of the array as the key
     * @param array
     * @param low the starting index of the array
     * @param high the ending index of the array
     * @return the partition index
     */
    public static int hoarePartition(int[] array, int low, int high){
        int key = array[0]; // The numbers in the array to compare to
        int i = low-1; //Starting index at the begining of array
        int j = high+1;// Starting index at the end of the array
        int temp;// Keep track of a number in array before the swapped with another number in array

        while(i<=j){
            do{ // deincrement j while the number in the array is greater than key value
                j-=1;
            } while (array[j]>key);

            do{//increment i while the number in the array is less than key value
                i+=1;
            } while(array[i]<key);

            if(i>=j){//After i pass j return j value index
                return j;
            }
            temp = array[j]; // Swap i and j value
            array[j]= array[i];
            array[i] = temp;
            
        }
        return -1;
    }
    /**
     * Finds the partition index and partition the array using the lomuto partition method using index low oif the array as the key
     * @param array
     * @param low the starting index of the array
     * @param high the ending index of the array
     * @return the partition index
     */
    public static int lomutoPartition(int[] array,int low,int high){  
        int pivot = array[high];// The number that is compared to in the array.
        int temp; // Keep track of a number in array before the swapped with another number in array
        int i = low-1; //Starting index of the method

        for(int j = low; j < high;++j){//loop through the array
            if(array[j]<= pivot){// Swap numbers when number in the array is less than or equal pivot
                i+=1;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        temp= array[high];
        array[high] = array[i+1];
        array[i+1] = temp;
        return i+1;
        
    }
    /**
     * Print the array and its first partition
     * @param a array to be printed
     * @param name name of the partition method
     * @param index partition index of the array
     */
    public static void printAll(int[] a, String name, int index){
        System.out.println(name);//Print method used
        for(int i: a){//Print the array
            System.out.print(i + ", ");
        }
        System.out.println();
        
        if(name.equals( "Hoare")){//Print Hoare partitions
            printPartitionsH(a, index+1);
        }
        else{//Print lomuto partitions
            
            printPartitionL(a, index);
        }
        System.out.println();
    }

   
    /**
     * Print the partitions of the array for Hoare Method
     * @param a the enitre array
     * @param index the index partition to split the array in two
     */
    public static void printPartitionsH(int[] a, int index){
        System.out.print("Left{");//print left side of partition
        for(int i =0; i< index; ++i){
            System.out.print(a[i] + ", ");
        }
         System.out.print("} Right{");

        for(int j= index; j < a.length; ++j){//print right side of partition
            System.out.print(a[j] + ", ");
        }
        System.out.println("}");
    }
    /**
     * Print the partitions for lomuto method without the pivot number/value that is in the right index position
     * @param a the enitre array
     * @param index the index partition to split the array in two
     */
    public static void printPartitionL(int[] a, int index){
        System.out.print("Left{");
        for(int i =0; i< index; ++i){//print left side of partition
            System.out.print(a[i] + ", ");
        }
         System.out.print("} Right{");

        for(int j= index+1; j < a.length; ++j){//print right side of partition
            System.out.print(a[j] + ", ");
        }
        System.out.println("}");
    }
    public static void main(String[] args){
        
        String hoare = "Hoare";
        String lomoto = "Lomoto";
        //Unit test 1
        int[] testArray1 = {4,6,9,3,7};
        int[] testArray2 = {4,6,9,3,7};
        int h = hoarePartition(testArray1,0,4); //index of partition for hoare

        int l = lomutoPartition(testArray2, 0, 4);//index of partition for lomuto
        System.out.println("Test 1-Before: {4,6,9,3,7}");
        printAll(testArray1, hoare, h);
        printAll(testArray2, lomoto, l);
       
        // Test 2
        int[] testArray5 = {84,3,7,1,9,6,2,5,};
        int[] testArray6 = {84,3,7,1,9,6,2,5,};
        int h3 = hoarePartition(testArray5,0, testArray5.length-1); //index of partition for hoare
        int l3 = lomutoPartition(testArray6, 0, testArray6.length-1);//index of partition for lomuto

        System.out.println("Test 2-Before: {84,3,7,1,9,6,2,5,}");
        printAll(testArray5, hoare, h3);
        printAll(testArray6, lomoto, l3);

        //Test 3
        int[] testArray7 = {10,17,19,21,44,55,57,63,65,67};
        int[] testArray8 = {10,17,19,21,44,55,57,63,65,67};
        int h4 = hoarePartition(testArray7,0,testArray7.length-1);//index of partition for hoare
        int l4 = lomutoPartition(testArray8, 0,testArray8.length-1);//index of partition for lomuto

        System.out.println("Test 3-Before: {10,17,19,21,44,55,57,63,65,67}");
        printAll(testArray7, hoare, h4);
        printAll(testArray8, lomoto, l4);
       //Test 4
       try{ //Test the empty set
        System.out.println("Test 4-Before: {}");
        int[] testArray3 = {};
        int[] testArray4 = {};
        int h2 = hoarePartition(testArray3, 0,0);//index of partition for hoare

        int l2 = lomutoPartition(testArray4, 0, 0);//index of partition for lomuto

       
        printAll(testArray3, hoare, h2);
        printAll(testArray4, lomoto, l2);
       }
       catch(Exception e){//Methods fail due to the array being empty
            System.out.println("Empty Array");
       }
       /*
        From what i see the lomuto method put the pivot number in the correct position in the array
       compared to hoare but both do split the numbers to arrays before the pivot and after the pivot.
       The methods do not swap the numbers if the array is already sorted.
       */
        
       
    }
}







