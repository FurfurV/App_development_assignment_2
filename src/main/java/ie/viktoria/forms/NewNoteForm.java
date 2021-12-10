package ie.viktoria.forms;

import ie.viktoria.entities.Student;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Data
public class NewNoteForm {
    private int newNoteId;

    @Size(min=4, max=50)
    private String newNoteText;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotNull
    private String studentId;
}
