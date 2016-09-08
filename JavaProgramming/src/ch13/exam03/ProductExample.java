package ch13.exam03;

public class ProductExample {

	public static void main(String[] args) {
		Product<String,String> p1 = new Product<>();
		
		p1.setKind("Tv");
		p1.setModel("스마트");
		
		String kind = p1.getKind();
		String model = p1.getModel();
		
		
		Product<Tv,String> p2 = new Product<>();
		p2.setKind(new Tv());
		p2.setModel(model);
		Tv p3 = p2.getKind();
		String p4 = p2.getModel();
		
	}

}
