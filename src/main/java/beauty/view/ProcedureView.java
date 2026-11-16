package beauty.view;

import beauty.enums.ProcedureType;
import lombok.*;

@Builder
@Getter
public class ProcedureView {

    private ProcedureType procedureType;
    private String procedureName;
    private Integer price;
    private String duration;
    private String photoName;
}
