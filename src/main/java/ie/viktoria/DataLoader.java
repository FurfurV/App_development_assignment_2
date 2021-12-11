package ie.viktoria;

import ie.viktoria.entities.OwnUser;
import ie.viktoria.entities.Student;
import ie.viktoria.service.INoteService;
import ie.viktoria.service.IStudentService;
import ie.viktoria.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Data
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    INoteService noteService;

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("R00000001","student@email.com","dummy","test");
        Student student2 = new Student("R00000002","student3@email.com","Prancer","deer");
        Student student3 = new Student("R00000003","rudolph@email.com","Rudolph","deer");
        Student student4 = new Student("R00000004","gingerbread@email.com","Gingerbread","Cookies");
        Student student5 = new Student("R00000005","crinkle@email.com","Crinkle","Cookies");

        Student student6 = new Student("R00000006","chocochip@email.com","Chocolate","Chip");
        Student student7 = new Student("R00000007","snickerdoodles@email.com","Snickerdoodles","Cookie");
        Student good_student = new Student("R00000008","student2@email.com","goodstudent","test2");

        Student grinch = new Student("R00000009","sample@email.com","Grinch","green");
        Student pudding = new Student("R00000010","whatever@email.com","christmas","pudding");

        studentService.shortSave(student1);
        studentService.shortSave(student2);
        studentService.shortSave(student3);
        studentService.shortSave(student4);
        studentService.shortSave(student5);
        studentService.shortSave(student6);
        studentService.shortSave(student7);
        studentService.shortSave(good_student);
        studentService.shortSave(grinch);
        studentService.shortSave(pudding);

        noteService.save(LocalDate.of(2021,8,4),"blahblah", student1);
        noteService.save(LocalDate.of(2021,10,9),"blahblahbla", student1);

        noteService.save(LocalDate.of(2021,8,4),"just some random notes", student2);
        noteService.save(LocalDate.of(2021,10,9),"just some random notes", student2);
        noteService.save(LocalDate.of(2021,10,9),"just some random notes", student2);

        noteService.save(LocalDate.of(2021,7,4),"just some more notes", student3);
        noteService.save(LocalDate.of(2021,7,4),"just some more notes", student3);

        noteService.save(LocalDate.of(2021,9,9),"mmmm cookies", student4);
        noteService.save(LocalDate.of(2021,9,9),"mmmm cookies", student4);

        noteService.save(LocalDate.of(2021,9,10),"Lorem ipsum dolor sit amet, consectetur adipiscing elit", student5);
        noteService.save(LocalDate.of(2021,9,10),"Lorem ipsum dolor sit amet, consectetur adipiscing elit", student5);
        noteService.save(LocalDate.of(2021,9,10),"Lorem ipsum dolor sit amet, consectetur adipiscing elit", student5);

        noteService.save(LocalDate.of(2021,12,15),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,16),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,17),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,18),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,19),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,20),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,20),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,20),"Stole the gifts", grinch);
        noteService.save(LocalDate.of(2021,12,20),"Stole the gifts", grinch);

        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);
        noteService.save(LocalDate.of(2021,12,11),"bad unfortunately", pudding);

        noteService.getAllNotes().forEach(System.out::println);
        noteService.getAllNotesFromStudent(student1.getStudentId()).forEach(System.out::println);
        noteService.getAllNotesFromStudent(grinch.getStudentId()).forEach(System.out::println);

        OwnUser mentorUser = new OwnUser("mentor@mtu.ie","password",
                "MENTOR","mentor","sampleUser");

        OwnUser reviewUser = new OwnUser("rev@mtu.ie","password",
                "REVIEWER","rev","reviewer");

        OwnUser apiUser = new OwnUser("api","password",
                "API","api","apiName");

        userService.save(mentorUser);
        userService.save(reviewUser);
        userService.save(apiUser);
    }
}
