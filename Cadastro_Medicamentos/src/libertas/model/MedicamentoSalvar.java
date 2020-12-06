package libertas.model;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import libertas.dao.MedicamentoDao;
import libertas.pojo.Medicamento;

public class MedicamentoSalvar implements Modelo {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MedicamentoDao mdao = new MedicamentoDao();
			
			Medicamento m = new Medicamento();
			
			m.setId(Integer.parseInt(request.getParameter("idmedicamento")));
			m.setNome(request.getParameter("nome"));
			m.setMarca(request.getParameter("marca"));
			m.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			m.setData_fabricacao(Date.valueOf(request.getParameter("data_fabricacao")));
			m.setData_validade(Date.valueOf(request.getParameter("data_validade")));
			m.setPreco(Double.parseDouble(request.getParameter("preco")));
			
			if (m.getId()==0) {
				mdao.inserir(m);
			} else {
				mdao.alterar(m);
			}
			
			//imprime o resultado da consulta no banco de dados:
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.print(gson.toJson("ok"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
