import java.util.ArrayList;
/**
 * WordFreq stores a phrase and its frequency. Builds a max heap of an arraylist of WordFreq.
 * @author Kevin Thai 
 */
public class WordFreq {
     String word;
     int frequency;
    /**
     * Constructs the WordFreq object save the phrase and frequency of the phrase.
     * @param word the phrase
     * @param frequency the frequency amount of the phrase 
     */
    public WordFreq(String word, int frequency) {
        this.frequency = frequency;
        this.word = word;
    }
    /**
     * Gets the phrase
     * @return Return phrase
     */
    public String getWord() {
        return word;
    }
    /**
     * Set the new phrase to word
     * @param word The phrase
     */
    public void setWord(String word) {
            this.word = word;
        }
        /**
         * Gets the frequency of the phrase
         * @return frequency amount of the phrase
         */
    public int getFrequency() {
        return frequency;
    }
    /**
     * Set the frequency to object
     * @param frequency frequency amount of the phrase
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Compare frequency of parent node to left and right child node 
     * and swap parent node with child if the child node have the largest frequency. 
     * If there is a swap run max heap again on the that child node
     * @param list list of WordFreq onjects
     * @param i the parent node index
     */
    public static void maxHeap(ArrayList<WordFreq> list, int i){
        WordFreq temp;// Placeholder for swap
        int largest;// Index of largest frequency node
        int leftNode = 2*i+1; // left child node index
        int rightNode = 2*i+2; // right child node index
        if(leftNode< list.size() && list.get(leftNode).getFrequency() > list.get(i).getFrequency()){
            largest = leftNode;
        }
        else{
            largest = i;
        }

        if(rightNode < list.size() && list.get(rightNode).getFrequency() > list.get(largest).getFrequency()){
            largest = rightNode;
        }

        if(largest != i){// Swap parent node with child node if child is larger
            temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            maxHeap(list, largest);// Run max heap on child node
        }
        
    }
    /**
     * Builds a max heap from array list of wordfreq objects
     * @param list Array List of wordfreq objects
     */
    public static void buildMaxHeap(ArrayList<WordFreq> list){
        int sIndex = (list.size()+1)/2-1; //Starting at index before first leaf node
        for(int i = sIndex; i >= 0;--i ){//Run max heap from non leaf node to root node
            maxHeap(list, i);
        }
    }
    /**
     * Return a string of the word and the frequency;
     * @Return the word and frequency of WordFreq
     */
    @Override
    public String toString(){
        return word +", " +frequency;
    }
    public static void main(String[] args) {

        ArrayList<WordFreq> list = new ArrayList<>();//ArrayList of WordFreq objects
        WordFreq phrase = new WordFreq("happy", 400);
        list.add(phrase);
        list.add(new WordFreq("satisfied",100));
        list.add(new WordFreq("neutral",300));
        list.add(new WordFreq("would buy again", 200));
        list.add(new WordFreq("terrible", 160));
        list.add(new WordFreq("inconvenient",900));
        list.add(new WordFreq("difficult to use", 100));
        list.add(new WordFreq("easy to use", 140));
        list.add(new WordFreq("would recommend to friends", 800));
        list.add(new WordFreq("visit the store", 700));

        for(WordFreq wf: list){
            System.out.println(wf.toString());
        }
       
        buildMaxHeap(list);
        System.out.println();
        System.out.println("After MaxHeap");
         for(WordFreq wf: list){
            System.out.println(wf.toString());
        }
    }

}
