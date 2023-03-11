/**Step 17 ParagraphFrequency class represents a word and its word count*/
public class ParagraphFrequency implements Comparable<ParagraphFrequency>{
    private String word;
    private Integer count;

    /**constructor*/
    public ParagraphFrequency(String word, Integer wordCount)
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

    /**Count setter*/
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

    /**Compares 2 words and returns the countValue determining the order*/
    @Override
    public int compareTo(ParagraphFrequency nextWord) {
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
