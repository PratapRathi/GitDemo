import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Javabrushup {

	public static void main(String[] args) {
		
		System.out.println("Pratap Rathi");
		// Array
				int[] Arr = new int[5];
				Arr[0] = 4;
				Arr[1] = 14;
				Arr[2] = 9;
				Arr[3] = 8;
				Arr[4] = 5;
				System.out.println(Arr[3]);
				System.out.println("**********");
				//System.out.println(Arr[3]);
		int[] Arr2 = {2,5,6,3,8};
		//System.out.println(Arr2[3]);
		// Loop
		//for(int i=0; i<Arr.length; i++)
		//{System.out.println(Arr[i]);}
		
		//String[] we = {"pratap","anjali","rathi"};
		//for(int i=0; i<we.length; i++)
		//{System.out.println(we[i]);}
		
		//for (String n:we)
		//{System.out.println(n);}
				
		for (int v=0; v<Arr.length; v++)
		{	
		if (Arr [v]%2==0)
			{System.out.println(Arr[v]);
			break; }
		else 
			{ System.out.println(Arr[v]);  
					}}
		System.out.println("Arraylist");
		
		//Arraylist
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Pratap");
		list.add("Anjali");
		list.add("5");
		list.remove(2);
		for (int r=0; r<list.size(); r++)
		{System.out.println(list.get(r));}
		for(String val: list)
		{
			System.out.println(val);
		}
		
		System.out.println(list.contains("Pratap"));
		//It must be an array but this is an arraylist
		
		String[] F = {"Pratap","Anjali","Rathi"};
		List<String>newlist = Arrays.asList(F);
		System.out.println(Arr2);
				
		
	}

}
