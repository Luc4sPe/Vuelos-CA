package ar.edu.undec.prog.mapper;

import ar.edu.undec.prog.modeloEntity.TipoPilotoEntity;
import ar.edu.undec.prog.repositorioCRUD.IBuscarTipoPilotosPorDenominacionCRUD;
import excepciones.TipoPilotoIncompletoException;
import modelo.TipoPiloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class TipoPilotoMapper {


    public TipoPilotoEntity mapeoCoreData(TipoPiloto tipoPilotoCore) {
        TipoPilotoEntity elTipo = new TipoPilotoEntity();
        elTipo.setIdTipoPiloto(tipoPilotoCore.getIdTipoPiloto());
        elTipo.setDenominacion(tipoPilotoCore.getDenominacion());
        return elTipo;

    }

    public TipoPiloto mapeoDataCore(TipoPilotoEntity elTipoPiloto) {
        try {
            return TipoPiloto.factoryTipoPiloto(elTipoPiloto.getIdTipoPiloto(), elTipoPiloto.getDenominacion());
        } catch (TipoPilotoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
