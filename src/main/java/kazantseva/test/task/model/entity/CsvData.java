package kazantseva.test.task.model.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CsvData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @CsvBindByName(column = "State")
    private String state;

    @NotNull
    @CsvBindByName(column = "Name")
    private String name;

    @NotNull
    @Column(name = "institution_type")
    @CsvBindByName(column = "Institution Type")
    private String institutionType;

    @NotNull
    @CsvBindByName(column = "Phone Number")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @CsvBindByName(column = "Website")
    private String website;
}
