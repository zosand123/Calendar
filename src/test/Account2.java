package test;

public class Account2 {
	//field
	//계좌번호
	private String accountNo;
	//계좌소유자명	
	private String owner;
	//잔고
	private int balance;
	
	//constructor
	public Account2(String accountNo, String owner, int balance){
		this.accountNo = accountNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	//setter & getter
	public String getAccountNo(){
		return accountNo;
	}
	public String getOwner(){
		return owner;
	}
	public int getBalance(){
		return balance;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String toString() {//to String () method 가 호출되면 (ano+owner+balance) 이 값들을 String 문자열로 리턴
		return "계좌번호:"+accountNo+"   계좌주:"+owner+"   계좌잔액:"+balance+'\n';//이 method를 호출하면 계좌번호+소유주+잔액 표시
	}
	
}
