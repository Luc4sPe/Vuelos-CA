package ar.edu.undec.prog.Data.repositorioCRUD;

import ar.edu.undec.prog.Data.modeloEntity.PilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuscarPilotosPorDNI extends CrudRepository<PilotoEntity, Integer> {
    PilotoEntity findByDni(String documento);
}
