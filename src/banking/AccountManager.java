package banking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;

public class AccountManager {

	// 계좌정보
	Account accout;

	// 계좌리스트
//	ArrayList<Account> accLists = new ArrayList<Account>();
	HashSet<Account> accLists = new HashSet<Account>();

	// 계좌정보 불러오기
	public void accountLoad() {
		try {
			// 파일의 정보를 받아올 객체 생성
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/banking/account_info.obj"));

			// 스트림객체는 사이즈(내부요소의 갯수)를 확인할 수 없으므로 무한루프를 이용하며 모두 꺼냄
			// 마지막을 꺼낸 후 발생하는 in.readObject()오류는 ClassNotFoundException으로 exception처리.
			while (true) {
				Account accout = (Account) in.readObject();
				accLists.add(accout);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("객체가 없는 오류");
		} catch (IOException e) {
			// System.out.println("IO익셉션 발생");
		}
	}

	public static void showMenu() {
		System.out.println("######메뉴를 입력하세요#######");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
	}

	public void makeAccount() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("계좌를 선택하세요");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int creditYn = scanner.nextInt();
		scanner.nextLine();

		if (creditYn == 1) {
			System.out.println("계좌번호를 입력하세요");
			String accountNumbe = scanner.nextLine();

			System.out.println("이름을 입력하세요");
			String name = scanner.nextLine();

			System.out.println("이자율을 입력하세요");
			int rate = scanner.nextInt();
			scanner.nextLine();

			System.out.println("잔액을 입력하세요");
			int balance = scanner.nextInt();
			scanner.nextLine();
			
			// 계좌번호 중복 체크
//
//			for (Account acc : accLists) {
//				if (acc.getAccountNumber().equals(accountNumbe)) {
//					System.out.println("이미 등록된 계좌 입니다. 계좌번호를 확인하세요");
//					chk = true;
//					break;
//				}
//			}
//			if (!chk) {
//				Account accout = new NormalAccount(accountNumbe, name, balance, rate);
//				accLists.add(accout);
//				System.out.println("계좌개설이 완료되었습니다.");
//
//				System.out.println("계좌번호 :" + accout.getAccountNumber());
//				System.out.println("고객이름 :" + accout.getName());
//				System.out.println("잔액 :" + accout.getBalance());
//				System.out.println("기본이자 :" + ((NormalAccount) accout).getRate());
//			}

			Account accout = new NormalAccount(accountNumbe, name, balance, rate);
			boolean chk = accLists.add(accout);
			if (!chk) {
				System.out.println("등록된 계좌정보입니다.기존의 정보를 삭제 후 재등록하시겠습니까? Y or N ");
				String chkYn = scanner.nextLine();
				if (chkYn.equals("Y")) {
					delAccount2(accountNumbe);
				}
				accLists.add(accout);
				System.out.println("계좌번호 :" + accout.getAccountNumber());
				System.out.println("고객이름 :" + accout.getName());
				System.out.println("잔액 :" + accout.getBalance());
				System.out.println("기본이자 :" + ((NormalAccount) accout).getRate());
			}

		} else if (creditYn == 2) {
			System.out.println("계좌번호를 입력하세요");
			String accountNumbe = scanner.nextLine();

			System.out.println("이름을 입력하세요");
			String name = scanner.nextLine();

			System.out.println("이자율을 입력하세요");
			int rate = scanner.nextInt();
			scanner.nextLine();

			System.out.println("신용등급을 입력하세요");
			System.out.println("1.A");
			System.out.println("2.B");
			System.out.println("3.C");
			int creditRatingI = scanner.nextInt();
			String creditRating = creditRatingI == 1 ? "A" : (creditRatingI == 2 ? "B" : "C");
			scanner.nextLine();

			System.out.println("잔액을 입력하세요");
			int balance = scanner.nextInt();
			scanner.nextLine();
			
			// 계좌번호 중복 체크
//			for (Account acc : accLists) {
//				if (acc.getAccountNumber().equals(accountNumbe)) {
//					System.out.println("이미 등록된 계좌 입니다. 계좌번호를 확인하세요");
//					chk = true;
//					break;
//				}
//			}
//			if (!chk) {
//				Account accout = new HighCreditAccount(accountNumbe, name, balance, rate, creditRating);
//				accLists.add(accout);
//				System.out.println("계좌개설이 완료되었습니다.");
//
//				System.out.println("계좌번호 :" + accout.getAccountNumber());
//				System.out.println("고객이름 :" + accout.getName());
//				System.out.println("잔액 :" + accout.getBalance());
//				System.out.println("기본이자 :" + ((HighCreditAccount) accout).getRate());
//				System.out.println("신용등급 :" + ((HighCreditAccount) accout).getCreditRating());
//			}
			Account accout = new HighCreditAccount(accountNumbe, name, balance, rate, creditRating);
			boolean chk = accLists.add(accout);
			if (!chk) {
				System.out.println("등록된 계좌정보입니다.기존의 정보를 삭제 후 재등록하시겠습니까? Y or N ");
				String chkYn = scanner.nextLine();
				if (chkYn.equals("Y")) {
					delAccount2(accountNumbe);
				}
				accLists.add(accout);
				System.out.println("계좌번호 :" + accout.getAccountNumber());
				System.out.println("고객이름 :" + accout.getName());
				System.out.println("잔액 :" + accout.getBalance());
				System.out.println("기본이자 :" + ((HighCreditAccount) accout).getRate());
				System.out.println("기본이자 :" + ((HighCreditAccount) accout).getRate());
			}
			
		} else {
			System.out.println("계좌 종류를 정확히 선택해 주세요");
		}

	}

