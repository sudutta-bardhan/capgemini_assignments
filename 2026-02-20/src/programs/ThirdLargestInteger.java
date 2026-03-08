package programs;

import java.util.*;

public class ThirdLargestInteger
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Size of the array: ");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Array Elements: ");
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int tmax = thirdLargest(arr, n);
		System.out.println("Third Largest Element in the Array: " + tmax);
		
		sc.close();
	}
	
	public static int thirdLargest(int arr[], int n)
	{
		return Arrays.stream(arr)
				.distinct()
				.boxed()
				.sorted(Collections.reverseOrder())
				.skip(2)
				.findFirst()
				.orElse(-1);
	}
}