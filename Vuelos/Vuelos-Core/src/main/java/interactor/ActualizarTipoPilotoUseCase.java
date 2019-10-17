package interactor;

import modelo.TipoPiloto;
import repositorio.IActualizarTipoPilotoRepo;

public class ActualizarTipoPilotoUseCase {

    IActualizarTipoPilotoRepo actualizarTipoPilotoRepo;

    public ActualizarTipoPilotoUseCase(IActualizarTipoPilotoRepo actualizarTipoPilotoRepo) {
        this.actualizarTipoPilotoRepo = actualizarTipoPilotoRepo;
    }

    public boolean actualizarTipoPiloto(TipoPiloto tipoPilotoDatosNuevos){
        TipoPiloto tipoPilotoAModificar = actualizarTipoPilotoRepo.findByIdTipoPiloto(tipoPilotoDatosNuevos.getIdTipoPiloto());
        if (tipoPilotoAModificar!=null)
            {
            return this.actualizarTipoPilotoRepo.actualizar(tipoPilotoDatosNuevos);
        }
        return false;
    }


}
