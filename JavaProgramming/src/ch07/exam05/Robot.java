package ch07.exam05;

public class Robot extends Machine{
	
	
	@Override
	void work() {
		// TODO Auto-generated method stub
		System.out.println("Robot-work() 실행");
		super.work();
	}
	
	/*public final void powerOn(){
		 System.out.println("전원을 연결합니다"); 
	 }*/
}
