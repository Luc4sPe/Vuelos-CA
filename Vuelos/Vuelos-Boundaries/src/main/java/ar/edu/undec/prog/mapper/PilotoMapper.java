package ar.edu.undec.prog.mapper;

import ar.edu.undec.prog.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.ICrearTipoPilotoCRUD;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;

public class PilotoMapper {

    @Autowired
    ICrearTipoPilotoCRUD buscarTipoPilotoCRUD;

    public Piloto mapeoDataCore(PilotoEntity elPiloto) {
        try {
            return Piloto.factoryPiloto(elPiloto.getIdPiloto(),elPiloto.getApellido(),elPiloto.getNombre(),elPiloto.getDni(), TipoPiloto.factoryTipoPiloto(elPiloto.getTipoPiloto().getIdTipoPiloto(),elPiloto.getTipoPiloto().getDenominacion()));
        } catch (PilotoIncompletoException | TipoPilotoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PilotoEntity mapeoCoreData(Piloto pilotoCore) {
        PilotoEntity pilotoEntity = new PilotoEntity();
        pilotoEntity.setIdPiloto(pilotoCore.getIdPiloto());
        pilotoEntity.setNombre(pilotoCore.getNombre());
        pilotoEntity.setApellido(pilotoCore.getApellido());
        pilotoEntity.setDni(pilotoCore.getDni());
        if (pilotoCore.getTipoPiloto().getIdTipoPiloto() != null) {
            pilotoEntity.setTipoPiloto(buscarTipoPilotoCRUD.findByIdTipoPiloto(pilotoCore.getTipoPiloto().getIdTipoPiloto()));
        } else {
            pilotoEntity.setTipoPiloto(new TipoPilotoMapper().mapeoCoreData(pilotoCore.getTipoPiloto()));
        }
        return pilotoEntity;
    }
}
