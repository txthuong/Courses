package Section14Streams;

import java.util.ArrayList;

import org.testng.annotations.Test;


public class StreamsTutorial {

	@Test
	public void regular() {
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

	}
	
	@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Braveheart");
		names.add("Aladin");
		names.add("Ironman");
		names.add("Aquaman");	
	}

}
