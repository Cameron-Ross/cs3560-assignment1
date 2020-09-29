import java.util.*;

public class MultipleSolutionQuestion extends Question
{

	public MultipleSolutionQuestion(String prompt, String choices, String answer) 
	{
		super(prompt, choices, answer);
	}

	@Override
	public boolean checkSolution(String solution) 
	{
		// get answers and sort them
		char[] answers = getAnswer().toCharArray();
		Arrays.sort(answers);
		
		// get solutions, remove spaces and commas, sort them
		String s = solution.replace(" ", "").replace(",", "");
		char[] solutions = s.toCharArray();
		Arrays.sort(solutions);
		
		// check if solutions match answers
		if(solutions.length != answers.length) return false;
		for(int i = 0; i < solutions.length; i++)
		{
			if(solutions[i] != answers[i]) return false;
		}
		
		return true;
	}

}
