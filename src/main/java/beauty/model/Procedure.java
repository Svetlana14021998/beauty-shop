package beauty.model;

import beauty.enums.ProcedureType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "procedures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "procedure_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProcedureType procedureType;

    @Column(name = "procedure_name", nullable = false)
    private String procedureName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "photo_name")
    private String photoName;
}
