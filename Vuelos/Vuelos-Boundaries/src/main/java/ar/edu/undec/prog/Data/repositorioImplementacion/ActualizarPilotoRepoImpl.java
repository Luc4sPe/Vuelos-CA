package ar.edu.undec.prog.Data.repositorioImplementacion;

import modelo.Piloto;
import org.springframework.stereotype.Service;
import repositorio.IActualizarPilotoRepo;

@Service
public class ActualizarPilotoRepoImpl implements IActualizarPilotoRepo {


    @Override
    public boolean guardar(Piloto pilotoDatosNuevos) {
        return false;
    }

    @Override
    public Piloto findByDNI(String dni) {
        return null;
    }
}
