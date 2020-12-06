package libertas.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import libertas.dao.MedicamentoDao;
import libertas.pojo.Medicamento;

public class MedicamentoConsultar implements Modelo {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MedicamentoDao mdao = new MedicamentoDao();
			
			int idmedicamento = Integer.parseInt(request.getParameter("idmedicamento"));
			
			Medicamento m = mdao.consultar(idmedicamento);
			Gson gson = new Gson();
			
			//imprime o resultado da consulta no banco de dados:
			PrintWriter writer = response.getWriter();
			writer.print(gson.toJson(m));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
