package setsAndMaps;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class CourseList {

	Map<String, Collection<String>> courses = new HashMap<>();

	public void takeCourse(String student, String course) {
		Collection<String> studentCourses;

		if (student == null || course == null) 
			throw new IllegalArgumentException();



		if (courses.containsKey(student)) {
			studentCourses = courses.get(student);
			studentCourses.add(course);
			courses.put(student, studentCourses);
		}

		if (!(courses.containsKey(student))) {
			studentCourses = new HashSet<>();
			studentCourses.add(course);
			courses.put(student, studentCourses);
		}
	}

	public boolean isTakingCourse(String student, String course) {
		boolean takingCourse = false;

		if (student == null || course == null)
			throw new IllegalArgumentException();

		if (courses.containsKey(student)) {
			if (courses.get(student).contains(course))
				takingCourse = true;
		}
		return takingCourse;
	}

	public int numCoursesTaking(String student) {
		if (student == null)
			throw new IllegalArgumentException();
		
		if (courses.containsKey(student))
			return courses.get(student).size();

		return 0;
	}

	public int numEnrolled(String course) {
		int num = 0;
		if (course == null) 
			throw new IllegalArgumentException();
		
		for (String s: courses.keySet()) {
			if (courses.get(s).contains(course)){
				num++;
			}
		}
		return num;
	}

	public String mostPopularCourse() {
		String popular = null;
		int most = 0;
		for (String s: courses.keySet()) {
			for (String c: courses.get(s)) {
				if (numEnrolled(c) >= most) {
					most = numEnrolled(c);
					popular = c;
				}
			}
		}
		return popular;
	}

	public boolean dropCourse(String student, String course) {
		if (student == null || course == null)
			throw new IllegalArgumentException();
		
		if (courses.containsKey(student) && courses.get(student).contains(course)) {
			courses.get(student).remove(course);
			return true;
		}
		return false;
	}

}
