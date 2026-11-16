package beauty.service;

import beauty.converter.Procedure2ProcedureViewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import beauty.repository.ProcedureRepository;
import beauty.view.ProcedureView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureService {
    private final ProcedureRepository repository;
    private final Procedure2ProcedureViewConverter converter;

    public List<ProcedureView> getAllProcedure() {
        return repository.findAll().stream()
                .map(converter::convert)
                .toList();
    }
}
