package services;

public class Java implements ICourse {
	
	public Java() {
		System.out.println("Java Bean Created");
	}
	public Boolean getTheCourse(Double price) {
		System.out.println("Buying Java Boot worth " + price);
		return true;
	}

}
