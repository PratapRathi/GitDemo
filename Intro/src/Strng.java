
public class Strng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = new String("Pratap Anjali Rathi");
		String[] A = s.split(" ");
		System.out.println(A[0]);
		System.out.println(s.length());
		for (int v=s.length()-1; v>=0; v--)
		{
			System.out.print(s.charAt(v)); 
		}

	}

}
