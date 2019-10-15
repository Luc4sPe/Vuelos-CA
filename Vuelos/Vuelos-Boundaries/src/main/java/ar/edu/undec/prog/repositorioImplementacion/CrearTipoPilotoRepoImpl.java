package ar.edu.undec.prog.repositorioImplementacion;

import ar.edu.undec.prog.mapper.TipoPilotoMapper;
import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import ar.edu.undec.prog.repositorioCRUD.ICrearTipoPilotoCRUD;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.ICrearTipoPilotoRepo;

@Repository
public class CrearTipoPilotoRepoImpl implements ICrearTipoPilotoRepo {

    @Autowired
    ICrearTipoPilotoCRUD crearTipoPilotoCRUD;

    @Autowired
    IBuscarTipoPilotosPorDenominacionCRUD buscarTipoPilotosPorDenominacionCRUD;

    @Override
    public boolean guardar(TipoPiloto tipoPilotoNuevo) {
        TipoPilotoEntity elTipoPilotoAGuardar = new TipoPilotoMapper().mapeoCoreData(tipoPilotoNuevo, buscarTipoPilotosPorDenominacionCRUD);
        return crearTipoPilotoCRUD.save(elTipoPilotoAGuardar).getIdTipoPiloto()!=null;
    }

    @Override
    public TipoPiloto findByIdTipoPiloto(Integer id){
        TipoPilotoEntity elTipoPilotoEntity = crearTipoPilotoCRUD.findByIdTipoPiloto(id);
        return new TipoPilotoMapper().mapeoDataCore(elTipoPilotoEntity);
    }

    @Override
    public TipoPiloto findByDenominacion(String denominacion) {
        return null;
    }
}
