package banking;

import java.io.Serializable;
import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) throws MenuSelectException {
		
		//메뉴 메소드 호출을 위한 핸들러인스턴스 생성
		AccountManager accountManager = new AccountManager();
		
		//계좌정보 불러오기(프로그램 실행시 먼저 실행)
		accountManager.accountLoad();
		
		AutoSaver thread = new AutoSaver();
		// 종료 메뉴를 누르기 전까지는 계속실행(무한루프)
		while (true) {
			AccountManager.showMenu();
			Scanner scanner = new Scanner(System.in);
			int menuNum = scanner.nextInt();
			
			if(menuNum<1||menuNum>7) {
				MenuSelectException excep = new MenuSelectException();
				throw excep;
			}
				 
			switch (menuNum) {

			case ICustomDefine.MAKE :
				accountManager.makeAccount();
				break;
			case ICustomDefine.DEPOSIT :
				accountManager.depositMoney();
				break;
			case ICustomDefine.WITHDRAW :
				accountManager.withdrawMoney();
				break;
			case ICustomDefine.INQUIRE :
				accountManager.showAccInfo();
				break;
			case ICustomDefine.DELETE :
				accountManager.delAccount();
				break;
			case ICustomDefine.AUTOSAVE :
			 accountManager.autoSave(thread);
				break;
			case ICustomDefine.EXIT :
				accountManager.accountListSave(); //저장 후 종료
				
				return;

			}

		}
	}
}
