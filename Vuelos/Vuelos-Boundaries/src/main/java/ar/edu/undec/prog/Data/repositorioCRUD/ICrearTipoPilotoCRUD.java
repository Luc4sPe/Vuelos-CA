package ar.edu.undec.prog.Data.repositorioCRUD;

import ar.edu.undec.prog.Data.modeloEntity.TipoPilotoEntity;
import modelo.TipoPiloto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearTipoPilotoCRUD extends CrudRepository <TipoPilotoEntity, Integer> {
    TipoPilotoEntity findByIdTipoPiloto(Integer id);
    TipoPilotoEntity findByDenominacion(String denominacion);
}
