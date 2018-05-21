import java.util.*;
public class test {
	public <E> void m1(List<? super E>L, E e) {
		L.add(e);
	}
	public void m2(List lst) {
		E e = lst.get(0);
	}
}
