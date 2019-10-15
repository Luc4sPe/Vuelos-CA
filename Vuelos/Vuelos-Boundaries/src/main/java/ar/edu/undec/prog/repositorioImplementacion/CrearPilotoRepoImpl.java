package ar.edu.undec.prog.repositorioImplementacion;

import ar.edu.undec.prog.mapper.PilotoMapper;
import ar.edu.undec.prog.mapper.TipoPilotoMapper;
import ar.edu.undec.prog.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.IBuscarPilotosPorDNI;
import ar.edu.undec.prog.repositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import ar.edu.undec.prog.repositorioCRUD.ICrearPilotoCRUD;
import ar.edu.undec.prog.repositorioCRUD.ICrearTipoPilotoCRUD;
import modelo.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearPilotoRepo;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

@Repository
public class CrearPilotoRepoImpl implements ICrearPilotoRepo {


    @Autowired
    ICrearPilotoCRUD crearPilotoCRUD;

    @Autowired
    IBuscarTipoPilotosPorDenominacionCRUD buscarTipoPilotosPorDenominacionCRUD;

    @Autowired
    IBuscarPilotosPorDNI buscarPilotosPorDNI;


    public boolean guardar(Piloto pilotoNuevo) {
        PilotoEntity elPilotoAGuardar=new PilotoMapper().mapeoCoreData(pilotoNuevo);
        return crearPilotoCRUD.save(elPilotoAGuardar).getIdPiloto()!=null;
    }

    public Piloto findByDNI(String pDNI) {
        return new PilotoMapper().mapeoDataCore(buscarPilotosPorDNI.findByDni(pDNI));
    }

    public PilotoEntity actualizar(Piloto elPiloto) {
        return crearPilotoCRUD.save(new PilotoMapper().mapeoCoreData(elPiloto));
    }
}
