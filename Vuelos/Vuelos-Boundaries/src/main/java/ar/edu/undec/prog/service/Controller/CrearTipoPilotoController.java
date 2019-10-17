package ar.edu.undec.prog.service.Controller;

import ar.edu.undec.prog.repositorioImplementacion.CrearTipoPilotoRepoImpl;
import ar.edu.undec.prog.service.ServiceMapper.TipoPilotoMapper;
import ar.edu.undec.prog.service.modeloService.TipoPilotoDTO;
import excepciones.TipoPilotoExisteException;
import input.ICrearTipoPilotoInput;
import interactor.CrearTipoPilotoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorio.ICrearTipoPilotoRepo;

@RequestMapping("/")
@RestController
public class CrearTipoPilotoController {

    private ICrearTipoPilotoInput crearTipoPilotoInput;

    public CrearTipoPilotoController(ICrearTipoPilotoInput crearTipoPilotoInput) {
        this.crearTipoPilotoInput = crearTipoPilotoInput;
    }


    @RequestMapping(value = "tipoPiloto", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearTipoPiloto(@RequestBody TipoPilotoDTO tipoPilotoDTO) {
        try {
            boolean resultado = this.crearTipoPilotoInput.crearTipoPiloto(new TipoPilotoMapper().mapeoDTOCore(tipoPilotoDTO));
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (TipoPilotoExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }


    /*

     private CrearAccionAdapter crearAccionAdapter;

    public CrearAccionController(CrearAccionAdapter crearAccionAdapter) {
        this.crearAccionAdapter = crearAccionAdapter;
    }

    @RequestMapping(value = "accion", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearTipoPiloto(@RequestBody TipoPilotoDTO TipoPilotoDTO){
        try {
            boolean resultado = this.crearAccionAdapter.crearTipoPiloto(TipoPilotoDTO);
            if(resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (AccionExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
     */

}
