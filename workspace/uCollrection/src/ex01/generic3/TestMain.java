package ex01.generic3;

class Car{}
class Tv{}

class Product<T, M>{
	T kind; //Tv t
	M model;//
	
	
	
	public Product() {}
	public Product(T kind, M model) {
		
		this.kind = kind;
		this.model = model;
	}
	
	
}
//상속
class NewProduct<T,M,C> extends Product<T,M>{
	C color;

	public NewProduct(T kind, M model, C color) {
		
		super(kind, model);
		this.kind = kind;
		this.model = model;
		this.color = color;
	}
	

}

public class TestMain {
	public static void main(String[] args) {
		Product <Tv, String> p1 = new  Product<Tv, String>();
		p1.kind = new Tv();
		p1.model = "스마트 Tv";
		
		Car d520 = new Car();
		Product <Car, String> p2 = new Product<>();
		p2.kind = d520;
		p2.model = "벤츠 520D";
		
		NewProduct<Car, String, Integer> np1 = new NewProduct<>(d520,"520d", 0xffffff);
		
	}
}
