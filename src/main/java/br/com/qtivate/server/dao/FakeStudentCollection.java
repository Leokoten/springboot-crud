package br.com.qtivate.server.dao;

import br.com.qtivate.server.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDb")
public class FakeStudentCollection implements StudentDao {

    private static final List<Student> db = new ArrayList<>();
    @Override
    public int insertStudent(UUID id, Student student) {
        db.add(new Student(id, student.getRA(), student.getName()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return db;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateStudentById(UUID id, Student student) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (studentMaybe.isEmpty()) return 0;
        Student newStudent = new Student(
                studentMaybe.get().getId(),
                student.getRA(),
                student.getName());
        db.set(db.indexOf(studentMaybe.get()), newStudent);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID id) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (studentMaybe.isEmpty()) return 0;
        db.remove(studentMaybe.get());
        return 1;
    }
}
