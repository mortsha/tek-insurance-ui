package tek.insurance.app.utilities;

public class DataGenerator {
	
	public static void main(String[] args) {
			System.out.println(getEmail());
	}
	public static String getEmail() {
		String name = "smile";
		String provider = "@msh.ca";
		String num = "";
		for (int i = 0; i < 3; i++) {
			num += (int) (Math.random() * 10);
		}
		return name + num + provider;
	}

}
