package lambdaTest;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class LambdaTest {
	
	
	public static void main(String[] args){
	    List<String> languages = (List<String>) Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
	 
	    System.out.println("Languages which starts with J :");
	    filter(languages, (str)-> ((String) str).startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)-> ((String) str).endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
	 
	    System.out.println("Print language whose length greater than 4:");
	    filter(languages, (str)->((String) str).length() > 4);
	
	    List<Integer> prices = Arrays.asList(100,110,120,130,140);
	    addOn(prices);
	
	}
	
	
	public static void addOn(List<Integer> names) {
		System.out.println("Total : " +names.stream().map((name)-> name + .1*name).reduce((sum, name)-> sum += name).get());	//get() to cancel optional[660.0]
	}
	
	
	public static <T> void filter(List<T> names, Predicate<T> condition) {
		names.stream().filter((name)->(condition.test(name))).forEach((name) -> System.out.println(name));
	}
}
