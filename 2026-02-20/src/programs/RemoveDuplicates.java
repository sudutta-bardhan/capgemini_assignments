package stream_api_programs;

import java.util.*;

public class RemoveDuplicates
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
		
		int res[] = removeDupes(arr, n);
		System.out.println("After removing duplicates: ");
		for(int i = 0; i < res.length; i++)
		{
			System.out.print(res[i] + " ");
		}
		
		sc.close();
	}
	
	public static int[] removeDupes(int arr[], int n)
	{
		return Arrays.stream(arr)
				.distinct()
				.toArray();
	}
}