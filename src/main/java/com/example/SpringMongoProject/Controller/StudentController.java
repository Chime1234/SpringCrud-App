package com.example.SpringMongoProject.Controller;
import com.example.SpringMongoProject.Entity.Student;
import com.example.SpringMongoProject.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;
    @PostMapping(value = "/save")
    public String saveStudent(@RequestBody Student students)
    {
        studentServices.saveorUpdate(students);
        return students.get_id();
    }
    @GetMapping(value = "/getAll")
    public Iterable<Student>getStudents()
    {
        return studentServices.listAll();
    }
    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name="id")String _id)
    {
        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }
    @GetMapping(value = "/pagination/{offset}/{pageSize}")
    public Iterable<Student>getStudents(@PathVariable int offset, @PathVariable int pageSize)
    {
        return studentServices.findStudentWithPagination(offset, pageSize);
    }
    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id )
    {

        studentServices.deleteStudent(_id);
    }
    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name="id")String studentid)
    {
        return  studentServices.getStudentByID(studentid);
    }

}
