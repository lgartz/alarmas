package co.com.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import co.com.system.negocio.FactorRetencion;

/**
 * Servlet implementation class RetencionServlet
 */
@WebServlet("/RetencionServlet")
public class RetencionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetencionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        
		  JSONObject obj = new JSONObject();
		  LinkedList l1 = getFactoresHash(obtenerXDato());
		  obj.put("rows", l1);	        
		  
		  String jsonString = obj.toJSONString();
		  System.out.println(jsonString);		  
          response.getWriter().write(jsonString);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
 
        JSONObject obj = new JSONObject();
        obj.put("data", "Creado exitosamente");	
        String jsonString = obj.toJSONString();
        System.out.println(json);
        response.setContentType("text/plain");
        response.getWriter().write(jsonString);
	}
	
	private LinkedList getFactoresHash(List<FactorRetencion> list)
	{
		LinkedList l = new LinkedList();
		for(FactorRetencion f : list)
		{
			LinkedHashMap m1 = new LinkedHashMap();
			 m1.put("OrderID",f.getCodigoFactor());
			 m1.put("Descripcion",f.getDescripcion());
			 m1.put("IndicadorIE", f.getIndicadorIngresoEgresoEnum());			 
			 m1.put("IndicadorO",f.getIndicadorOperacional());
			 m1.put("RetencionND",f.getPorcentajeRetencionNoDecl());
			 m1.put("RetencionD", f.getPorcentajeRetencionDeclarante());			 
			 m1.put("AplicaD",f.getIndicadorAplicaDividendos());
			 l.add(m1);
		}
		
		return l;
		
		
	}

	private List<FactorRetencion> obtenerXDato()
	{
		List<FactorRetencion> l = new ArrayList<FactorRetencion>();
		
		for(Integer i=0; i<=100;i++)
		{
			FactorRetencion f = new FactorRetencion();
			f.setCodigoFactor(i.toString());
			f.setDescripcion("Descripcion del factor nro "+i.toString() );
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
