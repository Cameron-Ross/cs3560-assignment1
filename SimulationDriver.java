import java.util.*;
public class SimulationDriver 
{

	public static void main(String[] args)
	{
		// create random students and questions
		int numStudents = (int)(Math.random() * 29) + 2;
		int numQuestions = (int)(Math.random() * 8) + 3;
		Student[] students = generateRandomStudents(numStudents);
		Question[] questions = generateRandomQuestions(numQuestions);
		
		
		VotingService service = new VotingService(students, questions);
		Play(service);
		
	}
	
	private static void Play(VotingService service)
	{
		// loop through all questions
		for(int i = 0; i < service.getQuestions().length; i++)
		{
			// Display the Question
			service.AskQuestion();
			
			// Submit Student Answers
			boolean singleSolution = service.getQuestions()[i].getAnswer().length() == 1;
			for(int j = 0; j < service.getStudents().length; j++)
			{
				service.SubmitSolution(getRandomSolution(singleSolution), service.getStudents()[j]);
			}
			
			System.out.println();
			
			// Loop through students again, 30% chance they change answer
			for(int j = 0; j < service.getStudents().length; j++)
			{
				if(Math.random() < .3)
				{
					service.SubmitSolution(getRandomSolution(singleSolution), service.getStudents()[j]);
				}
			}
			
			// End the question
			service.EndQuestion();
		}
	}
	
	// all the below methods help generate random students, questions, and student solutions
	private static Student[] generateRandomStudents(int number)
	{
		Student[] students = new Student[number];
		
		for(int i = 0; i < students.length; i++)
		{
			// for simplicity sake, the unique id will match the index
			Student student = new Student("" + i, getRandomName());
			students[i] = student;
		}
		
		return students;
	}
	
	private static Question[] generateRandomQuestions(int number)
	{
		Question[] questions = new Question[number];
		
		for(int i = 0; i < questions.length; i++)
		{
			boolean singleAnswer = Math.random() > .5;
			questions[i] = createQuestion(singleAnswer);
		}
		
		return questions;
	}

	private static String getRandomName()
	{
		String[] names = {"Michael", "Christopher", "Jessica", "Matthew", "Ashley", "Jennifer",
						 "Joshua", "Amanda","Daniel","David","James","Robert","John" ,"Joseph",
						 "Andrew","Ryan","Brandon","Jason","Justin","Sarah","William","Jonathan",
						 "Stephanie","Brian","Nicole","Nicholas","Anthony","Heather","Eric",
						 "Elizabeth", "Adam"};
		
		int random = (int)(Math.random() * names.length);
		return names[random];
	}
	
	private static Question createQuestion(boolean singleAnswer)
	{
		Question question;
		
		if(singleAnswer)
		{
			int a = (int)(Math.random() * 13) + 1;
			int b = (int)(Math.random() * 13) + 1;
			
			String prompt = "What is " +  a + " x " + b + "?";
			
			String choices = "A) " + (a*b) +
						   "\nB) " + (a*(b+1)) + 
						   "\nC) " + (a*(b-1)) + 
						   "\nD) " + (a*(b+2));
			
			String answer = "A";
			
			question = new SingleSolutionQuestion(prompt, choices, answer);
		}
		else
		{
			int a = (int)(Math.random() * 101);
			String prompt = "Select all numbers greater than " + a;
			
			String choices = "A) " + (a + (int)(Math.random() * 10)) +
						     "\nB) " + (a + (int)(Math.random() * 10) + 1) + 
						     "\nC) " + (a - (int)(Math.random() * 10)) + 
						     "\nD) " + (a - (int)(Math.random() * 10));
			
			String answer = "AB";
			
			question = new MultipleSolutionQuestion(prompt, choices, answer);
		}
		
		return question;
	}
	
	private static String getRandomSolution(boolean singleAnswer)
	{
		if(singleAnswer) 
		{
			String[] options = {"A", "A", "B", "C", "D"}; // twice as likely to get right answer
			return options[(int)(Math.random() * options.length)];
		}
		else
		{
			String a = (Math.random() < .8) ? "A" : "";
			String b = (Math.random() < .8) ? "B" : "";
			String c = (Math.random() < .25) ? "C" : "";
			String d = (Math.random() < .25) ? "D" : "";
			return a+b+c+d;
		}
	}
	
}
