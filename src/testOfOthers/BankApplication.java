package testOfOthers;

//Scanner import from java.util package
import java.util.Scanner;

public class BankApplication {
	//101개의 계좌를 저장할 수 있는 배열 객체 생성 		//comment : 아래코드의 경우에는100개의 계좌를 저장할 수 있는 것임
	
	
	//이 class 안에서만(private) 계좌 생성하면 객체 배열  accountArray변수 안에 계좌번호 값이 저장됨    라고 보기보다는
	//comment : private으로 선언되었기 때문에   BankApplication클래스가 아닌 다른 외부의 클래스에서  접근불가
	private static Account[] accountArray = new Account[100];
	
	//1.계좌생성 | 2.계좌목록 | 3.예금 | 4. 출금 | 5. 종료 --> 1,2,3,4,5 값을 입력 받기 위한 sc Scanner 
	private static Scanner sc = new Scanner(System.in);

	//실행하기 위한 main method
	public static void main(String[] args) {
		//밑에서 12345 목록이 지속적으로 출력될 수 있는 while 문을 위래 True 값이 저장된 run 변수 선언 
		boolean run = true;
		
		//run = True 이기 때문에 이 while 문은 지속
		//값이 True 일대 아래 내용 출력
		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("------------------------------------------------------");
			System.out.println("선택 > ");
			
			//12345번 중에 고객이 선택해 입력한 값을 selectNo 변수 안에 저장
			int selectNo = sc.nextInt();
			
			//위에 입력된 값이 저장된 selectNo의 값이 1번이면
			if(selectNo == 1) {
				createAccount(); //createAccount() method 호출해서 1.계좌생성
			} else if (selectNo == 2) { //위에 입력된 값이 저장된 selectNo의 값이 2번이면
				accountList(); //accountList() method 호출해서 2.계좌목록 조회
			} else if (selectNo == 3) {//위에 입력된 값이 저장된 selectNo의 값이 3번이면
				deposit(); //deposit() method 호출해서 예금 진행
			} else if (selectNo == 4) {//위에 입력된 값이 저장된 selectNo의 값이 4번이면
				withdraw();//withdraw() method 호출해서 출금진행
			} else if (selectNo ==5) {//위에 입력된 값이 저장된 selectNo의 값이 5번이면
				run = false; //변수 run 의 값을 false 로 하고 while 문 종료
			}
		}//while 
		System.out.println("Henry 은행을 이용해 주셔서 감사합니다. \n" + "안녕히 가십시오."); //while 문이 종료되면 "안녕히 가십시오" 출력
	}
	
	//comment: 메서드역할에 대한 주석을 작성해주세요
	//circlePrintln01 method가 호출되면 "계좌생성" 출력
	private static void circlePrintln01() {
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("-------------");
	}
	
	//circlePrintln02() method가 호출되면 "계좌목록" 출력
	private static void circlePrintln02() {
		System.out.println("-------------");
		System.out.println("계좌목록");
		System.out.println("-------------");
	}
	
	//circlePrintln03() method가 호출되면 "예금" 출력
	private static void circlePrintln03() {
		System.out.println("-------------");
		System.out.println("예금");
		System.out.println("-------------");
	}
	
	//circlePrintln04() method가 호출되면 "출금" 출력
	private static void circlePrintln04() {
		System.out.println("-------------");
		System.out.println("출금");
		System.out.println("-------------");
	}
	
	
	//계좌생성 method //comment: 메서드역할에 대한 주석을 작성한 점 칭찬해요~ ^-^
	//위에 계좌를 배열에 저장하기 위해 같은 접근 제한자 private 지정
	//이 class (은행??) 에서만 접근할 수 있게끔 계좌 생성...??
	//comment: private으로 선언하지 않고 public으로 선언하면  또 다른 클래스에서도  호출할 수 있어요
	private static void createAccount() {
		
		circlePrintln01(); //circlePrintln01(); method 호출해서 "계좌생성" 출력
		//comment: 함수(circlePrintln01()~circlePrintln04())마다 해당 부분이 무엇인지 출력하는 코드가 중복되는데
		//comment: 이런 경우에는  출력내용만 부분적으로 다를 뿐이니
		//comment: 매개변수있는 함수1개로 만들어서  
		//comment: 출력내용이 다른부분을  함수의 매개값으로 던져서 사용할 수 도 있겠지요..
		//comment: 한번  바꿔보세요~
		
		
		//"계좌번호(000-000형식)"를 출력해 계좌를 생성할 예비 소유주가 볼 수 있도록 해줌
		//comment: println메서드보다는 print메서드가  더 편할 수 도 있어요 
		System.out.println("계좌번호(000-000형식) : ");
		//sc.next() scanner를 호출해 String 타입 값인 계좌번호를 입력 받아 여기서 선언된 accountNum 변수 안에 값 저장 
		String accountNum = sc.next();
		//예비 소유주가 "계좌주"를 보고 이름을 입력할 수 있게 출력
		System.out.println("계좌주 : ");
		//sc.next() scanner를 호출해 예비 소유주의 이름(값)을 받아 String 타입 accountOwner 변수 안에 값 저장 
		String accountOwner = sc.next();
		//"초기 입금액"을 출력해 예비 소유주가 값을 입력할 수 있도록 보여줌
		System.out.println("초기 입금액 : ");
		//sc.next() scanner를 호출해 예비 소유주의 int 타입 초기 입금액을 받아 int 타입 accountBal 변수 안에 값 저장  
		int accountBal = sc.nextInt();
		
		
		//createAccount() method가 호출이 되어서 예비 소유주가 계좌번호(accountNum), 계좌주(accountOwner),
		//초기 입금액(accountBal)를 입력하면 이 3개의 값을 저장할 수 있게끔 newAccount 객체를 생성해 값을 저장
		//Account Class의 public variables 호출 및 접근 가능
		Account newAccount = new Account(accountNum, accountOwner, accountBal);
		
		//for문을 이용해 위에 생성한 배열 안에 3개의 값 저장
		for(int i =0; i<accountArray.length; i++) {
			if (accountArray[i] == null) {//만약에 위에서 생성한 배열의 element(0부터 확인)의 값이 null이면 
				//소유주의 계좌번호, 계좌주, 초기 입금액이 들어있는 newAccount를 배열 element에 저장 
				accountArray[i] = newAccount; //3개의 값이 저장된 newAccount를 null의 값인 element 안에 덮어 씌운다
				//배열 안에 저장이 되고 나면 "결과 : 계좌가 생성되었습니다." 출력
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}//if
		} //for
	} //createAccount method
	
	//계좌목록 보기
	//이 class (은행) 안에서만 접근할 수 있는 계좌목록 보기 accountList method 선언
	private static void accountList() {
		
		//accountList() method가 호출되면 circlePrintln02() method를 호출해 "계좌목록" 출력
		circlePrintln02();
		
		//배열의 element 를 하나씩 접근해서 
		for(int i = 0; i < accountArray.length; i++) {
			Account account = accountArray[i]; //account 변수 안에 값을 저장
			if(accountArray[i] != null ) { //null이 아닌 element를 가져와 account 변수 안에 저장된 값을 
				System.out.println(account.toString()); //account Class 에 있는 toString 출력해서 배열안에 저장된 "계좌번호 소유주 잔액" 출력
			}
		}
	}//accountList()
	
	//예금하기
	//이 은행에서만 접근할 수 있도록 private 처리된 deposit method
	private static void deposit() {
		//deposit() method가 호출되면 circlePrintln03() method를 호출해서 "예금" 출력
		circlePrintln03();
		
		//소유주가 계좌번호를 입력할 수 있도록 "계좌 번호(000-000형식) : " 출력
		System.out.println("계좌 번호(000-000형식) : ");
		//sc Scanner를 사용해 소유주의 계좌번호를 받아 accountNum 변수 안에 저장
		String accountNum = sc.next();
		//소유주가 "예금액"을 입력할 수 있도록 화면에 출력
		System.out.println("예금액");
		//sc Scanner를 사용해  소유주의 int 타입의 "예금액"을 입력받아 int 타입의 accountBal 변수 안에 저장 
		int accountBal = sc.nextInt();
		
		//계좌번호를 확인할 수 있는 객체 생성 | 위에서 받은 accountNum 안에 저장된 계좌번호 값이 account 안에 저장됨
		//아래에서 선언된 findAccount(String ano) method 안에 ano 변수 안에 계좌번호 값이 저장되고
		Account account = findAccount(accountNum);
		
		//findAccount method 를 통해서 account 의 값이 null로 나오면 
		//(배열안에 저장되어 있는 계좌번호와 위에서 입력된 계좌번호가 일치하지 않으면)
		//"계좌가 존재하지 않습니다." 출력
		if (account == null) { 
			System.out.println("계좌가 존재하지 않습니다.");
			return; //끝
		}
		
		//배열 --> ano 값 안에 저장된 계좌번호와 accountNum 위에서 입력된 계좌번호 비교해서 
		//같지 않으면 "!" "계좌가 존재하지 않습니다." 출력
		if(!account.getAno().contentEquals(accountNum)) {
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
			return; //끝
		}
		
		//예금을 하기 위해 setBalance()method 호출해서 int타입 Balance 변수 안에
		//값 --> account.getBalance()(기존에 있던 잔액) + accountBal(위에서 입력된 예금액) 저장
		//그리고 이 값을  Account class의 변수 Balance 안에 저장
		account.setBalance(account.getBalance()+accountBal);
		//그리고 나서 "예금이 성공되었습니다" 출력
		System.out.println(accountBal+"원이 예금되었습니다");
	}//deposit
	
	//출금하기
	private static void withdraw() {
		//circlePrintln04() method 호출해서 "출금" 출력
		circlePrintln04();
		
		//소유주가 계좌번호를 입력할 수 있도록 "계좌 번호(000-000형식) : " 출력
		System.out.println("계좌 번호(000-000형식) : ");
		//sc Scanner를 사용해 소유주의 출금액을 받아 accountNum 변수 안에 저장
		String accountNum = sc.next();
		//소유주가 "출금액"을 입력할 수 있도록 화면에 출력
		System.out.println("출금액 : ");
		//sc Scanner를 사용해  소유주의 int 타입의 "출금액"을 입력받아 int 타입의 accountBal 변수 안에 저장 
		int accountBal = sc.nextInt();
		
		//계좌번호를 확인할 수 있는 객체 생성 | 위에서 받은 accountNum 안에 저장된 계좌번호 값이 account 안에 저장됨
		//아래에서 선언된 findAccount(String ano) method 안에 ano 변수 안에 계좌번호 값이 저장되고
		Account account = findAccount(accountNum);
		
		//findAccount method 를 통해서 account 의 값이 null로 나오면 
		//(배열안에 저장되어 있는 계좌번호와 위에서 입력된 계좌번호가 일치하지 않으면)
		//"계좌가 존재하지 않습니다." 출력
		if (account == null) { 
			System.out.println("계좌가 존재하지 않습니다.");
			return; //끝
		}
		
		//배열 --> ano 값 안에 저장된 계좌번호와 accountNum 위에서 입력된 계좌번호 비교해서 
		//같지 않으면 "!" "계좌가 존재하지 않습니다." 출력
		if(!account.getAno().contentEquals(accountNum)) {
			System.out.println("계좌번호를 잘못 입력하셨습니다.");
			return; //끝
		}
		
		//account.getBalance() == 0 통장의 잔액이 0 이거나,
		//account.getBalance() < accountBal 통장의 잔액보다 위에서 입력한 값이 더 크거나
		// account.getBalance() - accountBal < 0 통장잔액에서 위에서 입력한 값을 뺐을때 0보다 작으면
		//"잔액이 부족합니다" 출력
		if(account.getBalance() == 0 || account.getBalance() < accountBal || account.getBalance() - accountBal < 0) {
			System.out.println("잔액이 부족합니다.");
			return; //끝
		}
		
		//출금을 하기 위해 setBalance()method 호출해서 int타입 Balance 변수 안에
		//값 --> account.getBalance()(기존에 있던 잔액) - accountBal(위에서 입력된 출금액) 저장
		//그리고 이 값을  Account Class의 변수 Balance 안에 저장
		account.setBalance(account.getBalance()-accountBal);
		//그리고 나서 "예금이 성공되었습니다" 출력
		System.out.println(accountBal+"원이 출금되었습니다");
	}
		

	
	//String 타입의 ano (계좌번호)의 값이 이 Class 안에서 [위에서] 입력되면
	//ano 변수 안에 저장되는 method
	//Account = Account Class 에 접근할 수 있는 ??????????
	//comment: 입력받은 계좌번호를 이용하여 계좌조회
	private static Account findAccount(String ano) {
		
		//account 변수를 null 로 초기화 --> 배열에 접근해서 확인하기 위해
		Account account = null;
		
		//배열의 (계좌번호의 저장공간) element 에 하나씩 접근해서 
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i] != null) { //계좌번호가 있는 element 만 확인하기 때문에 !=
				
				//accountArray[i] (배열)에 접근해서 계좌번호 배열 안에 있는 계좌번호 조회
				//그리고 getAno() method를 호출해 Account Class ano 변수 안에 저장해서 ano의 값인 계좌번호를 리턴 
				//그리고 accountNum 변수 안에 저장
				String accountNum = accountArray[i].getAno();
					////배열에서 얻은 계좌번호가 저장되어 있는 accountNum의 값과 
					//위에서 입력된 소유주가 입력한 계좌번호가 저장되어 있는 ano의 값을 비교 
					if(accountNum.equals(ano)) {
						account = accountArray[i]; //배열안에 저장되어 있는 계좌번호의 값을 account 변수 안에 저장
						break;
					}//if
				}// accountNum
			}//for
			return account; //account 의 값인 계좌번호를 리턴 또는 null을 리턴
		}//findAccount(String ano) method
} //BankApplication Class
