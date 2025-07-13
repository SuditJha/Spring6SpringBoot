package services;

public class SpringBoot implements ICourse {
	
	public SpringBoot() {
		System.out.println("Spring Boot Bean");
	}

	public Boolean getTheCourse(Double price) {
		// TODO Auto-generated method stub
		System.out.println("Buying Spring Boot worth " + price);
		return true;
	}

}
