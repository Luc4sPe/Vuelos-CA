package ar.edu.undec.prog.Data.repositorioCRUD;

import ar.edu.undec.prog.Data.modeloEntity.PilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearPilotoCRUD extends CrudRepository <PilotoEntity, Integer> {
}
