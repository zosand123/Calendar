package oop;

public class Method {
//hihi
	public static void main(String[] args) {
		
		int result = Method2.max(2,8);
		System.out.println(result);
		System.out.println("hi world");
	}
	
	
	static class Method2{
		static int max (int a,int b) {
			if(a>b) {
				return a;
			}else {
				return b;
			}
		}
	}
	
}
