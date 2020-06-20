package vo;

public class Question {
	private String numberone;
	private String numbertwo;
	private String operator;
	private String result;
	
	public Question() {
	}

	public Question(String numberone, String numbertwo, String operator, String result) {
		this.numberone = numberone;
		this.numbertwo = numbertwo;
		this.operator = operator;
		this.result = result;
	}

	public String getNumberone() {
		return numberone;
	}

	public void setNumberone(String numberone) {
		this.numberone = numberone;
	}

	public String getNumbertwo() {
		return numbertwo;
	}

	public void setNumbertwo(String numbertwo) {
		this.numbertwo = numbertwo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return numberone + operator + numbertwo + "=" + result;
	}
}

	