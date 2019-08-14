package code.D_14_08.Enum;

public class Main_Enum {

	public static void main(String[] args) {
		Cars cars[] = new Cars[10];
		String Models[] = { "Lamborgini", "porche", "Mclarane", "Ferrari", "Buggate", "Verone", "Tesla", "Maruti",
				"Hundayi", "Honda" };
//		System.out.println(Level.values().toString());
		for (Level l : Level.values()) {
			Cars c = new Cars();
//			System.out.println(l);
			int m = (int) Math.ceil(Math.random() * 5);
			int n = (int) Math.floor(Math.random() * 10);
			c.createCars(l, Models[n]);
			System.out.println(c.getCar());
			
		}
//		Level.values()
//		car.createCars(Level.AWESOM, "Lamborgini");
//		System.out.println(car.getCar());

	}

}
