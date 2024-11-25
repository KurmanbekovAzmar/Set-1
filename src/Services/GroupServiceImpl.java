package Services;

import Model.*;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService {
    private Database database;

    public Database getDatabase() {
        return database;
    }

    public GroupServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addGroup(String name, String description) {
        List<Student> students = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();
        Group group = new Group(GeneratedId.groupid(),name, description, students, lessons);
        database.getGroups().add(group);
        System.out.println(group);

    }

    @Override
    public Group getGroupByName(String name) {
        for (Group g : database.getGroups()) {
            if (g.getName().equals(name)) {
                return g;
            }
        }
        return null;        }

    @Override
    public Group updateName(String oldName, String newName) {
        for (Group group1 : database.getGroups()) {
            if (group1.getName().equals(oldName)) {
                group1.setName(newName);
                System.out.println("Группанын жаны аты  " + newName);

                return group1;

            }

        }
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return database.getGroups();
    }

    @Override
    public void addStudent(String name, String studentName, String lastName, String email, String password) {
        Student student = new Student(GeneratedId.studentId(),studentName, lastName, email, password);
        for (Group n : database.getGroups()) {
            if (n.getName().equals(name)) {
                n.getStudents().add(student);
                System.out.println("Cтудент успешно добавлен");
            }
        }
    }

    @Override
    public Student updateStudent(String email, String password, String newName, String newLastName) {
        for (Group s : database.getGroups()) {
            for (Student students : s.getStudents()) {

                    if (students.getEmail().equals(email) && students.getPassword().equals(password)) {

                    students.setName(newName);
                    students.setLastName(newLastName);
                    return students;
                }


            }
        }return null;
    }

    @Override
    public void getAllStudents(String name) {
        for (Group g: database.getGroups()) {
            if (g.getName().equals(name)) {
                System.out.println(g.getStudents());
            }

        }
    }

    @Override
    public Student findStudentByName(String name) {
        for (Group g:database.getGroups()) {
            for (Student s:g.getStudents()) {
                if (s.getName().equals(name)){
                    return s;
                }

            }

        }
        return null;
    }

    @Override
    public String deleteStudent(String name) {
        for (Group g : database.getGroups()) {
            for (Student s : g.getStudents()) {
                if (s.getName().equals(name)) {
                    g.getStudents().remove(s);
                }
return "Студент "+ name + " ийгиликту очурулду";
            }

        }
return null;
    }

    @Override
    public void addLesson(String name, String lessonName, String description) {
  Lesson lesson = new Lesson(GeneratedId.lessonid(),lessonName,description);
        for (Group g:database.getGroups()) {
         if (g.getName().equals(name)){
            g.getLessons().add(lesson);
             System.out.println("Сабак ийгиликту кошулду");
         }


        }
    }

    @Override
    public Lesson getLesson(String name) {
        for (Group g:database.getGroups()) {
            for (Lesson l:g.getLessons()){
                if (l.getName().equals(name)){
                    return l;
                }
            }
        }
        return null;
    }

    @Override
    public void getAllLesson(String name) {
        for (Group g: database.getGroups()){
            if (g.getName().equals(name)){
                System.out.println(g.getLessons());
            }
        }

    }

    @Override
    public String deleteLesson(String name) {
        for (Group g :database.getGroups()) {
            for (Lesson l:g.getLessons()) {
                if (l.getName().equals(name)){
                    g.getLessons().remove(l);
                }
                return "Студент "+ name + " ийгиликту очурулду";

            }
        }
        return null;
    }

    @Override
    public String deleteGroup(String name) {
        try{
            for (Group g:database.getGroups()){
                if (g.getName().equals(name)){
                    database.getGroups().remove(g);
                    return name + " деген группа очурулду ";
                }
            }
            return "Мындай группа жок";
        } catch (Exception e){
           return e.getMessage();
        }
    }

    @Override
    public void getAllStudentLesson(String email) {
        for (Group g: database.getGroups()) {
            for (Student s: g.getStudents()) {
                if (s.getEmail().equals(email)){
                    System.out.println(g.getLessons());
                }

            }
        }

    }


}




