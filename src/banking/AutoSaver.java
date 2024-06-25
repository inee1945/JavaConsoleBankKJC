package banking;

 class AutoSaver extends Thread {

	public AutoSaver() {
		
	}
	@Override
	public void run() {
		try {
			while(true) {
			//	am.saveInfoTxt();
				
				
				System.out.println("자동저장중입니다");
				Thread.sleep(3000);
			}
		}
		catch (InterruptedException e) {
		}
	}
}