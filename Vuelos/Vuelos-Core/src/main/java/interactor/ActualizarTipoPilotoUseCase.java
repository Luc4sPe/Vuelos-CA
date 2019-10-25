package interactor;

import excepciones.TipoPilotoExisteException;
import modelo.TipoPiloto;
import repositorio.IActualizarTipoPilotoRepo;

import java.util.ArrayList;
import java.util.Collection;

public class ActualizarTipoPilotoUseCase {

    IActualizarTipoPilotoRepo actualizarTipoPilotoRepo;

    public ActualizarTipoPilotoUseCase(IActualizarTipoPilotoRepo actualizarTipoPilotoRepo) {
        this.actualizarTipoPilotoRepo = actualizarTipoPilotoRepo;
    }

    public boolean actualizarTipoPiloto(TipoPiloto tipoPilotoDatosNuevos) throws TipoPilotoExisteException {
        TipoPiloto tipoPilotoAModificar = actualizarTipoPilotoRepo.findByDenominacion(tipoPilotoDatosNuevos.getDenominacion());
        if (tipoPilotoAModificar == null) {
            return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
        } else if (tipoPilotoAModificar.getIdTipoPiloto() != tipoPilotoDatosNuevos.getIdTipoPiloto()) {
            throw new TipoPilotoExisteException();
        } else {
            return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
        }
    }

}
