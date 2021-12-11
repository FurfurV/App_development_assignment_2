package ie.viktoria.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Data
public class SearchStudentForm {
    @NotNull
    @Size(min=9, max=9)
    private String newStudentId;
}
