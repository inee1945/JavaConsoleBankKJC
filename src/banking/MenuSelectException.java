package banking;

public class MenuSelectException extends Exception{
	public MenuSelectException() {
		super("메뉴에 있는 숫자만 입력이 가능합니다.");
	}
}
