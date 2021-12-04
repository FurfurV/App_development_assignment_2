package ie.viktoria;

import ie.viktoria.dao.INoteDao;
import ie.viktoria.dao.IStudentDao;
import ie.viktoria.dao.IUserDao;
import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import ie.viktoria.entities.User;
import ie.viktoria.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    IUserDao userDao;

    @Autowired
    IStudentDao studentDao;

    @Autowired
    INoteDao noteDao;

    @Autowired
    NoteService noteService;

    @Override
    public void run(String... args) throws Exception {
        User testUser = new User("test@email.com","pass","role","fname","lname");
        testUser = userDao.save(testUser);
        System.out.println(testUser);

        User testUser2 = new User("test2@email.com","pass2","role2","fname2","lname2");
        testUser2 = userDao.save(testUser2);
        System.out.println(testUser2);

        Student student = new Student("student@email.com","student","test");
        studentDao.save(student);

        System.out.println(userDao.count());
        System.out.println(userDao.findById("test@email.com"));
        System.out.println(userDao.findById("hmm").isPresent());

        Note good = new Note("2021-11-10","blahblah", student);
        Note good2 = new Note("2021-10-9","blahblahbla", student);
        noteDao.save(good);
        noteDao.save(good2);

        noteService.getAllNotes().forEach(System.out::println);
    }
}
