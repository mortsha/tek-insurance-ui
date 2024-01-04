package tek.insurance.app.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class DataGenerator {
	public static void main(String[] args) {
		DataGenerator data = new DataGenerator();
		System.out.println(data.getEmail1());
		System.out.println(data.getAddressLine());
		System.out.println(data.getZipeCode());
		System.out.println(data.zipcode());
		System.out.println("PhoneNumber " + data.getPhoneNumber());
		System.out.println("License: " + data.getLicensePlate());
	}

	private Faker faker;

	public static String getEmail() {
		String name = "smile";
		String provider = "@msh.ca";
		String num = "";
		for (int i = 0; i < 4; i++) {
			num += (int) (Math.random() * 10);
		}
		return name + num + provider;
	}


	public DataGenerator() {
		this.faker = new Faker();
	}

	public String getFirstName() {

		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getEmail1() {
		String firstName = getFirstName();
		String lastName = getLastName();
		return firstName + "_" + lastName + "@smile.ca";
	}

	public String getJobTitle() {
		return faker.job().position();
	}

	public Date getDateOfBirth() {
		Date date = faker.date().birthday();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		try {
			return formatter.parse(formattedDate);
		} catch (ParseException e) {
			throw new RuntimeException("Date parse Exception");
		}
	}

	public String getExtension() {
		return faker.phoneNumber().extension();
	}

	public String getPhoneNumber() {
		Random random = new Random();
		String phone = "2";
		for (int i = 0; i < 9; i++) {
			int num = random.nextInt(9);
			phone += num;
		}
		return phone;
	}

	public String getLicensePlate() {
		Random random = new Random();
		StringBuilder licensePlate = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			char letter = (char) ('A' + random.nextInt(28));
			licensePlate.append(letter);
		}
		licensePlate.append('-');

		for (int i = 0; i < 3; i++) {
			int number = random.nextInt(9);
			licensePlate.append(number);
		}

		return licensePlate.toString();
	}

	public String getAddressLine() {
		return faker.address().streetAddressNumber().concat(" ").concat(faker.address().streetName());
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getState() {
		return faker.address().state();
	}

	public String getZipeCode() {
		Random random = new Random();
		String nums = "";
		for (int i = 0; i < 5; i++) {
			int randomNum = random.nextInt(9);
			nums += randomNum;
		}
		return nums;
	}

	public String zipcode() {
		return faker.address().zipCode();
	}

	public String formatPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10) {
			String areaCode = phoneNumber.substring(0, 3);
			String firstPart = phoneNumber.substring(3, 6);
			String secondPart = phoneNumber.substring(6, 10);
			return String.format("(%s) %s-%s", areaCode, firstPart, secondPart);
		} else {
			return "Invalid phone number";
		}

	}
}
