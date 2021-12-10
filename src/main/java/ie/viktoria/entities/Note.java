package ie.viktoria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue
    private int noteId;
    @Column(nullable = false)
    private LocalDate noteDate;
    @Column(nullable = false)
    private String noteText;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student studentNote;

    public Note(LocalDate date, String text, Student studentNote) {
        this.noteDate = date;
        this.noteText = text;
        this.studentNote = studentNote;
    }

}
