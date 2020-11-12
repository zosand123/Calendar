package valid;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//테스트소스
//비밀번호 유효성검사기능을 테스트하기위한 테스트클래스

/*참고	Parameterized란?
  단위테스트를 실행시   여러가지 입력값에 대한  테스트를 한 번에 수행할 때 사용
 ==> 즉, 서로 다른 조건값을  바꾸어가면서  반복적으로 테스트를 해야 하는  경우  			*/
@RunWith(Parameterized.class)
public class ValidPWTest {
	private String password;
	private boolean isValid;
	private static ValidPW validator; //정적변수
	
	
	//@BeforeClass는  클래스안의 test메서드를 run하기 전에  단 한번만  실행한다
	// 따라서  주로  정적 변수의 값을 초기화할 때 사용한다
	@BeforeClass
	public static void setUp() {
		validator = new ValidPW();
	}

	//생성자
	public ValidPWTest(String password, boolean isValid) {
		this.password=password;
		this.isValid = isValid;
	}
	
	//테스트하고자하는  파라미터를 제공하는 함수
	@Parameters
	public static Collection passwords() {
		return Arrays.asList(
				new Object[][] {
					{"123f",false},
					{"123",false},
					{"qwerasdf12",true},
					{"12345678",false},
					{"1q2w3e4r",true},
					{"qwerasdf",false}
				}
			);
	}
	
	@Test
	public void isValidPwWithParams() {
		assertEquals(validator.isValid(this.password), this.isValid);
	}
	
}










