package co.com.system.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/factorRetencion")
public class FactorRetencionAction {

	@GET
	@Path("/getListFactorRetencion")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FactorRetencion> getListFactorRetencion() {
		return obtenerXDato();
	}
	
	@GET
	@Path("/getFactorRetencion")
	@Produces(MediaType.APPLICATION_JSON)
	public FactorRetencion getFactorRetencion() {
		FactorRetencion f = new FactorRetencion();
		f.setIdFactorRetencion(123L);
		f.setCodigoFactor("123");
		f.setDescripcion("Descripcion del factor nro 123");
		f.setIndicadorIngresoEgresoEnum("Ingreso");
		f.setIndicadorOperacional(true);
		f.setPorcentajeRetencionNoDecl(96);
		f.setPorcentajeRetencionDeclarante(4);
		f.setIndicadorAplicaDividendos(false);
		return f;
	}
	
	@GET
	@Path("/getFactorRetencionResponse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFactorRetencionResponse() {
		FactorRetencion f = new FactorRetencion();
		f.setIdFactorRetencion(123L);
		f.setCodigoFactor("123");
		f.setDescripcion("Descripcion del factor nro 123");
		f.setIndicadorIngresoEgresoEnum("Ingreso");
		f.setIndicadorOperacional(true);
		f.setPorcentajeRetencionNoDecl(96);
		f.setPorcentajeRetencionDeclarante(4);
		f.setIndicadorAplicaDividendos(false);
		return  Response.status(200).entity(f).build();
	}
	
	
	

	private List<FactorRetencion> obtenerXDato() {
		List<FactorRetencion> l = new ArrayList<FactorRetencion>();

		for (Integer i = 0; i <= 100; i++) {
			FactorRetencion f = new FactorRetencion();
			f.setCodigoFactor(i.toString());
			f.setDescripcion("Descripcion del factor nro " + i.toString());
			f.setIndicadorIngresoEgresoEnum("Ingreso");
			f.setIndicadorOperacional(true);
			f.setPorcentajeRetencionNoDecl(96);
			f.setPorcentajeRetencionDeclarante(4);
			f.setIndicadorAplicaDividendos(false);

			l.add(f);
		}

		return l;
	}
}
