package vo;


public class Student {
	private int count;
	private String name;
	private double score;
	private String time;
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student() {
		super();
	}
	
	public Student(int count, String name, double score , String time) {
		this.name = name;
		this.count = count;
		this.time = time;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return count + "\t" + name + "\t" + score + "\t" + time;
	}



	
}
