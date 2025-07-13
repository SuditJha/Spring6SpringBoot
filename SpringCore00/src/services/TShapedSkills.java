package services;

public class TShapedSkills {
	
	private ICourse course;

	public TShapedSkills() {
		// TODO Auto-generated constructor stub
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	public boolean buyTheCourse(double amount) {
		course.getTheCourse(4999.0);
		return true;
		
	}
	

}
