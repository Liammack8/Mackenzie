import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        
        /**creates array list and populates with data from words.txt*/
        ArrayList<String> words = readWords("res/words.txt"); //step 4

        /**Step 5 creates a hashmap storing the word and word count*/
        HashMap<String, Integer> wordCounter = buildHashMap(words);

        /**Step 6 creates html file words.html displaying word and word count columns */
        createHTMLFile(wordCounter, "res/words.html");
        
        /**Step 9 creates and populates array list of WordFrequency objects*/
        ArrayList<WordFrequency> wordFrequencyList = new ArrayList<>();
        for(Entry<String, Integer> data : wordCounter.entrySet())
        {
           String word = data.getKey();
           Integer frequency = data.getValue();
           WordFrequency wordFrequency = new WordFrequency(word, frequency);
           wordFrequencyList.add(wordFrequency);
        }
        /**Sorts contents of the wordFrequencyList in ascending wordCount order*/
        Collections.sort(wordFrequencyList);

        for(WordFrequency wordFrequency : wordFrequencyList)
        {
            System.out.println(wordFrequency);
        }

        /**Step 10 calls function creating html output file with word and word count columns sorted in ascending order*/
        sortedHTMLFile(wordFrequencyList);
        
        /**Step 14 stores contents of paragraph.txt in array list*/
        ArrayList<String> paragraphList = organizeParagraph("res/paragraph.txt");

        /**Step 15 creates a hashmap and stores the number of occurences of each word in paragraphList*/
        HashMap<String, Integer> paragraphMap = buildHashMap(paragraphList);
        
        System.out.println(paragraphList); 
        System.out.println(paragraphMap);

        /**Step 16 creates output html file consisting of word and word count columns*/
        createHTMLFile(paragraphMap, "res/paragraph.html");

        /**Step 18 creates and populates an array list of ParagraphFrequency objects*/
        ArrayList<ParagraphFrequency> ParagraphFrequencyList = new ArrayList<>();
        for(Entry<String, Integer> data : (paragraphMap).entrySet())
        {
           String word = data.getKey();
           Integer frequency = data.getValue();
           ParagraphFrequency listValues = new ParagraphFrequency(word, frequency);
           ParagraphFrequencyList.add(listValues);
        }
        System.out.println(ParagraphFrequencyList);
        
        /**Step 19 sorts contents of the array list in increasing order of the word count + creates
            HTML output file of sorted words*/
        Collections.sort(ParagraphFrequencyList);
        sortedParagraphHTMLFile(ParagraphFrequencyList);
        
    }

    
    private static void sortedParagraphHTMLFile(ArrayList<ParagraphFrequency> sortedList) {
        File file = new File("res/sortedParagraphWords.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            
            builder.append("<h1>Word Count<h1>");
            builder.append( "<table border = \"2\">");

            for(ParagraphFrequency value: sortedList)
            {
                builder.append("<tr>");
                builder.append("<td>" + value.getWord() + "</td>");
                builder.append("<td>" + value.getCount() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    

     /**Step 4 reads the contents of a text file, separates it into words (removing all blanks and
        punctuation), and store the words in an ArrayList */
    private static ArrayList<String> readWords(String fileName) { 
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try{
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null)
            {
                String[] words = line.split("[ .,]+");
                for (String word: words)
                {
                    if(word.trim().length() > 0) {
                        wordList.add(word.toLowerCase());
                    }
                }
                line=bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    /** Creates a hashmap to store count of word occurences*/
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words)
    {
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for(String word: words) {
            Integer count = wordCounter.get(word);
            if(count == null)
            {
                wordCounter.put(word, 1);
            }
            else
            {
                wordCounter.put(word, count +1);
            }
        }
        return wordCounter;
    }

    /** Create output file containing word and word count columns */
    private static void createHTMLFile(HashMap<String, Integer> wordCounter, String fileName) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count<h1>");

            builder.append( "<table border = \"2\">");
            for(String key: wordCounter.keySet())
            {
                builder.append("<tr>");
                builder.append("<td>" + key + "</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String keyWord: wordCounter.keySet()) {
            System.out.println(keyWord + ": " + wordCounter.get(keyWord));
        }
    }

    /**Step 10 function creates html output file displaying word and word count columns sorted in ascending order*/
    private static void sortedHTMLFile(ArrayList<WordFrequency> sortedList) {
        File file = new File("res/sortedWords.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            
            builder.append("<h1>Word Count<h1>");
            builder.append( "<table border = \"2\">");

            for(WordFrequency value: sortedList)
            {
                builder.append("<tr>");
                builder.append("<td>" + value.getWord() + "</td>");
                builder.append("<td>" + value.getCount() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            fileWriter.append(builder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**Populates array list with file data removing all spaces and punctuation*/
    private static ArrayList<String> organizeParagraph(String fileName) { 
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try{
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null)
            {
                String[] words = line.split("[ .,-]+");
                for (String word: words)
                {
                    if(word.trim().length() > 0) {
                        wordList.add(word.toLowerCase());
                    }
                }
                line=bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
