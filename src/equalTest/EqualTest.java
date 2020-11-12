package equalTest;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
/* 참고   https://junit.org/junit4/javadoc/latest/index.html
 * 
 * 참고  
 *   assert메소드에 대해서 궁금하시면   Class Assert검색
 *       
 *   assert메소드에서 message는 선택사용.생략가능
 *   assertSame(String message, Object expected, Object actual)
 *   	: 기대값과 실제값이 동일주소값인지 비교
 *   assertEquals(String message, Object expected, Object actual)
 *   	: 기대값과 실제값이 동일값인지 비교
 */

/*참고	 Hamcrest란?
 *  소프트웨어 테스트를 위한 framework
 *  import static org.hamcrest.CoreMatchers.*;해야한다
 */
//junit4에서는 Test클래스가 junit.framework.TestCase를 상속받지 않아도 된다
//public class EqualTest extends TestCase{
public class EqualTest{
	
	//@Test(timeout=제한시간 ms단위)
	//@Test(timeout=1000)//1초 //1ms= 1/1000초
	@Test(timeout=10)//0.1초  10/1000
	public void testTimeOut() throws Exception{
		long sum = 0;
		for(int i=0; i<10000; i++) {
			for(int j=0; j<10000; j++) {
				sum+=j;
			}
		}
		System.out.println("sum="+sum);
	}
	
	//@Ignore은 Test에서 제외해라
	@Ignore  //import org.junit.Ignore;
	@Test
	public void tIgnore() throws Exception {
		assertTrue(false);
	}
	
	
	//assertThat( 검사할대상데이터, 조건);
	@Test
	public void tAssertThat() {
	    Object result = "test";
		assertTrue(result instanceof String); //success. //Junit4사용
		assertThat(result, instanceOf(String.class));  //success //Hamcrest사용
		
		
		int i=3;
		assertThat(i,is(3));
		
		assertThat(Arrays.asList("one","two","three")  , hasItems("one","two") );
	}
	
	//junit4에서 테스트메소드명은 반드시 test로 시작하지 않아도 된다
	@Test
	public void tAssertNotNull() {
		//assertNotNull("not null이어야 해요", new Object()); //success
		
		String str1 = null;
		str1 = new String("하하호호");
		assertNotNull("not null이어야 해요", str1);//success 또는 fail
	}
	
	@Test
	public void testAssertTrue() {
		//assertTrue("fail-true가 나와야해요",false);  //fail
		assertTrue("fail-ture가 나와야해요",true); //true
	}
	
	
	@Test
	public void testAssertFalse() {
		assertFalse("fail-false가 나와야해요",false);  //success
		//assertFalse("fail-false가 나와야해요",true); //true
	}
	
	/*Arrays.asList() : 일반 배열을 ArrayList로 변환
	 * get(), contains()는 사용가능하지만
	 * add() 사용불가
	 */
	//List비교
	@Test
	public void testValueEqual2() {
		List<Integer> expected = Arrays.asList(1,2,3);
		List<Integer> actual = Arrays.asList(1,2,3);
		assertEquals("두 List의 값과 순서가 같아요",expected,actual);
	}
	
	@Test
	public void testAssertArrayEquals2() {
		String[] expected = new String[] {"a","b","c"};
		String[] actual   = new String[] {"a","b","c"};
		//배열의 길이와 값이 동일해야 한다
		//String[] actual   = new String[] {"A","b","c"};//값이 동일하지 않아서 fail
		//String[] actual   = new String[] {"a","b"};//길이가 동일하지 않아서 fail
		assertArrayEquals("failure-byte array not same",expected,actual);
	}
	
	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "qwert".getBytes();
		byte[] actual = "qwert".getBytes();
		assertArrayEquals("failure-byte array not same",expected,actual);
	}
	
	//reference 비교
	@Test
	public void testReferenceEqual() {
		String str1 = new String("문자열");
		//String str2 = new String("문자열");
		String str2 = str1;
		//System.out.println("reference 비교결과="+(str1==str2) );//false
		assertSame("두 객체의 주소값이 동일",str1,str2);
	}
	
	//value비교
	@Test
	public void testValueEqual() {
		String str1 = new String("이순신");
		String str2 = new String("이순신");
		//System.out.println("value 비교결과="+(	str2.equals(str1)) );//true
		//assertEquals("두 객체의 값이 동일",str1,str2);
		
		double d1=11.9;
		double d2=12.0;
		assertEquals(d1,d2,0.0001);
	}
	
	
}











