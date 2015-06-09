package co.com.system.negocio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

@Path("/factorRetencionCrud")
public class FactorRetencionCrud {

	@POST
	@Path("/crear/{id}/{name}")
	public Response crearFactor(@PathParam("id") String id,@PathParam("name") String name) {
		System.out.println("Crear algo del id: "+id+" y nombre: "+name);
		return Response.status(200).entity("ok crado").build();
	}
	
	@POST	
	@Path("/crearfactor")
	@Consumes("application/json")
	@Produces("application/json")
	public JSONObject crearFactor(FactorRetencion factorRetencion) {
		System.out.println("Crear 2 factorRetencion del id: "+factorRetencion.getIdFactorRetencion()+" y codigoFactor: "+factorRetencion.getCodigoFactor());
		JSONObject obj = new JSONObject();
	    obj.put("data", "Creado exitosamente");
	    
		return obj;
	}
	
//	@POST
//	@Path("/crearfactor")
//	@Consumes("application/json")
//	public Response crearFactor(FactorRetencion factorRetencion) {
//		System.out.println("Crear 2 factorRetencion del id: "+factorRetencion.getIdFactorRetencion()+" y codigoFactor: "+factorRetencion.getCodigoFactor());
//		return Response.status(200).entity("ok crado : "+factorRetencion).build();
//	}

}
