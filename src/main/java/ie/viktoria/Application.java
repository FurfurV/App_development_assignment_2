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

import java.time.LocalDate;

@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
