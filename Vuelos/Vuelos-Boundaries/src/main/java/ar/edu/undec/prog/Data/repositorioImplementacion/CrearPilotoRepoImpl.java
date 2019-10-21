package ar.edu.undec.prog.Data.repositorioImplementacion;

import ar.edu.undec.prog.Data.mapper.PilotoMapper;
import ar.edu.undec.prog.Data.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.Data.repositorioCRUD.IBuscarPilotosPorDNI;
import ar.edu.undec.prog.Data.repositorioCRUD.ICrearPilotoCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearPilotoRepo;

@Repository
public class CrearPilotoRepoImpl implements ICrearPilotoRepo {


    @Autowired
    ICrearPilotoCRUD crearPilotoCRUD;

    @Autowired
    IBuscarPilotosPorDNI buscarPilotosPorDNI;

    @Override
    public boolean guardar(Piloto pilotoNuevo) {
        PilotoEntity elPilotoAGuardar=new PilotoMapper().mapeoCoreData(pilotoNuevo);
        return crearPilotoCRUD.save(elPilotoAGuardar).getIdPiloto()!=null;
    }

    @Override
    public Piloto findByDNI(String pDNI) {
        return new PilotoMapper().mapeoDataCore(buscarPilotosPorDNI.findByDni(pDNI));
    }
    
}
