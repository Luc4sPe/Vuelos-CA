package ar.edu.undec.prog.Service.Config;

import interactor.CrearTipoPilotoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorio.ICrearTipoPilotoRepo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private ICrearTipoPilotoRepo iCrearTipoPilotoRepo;

    @Bean
    public CrearTipoPilotoUseCase crearTipoPilotoUseCase(){
        return new CrearTipoPilotoUseCase(iCrearTipoPilotoRepo);
    }

}
