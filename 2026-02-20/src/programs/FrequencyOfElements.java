package stream_api_programs;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyOfElements
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
		
		Map<Integer, Long> res = findFrequency(arr, n);
		
		System.out.println("Frequency of elements:");
		for(Map.Entry<Integer, Long> entry : res.entrySet())
		{
			System.out.println(entry.getKey() + ": " + entry.getValue() + " times(s)");
		}
		
		sc.close();
	}
	
	public static Map<Integer, Long> findFrequency(int arr[], int n)
	{
		return Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(
						e -> e,
						Collectors.counting()
				));
	}
}