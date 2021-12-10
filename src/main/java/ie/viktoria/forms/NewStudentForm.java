package ie.viktoria.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Data
public class NewStudentForm {
    @NotNull
    @Size(min=9, max=9)
    private String newStudentId;

    @Size(min=4, max=50)
    @Email
    private String newStudentEmail;

    @Size(min=2, max=50)
    private String newStudentFirstName;

    @Size(min=2, max=50)
    private String newStudentLastName;
}
