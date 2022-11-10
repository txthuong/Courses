package Section14Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamTutorial3 {

	
	@Test
	public void streamMap()
	{
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Adamma");
		names1.add("Ronaldo");
		names1.add("Messi");
		names1.add("Alahuhuhu");
		
		List<String> names = Arrays.asList("Abba", "Marco", "Luffy", "Aodai", "Akaido", "King");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.forEach(s->System.out.println(s));
	}
}
