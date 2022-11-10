package Section14Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTutorial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Braveheart");
		names.add("Aladin");
		names.add("Ironman");
		names.add("Aquaman");
		
		int count = 0;
		for(int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		
		System.out.println(count);
		
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		String s1 = "";
		long d = Stream.of("Abba", "Marco", "Luffy", "Aodai", "Akaido", "King").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();

		System.out.println(d);
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

		Stream.of("Abba", "Marco", "Luffya", "Aodai", "Akaidoa", "King").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream.of("Azbba", "Marco", "Luffya", "Aodai", "Akaidoa", "King").sorted().forEach(s->System.out.println(s));
		
		List<String> names2 = Arrays.asList("Azbba", "Marco", "Luffya", "Aodai", "Akaidoa", "King");
		names2.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}

}
