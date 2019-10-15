package ar.edu.undec.prog.mapper;

import ar.edu.undec.prog.modeloEntity.PilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.IBuscarPilotosPorDNI;
import ar.edu.undec.prog.repositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import excepciones.PilotoIncompletoException;
import excepciones.TipoPilotoIncompletoException;
import modelo.Piloto;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class PilotoMapper {


    public PilotoEntity mapeoCoreData(Piloto pilotoCore) {
            PilotoEntity pilotoEntity = new PilotoEntity();
            pilotoEntity.setIdPiloto(pilotoCore.getIdPiloto());
            pilotoEntity.setNombre(pilotoCore.getNombre());
            pilotoEntity.setApellido(pilotoCore.getApellido());
            pilotoEntity.setDni(pilotoCore.getDni());
            pilotoEntity.setTipoPiloto(new TipoPilotoMapper().mapeoCoreData(pilotoCore.getTipoPiloto()));
            return pilotoEntity;

    }

    public Piloto mapeoDataCore(PilotoEntity elPiloto) {
        try {
            return Piloto.factoryPiloto(elPiloto.getIdPiloto(),elPiloto.getApellido(),elPiloto.getNombre(),elPiloto.getDni(), TipoPiloto.factoryTipoPiloto(elPiloto.getTipoPiloto().getIdTipoPiloto(),elPiloto.getTipoPiloto().getDenominacion()));
        } catch (PilotoIncompletoException | TipoPilotoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }


}
