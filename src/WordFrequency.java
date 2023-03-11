/** WordFrequency class represents a word and its word count*/

public class WordFrequency implements Comparable<WordFrequency>{
    private String word;
    private Integer count;

    /**Contructor*/
    public WordFrequency(String word, Integer wordCount)
    {
        this.word = word;
        this.count = wordCount;
    }

    /**Word getter*/
    public String getWord()
    {
        return word;
    }

    /**Count getter*/
    public Integer getCount()
    {
        return count;
    }
    /**Word setter*/
    public void setWord(String setWord)
    {
        this.word = setWord;
    } 
    /**Count setter */
    public void setCount(Integer setCount)
    {
        this.count = setCount;
    } 
    
    /**Converts word and count into a string*/
    @Override
    public String toString()
    {
        return word + ": " + count;
    }

    /**Compares count of two words and returns the countValue representing the order*/
    @Override
    public int compareTo(WordFrequency nextWord) {
         int countValue = 2;
        
        if(this.count > nextWord.count)
            countValue = 1;
        if(this.count < nextWord.count)
            countValue = -1;
        if(this.count == nextWord.count)
            countValue = 0;
        
        return countValue;
    }
}