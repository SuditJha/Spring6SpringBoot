package services;

public class TShapedSkills {
	
	private ICourse course;

	public TShapedSkills() {
		// TODO Auto-generated constructor stub
		System.out.println("TShaped Skill Bean");
	}

	public TShapedSkills(ICourse course) {
		super();
		System.out.println("Constructor Injection");
		this.course = course;
	}

	public void setCourse(ICourse course) {
		System.out.println("Setter 'Java' Injected");
		this.course = course;
		
	}
	
	public boolean buyTheCourse(double amount) {
		course.getTheCourse(4999.0);
		return true;
		
	}
	

}
