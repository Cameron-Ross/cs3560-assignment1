public class SingleSolutionQuestion extends Question 
{

	public SingleSolutionQuestion(String prompt, String choices, String answer) 
	{
		super(prompt, choices, answer);
	}

	@Override
	public boolean checkSolution(String solution) 
	{
		return getAnswer().toLowerCase().contains(solution.toLowerCase());
	}
}
