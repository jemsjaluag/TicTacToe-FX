import Game.Referee;

public class TestClass {
	
	public static void main(String[] args) {
		
		Referee r = new Referee();
		
		r.scan();
		
		boolean b = r.getResult();
		System.out.println(b);
		
	}
}
