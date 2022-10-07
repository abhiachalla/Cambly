import java.util.*;

public class CamblyAbhi {

  /*
  Sorts a map in descending order of its values.

  @param unsortedMap should be sorted based on its values
  @return sortedMap sorted based on its values
  */
  public static Map<String, Integer> sortMapByValue(Map<String, Integer> unsortedMap)
  {
    // Create a list from elements of HashMap
    List<Map.Entry<String, Integer> > mapList = new LinkedList<>(unsortedMap.entrySet());

    // Sort the list using a lambda anonymous function
    mapList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

    // Enter the key-value pairs into the new map in a sorted manner.
    Map<String, Integer> sortedMap = new LinkedHashMap<>();

    for (Map.Entry<String, Integer> mapEntry : mapList) {
      sortedMap.put(mapEntry.getKey(), mapEntry.getValue());
    }
    return sortedMap;
  }



  public static void main(String[] args) {

    String input = "From the moment the first immigrants arrived on these shores, generations of parents have worked hard and sacrificed whatever is necessary so that their children could have the same chances they had; or the chances they never had. Because while we could never ensure that our children would be rich or successful; while we could never be positive that they would do better than their parents, America is about making it possible to give them the chance. To give every child the opportunity to try. Education is still the foundation of this opportunity. And the most basic building block that holds that foundation together is still reading. At the dawn of the 21st century, in a world where knowledge truly is power and literacy is the skill that unlocks the gates of opportunity and success, we all have a responsibility as parents and librarians, educators and citizens, to instill in our children a love of reading so that we can give them the chance to fulfill their dreams.";

    String[] inputArr = input.split(" ");

    //Using a TreeMap in order to preserve the alphabetical order of the keys so that entries with same frequency will be aplhabetically sorted
    Map<String, Integer> unsortedValuesMap = new TreeMap<>();

    for(String s1: inputArr) {
      s1 = s1.toLowerCase();
      //checking if there are any non-alphabetic characters such as punctuations in the last character of each word and removing them.
      if(!Character.isLetter(s1.charAt(s1.length()-1))) {
        s1 = s1.substring(0,s1.length()-1);
      }
      unsortedValuesMap.put(s1,unsortedValuesMap.getOrDefault(s1,0)+1);
    }

    //Sort the map based on the values which represent the occurences
    Map<String, Integer> result = sortMapByValue(unsortedValuesMap);

    for(Map.Entry<String, Integer> e: result.entrySet()) {
      System.out.println(e.getKey() + ": " + e.getValue());
    }
  }
}
