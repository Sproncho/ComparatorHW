package telran.arrays.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.arrays.tools.ArrayTools;

class ArraysTest {
	Integer[] arrNum;
	String[] arrStr;

	@BeforeEach
	public void setUp() throws Exception {
		arrNum = new Integer[] { 9, 7, 4, 7, 2, 5, 9, 1, 0 };
		arrStr = new String[] { "one", "two", "three", "four", "five" };
	}

	@Test
	void testPrintArray() {
		System.out.println("Test printArray");
		ArrayTools.printArray(arrNum);
		ArrayTools.printArray(arrStr);
	}

	@Test
	void testFindFirst() {
		System.out.println("Test findFirst");
		Integer res = ArrayTools.findFirst(arrNum, n -> n % 2 == 0);
		System.out.println(res);
		String str = ArrayTools.findFirst(arrStr, s -> s.length() == 4);
		System.out.println(str);
	}

	@Test
	void testBubbleSortInteger() {
		System.out.println("Test BubbleSortInteger");
		ArrayTools.bubbleSort(arrNum);
		ArrayTools.printArray(arrNum);
	}

	@Test
	void testBubbleSortString() {
		System.out.println("Test BubbleSortString");
		ArrayTools.bubbleSort(arrStr);
		ArrayTools.printArray(arrStr);
	}

	@Test
	void testBubbleSortStringComparator() {
		System.out.println("Test BubbleSortString Comparator");
		ArrayTools.bubbleSort(arrStr, (s1, s2) -> s1.length() - s2.length());
		ArrayTools.printArray(arrStr);
	}
	@Test
	void testBubbleSortIntComparator() {
		Integer[] origin = {1,2,3,4,5,6,7,8,9,3};
		Integer[] expected = {2,4,6,8,9,7,5,3,3,1};
		ArrayTools.bubbleSort(origin, (s1, s2) -> {
			if(s1 == s2)
				return 0;
			if(s1 % 2 == 0 && s2 % 2 == 1)
				return -1;
			else if(s1 % 2 == 1 && s2 % 2 == 0)
				return 1;
			else if(s1 % 2 == 0 && s2 % 2 == 0)
				return s1 - s2;
			else
				return s2 - s1;

		});
		ArrayTools.printArray(origin);
		assertArrayEquals(expected,origin);
	}
}
