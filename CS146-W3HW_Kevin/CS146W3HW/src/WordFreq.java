import java.util.ArrayList;

/**
 * WordFreq stores a phrase and its frequency. 
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
     * Set the phrase to 
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

    public static void maxHeap(ArrayList<WordFreq> list, int i){
        int largest;
        int leftNode = 2*i+1; // left child node index
        int rightNode = 2*i+2; // right child node index
        if(leftNode<= list.size() && list.get(leftNode).getFrequency() > list.get(i).getFrequency()){
            largest = leftNode;
        }
        else{
            largest = i;
        }
        if(rightNode <= list.size() && list.get(rightNode).getFrequency() > list.get(largest).getFrequency()){
            largest = rightNode;
        }
        System.out.println(list.get(largest).toString());

    }
    /**
     * Builds a max heap from array list of wordfreq objects
     * @param list Array List of wordfreq objects
     */
    public static void buildMaxHeap(ArrayList<WordFreq> list){


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
        ArrayList<WordFreq> list = new ArrayList<>();
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
        //test max heap method
        maxHeap(list, 0);
        System.out.println("Largest should be \"happy, 400\" at index 0");
        maxHeap(list, 1);
        System.out.println("Largest should be \"would buy again, 200\" at index 1");
        maxHeap(list, 3);
        System.out.println("Largest should be \"would recommend to friends, 800\" at index 3");
        maxHeap(list, 6);
        System.out.println("Largest should be \"difficult to use, 100\" at index 6");
    }

}
