import java.math.BigDecimal;
import java.util.*;
public class LearnCompare {
	
	public static class Item implements Comparable<Item> {

		private int number;
		private String description;

		public Item(int num, String descript){
		    this.number = num;
		    this.description = descript;
		}

		public int getNumber(){
		    return number;
		}

		public String getDescription(){
		    return description;
		}

		@Override public int compareTo(Item i){
		//    Item i = (Item) o;
		   // if(this.getNumber() > i.getNumber())
		   //     return -1;

		 //   if(this.getNumber() < i.getNumber())
		//        return 1;

		  //  return 0;
			//i.getNumber()-this.getNumber() - decreasing order
			//this.getNumber()- i.getNumber()  -- Increasing order
			return  this.getNumber()-i.getNumber();//x-y ->asc ;y-x->desc
		}

	}
	
	/*
	 * Another way to sort compare if we can't use class implements
	 * 
	 *  // Sort, ignoring case during sorting 
        Arrays.sort(tempArray, new Comparator<Character>(){ 
  
            @Override
            public int compare(Character c1, Character c2) 
            { 
                // ignoring case 
                return Character.compare(Character.toLowerCase(c1), 
                                        Character.toLowerCase(c2)); 
            } 
        }); 
	 */
	
	/*
	 * List<List<Integer>> matchedPostions = asList(asList(1, 198, 200), asList(2, 50, 61));
	Collections.sort(matchedPostions, new Comparator<List<Integer>>() {
	    @Override
	    public int compare(List<Integer> o1, List<Integer> o2) {
	        // Sort the lists using the starting position (second element in the list)
	        return o1.get(1).compareTo(o2.get(1));
	    }
	});

	System.out.println(matchedPostions);
	// [[2, 50, 61], [1, 198, 200]]
	 */

	
	/*
	 *  Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval i,Interval j){
                return i.start-j.start;
            }
        });
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item[] items = new Item[3];
	    items[0] = new Item(102, "Duct Tape");
	    items[1] = new Item(103, "Bailing wire");
	    items[2] = new Item(101, "Chewing Gum");

	    Arrays.sort(items);

	    for (Item i : items){
	        System.out.println(i.getNumber() + ": " + i.getDescription());
	    }

	}

}
