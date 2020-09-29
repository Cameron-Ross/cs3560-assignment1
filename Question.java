public abstract class Question 
{
	private String prompt;
	private String choices;
	private String answer;
	
	
	public Question(String prompt, String choices, String answer)
	{
		this.prompt = prompt;
		this.choices = choices;
		this.answer = answer;
	}
	
	public abstract boolean checkSolution(String solution);
	
	public void displayPrompt()
	{
		System.out.println(prompt);
		System.out.println(choices);
	}

	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}
	

}
