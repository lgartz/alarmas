package co.com.system.negocio;

import java.util.Date;



public class FactorRetencion {

	private Long idFactorRetencion;

	private String lineaProducto;

	private String codigoFactor;

	private String usuario;

	private String descripcion;
	
	private Date fechaCreacion;

	private Boolean indicadorOperacional;

	private String indicadorIngresoEgresoEnum;

	private Boolean indicadorGrabado;

	private Integer porcentajeRetencionDeclarante;

	private Integer porcentajeRetencionNoDecl;

	private Boolean indicadorAplicaDividendos;

	
	public Long getIdFactorRetencion() {
		return idFactorRetencion;
	}

	public void setIdFactorRetencion(Long idFactorRetencion) {
		this.idFactorRetencion = idFactorRetencion;
	}

	
	public String getLineaProducto() {
		return lineaProducto;
	}

	public void setLineaProducto(String lineaProducto) {
		this.lineaProducto = lineaProducto;
	}

	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodigoFactor() {
		return codigoFactor;
	}

	public void setCodigoFactor(String codigoFactor) {
		this.codigoFactor = codigoFactor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getIndicadorOperacional() {
		return indicadorOperacional;
	}

	public void setIndicadorOperacional(Boolean indicadorOperacional) {
		this.indicadorOperacional = indicadorOperacional;
	}

	public String getIndicadorIngresoEgresoEnum() {
		return indicadorIngresoEgresoEnum;
	}

	public void setIndicadorIngresoEgresoEnum(
			String indicadorIngresoEgresoEnum) {
		this.indicadorIngresoEgresoEnum = indicadorIngresoEgresoEnum;
	}

	public Boolean getIndicadorGrabado() {
		return indicadorGrabado;
	}

	public void setIndicadorGrabado(Boolean indicadorGrabado) {
		this.indicadorGrabado = indicadorGrabado;
	}

	public Integer getPorcentajeRetencionDeclarante() {
		return porcentajeRetencionDeclarante;
	}

	public void setPorcentajeRetencionDeclarante(
			Integer porcentajeRetencionDeclarante) {
		this.porcentajeRetencionDeclarante = porcentajeRetencionDeclarante;
	}

	public Integer getPorcentajeRetencionNoDecl() {
		return porcentajeRetencionNoDecl;
	}

	public void setPorcentajeRetencionNoDecl(Integer porcentajeRetencionNoDecl) {
		this.porcentajeRetencionNoDecl = porcentajeRetencionNoDecl;
	}

	public Boolean getIndicadorAplicaDividendos() {
		return indicadorAplicaDividendos;
	}

	public void setIndicadorAplicaDividendos(Boolean indicadorAplicaDividendos) {
		this.indicadorAplicaDividendos = indicadorAplicaDividendos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}