package Test.Test;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class FinallyTest {

	@Test
	public void test() {
		
		String[] a = {"Angu","Ganesh",null};
		List<String> list = Arrays.asList(a);
		
		for(String eachString : list) {
			try {
				System.out.println(eachString.length());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} finally {
				System.out.println("It is Finally Block");
			}
		}
		
		
	}
	 
}
