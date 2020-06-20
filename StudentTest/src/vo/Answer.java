package vo;

public class Answer {
	private int answer;

	public Answer() {
	}

	public Answer(int result) {
		this.answer = result;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int result) {
		this.answer = result;
	}
	

	@Override
	public String toString() {
		return String.valueOf(answer);
	}
}
