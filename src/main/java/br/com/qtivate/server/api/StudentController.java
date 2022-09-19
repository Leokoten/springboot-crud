package br.com.qtivate.server.api;

import br.com.qtivate.server.model.Response;
import br.com.qtivate.server.model.Student;
import br.com.qtivate.server.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Response addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new Response("Success", "Succesfully added student " + student.getName(), 200);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id) {
        return studentService.getStudentById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public Response updateStudentById(@PathVariable("id") UUID id, @RequestBody Student student) {
        if (studentService.updateStudentById(id, student) == 0)
            return new Response("Error", "Student not found", 400);
        return new Response("Success", "Successfully updated student", 200);
    }

    @DeleteMapping(path = "{id}")
    public Response deleteStudentById(@PathVariable("id") UUID id) {
        if (studentService.deleteStudentById(id) == 0)
            return new Response("Error", "Student not found", 400);
        return new Response("Success", "Successfully deleted student", 200);
    }
}
