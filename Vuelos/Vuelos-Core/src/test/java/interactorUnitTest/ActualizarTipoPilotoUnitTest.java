package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.TipoPilotoExisteException;
import excepciones.TipoPilotoIncompletoException;
import interactor.ActualizarTipoPilotoUseCase;
import modelo.TipoPiloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IActualizarTipoPilotoRepo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarTipoPilotoUnitTest {

    @Mock
    IActualizarTipoPilotoRepo actualizarTipoPilotoRepo;

    @Test
    public void actualizarTipoPiloto_TipoPilotoActualizadoCorrectamente() throws TipoPilotoIncompletoException, TipoPilotoExisteException {
        TipoPiloto tipoPilotoActualizar=TipoPiloto.factoryTipoPiloto(1,"Comandanteeee");
        when(actualizarTipoPilotoRepo.findByIdTipoPiloto(1)).thenReturn(TipoPiloto.factoryTipoPiloto(1,"Comandante"));
        when(actualizarTipoPilotoRepo.actualizar(tipoPilotoActualizar)).thenReturn(true);

        ActualizarTipoPilotoUseCase actualizarTipoPilotoUseCase = new ActualizarTipoPilotoUseCase(actualizarTipoPilotoRepo);
        boolean resultado=actualizarTipoPilotoUseCase.actualizarTipoPiloto(tipoPilotoActualizar);
        Assertions.assertTrue(resultado);
    }
}
