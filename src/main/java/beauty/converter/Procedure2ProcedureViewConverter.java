package beauty.converter;

import beauty.config.AppConfig;
import beauty.model.Procedure;
import beauty.view.ProcedureView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static beauty.helpers.DurationToString.getDurationAsString;

@Component
@RequiredArgsConstructor
public class Procedure2ProcedureViewConverter {

    @Autowired
    private final AppConfig config;

    public ProcedureView convert(Procedure procedure) {
        return ProcedureView.builder()
                .procedureType(procedure.getProcedureType())
                .procedureName(procedure.getProcedureName())
                .photoName(config.getServicePhotoPath() + "/" + procedure.getPhotoName())
                .duration(getDurationAsString(procedure.getDuration()))
                .price(procedure.getPrice())
                .build();
    }
}
