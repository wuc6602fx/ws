package apjp2017.hw4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class HW41 {

	/**
	 * Given an int stream strm, find the sum of all squares of stream elements
	 * which pass the input predicate p. So for example, if strm is (1, -2, 3, 4)
	 * and p is (x) -> x > 0. then the return value is 1^2 + 3^2 + 4^2 = 26.
	 * 
	 * @param stream
	 *            the input stream
	 * @param p
	 *            the predicate to test
	 * @return
	 */
	public static long sumOfSquareOfIntsPassingTest(IntStream strm, IntPredicate p) {
		// PUT YOUR CODE HERE!
		return strm.filter(p).map(x -> x*x).asLongStream().sum();
	}

	/**
	 * Given a stream of Date objects, Group all stream elements by their week day.
	 * The result is a map of type Map<String,Set&lt;Date>>, where the keys are
	 * "SUN", "MON", ..., and "SAT" and the value for each key is the set of all
	 * date elements whose key is its week day.
	 * 
	 * <div style='color:blue'> NOTES:<br/>
	 * 1. use Stream.collect(Collectors.groupingBy(...)) to get a map of type
	 * Map&lt;String, List&lt;Date>> <br/>
	 * 2. And then, transform the resulting Map&lt;String, List&lt;Date>> to an
	 * object of type Map&lt;String, Set&lt;Data>> </div>
	 * 
	 * 
	 * 
	 * @param strm
	 *            a stream of Date objects
	 * @return a grouping of stream objects according to their week day.
	 */
	
	public static Map<String, Set<Date>> groupingDatesByWeekDay(Stream<Date> strm) {
		// PUT YOUR CODE HERE!
		strm.collect(Collectors.groupingBy(Date::getDay, Collectors.toSet()));
		Map<Integer, Set<Date>> old = strm.collect(Collectors.groupingBy(Date::getDay, Collectors.toSet()));
		System.out.println("tttttttttttttt"+old.toString());
		
		Map<String, Set<Date>> rlt = old.entrySet().stream().collect(Collectors.toMap(entry -> int2WeekDay(entry.getKey()), Map.Entry::getValue));

		System.out.println("tttttttttttttt"+rlt.toString());
		return rlt;
	}

	/**
	 * A utility function used to map 0..6 to weekDay.
	 * 
	 * @param w
	 * @return
	 */
	static String int2WeekDay(int w) {
		switch (w) {
		case 0:
			return "SUN";
		case 1:
			return "MON";
		case 2:
			return "TUE";
		case 3:
			return "WED";
		case 4:
			return "THU";
		case 5:
			return "FRI";
		case 6:
			return "SAT";
		}
		return "INTERNAL ERROR";
	}

	public static boolean isPrime(Long l) {
		for(Long t = l-1;t>1;t--) {
			if(l%t == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * Return the stream of all prime long numbers in descending order. The type of
	 * the number in the stream is long.
	 * 
	 * @return the stream of all long primes.
	 */
	
	
	public static LongStream primes() {
		// put your code here!
		//List<Long> list = new ArrayList<>();
		LongStream.Builder b = LongStream.builder();
		for (Long l = Long.MAX_VALUE; l >= Long.MIN_VALUE; l--) {
			if(isPrime(l)) {
				//list.add(l);
				b.accept(l);
			}
		}
		return b.build();
	}

	/**
	 * Use ForkJoin framework to parallelize the initialization of a big array ar of
	 * type T[] with an IntFunction f: Int -> T such that the element ar[k] will be
	 * set with the value f(k) for each index k.<br/>
	 * 
	 * <b style='color:blue'>NOTE: YOU NEED ONLY Implement the compute() method of
	 * the locl class Task in this method to accomplish the initialization.</b>
	 * 
	 * @param ar
	 *            an input array of type T[]
	 * @param f
	 *            the initialization function
	 * @param bound
	 *            use ordinal/sequential array initialization if ar.length < bound
	 * @return the input ar array with contents initialized by f.
	 */
	public static <T> T[] initializeArray(final T[] ar, final IntFunction<T> f, final int bound) {

		// NOTE: YOU NEED ONLY Implement the compute() method in this local class
		// to accomplish the initialization.

		@SuppressWarnings("serial")
		class Task extends RecursiveAction {
			int s, e;

			Task(int ar, int ar2) {
				s = ar;
				e = ar2;
			}
			
			public void initialize() {
				for(int i = 0;i<bound;i++) {
					ar[i] = f.apply(i);
				}
			}

			@Override
			protected void compute() {
				
				if (e - s < bound) {
					// PUT YOUR CODE HERE!
					// initialize ar[s..e) directly
					// ...
					initialize();
					
					
				} else {
					// PUT YOUR CODE HERE!
					// create sub tasks,
					// fork and join subtasks
					// ...
					Task t1 = new Task((int)ar[0],(int)ar[(ar.length-1)/2]);
					Task t2 = new Task((int)ar[(ar.length-1)/2 +1],(int)ar[ar.length-1]);
					t2.fork();
					t1.compute();
					t2.join();
					return; 
				}

			}
		}

		// Start the invocation of the main task ( using default ForkJoin common pool).
		new Task(0, ar.length).invoke();
		return ar;

	}

	/**
	 * Given an array ar of integers, find a contiguous subarray which has maximum
	 * sum over other subarrays.
	 * 
	 * For example, if ar is {1,2,3}, then {1,2,3} is the maximum subarray. But if
	 * ar is {���2, 1, ���3, 4, ���1, 2, 1, ���5, 4}, then {4, ���1, 2, 1} is the maximum
	 * sbuarray with sum 6. <br/>
	 * 
	 * The return value is an int[] with contents {start, end, sum }, where 'start'
	 * and 'end' is the start index and end index (inclusive) of the subarray and
	 * 'sum' is the sum of the subarray.
	 * 
	 * <b style='color:blue'>NOTE:You must use Java's ForkJoin framework to provide
	 * a concurrent implementation of this method </b> </b><br/>
	 * 
	 * See <a href="http://www.csie.ntnu.edu.tw/~u91029/MaximumSubarray.html#4">this
	 * page</a> or <a href=
	 * "https://www.tutorialcup.com/array/maximum-subarray-sum-divide-conquer.htm">this
	 * page</a> for sequential divide-and-conquer implementation
	 * 
	 * 
	 * @param ar
	 *            a non empty array of integers
	 * @param bound
	 *            an integer over which the problem must be divided into subtasks.
	 * @return an int[] with content {start_index, end_index, sum}
	 * 
	 */
	public static int[] maxSubarray(final int[] ar, final int bound) {

		/**
		 * The following local class is used to decomposed the problems into sub tasks
		 * which can be forked/invoked using the ForkJoin framework.
		 * 
		 * Each task required to compute the following values about a subarray ar[s, e)
		 * of ar.
		 * <ol>
		 * <li>0. The sum of all array elements ar[s..e).
		 * <li>1. maximum prefix sum of ar[s, prefixEnd] with value sum2 <br/>
		 * => use field 'prefixEnd' and 'sum2' to record these 2 values.
		 * <li>2. maximum suffix sum of ar[suffixStart, e] with value sum3 <br/>
		 * => use field 'suffixStart' and 'sum3' to record these 2 values.
		 * <li>3. maximum subarray sum ar[s,e] <br/>
		 * => use fields 's1', 'e1', 'sum1' to record these 3 values.
		 * <li>As a result, after completion of the task Task(s,e), all the above 8
		 * fields should be set.
		 * 
		 * </ol>
		 * 
		 * @author chencc
		 *
		 */
		@SuppressWarnings("serial")
		class Task extends RecursiveAction {
			private int s; // start_index of the subarry
			private int e; // end_index (exclusive) of the subarray

			Task(int s, int e) {
				this.s = s;
				this.e = e;
			}

			int sum; // = sum of ar[s..e)
			int s1, e1, sum1; // largest subarray is ar[s1,e1] with sum = sum1.
			// largest prefix of subarray is ar[s, prefixEnd] with sum = sum2
			// note: prefixEnd == s-1 means the prefix is empty and sum2 = 0.
			int prefixEnd, sum2;
			// largest suffix subarray is ar[suffixStart,e] with sum = sum3
			// note: prefixEnd == e means the suffix is empty and sum3 = 0.
			int suffixStart, sum3; // largest suffix sum

			void seqCompute() {
				// PUT YOUR CODE HERE!!
				// You should do the following 4 works:
				// 0. sum 1. max subarray, 2. max prefix sum and 3. max suffix sum

				// compute total sum(ar[s]+...+ar[e-1]) (sum).
				// compute largest prefix sum(sum2) and
				// its end position(prefixEnd(inclusive)).

				// compute largest suffix sum(sum3) and
				// its satrt position(suffixStart).

				// compute largest subarray sum (sum1) and
				// its start position(s1) and end positino(e2 (inclusive))
				// note: the subarray cannot be empty!!

			}

			/**
			 * <b stye='color:blue'> This method contains blanks which the students must
			 * provide code!! </b>
			 * 
			 * @return the result of this task.
			 */
			protected void compute() {
				if (e - s < bound) {
					seqCompute();
				} else {
					int m = s + e >> 1;
					Task tsk1 = new Task(s, m);
					tsk1.fork();
					Task tsk2 = new Task(m, e);
					tsk2.compute();
					tsk1.join();

					// PUT YOUR CODE here!!
					// ISSUE: How to set/update sum, s1,e1, prefixEnd, suffixStart; sum1,sum2,sum3;
					// from completed tsk1 and tsk2.
					// ...
					//

				}
			}
		}

		// create the main task.
		Task mainTask = new Task(0, ar.length);

		// start the invocation
		mainTask.invoke();

		// Fetch result from mainTask!
		return new int[] { mainTask.s1, mainTask.e1, mainTask.sum1 };

	}

	public static class HW41Test extends BaseTest {

		public HW41Test() {
			super(false /* no scoring */ );
		}

		public void testSumOfSquareOfIntsPassingTest() {

			try {
				test();
				long out1 = sumOfSquareOfIntsPassingTest(IntStream.rangeClosed(1, 100), e -> true);
				long sol1 = 0;
				for (int k = 0; k <= 100; k++) {
					sol1 += k * k;
				}
				if (sol1 != out1) {
					error("error testsumOfSquareOfIntsPassingTest(). result:%s, expected:%s\n", out1, sol1);
				}
			} catch (Exception e) {
				error("error testsumOfSquareOfIntsPassingTest(). Thrown Exception:%s", e);

			}

			try {
				test();
				long out2 = sumOfSquareOfIntsPassingTest(IntStream.rangeClosed(100, 500), e -> e % 3 == 1);
				long sol2 = 0;
				for (int k = 100; k <= 500; k++) {
					if (k % 3 == 1)
						sol2 += k * k;
				}
				if (sol2 != out2) {
					error("error  2nd testsumOfSquareOfIntsPassingTest(). result:%s, expected:%s\n", out2, sol2);
				}
			} catch (Exception e) {
				error("error 2nd  testsumOfSquareOfIntsPassingTest(). Thrown Exception:%s", e);
			}

		}

		public void testGroupingDates() {

			try {
				test();

				Date d = new Date(117, 11, 30);

				Stream<Date> dates = Stream.iterate(d,
						d2 -> new Date(d2.getYear(), d2.getMonth() + 1, d2.getDate() + 1));

				// System.out.println(dates.collect);
				Map<String, Set<Date>> ans1 = groupingDatesByWeekDay(dates.limit(20));

				Map<String, Set<Date>> sol1 = new LinkedHashMap<>();

				// for (int w = 0; w < 7; w++) {
				// sol1.put(int2WeekDay(w), new TreeSet<Date>());
				// }

				Date cdate = new Date(d.getTime());
				for (int k = 0; k < 20; k++) {
					String key = int2WeekDay(cdate.getDay());
					Set<Date> v = sol1.get(key);
					if (v == null) {
						v = new TreeSet<>();
						sol1.put(key, v);
					}
					v.add(cdate);

					cdate = new Date(cdate.getYear(), cdate.getMonth() + 1, cdate.getDate() + 1);
				}

				System.out.println("\n" + ans1);
				System.out.println(sol1);
				if (!(sol1.equals(ans1))) {
					error("error testGroupingDates()! result:%s, expected: %s", ans1, sol1);
				}

			} catch (Exception e) {
				error("error testGroupingDates(). Thrown Exception:%s", e);

			}

		}

		public void testPrimes() {

			try {
				test();

				long[] ans1 = primes().limit(10).toArray();
				long[] sol1 = new long[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

				// System.out.println(
				// LongStream.of(ar1).boxed().collect(Collectors.<Long>toList()));

				// for(long s : ar1) System.out.print(s + " ");

				if (!(Arrays.equals(ans1, sol1))) {
					error("Fail to pass testPrimes(): your result:%s, expected:%s \n", ans1, sol1);
				}
			} catch (Exception e) {
				error("Fail to complete testPrimes(). Thrown Exceptin: %s", e);
			}

			try {
				test();

				long[] ans2 = primes().skip(1000).limit(10).toArray();
				long[] sol2 = new long[] { 7927, 7933, 7937, 7949, 7951, 7963, 7993, 8009, 8011, 8017 };

				// System.out.println(
				// LongStream.of(ar1).boxed().collect(Collectors.<Long>toList()));

				for (long s : ans2)
					System.out.print(s + " ");

				if (!(Arrays.equals(ans2, sol2))) {
					error("Fail to pass 2nd testPrimes(): your result:%s, expected:%s \n", ans2, sol2);
				}
			} catch (Exception e) {
				error("Fail to complete 2nd testPrimes(). Thrown Exceptin: %s", e);
			}
		}

		public void testArrayInitialization() {
			try {
				test();

				Integer[] ans1 = new Integer[1_0000];

				initializeArray(ans1, t -> t * 7 + 2, 1000);

				for (int k = 0; k < ans1.length; k++) {
					if (ans1[k] == null || ans1[k] != k * 7 + 2) {
						error("error testArrayInitialization() at position %s! result: %s, expected: %s", k,
								ans1[k], k * 7 + 2);
						break;
					}
				}
			} catch (Exception e) {
				error("error testArrayInitialization()! thrown Exception:%s", e);

			}

			try {
				test();

				Integer[] ans1 = new Integer[10_0000];

				initializeArray(ans1, t -> t * t, 1000);

				for (int k = 0; k < ans1.length; k++) {
					if (ans1[k] == null || ans1[k] != k * k) {
						error("error 2nd testArrayInitialization() at position %s! result: %s, expected: %s", k, ans1[k],
								k * k);
						break;
					}
				}
			} catch (Exception e) {
				error("error 2nd testArrayInitialization()! thrown Exception:%s", e);

			}

		}

		private static List<Integer> toList(int[] ar){
			 return 
				 IntStream.of(ar).mapToObj(Integer::new).collect(Collectors.toList()) ;
		}
		
		public void testMaxSubarray() {

			try {
				test();
				int[] sample1 = new int[] { -5, 3, 3, -4, 5, 9, -7, 8, -1, 3, -5, 6, 7, -8 };

				int[] ans1 = maxSubarray(sample1, 5);

				System.out.print("test maxSubArray:");
				System.out.print("input:" + toList(sample1));
				System.out.print("answer:"+ toList(ans1));
				System.out.println("\n====================");

				int[] sol1 = { 1, 12, 27 };

				if (!Arrays.equals(sol1, ans1)) {
					error("error testMaxSubarray! result:%s, expected: %s", toList(ans1), toList(sol1));
				}

			} catch (Exception e) {
				error("error testMaxSubarray! thrown Exception: %s", e);
			}
			
			try {
				test();
				int[] sample2 = new int[] { 3, -4, 5, 9, -7, 8, -1, 3, -5 };

				int[] ans2 = maxSubarray(sample2, 100);

				
				System.out.print("test maxSubArray:");
				System.out.print("input:" + toList(sample2));
				System.out.print("answer:"+ toList(ans2));
				System.out.println("\n====================");

				int[] sol2 = { 2, 7, 17 };

				if (!Arrays.equals(sol2, ans2)) {
					error("error 2nd testMaxSubarray! result:%s, expected: %s", toList(ans2), toList(sol2));
				}

			} catch (Exception e) {
				error("error 2nd testMaxSubarray! thrown Exception: %s", e);
			}

			try {
				test();

				int[] sample3 = new Random(1113).ints(100, -40, 20).toArray();

				int[] ans3 = maxSubarray(sample3, 20);

				System.out.print("test maxSubArray:");
				System.out.print("input:" + toList(sample3));
				System.out.print("answer:"+ toList(ans3));
				System.out.println("\n====================");

				int[] sol3 = { 40, 57, 78 };
				int s = 0;
				for (int k = 0; k < ans3[0]; k++) {
					System.out.print(sample3[k] + ",");
					s += sample3[k];
				}
				System.out.println("\nsum[0..s-1]=" + s);
				s = 0;
				for (int k = ans3[0]; k <= ans3[1]; k++) {
					System.out.print(sample3[k] + ",");
					s += sample3[k];
				}
				System.out.println("\nsum[s..e]=" + s);
				s = 0;

				for (int k = ans3[1] + 1; k < sample3.length; k++) {
					System.out.print(sample3[k] + ",");
					s += sample3[k];
				}
				System.out.println("\nsum[e+1,...]=" + s);
				System.out.println();
				if (!Arrays.equals(sol3, ans3)) {
					error("error 3rd testMaxSubarray! result:%s, expected: %s", toList(ans3), toList(sol3));
				}

			} catch (Exception e) {
				error("error 3rd testMaxSubarray! thrown Exception: %s", e);
			}
		}

		public String doTest() {

			testPrimes();
			
			testGroupingDates();

			testSumOfSquareOfIntsPassingTest();

			testArrayInitialization();

			// fibSeq();

			testMaxSubarray();

			return summary();

		}

	}

	public static void main(String[] args) {

		HW41Test t = new HW41Test();

		String rlt = t.doTest();

		System.out.println(rlt);

		// OPTIONAL: provide some tests of your own inside the selfTest() method
		
		selfTest();

	}

	public static void selfTest() {
		// OPTIONAL:
		// PUT SOME TESTs of your own here to enhance the belief that your program is
		// correct!
		long ans1 = sumOfSquareOfIntsPassingTest(IntStream.of(1, 2, 3, 4),(x) -> x > 0);
		System.out.println(ans1);
	}

}

class BaseTest {

	protected int nTests = 0; // Each test may produce multiple errors!
	protected int nErrors = 0;
	protected int nTestErrors = 0; // Each testError may comprise many errors.
	protected boolean newTest = true;

	boolean mkScore; // produce score?

	// the formula for final score from test errors
	protected Int3ToIntFunction scoreFun = Int3ToIntFunction.DEFAULT;

	protected void setScoreFun(Int3ToIntFunction f) {
		scoreFun = f;
	}

	public interface Int3ToIntFunction {

		int apply(int nTests, int nTestErrors, int nErrors);

		public static Int3ToIntFunction DEFAULT = (nTests, nTestErrors, nErrors) -> (nTests - nTestErrors) * 60 / nTests
				+ 40;
	}

	public BaseTest(boolean mkScore) {
		this.mkScore = mkScore;
	}

	public BaseTest() {
		this(false);
	}

	public int makeScore() {
		return mkScore ? scoreFun.apply(nTests, nErrors, nTestErrors) : -1;

	}

	protected void error() {
		error("");
	}

	protected void error(String s) {
		nErrors++;
		if (newTest) {
			nTestErrors++;
			newTest = false;
			System.out.println(">>> new TestError! <<< ");
		}
		System.out.println("*** error " + nErrors + "*** :" + s);
	}

	protected void error(String s, Object... args) {
		error(String.format(s + "\n", args));
	}

	protected void test() {
		nTests++;
		newTest = true;
	}

	// static void test(int k) {
	// nTests += k ;
	// }

	protected String summary() {

		StringBuilder sb = new StringBuilder();
		sb.append("There are totally " + nTests + " full tests! \n");
		sb.append("There are " + nTestErrors + " test errors! \n");
		sb.append("There are " + nErrors + " detailed errors! \n");
		sb.append("The passing rate is " + (nTests - nTestErrors) + "/" + nTests + "="
				+ ((nTests - nTestErrors) * 100 / nTests) + "!\n");

		if (mkScore) {
			int score = makeScore();
			// (nTests - nTestErrors) * 60 / nTests + 40;
			sb.append("The score is " + score + " provided your source passes compilation!");
		}

		return sb.toString();

	}

}
