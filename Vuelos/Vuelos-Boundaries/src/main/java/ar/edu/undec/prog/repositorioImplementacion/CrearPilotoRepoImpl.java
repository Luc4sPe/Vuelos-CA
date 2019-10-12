package ar.edu.undec.prog.repositorioImplementacion;

import ar.edu.undec.prog.mapper.PilotoMapper;
import ar.edu.undec.prog.mapper.TipoPilotoMapper;
import ar.edu.undec.prog.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.ICrearPilotoCRUD;
import ar.edu.undec.prog.repositorioCRUD.ICrearTipoPilotoCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearPilotoRepo;

@Repository
public class CrearPilotoRepoImpl implements ICrearPilotoRepo {

    @Autowired
    ICrearPilotoCRUD crearPilotoCRUD;

    @Autowired
    ICrearTipoPilotoCRUD crearTipoPilotoCRUD;

    public boolean guardar(Piloto pilotoNuevo) {
        PilotoEntity elPilotoAGuardar=new PilotoMapper().mapeoCoreData(pilotoNuevo);
        if (pilotoNuevo.getTipoPiloto().getIdTipoPiloto()!=null)
            elPilotoAGuardar.setTipoPiloto(crearTipoPilotoCRUD.findByIdTipoPiloto(pilotoNuevo.getTipoPiloto().getIdTipoPiloto()));
        return crearPilotoCRUD.save(elPilotoAGuardar).getIdPiloto()!=null;
    }

    public Piloto findByDNI(String pDNI) {
        return null;
    }
}
