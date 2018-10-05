package hr.fer.zemris.java.hw06.demo4;

/**
 * Class that represents a student records. Student record contains student's
 * jmbag, last name, first name, points the student achieved on his midterms,
 * finals and laboratories. Also contains student's final grade. Each student is
 * definitely diversed by his jmbag.
 * 
 * @author Dinz
 *
 */
public class StudentRecord implements Comparable<StudentRecord> {
	/**
	 * Jmbag of the student.
	 */
	private String jmbag;
	/**
	 * Last name of the student.
	 */
	private String lastName;
	/**
	 * First name of the student.
	 */
	private String firstName;
	/**
	 * Points student achieved on his midterm exam.
	 */
	private double midtermPoints;
	/**
	 * Points student achieved on his final exam.
	 */
	private double finalsPoints;
	/**
	 * Points student achieved on his laboratory practices.
	 */
	private double labPoints;
	/**
	 * Final grade student achieved.
	 */
	private int finalGrade;

	/**
	 * Constructs a new student record.
	 * 
	 * @param jmbag
	 *            Jmbag of the student.
	 * @param lastName
	 *            Last name of the student.
	 * @param firstName
	 *            First name of the student.
	 * @param midtermPoints
	 *            Student's midterm exam points.
	 * @param finalsPoints
	 *            Student's final exam points.
	 * @param labPoints
	 *            Student's laboratory practices points.
	 * @param finalGrade
	 *            Student's final grade.
	 */
	public StudentRecord(String jmbag, String lastName, String firstName, double midtermPoints, double finalsPoints,
			double labPoints, int finalGrade) {
		this.jmbag = jmbag;
		this.lastName = lastName;
		this.firstName = firstName;
		this.midtermPoints = midtermPoints;
		this.finalsPoints = finalsPoints;
		this.labPoints = labPoints;
		this.finalGrade = finalGrade;
	}

	/**
	 * Returns the student's jmbag.
	 * 
	 * @return Student's jmbag.
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Returns student's last name.
	 * 
	 * @return Student's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns student's first name.
	 * 
	 * @return Student's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns student's midterm points.
	 * 
	 * @return Student's midterm points.
	 */
	public double getMidtermPoints() {
		return midtermPoints;
	}

	/**
	 * Returns student's finals points.
	 * 
	 * @return Student's finals points.
	 */
	public double getFinalsPoints() {
		return finalsPoints;
	}

	/**
	 * Returns student's laboratory points.
	 * 
	 * @return Student's laboratory points.
	 */
	public double getLabPoints() {
		return labPoints;
	}

	/**
	 * Returns student's final grade.
	 * 
	 * @return Student's final grade.
	 */
	public int getFinalGrade() {
		return finalGrade;
	}

	/**
	 * Formats student's data to string.
	 */
	public String toString() {
		return "JMBAG: " + jmbag + " Last name: " + lastName + " First Name: " + firstName + " Midterm points: "
				+ midtermPoints + " Finals points: " + finalsPoints + " Lab points: " + labPoints + " Total points: "
				+ getTotalPoints() + " Final grade: " + finalGrade;
	}

	/**
	 * Calculates and returns student's total points.
	 * 
	 * @return Student's total points.
	 */
	public double getTotalPoints() {
		return this.midtermPoints + this.finalsPoints + this.labPoints;
	}

	/**
	 * Method that compares the students based on their jmbag's.
	 */
	@Override
	public int compareTo(StudentRecord other) {
		return this.jmbag.compareTo(other.getJmbag());
	}

}
