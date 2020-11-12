package test;

import java.util.Scanner;

public class BankApplication{
	
	private static Account2[] accountArray = new Account2[100];
	
	static String accountNo;
	static String owner;
	static int balance;
	static int withdraw;

	static Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {
		boolean run = true;	//반복실행여부를 저장하기위한 변수
		
		
		//반복문
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택> ");
			
			//번호입력받기
			int select = sc.nextInt();
			//입력받은 값에 따라 각 각의  함수호출
			/*예) 1이면  계좌생성 함수호출
			     2이면  계좌목록조회 함수호출
			*/
			
			if (select == 1) {
				createAccount();
			} else if(select == 2) {
				accountList(); 
			} else if(select == 3) {
				deposit();
			} else if(select ==4) {
				withdraw();
			} else if(select ==5) {
				System.out.println("자바은행을 이용해주셔서 감사합니다.");
				break;
			} else {
				System.out.println("다시 눌러주세요.");
				run=true;
			}
		}
	}
	
	//계좌생성하기
	static void createAccount() {
		System.out.println("--------------");
		System.out.println("계좌생성");
		System.out.println("--------------");
		
		//계좌번호, 계좌주: 초기입금액 입력받아 저장
		System.out.print("계좌번호: ");
		accountNo = sc.next();
		System.out.print("계좌주:");
		owner = sc.next();
		System.out.print("초기입금액:");
		balance = sc.nextInt();
		
		Account2 newAccount = new Account2(accountNo, owner, balance);
		//이미있는 계좌번호면 계설안됨 
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] == null ) {
				accountArray[i] = newAccount; //new 쓰면 생성자 호출!
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}//if
		}//for
	}//createAccount method

	//계좌목록보기
	static void accountList() {
		System.out.println("--------------");
		System.out.println("계좌목록");
		System.out.println("--------------");
		
		//계좌수만큼 반복하여 계좌번호, 계좌주, 잔고 출력
		for (int i = 0; i < accountArray.length; i++) {
			Account2 a2 = accountArray[i];
			if(accountArray[i]!=null) {
			System.out.print(a2.toString());
			}
		}	
	}
	//예금하기
	static void deposit() {
		System.out.println("--------------");
		System.out.println("예금");
		System.out.println("--------------");
		
		//계좌번호, 예금액입력받아 변수에 저장
		System.out.print("계좌번호:");
		accountNo = sc.next();
		System.out.print("입금할 금액:");
		int deposit = sc.nextInt();
		
		Account2 a2 = findAccount(accountNo);
		
		//해당계좌가 없으면 결과: 계좌가 없습니다.출력
		if(a2==null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		} else {
			a2.setBalance(balance+deposit);
			//해당계좌의 잔고조회하여 출력 + 결과: 예금이 성공되었습니다.출력
			System.out.println(a2.toString()+"예금이 성공되었습니다.");
		}
	}
	//출금하기
	static void withdraw() {
		System.out.println("--------------");
		System.out.println("출금");
		System.out.println("--------------");
		
		//계좌번호, 출금액입력받아 변수에 저장
		System.out.print("출금할 계좌번호:");
		accountNo = sc.next();
		System.out.print("출금할 금액:");
		withdraw = sc.nextInt();
		//계좌번호로 계좌조회
		Account2 a2 = findAccount(accountNo);
		if(a2==null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}else if(a2.getBalance()-withdraw<0) {
			System.out.println("잔액이 부족합니다.");
			return;
		} else if(a2!=null && a2.getBalance()>=withdraw) {
					 a2.setBalance(a2.getBalance()-withdraw);
				System.out.println(a2.toString()+"출금이 성공되었습니다.");
				return;
			}
			
	}
	static Account2 findAccount(String accountNo){
		
		Account2 a2 = null;
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]!=null) {
			String ano = accountArray[i].getAccountNo();
				if(ano.equals(accountNo)) {
					a2 = accountArray[i];
					break;
				}//if
			}//if
		}//for
		return a2;
	}//findAccount

}//bankApplication
