package fibo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class FiboTest extends TestCase{

	public static void main(String[] args) {
		//junit.textui.TestRunner.run(FiboTest.class)를 호출함으로써 Test가 진행된다
		junit.textui.TestRunner.run(FiboTest.class);
		//JUnit은   FiboTest라는 클래스의  method중에서
		//test로  시작하는  이름의  method를    테스트메서드로  자동인식하여  자동으로 실행을 시킨다
	}

	public void testFibo2() {
		Fibo f1 = new Fibo();
		//assertEquals(["메세지"],예측값,실제값);
		//assertEquals(0,f1.fibo2(1));//fail
		//assertEquals(1,f1.fibo2(2));
		//assertEquals(f1.fibo2(1)+f1.fibo2(2),  f1.fibo2(3));
		assertEquals(f1.fibo2(2)+f1.fibo2(3),  f1.fibo2(4));
		assertEquals(55,  f1.fibo2(10));
		
		assertEquals(f1.fibo2(27)+f1.fibo2(28),  f1.fibo2(29));
	}
	
	public void testFibo1() {
		Fibo f1 = new Fibo();
		assertEquals(f1.fibo1(2)+f1.fibo1(3),  f1.fibo1(4));
		assertEquals(55,  f1.fibo1(10));
		assertEquals(f1.fibo1(27)+f1.fibo1(28),  f1.fibo1(29));
	}
	
	
}













