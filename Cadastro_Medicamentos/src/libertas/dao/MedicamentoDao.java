package libertas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import libertas.pojo.Medicamento;

public class MedicamentoDao {
	
	public void inserir(Medicamento m) {
	
		Conexao con = new Conexao();
		
		try {
			String sql = "INSERT INTO medicamentos (nome, marca, quantidade, data_fabricacao, data_validade, preco)"
					+ " VALUES (?,?,?,?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, m.getNome());
			prep.setString(2, m.getMarca());
			prep.setInt(3, m.getQuantidade());
			prep.setDate(4, m.getData_fabricacao());
			prep.setDate(5, m.getData_validade());
			prep.setDouble(6, m.getPreco());
			prep.execute();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	
	public void alterar(Medicamento m) {
		
		Conexao con = new Conexao();
		
		try {
			String sql = "UPDATE medicamentos SET nome=?, marca=?, quantidade=?, data_fabricacao=?, data_validade=?, preco=?"
					+ " WHERE id = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, m.getNome());
			prep.setString(2, m.getMarca());
			prep.setInt(3, m.getQuantidade());
			prep.setDate(4, m.getData_fabricacao());
			prep.setDate(5, m.getData_validade());
			prep.setDouble(6, m.getPreco());
			prep.setInt(7, m.getId());
			prep.execute();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	
	public void excluir(Medicamento m) {
		
		Conexao con = new Conexao();
		
		try {
			String sql = "DELETE FROM medicamentos WHERE id = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, m.getId());
			prep.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	
	public Medicamento consultar(int id) {
		
		Conexao con = new Conexao();
		Medicamento m = new Medicamento();
		
		try {
			String sql = "SELECT * FROM medicamentos WHERE id = " + id;
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				m.setId(res.getInt("id"));
				m.setNome(res.getString("nome"));
				m.setMarca(res.getString("marca"));
				m.setData_fabricacao(res.getDate("data_fabricacao"));
				m.setData_validade(res.getDate("data_validade"));
				m.setQuantidade(res.getInt("quantidade"));
				m.setPreco(res.getDouble("preco"));
				
			}
			
			res.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
		return m;
	}
	
	public LinkedList<Medicamento> listar(){
		
		Conexao con = new Conexao();
		LinkedList<Medicamento> listaMedicamento = new LinkedList<Medicamento>();
		
		try {
			String sql = "SELECT * FROM medicamentos";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Medicamento m = new Medicamento();
				m.setId(res.getInt("id"));
				m.setNome(res.getString("nome"));
				m.setMarca(res.getString("marca"));
				m.setData_fabricacao(res.getDate("data_fabricacao"));
				m.setData_validade(res.getDate("data_validade"));
				m.setQuantidade(res.getInt("quantidade"));
				m.setPreco(res.getDouble("preco"));
				listaMedicamento.add(m);
			}
			
			res.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
		return listaMedicamento;
	}

}
