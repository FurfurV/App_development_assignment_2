package ie.viktoria.service;

import ie.viktoria.entities.Student;

import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
}
