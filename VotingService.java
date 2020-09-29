public class VotingService 
{
	// holds students in service
	private Student[] students;
	// holds all questions to be asked
	private Question[] questions; 
	// holds a list of students answers for current question.
	// solutions are removed at the start of new question.
	private String[] solutions; 
	// says the question we are on
	private int currentQuestion; 
	
	public VotingService(Student[] students, Question[] questions)
	{
		this.setStudents(students);
		this.setQuestions(questions);
		currentQuestion = 0;
	}
	
	public void AskQuestion()
	{
		// Display the question
		System.out.println();
		getQuestions()[currentQuestion].displayPrompt();
		System.out.println();
		
		// Empty the solutions array from the previous question
		this.setSolutions(new String[students.length]);
	}

	public void SubmitSolution(String solution, Student student)
	{
		int index = Integer.parseInt(student.getId());
		boolean resubmittion = solutions[index] != null;
		
		if(resubmittion)
		{
			System.out.println(student.getName() + " has changed their answer to: " + solution);
		}
		else
		{
			System.out.println(student.getName() + " has answered: " + solution);
		}
		
		solutions[index] = solution;
	}
	
	public void EndQuestion()
	{
		System.out.println("\nThe answer was: " + questions[currentQuestion].getAnswer() + "\n");
		
		// give a student a point if their final answer was correct
		for(int i = 0; i < solutions.length; i++)
		{
			if(questions[currentQuestion].checkSolution(solutions[i]))
			{
				// Indexes Match
				students[i].gotCorrectAnswer();
				System.out.println(students[i].getName() + " got it right!");
			}
		}
		
		// Display Stats
		int[] stats = getSubmissionStats();
		System.out.println("A -> " + stats[0] + 
						 "\nB -> " + stats[1] +
						 "\nC -> " + stats[2] +
						 "\nD -> " + stats[3]);
		
		// Increase the current question
		currentQuestion++;
		
		
		System.out.println("-----------------------------------------");
		
		// display the winner if we are at the end of the game
		if(currentQuestion == questions.length) DisplayWinnerForGame();
		
	}

	private void DisplayWinnerForGame()
	{
		int highestScore = -1;
		String winner = "";
		for(Student s : students)
		{
			if(s.getQuestionsCorrect() > highestScore)
			{
				winner = s.getName();
				highestScore = s.getQuestionsCorrect();
			}
			else if(s.getQuestionsCorrect() == highestScore)
			{
				winner += (" and " + s.getName());
			}	
		}
		System.out.println(winner + " won!");
	}
	
	private int[] getSubmissionStats()
	{
		int[] stats = new int[4];
		for(int i = 0; i < solutions.length; i++)
		{
			stats[0] += getCharCount(solutions[i], 'A');
			stats[1] += getCharCount(solutions[i], 'B');
			stats[2] += getCharCount(solutions[i], 'C');
			stats[3] += getCharCount(solutions[i], 'D');
		}
		return stats;
	}
	
	private int getCharCount(String s, char c)
	{
		s = s.toLowerCase();
		c = Character.toLowerCase(c);
		int x = 0;
		for(int i = 0; i< s.length(); i++)
		{
			if(s.charAt(i) == c) x++;
		}
		return x;
	}
	
	/**
	 * @return the students
	 */
	public Student[] getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(Student[] students) {
		this.students = students;
	}

	/**
	 * @return the questions
	 */
	public Question[] getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	/**
	 * @return the currentQuestion
	 */
	public int getCurrentQuestion() {
		return currentQuestion;
	}

	/**
	 * @param currentQuestion the currentQuestion to set
	 */
	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	/**
	 * @return the solutions
	 */
	public String[] getSolutions() {
		return solutions;
	}

	/**
	 * @param solutions the solutions to set
	 */
	public void setSolutions(String[] solutions) {
		this.solutions = solutions;
	}

	
}
