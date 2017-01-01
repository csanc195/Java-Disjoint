/********************************************************************* 
 * 										SUMARY:
	The following program contains the method"disjoint" this method works with
lists of comparable items. The method "disjoint" determines if two given lists have common elements and 
outputs true or false if they are disjoint or not disjoint respectively.

	In this case the algorithm uses the fact that both lists are sorted and that the elements in 
them are comparable to its advantage.
	This algorithm uses a pair of iterators that point to the elements of the first and second list 
respectively and iterates through them verifying when is it that an element of the first list is in list 2, 
when that happens the algorithm returns false, if such event never happens it returns true instead.
	Here follows a brief summary of the method's implementation as well as some explanation about their
run time complexity:

 *DISJOINT*:
	This algorithm uses two iterators, a and b to traverse the two lists, a is the iterator for list1 
and b is the iterator for list 2. The algorithm checks that there are no common elements between list1
and list2. Since both lists are ordered the algorithm first checks if the current element from list1 
is greater than the current element on list2, if it is, it then advances the Iterator on the second list,
as it is not clear at this point if the element 1 is present on list2; in that case the algorithm continues
to traverse list2 by advancing its Iterator to the next element.
 	In the other hand if the current element on list1 is smaller than the current element on list2, then
the iterator of list1 is advanced since its obvious that element wont be found in list2 since both lists 
are ordered, as its understood and easy to prove that if x<y, then x<y+1, x<y+2 etc. 
	The last possibility checked is to verify if the current element of list1 is equal to the current 
element on list2, if they are equal the algorithm then returns false since they are not disjoint as they 
share at least that element. 
	This procedure continues until either the Iterator to list 1 or the Iterator to list 2 become null (in
which case the algorithm will return true since the end of one of the lists was fount without finding a common
element), or if one common element is found which will return false and conclude.. 
	This algorithm's running time complexity is linear, O(n+m) as it only has to go trough both lists 
simultaneously only once to solve the problem, in the worst case scenario, the algorithm has to go through both
lists until the end by traversing through one first, then the other, consider the following scenario:

		List1 = {15, 17, 19}; List2 = {2,4,6,7,8,9,10,11,12,13,14,21}

		The iterators be updated as follows:
			a = {15  15  15   15   15   15   15   15   15   15   15   15  17  19 null}
			b = {2    4   6    7    8   9    10   11   12   13   14   21  21  21}

	After the a is assigned null the loop is no longer executed and the program returns true.
This typical case caused both lists to be traversed in succession. In cases like this the complexity of 
the algorithm is O(N+M), with N and M being the number of elements on the lists one and two respectively.



Author’s Panther ID: <5446178>
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
 ********************************************************************/
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
