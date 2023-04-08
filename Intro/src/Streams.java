import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		names.add("Pratap");
		names.add("Anjali");
		names.add("Avisha");
		names.add("Manish");
		names.add("Amisha");
		int count = 0;
		for(int i=0; i<names.size(); i++)
		{
			String actual= names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}}
		System.out.println(count);
		streamfilter();
		streamMap();
		streamCollector();
		}
	public static void streamfilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Pratap");
		names.add("Anjali");
		names.add("Avisha");
		names.add("Manish");
		names.add("Amisha");
		Long c= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Total = "+c);
		
		Long d= Stream.of("Pratap","Anjali","Avisha","Manish","Amisha").filter(s->
		{s.startsWith("A");
		 return true;
		}).count();
		System.out.println("Second total = "+d);
		
		//names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(2).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		}
	public static void streamMap()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Pratap");
		names.add("Anjali");
		names.add("Avisha");
		names.add("Manish");
		names.add("Amisha");
		List<String> names1= Arrays.asList("Rathi","Taliyan","Goyat","Malik");
		//Change case
		Stream.of("Rathi","Taliyan","Goyat","Malik").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//change case and sorting
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Merging 2 List
		Stream<String> newStream= Stream.concat(names.stream(), names1.stream());
		// Search an String inside a List but return type is boolean.
		boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("Rathi"));
		System.out.println(flag);
		
	}
	public static void streamCollector()
	{
		// Converting Stream into List
		List<String> ls= Stream.of("Pratap","Anjali","Avisha").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		//Print unique number
		List<Integer> values= Arrays.asList(2,3,2,7,5,6,7,4);
		values.stream().distinct().sorted().forEach(s->System.out.print(s+","));
		int i= values.stream().distinct().sorted().collect(Collectors.toList()).get(2);
		System.out.println(i);
		
	}
}

