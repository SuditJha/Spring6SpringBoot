package services;

public class Java implements ICourse {

	public Boolean getTheCourse(Double price) {
		System.out.println("Buying Java Boot worth " + price);
		return true;
	}

}
