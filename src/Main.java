import Model.Admin;
import Model.Database;
import Model.Group;
import Services.GroupServiceImpl;
import Services.SignImpl;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2= new Scanner(System.in);
        Scanner scanner3= new Scanner(System.in);


        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("bekturakylbekov@gmail.com", "bektur2004"));

        ArrayList<Group> groups = new ArrayList<>();

        Database database = new Database(admins, groups);


        SignImpl l = new SignImpl(database);
        l.sign(admins);

        System.out.println("1. Войти ");
        System.out.println("2. Забыли пароль?");

        int a = scanner.nextInt();
        switch (a) {

            case 1:

                while (true) {
                    System.out.println("почтанызды жазыныз ");
                    String email = scanner1.nextLine();
                    System.out.println("Пароль жазыныз ");
                    String pasword = scanner1.nextLine();
                    String result = l.voity(email, pasword);
                    if (result.equals("Succes")) {
                        System.out.println(result);
                        break;
                    } else {
                        System.out.println(result);
                    }
                }

                while (true) {
                    System.out.println("1. add new group");
                    System.out.println("2. Get group by Name");
                    System.out.println("3. update group name");
                    System.out.println("4. get all groups");
                    System.out.println("5. Add new student to group");
                    System.out.println("6. update student");
                    System.out.println("7. Find student by first name");
                    System.out.println("8. Get all students by group name ");
                    System.out.println("9. Delete student by name");
                    System.out.println("10. Add new lesson to group");
                    System.out.println("11. Get lesson by name");
                    System.out.println("12. Get all lesson by group name");
                    System.out.println("13. delete lesson");
                    System.out.println("14. delete group");
                    System.out.println("15. getAllStudentLesson");
                    int b = scanner.nextInt();
                    GroupServiceImpl m = new GroupServiceImpl(database);

                    switch (b) {
                        case 1: {

                            System.out.println("Группанын атын жазыныз ");
                            String name = scanner1.nextLine();
                            System.out.println("Описание жазыныз ");
                            String desk = scanner1.nextLine();
                            m.addGroup(name, desk);
                        }
                        break;
                        case 2: {
                            System.out.println("Группанын атын жазыныз");
                            String n = scanner1.nextLine();
                            System.out.println(m.getGroupByName(n));
                        }
                        break;
                        case 3: {
                            System.out.println("Кайсыл группанын атын озгорконду каалайсыз");
                            String oldName = scanner1.nextLine();
                            System.out.println("Жаны ат жазыныз");
                            String newName = scanner1.nextLine();

                            System.out.println(m.updateName(oldName, newName));
                        }
                        break;
                        case 4: {
                            System.out.println(m.getAllGroups());
                        }
                        break;
                        case 5: {
                            System.out.println("Группаннын атын жазыныз");
                            String groupName = scanner2.nextLine();
                            System.out.println("Студенттин атын жазыныыз ");
                            String studentName = scanner2.nextLine();
                            System.out.println("Студенттин Фамилиясын жазыныыз ");
                            String lastName = scanner2.nextLine();
                            System.out.println("Почтасын жазыныз ");
                            String semail = scanner2.nextLine();
                            System.out.println("Пароль жазыныз ");
                            String password = scanner2.nextLine();

                            m.addStudent(groupName, studentName, lastName, semail, password);
                        break;}
                        case 6:{
                            System.out.println("Студенттин почтасын жазыныз");
                            String log = scanner3.nextLine();
                            System.out.println("пароль");
                            String pas = scanner3.nextLine();
                            System.out.println("Жаны ат жазыныз");
                            String newName = scanner3.nextLine();
                            System.out.println("Фамилия жазыныз");
                            String newLastname = scanner3.nextLine();
                            System.out.println(m.updateStudent(log, pas, newName, newLastname));
                        break;}
                        case 7:{
                            System.out.println("Студенттин атын жазыныз");
                            String name = scanner3.nextLine();
                            System.out.println(m.findStudentByName(name));
                        break;}
                        case 8:{
                            System.out.println("Кайсыл группанын студентерин коргонду калайсыз");
                            String get=scanner3.nextLine();
                            m.getAllStudents(get);
                        break;}
                        case 9:{
                            System.out.println("кайсыл студенти очургунуз келип жатат");
                            String delete=scanner3.nextLine();
                            System.out.println(m.deleteStudent(delete));
                            break; }
                        case 10:{
                            System.out.println("Кайсыл группага кошуну калайсыз атын жазыныз");
                            String grName= scanner3.nextLine();
                            System.out.println("Сабактын атын жазыныз");
                            String name = scanner3.nextLine();
                            System.out.println("Сабактын суроттомосун жазыныз");
                            String desc= scanner3.nextLine();
                            m.addLesson(grName,name,desc);
                        break;}
                        case 11:{
                            System.out.println("Сабактын атын жазыныз");
                            String name = scanner3.nextLine();
                            System.out.println(m.getLesson(name));
                        break;}
                        case 12:{
                            System.out.println("Группанын атын жазыныз");
                            String grName =scanner3.nextLine();
                            m.getAllLesson(grName);
                       break; }
                        case 13:{
                            System.out.println("Сабактын атын жазыныз");
                            String lessonName= scanner3.nextLine();
                            System.out.println(m.deleteLesson(lessonName));
                        break;}
                        case 14:{
                            System.out.println("Кайсыл группаны очуруну калайсыз");
                            String grName=scanner3.nextLine();
                            System.out.println(m.deleteGroup(grName));
                        break;}
                        case 15:{
                            System.out.println("Студентин почтасын жазыныз");
                            String email =scanner3.nextLine();
                            m.getAllStudentLesson(email);
                       break; }

                    }

                }
        }

    }
}