	// 입금 로직
	public void depositMoney() {
		int accNumYn = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("계좌번호를 입력하세요");
		String accountNumbe = scanner.nextLine();

		int depNum;
		while (true) {
			System.out.println("입금 금액을 입력하세요");
			depNum = scanner.nextInt();
			scanner.nextLine();
			if (depNum < 0) {
				System.out.println("입금 금액은 양수로 입력하세요");
				continue;
			}
			if (depNum % 500 != 0) {
				System.out.println("입금 금액은 500원 단위로 가능합니다.");
				continue;
			}

			break;
		}

		// 입력받은 계좌번호를 이용하여 대상을 찾는다.
		for (Account acc : accLists) {
			// 계좌번호가 같은 경우 잔액에서 입금받은 금액을 플러스 한 후 다시 setter를 이용하여 업데이트
			if (acc.getAccountNumber().equals(accountNumbe)) {
				if (acc instanceof NormalAccount) {
					// 기본이자율
					double rate = (double) (((NormalAccount) acc).getRate()) / 100;

					acc.setBalance(acc.getBalance() + (int) Math.floor(acc.getBalance() * rate) + depNum);
					System.out.println("입금이 완료 되었습니다.");
					System.out.println("잔액 : " + acc.getBalance());
					accNumYn = 1;
					break;
				} else {
					double rate = (double) (((HighCreditAccount) acc).getRate()) / 100;

					// 신용등급에 따른 추가 이자율계산
					String credit = ((HighCreditAccount) acc).getCreditRating();
					double rate2 = credit == "A" ? ICustomDefine.A
							: (credit == "B" ? ICustomDefine.B : ICustomDefine.C);
					rate2 = rate2 / 100;
					acc.setBalance(acc.getBalance() + (int) Math.floor(acc.getBalance() * rate)
							+ (int) Math.floor(acc.getBalance() * rate2) + depNum);
					System.out.println("입금이 완료 되었습니다.");
					System.out.println("잔액 : " + acc.getBalance());
					accNumYn = 1;
					break;
				}
			}
		}
		if (accNumYn == 0) {
			System.out.println("요청하신 계좌번호가 없습니다. 계좌번호를 확인하세요");
		}
	}

