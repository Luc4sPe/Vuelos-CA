package ar.edu.undec.prog.Data.repositorioCRUD;

import ar.edu.undec.prog.Data.modeloEntity.PilotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuscarPilotosPorNombreCRUD extends CrudRepository<PilotoEntity,Integer> {

    List<PilotoEntity> findByNombreContains(String nombre);
}
