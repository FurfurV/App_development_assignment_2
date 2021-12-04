package ie.viktoria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;

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
    private int id;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String text;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Student studentNote;

    public Note(String date, String text, Student studentNote) {
        this.date = date;
        this.text = text;
        this.studentNote = studentNote;
    }


}