	// 출금로직
	public void withdrawMoney() {
		int accNumYn = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("계좌번호를 입력하세요");
		String accountNumbe = scanner.nextLine();

		int withdNum;
		while (true) {
			System.out.println("출금 금액을 입력하세요");
			withdNum = scanner.nextInt();
			scanner.nextLine();
			if (withdNum < 0) {
				System.out.println("출금 금액은 양수로 입력하세요");
				continue;
			}
			if (withdNum % 1000 != 0) {
				System.out.println("출금 금액은 1000원 단위로 가능합니다.");
				continue;
			}
			break;
		}

		// 입력받은 계좌번호를 이용하여 대상을 찾는다.
		for (Account acc : accLists) {
			// 계좌번호가 같은 경우 잔액에서 출금요청받은 금액을 마이너스 한 후 다시 setter를 이용하여 업데이트
			if (acc.getAccountNumber().equals(accountNumbe)) {
				if (acc.getBalance() < withdNum) {
					System.out.println("잔액이 부족하여 출금할 수 없습니다.");
					accNumYn = 1;
				} else {
					acc.setBalance(acc.getBalance() - withdNum);
					System.out.println("출금이 완료 되었습니다.");
					System.out.println("잔액 : " + acc.getBalance());
					accNumYn = 1;
				}
			}
		}
		if (accNumYn == 0) {
			System.out.println("요청하신 계좌번호가 없습니다. 계좌번호를 확인하세요");
		}
	}

	// 모든 계좌정보 출력
	public void showAccInfo() {
		int i = 1;
		for (Account accout : accLists) {

			if (accout instanceof NormalAccount) {

				System.out.println("번호" + i);
				System.out.println("계좌번호 :" + accout.getAccountNumber());
				System.out.println("고객이름 :" + accout.getName());
				System.out.println("잔액 :" + accout.getBalance());
				System.out.println("기본이자 :" + ((NormalAccount) accout).getRate());
				System.out.println();
			} else {

				System.out.println("번호" + i);
				System.out.println("계좌번호 :" + accout.getAccountNumber());
				System.out.println("고객이름 :" + accout.getName());
				System.out.println("잔액 :" + accout.getBalance());
				System.out.println("기본이자 :" + ((HighCreditAccount) accout).getRate());
				System.out.println("신용등급 :" + ((HighCreditAccount) accout).getCreditRating());
				System.out.println();
			}
			i++;
		}
	}

	// 계좌 정보 삭제
	public void delAccount() {
		int chkNum = 1;
		Scanner scanner = new Scanner(System.in);

		System.out.println("계좌번호를 입력하세요");
		String accountNumbe = scanner.nextLine();

		for (Account acc : accLists) {
			if (acc.getAccountNumber().equals(accountNumbe)) {
				accLists.remove(acc);
				System.out.println("삭제되었습니다. ");
				chkNum = -1;
				break;
			}
		}
		if (chkNum == 1) {
			System.out.println("요청하신 계좌번호를 찾을 수 없습니다.");
		}
	}

	// 중복계좌 정보 삭제
	public void delAccount2(String accountNumbe) {
		for (Account acc : accLists) {
			if (acc.getAccountNumber().equals(accountNumbe)) {
				accLists.remove(acc);
				System.out.println("재등록 되었습니다.");
				break;
			}
		}
	}

	// 종료 시 lists의 계좌정보 file에 업데이트
	public void accountListSave() {
		try {
			// 리스트 정보를 담기위한 파일객체 생성
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/banking/account_info.obj"));

			// 리스트를 돌려서 하나씩 out객체에 담는다.
			for (Account acc : accLists) {
				out.writeObject(acc);

			}
			out.close();
		} catch (IOException e) {
			System.out.println("아이오 익셉션 발생~");
		}

	}
}
