package src;

/**
 *
 * @author Kevin Thai
 */
public class MergeArray {

    public static int[] merge( int[] left, int[] right){
        
        int[] mergedArray = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for ( int i = 0; i < mergedArray.length; ++i) {

            if(leftIndex< left.length && rightIndex< right.length){
                if( left[leftIndex] < right[rightIndex]){
                    mergedArray[i] = left[leftIndex];
                    leftIndex+=1;
                }
                else{
                    mergedArray[i] = right[rightIndex];
                    rightIndex+=1;
                }
            }
            else{
                if(leftIndex < left.length){
                    mergedArray[i] = left[leftIndex];
                    leftIndex+=1;
                }
                else{
                    mergedArray[i] = right[rightIndex];
                    rightIndex+=1;
                }

            }
            
        }
        return mergedArray;
    }

    public static void main(String[] args) {

        int[] testL = {1,2,5,6,9};
        int[] testR = {0,3,7,8,9};
        int[] test = merge(testL, testR);
       
        
        System.out.println();
        for(int num: test){
            System.out.print(num +", ");
        }
    }
}
