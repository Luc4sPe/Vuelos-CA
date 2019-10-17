package ar.edu.undec.prog.service.ServiceMapper;

import ar.edu.undec.prog.service.modeloService.TipoPilotoDTO;
import excepciones.TipoPilotoIncompletoException;
import modelo.TipoPiloto;

public class TipoPilotoMapper {

    public TipoPilotoDTO mapeoCoreDTO(TipoPiloto tipoPilotoCore) {
        TipoPilotoDTO elTipo = new TipoPilotoDTO(tipoPilotoCore.getIdTipoPiloto(),tipoPilotoCore.getDenominacion());
//        elTipo.setIdTipoPiloto(tipoPilotoCore.getIdTipoPiloto());
//        elTipo.setDenominacion(tipoPilotoCore.getDenominacion());
        return elTipo;

    }

    public TipoPiloto mapeoDTOCore(TipoPilotoDTO elTipoPiloto) {
        try {
            return TipoPiloto.factoryTipoPiloto(elTipoPiloto.getIdTipoPiloto(), elTipoPiloto.getDenominacion());
        } catch (TipoPilotoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
