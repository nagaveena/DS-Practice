/*
 * Sample Input:
*text = “you are very very smart”
*words = [“you”, “are”, “very”, “handsome”]

Sample Output:
[
[0],
[4],
[8, 13],
[-1]
]
 * 
 */

import java.util.*;
public class IndicesOfWordInText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<ArrayList<Integer>> find_words(String text, List<String> words) {
        ArrayList<ArrayList<Integer>> result =  new ArrayList<>();
        Map<String, List<Integer>> m = getMap(text);
        for (String word : words) {
            ArrayList<Integer> list = new ArrayList<>();
            if (m.containsKey(word)) {
                list.addAll(m.get(word));
            } else {
                list.add(-1);
            }
            result.add(list);
        }
        return result;
    }

    static Map<String, List<Integer>> getMap(String text) {
        Map<String, List<Integer>> m = new HashMap<>();
        int st = 0;
        for (int i = 1; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                String word = text.substring(st, i);
                List<Integer> list = m.get(word);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(st);
                m.put(text.substring(st, i), list);
                st = i + 1;
            }
        }
        return m;
    }
}

