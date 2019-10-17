package repositorio;

import modelo.TipoPiloto;

public interface IActualizarTipoPilotoRepo {

    boolean actualizar(TipoPiloto tipoPilotoDatosNuevos);

    TipoPiloto findByIdTipoPiloto(Integer id);
}
