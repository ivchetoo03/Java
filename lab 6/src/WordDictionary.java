import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class WordDictionary{

    private HashMap<String, String> wordMap;

    public WordDictionary(){
        wordMap = new HashMap<>();
    }
    
    public void addWord(String wordsLine){
        String[] words = wordsLine.split(" - ");
        wordMap.put(words[0], words[1]);
    }

    public void addWordList(String wordsLines){
        String[] wordsLinesArr = wordsLines.split("\n");
        String[] words;
        for (String wordLine : wordsLinesArr) {
            words = wordLine.split(" - ");
            wordMap.put(words[0], words[1]);
        }
    }
    
    public String removeWord(String word){
        return wordMap.remove(word);
    }

    public void removeWordList(String wordsToRemove){
        String[] wordsToRemoveList = wordsToRemove.split(" ");
        for (String wordToRemove : wordsToRemoveList) {
            if(wordMap.remove(wordToRemove) == null){
                System.out.println("Слово '" + wordToRemove + "' вже не існує");
            }
        }
    }

    public void translate(String keyWord){
        String translation = wordMap.get(keyWord);
        if(translation == null){
            System.out.println("Слово відсутнє або для нього відсутній переклад");
        }
        else{
            System.out.println("Переклад - " + wordMap.get(keyWord));
        }
    }

    public void list(){
        
        Set<Entry<String, String>> words = wordMap.entrySet();
        
        System.out.println("\nВміст словника:");
        for (Entry<String, String> entry : words) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
