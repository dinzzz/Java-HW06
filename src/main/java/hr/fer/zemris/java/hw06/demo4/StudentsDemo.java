package hr.fer.zemris.java.hw06.demo4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class that demonstrate the use of collection streams with the use of
 * available student records. The class demonstrates filtering, collecting and
 * mapping student records. Student records are uploaded from the "studenti.txt"
 * file located in the main project directory.
 * 
 * @author Dinz
 *
 */
public class StudentsDemo {
	/**
	 * Main method that executes the program.
	 * 
	 * @param args
	 *            Arguments from the command line.
	 */
	public static void main(String[] args) {

		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("./studenti.txt"));
		} catch (IOException e) {
			System.out.println("No such file.");
			System.exit(0);
		}

		List<StudentRecord> records = convert(lines);

		System.out.println("Number of students with more then 25 total points: " + vratiBodovaViseOd25(records));

		System.out.println("Number of students with the highest grade: " + vratiBrojOdlikasa(records));

		System.out.println("\nStudents with the highest grade:");
		for (StudentRecord student : vratiListuOdlikasa(records)) {
			System.out.println(student);
		}

		System.out.println("\nStudents with the highest grade sorted by total points:");
		for (StudentRecord student : vratiSortiranuListuOdlikasa(records)) {
			System.out.println(student);
		}

		System.out.println("\nStudents who failed the subject:");
		for (StudentRecord student : vratiPopisNepolozenih(records)) {
			System.out.println(student);
		}

		Map<Integer, List<StudentRecord>> mapGrades = razvrstajStudentePoOcjenama(records);
		System.out.println("\n Students grouped by grades:");
		{
			for (int i = 1; i <= 5; i++) {
				System.out.println("\nGrade: " + i);
				for (StudentRecord student : mapGrades.get(i)) {
					System.out.println(student);
				}
			}
		}

		Map<Integer, Integer> mapGradeCount = vratiBrojStudenataPoOcjenama(records);
		for (int i = 1; i <= 5; i++) {
			System.out.println("\nBroj studenata s ocjenom " + i + ": " + mapGradeCount.get(i));
		}

		Map<Boolean, List<StudentRecord>> mapPass = razvrstajProlazPad(records);
		System.out.println("\nStudents who have failed:");
		for (StudentRecord student : mapPass.get(false)) {
			System.out.println(student);
		}
		System.out.println("\nStudents who have passed:");
		for (StudentRecord student : mapPass.get(true)) {
			System.out.println(student);
		}

	}

	/**
	 * Converts a list of string inputs to student records.
	 * 
	 * @param lines
	 *            Lines of string inputs.
	 * @return List of student records.
	 */
	private static List<StudentRecord> convert(List<String> lines) {
		List<StudentRecord> list = new ArrayList<>();
		for (String line : lines) {
			String[] split = line.trim().split("\\s+");
			list.add(new StudentRecord(split[0], split[1], split[2], Double.parseDouble(split[3]),
					Double.parseDouble(split[4]), Double.parseDouble(split[5]), Integer.parseInt(split[6])));
		}
		return list;
	}

	/**
	 * Method that returns the number of students who achieved more then 25 total
	 * points.
	 * 
	 * @param records
	 *            List of student records.
	 * @return Number of students who achieved more then 25 total points.
	 */
	private static long vratiBodovaViseOd25(List<StudentRecord> records) {
		return records.stream().filter(s -> s.getMidtermPoints() + s.getFinalsPoints() + s.getLabPoints() > 25).count();
	}

	/**
	 * Method that returns the number of students who achieved the highest grade.
	 * 
	 * @param records
	 *            List of student records.
	 * @return Number of students with the highest grade.
	 */
	private static long vratiBrojOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(s -> s.getFinalGrade() == 5).count();
	}

	/**
	 * Method that returns the list of students who achieved the highest grade.
	 * 
	 * @param records
	 *            List of student records.
	 * @return List of students who achieved the highest grade.
	 */
	private static List<StudentRecord> vratiListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(s -> s.getFinalGrade() == 5).collect(Collectors.toList());
	}

	/**
	 * Method that returns the list of students who achieved the highest grade,
	 * sorted descending by total points.
	 * 
	 * @param records
	 *            List of student records.
	 * @return List of students who achieved the highest grade.
	 */
	private static List<StudentRecord> vratiSortiranuListuOdlikasa(List<StudentRecord> records) {
		return records.stream().filter(s -> s.getFinalGrade() == 5)
				.sorted((s2, s1) -> Double.compare(s1.getTotalPoints(), s2.getTotalPoints()))
				.collect(Collectors.toList());
	}

	/**
	 * Method that returns the list of students who failed the subject, sorted by
	 * their JMBAG's.
	 * 
	 * @param records
	 *            List of student records.
	 * @return List of students who failed the subject.
	 */
	private static List<StudentRecord> vratiPopisNepolozenih(List<StudentRecord> records) {
		return records.stream().filter(s -> s.getFinalGrade() == 1).sorted((s1, s2) -> s1.compareTo(s2))
				.collect(Collectors.toList());
	}

	/**
	 * Method that returns the students mapped by their final grades.
	 * 
	 * @param records
	 *            List of student records.
	 * @return Map that organised students by their final grades.
	 */
	private static Map<Integer, List<StudentRecord>> razvrstajStudentePoOcjenama(List<StudentRecord> records) {
		return records.stream().collect(Collectors.groupingBy(StudentRecord::getFinalGrade));
	}

	/**
	 * Method that returns the number of students mapped by the final grades.
	 * 
	 * @param records
	 *            List of student records.
	 * @return Map that counted and stored number of each final grade.
	 */
	private static Map<Integer, Integer> vratiBrojStudenataPoOcjenama(List<StudentRecord> records) {
		return records.stream()
				.collect(Collectors.toMap(StudentRecord::getFinalGrade, s -> 1, (s1, s2) -> s1 = s1 + s2));
	}

	/**
	 * Method that returns students organised by the criteria of passing the
	 * subject.
	 * 
	 * @param records
	 *            List of student records.
	 * @return Map that organised students based on their passing of the subject.
	 */
	private static Map<Boolean, List<StudentRecord>> razvrstajProlazPad(List<StudentRecord> records) {
		return records.stream().collect(Collectors.partitioningBy(s -> s.getFinalGrade() > 1));
	}
}
