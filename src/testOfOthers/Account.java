//인터넷에서 답 찾아서 이해용 주석문 추가함

package testOfOthers;

//계좌 정보 저장용 Class
public class Account{
	//field
	
	//계좌번호(ano), 소유주(owner), 입금액(balance)
	private String ano; //private 접근제어자를 이용해 외부 접근 제한
	private String owner;//private 접근제어자를 이용해 외부에서 소유주 변경 제한
	private int balance;//private 접근제어자를 이용해 외부에서 잔액 변경 제한
	
	//Account 생성자
	//외부에서 String ano, String owner, int balance 값을 받아서 위에서 선안된 ano owner balance 변수 안에 저장 및 처리 
	public Account(String ano, String owner, int balance) {
		this.ano=ano;
		this.owner=owner;
		this.balance=balance;
		
	}
	
	//계좌번호 호출 method
	public String getAno() {
		return ano; //getAno() method를 호출하면 생성되어 있는 계좌번호(ano) 달라!
	}
	
	//계좌번호 생성 method : String 값을 외부에서 입력하면 매개변수 ano 안에 값이 저장되고
	//private String ano로 선언된 ano 에 입력된 값이 저장됨
	public void setAno(String ano) {
		this.ano = ano; //private String ano = (String ano)
	}
	
	//소유주 생성 method
	public String getOwner() {
		return owner;// getOwner() method를 호출하면 생성되어 있는 소유주(owner) 달라!
	}
	
	//소유주 생성 method : String 값을 외부에서 입력하면 매개변수 owner 안에 값이 저장되고
	//private String owner 로 선언된 owner 에 입력된 값이 저장됨
	public void setOwner(String owner) {
		this.owner = owner; //private String owner = (String owner)
	}
	
	//계좌잔액조회 method
	public int getBalance() {
		return balance; //getBalance() method를 호출하면 계좌에 있는 잔액 달라!
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override //여기서 이게 왜?????? //comment: toString()은 Object가 가진 11개의 메소드중의 하나이기 때문이죠
	public String toString() {//to String () method 가 호출되면 (ano+owner+balance) 이 값들을 String 문자열로 리턴
		return ano+"   "+owner+"   "+balance+'\n'; //이 method를 호출하면 계좌번호+소유주+잔액 표시
	}
}








