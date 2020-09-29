public class Student 
{
	// Holds the student ID
	private String id;
	// Holds the student name
	private String name;
	// Holds how many questions they got correct to display results at end
	private int questionsCorrect;
	
	public Student(String id, String name)
	{
		this.setId(id);
		this.setName(name);
		this.setQuestionsCorrect(0);
	}

	public void gotCorrectAnswer()
	{
		questionsCorrect++;
	}
	
	/**
	 * @return the questionsCorrect
	 */
	public int getQuestionsCorrect() {
		return questionsCorrect;
	}
	/**
	 * @param questionsCorrect the questionsCorrect to set
	 */
	public void setQuestionsCorrect(int questionsCorrect) {
		this.questionsCorrect = questionsCorrect;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
