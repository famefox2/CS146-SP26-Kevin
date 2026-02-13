/**
 * WordFreq stores a phrase and its frequency
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
    public static void main(String[] args) {
        
            System.out.println("");
        }

}
