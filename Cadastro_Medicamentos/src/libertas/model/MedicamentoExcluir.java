package libertas.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import libertas.dao.MedicamentoDao;
import libertas.pojo.Medicamento;

public class MedicamentoExcluir implements Modelo {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MedicamentoDao mdao = new MedicamentoDao();
			
			Medicamento m = new Medicamento();
			m.setId(Integer.parseInt(request.getParameter("idmedicamento")));
			
			mdao.excluir(m);
			
			//imprime o resultado da consulta no banco de dados:
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.print(gson.toJson("ok"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
