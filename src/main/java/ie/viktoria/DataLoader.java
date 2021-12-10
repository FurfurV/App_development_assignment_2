package ie.viktoria;

import ie.viktoria.dao.INoteDao;
import ie.viktoria.dao.IStudentDao;
import ie.viktoria.dao.IUserDao;
import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import ie.viktoria.entities.User;
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
//    need to remove them
    @Autowired
    IUserDao userDao;

    @Autowired
    IStudentDao studentDao;

    @Autowired
    INoteDao noteDao;
    //    need to remove them


    @Autowired
    INoteService noteService;

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        User testUser = new User("test@email.com","pass","role","fname","lname");
        testUser = userDao.save(testUser);
        System.out.println(testUser);

        User testUser2 = new User("test2@email.com","pass2","role2","fname2","lname2");
        testUser2 = userDao.save(testUser2);
        System.out.println(testUser2);

        Student student = new Student("R00123456","student@email.com","dummy","test");
        studentDao.save(student);
        Student student2 = new Student("R00124566","student2@email.com","dummyTwo","test2");
        studentDao.save(student2);

        System.out.println(userDao.count());
        System.out.println(userDao.findById("test@email.com"));
        System.out.println(userDao.findById("hmm").isPresent());

        Note good = new Note(LocalDate.of(2021,8,4),"blahblah", student);
        Note good2 = new Note(LocalDate.of(2021,10,9),"blahblahbla", student);
        noteDao.save(good);
        noteDao.save(good2);
//
        noteService.getAllNotes().forEach(System.out::println);
//
        noteService.getAllNotesFromStudent(student.getStudentId()).forEach(System.out::println);
    }
}
