
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Problem1a {
	

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4);
		List<Integer> list2 =Arrays.asList(5,6,7);
		
		List<Integer> list3 = Arrays.asList(1,2,3,4);
		List<Integer> list4 =Arrays.asList(4,5,6,7);
		
		
		System.out.println("Lists are disjoint? "+ disjoint(list1, list2));
		System.out.println("Lists are disjoint? "+ disjoint(list3, list4));
		
	}
	
	/**
	 * This method takes two lists of comparable elements as parameters and determines if there are
	 * common elements between them.
	 * 
	 * @param L1
	 * @param L2
	 * @return <b>true</b> if there are no common elements between them, or <b>false</b> if there are.
	 * 		   Cases when one of the lists is <b>null</b> or one of the lists is empty return true.
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	boolean disjoint(List<AnyType> L1, List<AnyType> L2){

		if(L1 == (null) || L2 == (null) || L1.isEmpty() || L2.isEmpty()){
			return true;// if either list is null or empty, by deff of sets they are disjoint.
		}
		else{
			Iterator<AnyType> it1 =L1.listIterator();
			Iterator<AnyType> it2 =L2.listIterator();

			AnyType a = it1.next();
			AnyType b = it2.next();

			while(a!=null && b!=null){
				int compare= a.compareTo(b);
				if(compare>0)//if elem in list 1 is greater than elem in list 2, advance iterator 2.
					b =(it2.hasNext())? it2.next() : null;

					else if(compare<0)//if elem in list 1 is smaller than elem in list 2, advance iterator 1.
						a=(it1.hasNext()) ? it1.next() : null;

						else if(compare==0){// if elem are equal, return false, disjoint by the deff of disjoint sets.
							return false;
						}
			}
			return true;//return true as no common elements were found.
		}
	}
}
