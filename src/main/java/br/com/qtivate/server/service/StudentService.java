package br.com.qtivate.server.service;

import br.com.qtivate.server.dao.StudentDao;
import br.com.qtivate.server.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }

    public int updateStudentById(UUID id, Student student) {
        return studentDao.updateStudentById(id, student);
    }

    public int deleteStudentById(UUID id) {
        return studentDao.deleteStudentById(id);
    }
}
