# Java-Disjoint

<h3>SUMARY:</h3>
The following program contains the method"disjoint" this method works with lists of comparable items. The method "disjoint" determines if two given lists have common elements and outputs true or false if they are disjoint or not disjoint respectively.
In this case the algorithm uses the fact that both lists are sorted and that the elements in 
them are comparable to its advantage.
This algorithm uses a pair of iterators that point to the elements of the first and second list 
respectively and iterates through them verifying when is it that an element of the first list is in list 2, when that happens the algorithm returns false, if such event never happens it returns true instead.
Here follows a brief summary of the method's implementation as well as some explanation about their run time complexity:
<h4>DISJOINT:</h4>
This algorithm uses two iterators, a and b to traverse the two lists, a is the iterator for list1 
and b is the iterator for list 2. The algorithm checks that there are no common elements between list1 and list2. Since both lists are ordered the algorithm first checks if the current element from list1 is greater than the current element on list2, if it is, it then advances the Iterator on the second list, as it is not clear at this point if the element 1 is present on list2; in that case the algorithm continues to traverse list2 by advancing its Iterator to the next element.
In the other hand if the current element on list1 is smaller than the current element on list2, then the iterator of list1 is advanced since its obvious that element wont be found in list2 since both lists are ordered, as its understood and easy to prove that if: <br>x<y, then x < y+1, x<y+2 etc.<br> 
The last possibility checked is to verify if the current element of list1 is equal to the current 
element on list2, if they are equal the algorithm then returns false since they are not disjoint as they share at least that element. 
This procedure continues until either the Iterator to list 1 or the Iterator to list 2 become null (in
which case the algorithm will return true since the end of one of the lists was fount without finding a common element), or if one common element is found which will return false and conclude.
This algorithm running time complexity is linear, O(n+m) as it only has to go trough both lists 
simultaneously only once to solve the problem, in the worst case scenario, the algorithm has to go through both lists until the end by traversing through one first, then the other, consider the following scenario:
</p>
<br>
<b>List1 = {15,17,19}</b><br>
<b>List2 = {2,4,6,7,8,9,10,11,12,13,14,21}</b><br>

The iterators be updated as follows:<br>

<br><b>a = {15  15  15   15   15   15   15   15   15   15   15   15  17  19 null}</b><br>
<br><b>b = {2    4   6    7    8   9    10   11   12   13   14   21  21  21}</b><br>

After the a is assigned null the loop is no longer executed and the program returns true. This typical case caused both lists to be traversed in succession. In cases like this the complexity of the algorithm is <b>O(N+M)</b>, with N and M being the number of elements on the lists one and two respectively.

