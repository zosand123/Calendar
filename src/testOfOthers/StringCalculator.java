package testOfOthers;

import java.util.Scanner;

public class StringCalculator {

	//초기값과 계산 결과를 저장할 변수
	private double currValue=0.0;
	
	public StringCalculator() {}
	
	//초기값을 갖는 생성자
	public StringCalculator(double currValue) {
		this.currValue = currValue;
	}

	public static void main(String[] args) {

		StringCalculator sCalc = new StringCalculator();
				
		sCalc.run();
		
	}

	//계산기 실행 메소드, 입력값에 따라 계산, 클리어, 종료 기능을 수행한다
	public void run() {
		
		String input = null; //인풋값 저장변수
		Scanner sc = new Scanner(System.in); //스캐너 객체생성
		
		while(true) { //계산식을 입력받는 반복문
			System.out.println("계산식을 입력하세요. Clear는 C, 종료하려면 Q를 누르세요");
			System.out.println("현재 값 : "+currValue);
			
			//현재값이 0이 아니면 현재값에 계산을 할 수 있도록 현재값을 표시한다
			if(currValue!=0.0) {
				System.out.print("입력 > "+currValue);
			}else {
				System.out.print("입력 > ");
			}
			
			input = sc.nextLine(); //input에 입력받을값 넣기
			
			//입력값의 유효성을 검증한다
			input = validateString(input);
			
			//입력값에 따라 기능, 연산을 수행한다
			if(input.equals("wrongInput")) {
				continue;
			}else if(input.equals("C")||input.equals("c")){
				currValue = 0.0;
				System.out.println("현재값이 0으로 초기화 되었습니다");
				continue;
			}else if(input.equals("Q")||input.equals("q")){
				System.out.println("계산기를 종료합니다");
				System.exit(0);
			}else {
				double result = calculate(splitString(input));
				currValue = result;
				System.out.println("계산 결과 : "+result);
				continue;
			}
		}
	}
	
	//잘못된 입력을 제거하는 인풋 유효성 검증 메소드
	public String validateString(String input) {

		//불필요한 공백 제거, 잘못된 상황을 리턴하는 msg 변수 선언과 값 할당
		String pInput = input.trim();
		pInput = input.replaceAll(" ", "");
		String msg="wrongInput";
		
		//숫자와 소수점, 기호, 단축키를 제외한 문자는 잘못된 입력으로 간주한다
		for(int i=0;i<pInput.length();i++) {
			//단축키 값이 입력되면 그 키를 리턴한다
			char ch = pInput.charAt(i);
			if(ch=='C'||ch=='Q'||ch=='c'||ch=='q') {
				return String.valueOf(ch);
			//숫자와 소수점, 기호를 제외한 문자는 잘못된 입력으로 처리한다	
			} else if(!(Character.isDigit(ch)||ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='.')) {
				System.out.println("잘못된 입력입니다");
				return msg;
			}
		}
		
		//연산 기호를 입력하지 않은 경우
		if(pInput.indexOf('+')==-1&&pInput.indexOf('-')==-1&&pInput.indexOf('*')==-1&&pInput.indexOf('/')==-1) {
			System.out.println("연산 기호를 입력하세요");
			return msg;
		}
		
		//연산 기호를 2개 이상 입력한 경우
		int signalCount = 0;
		for(int i=0;i<pInput.length();i++) {
			char ch=pInput.charAt(i);
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				signalCount++;
			}
		}
		if(signalCount>1) {
			System.out.println("연산 기호는 한 번만 입력하세요");
			return msg;
		}
		
		return pInput;
	}
	
	//문자열을 나누는 메소드
	//결과물을 3개짜리 String 배열에 담아
	//String[0]엔 숫자1, String[1]엔 숫자2, String[2]엔 연산기호를 담음
	public String[] splitString(String input) {

		int signalIndex = 0; //인덱스 값을 찾는 int 변수선언 

		//연산기호가 무엇인지 찾는다
		if(input.indexOf('+')!=-1) { //+가 있을 경우 
			signalIndex=input.indexOf('+'); //+ 인덱스번호 
		}else if(input.indexOf('-')!=-1){
			signalIndex=input.indexOf('-');	
		}else if(input.indexOf('*')!=-1) {
			signalIndex=input.indexOf('*');	
		}else if(input.indexOf('/')!=-1) {
			signalIndex=input.indexOf('/');
		}
		
		String signal = String.valueOf(input.charAt(signalIndex));
		
		String[] str=input.split("\\"+signal);
				
		String[] result=new String[3];
		
		//현재 계산결과값이 0이 아니라면 숫자1에 현재값을 담는다
		if(currValue!=0.0) {
			result[0]=String.valueOf(currValue);	
		}else {
			result[0]=str[0];
		}
		result[1]=str[1];
		result[2]=signal;
	
		return result;
		
	}
	
	//input 배열을 받아 계산을 수행한다.
	public double calculate(String[] input) {
		
		double x = Double.parseDouble(input[0]); 
		double y = Double.parseDouble(input[1]);
		String signal=input[2];
		
		double result = 0.0;
		
		switch(signal) {
			case "+":
				result = plus(x, y);
				break;
			case "-":
				result = minus(x, y);
				break;
			case "*":
				result = multiply(x, y);
				break;
			case "/":
				result = divide(x, y);
				break;
		}
		
		return result;
		
	}
	
	public double plus(double x, double y) {
		return x+y;
	}
	
	public double minus(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x*y;
	}
	
	public double divide(double x, double y) {
		
		if(y==0) {
			System.out.println("0으로 나눌 수 없습니다");
			return x;
		}else {
			return x/y;
		}
		
	}
}
