package ar.edu.undec.prog.Service.modeloService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoPilotoDTO {

    @JsonProperty("idTipoPiloto")
    private Integer idTipoPiloto;
    @JsonProperty("denominacion")
    private String denominacion;

    public TipoPilotoDTO(@JsonProperty("idTipoPiloto") Integer idTipoPiloto,
                         @JsonProperty("denominacion") String denominacion) {

        this.idTipoPiloto = idTipoPiloto;
        this.denominacion = denominacion;
    }

    public Integer getIdTipoPiloto() {
        return idTipoPiloto;
    }

    public void setIdTipoPiloto(Integer idTipoPiloto) {
        this.idTipoPiloto = idTipoPiloto;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    /*
       @JsonProperty("idAccion")
    public final Integer idAccion;

    @JsonProperty("nombre")
    public String nombre;

    @JsonCreator
    public AccionDTO(@JsonProperty("idAccion") Integer idAccion,
                     @JsonProperty("nombre") String nombre) {
        this.idAccion = idAccion;
        this.nombre = nombre.toUpperCase();
    }
    */
}
