package stringCalculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringCalculator {
	
	double cv;
	double x;
	String sign;
	double y;
	Scanner sc = new Scanner(System.in);
	static StringCalculator scct;
	StringTokenizer stk;
	
	public static void main(String[] args) {
		scct = new StringCalculator();
		scct.calculate();
	}
	
	//계산하기 메소드 
	public void calculate() {
		scct = new StringCalculator();
		
		while(true) {
			System.out.println("계산할 값을 입력하세요. 종료:Q, 초기화:C ");
			if(cv!=0.0) {
				System.out.println("현재 값 : "+cv);
			}else {
				System.out.print("입력 : ");
			}
			
			String formula= sc.next();
			if(formula.equals("Q")) {
				System.exit(0);
			}else if(formula.equals("C")) {
				scct.cv=0.0;
				System.out.println("계산값이 초기화되었습니다.");
				continue;
			}
			cv = scct.valid(formula);
			System.out.println(formula+"="+cv);
		}
	}
	
	public double valid(String formula) {
		scct = new StringCalculator();
		stk = new StringTokenizer(formula,"+|-|*|/",true);
		if(cv==0.0) {
			x = Double.parseDouble(stk.nextToken());
		}else if(cv!=0.0) {
			x=cv;
		}
		sign = stk.nextToken();
		y = Double.parseDouble(stk.nextToken());
		switch(sign) {
		case "+" : cv=plus(x,y); break;
		case "-" : cv=minus(x,y); break;
		case "*" : cv=multiply(x,y); break;
		case "/" : cv=divide(x,y); break;
		}
		return cv;
	}
	
	public double plus(double x,double y) {
		return x+y;
	}
	public double minus(double x,double y) {
		return x-y;
	}
	public double multiply(double x,double y) {
		return x*y;
	}
	public double divide(double x,double y) {
		return x/y;
	}
	
}
