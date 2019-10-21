package ar.edu.undec.prog.Data.repositorioImplementacion;

import ar.edu.undec.prog.Data.mapper.PilotoMapper;
import ar.edu.undec.prog.Data.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.Data.repositorioCRUD.IBuscarPilotosPorNombreCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IBuscarPilotosPorNombreRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BuscarPilotosPorNombreRepoImpl implements IBuscarPilotosPorNombreRepo {
    @Autowired
    IBuscarPilotosPorNombreCRUD iBuscarPilotosPorNombreCRUD;

    public Collection<Piloto> buscarPilotosPorNombre(String nombrePiloto) {
        List<Piloto> pilotosBuscados = new ArrayList<>();
        for (PilotoEntity elPiloto : iBuscarPilotosPorNombreCRUD.findByNombreContains(nombrePiloto)) {
            Piloto piloto = new PilotoMapper().mapeoDataCore(elPiloto);
            pilotosBuscados.add(piloto);
        }
        return pilotosBuscados;
    }
}
