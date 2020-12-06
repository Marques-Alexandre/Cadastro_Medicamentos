package libertas.model;

import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import libertas.dao.MedicamentoDao;
import libertas.pojo.Medicamento;

public class MedicamentoListar implements Modelo {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MedicamentoDao mdao = new MedicamentoDao();
			LinkedList<Medicamento> lista = mdao.listar();
			Gson gson = new Gson();
			
			//imprime o resultado da consulta no banco de dados:
			PrintWriter writer = response.getWriter();
			writer.print(gson.toJson(lista));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
