package Services;

import Model.Group;
import Model.Lesson;
import Model.Student;

import java.util.List;

public interface GroupService {
   void addGroup(String name, String description);
   Group getGroupByName(String name);
   Group updateName(String oldName,String newName);
   List<Group> getAllGroups();

   void addStudent(String name,String studentName,String lastName,String email,String password);
   Student updateStudent(String email,String password,String newName,String newLastName);
void  getAllStudents(String name);
Student findStudentByName(String name);
 String deleteStudent(String name );
 void addLesson(String name,String lessonName,String description);
 Lesson getLesson(String name);
 void getAllLesson(String name);
 String deleteLesson(String name);
String deleteGroup(String name);
void getAllStudentLesson(String email);

}
