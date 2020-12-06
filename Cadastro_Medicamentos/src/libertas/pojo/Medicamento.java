package libertas.pojo;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Medicamento {
	private int id;
	private String nome;
	private String marca;
	private int quantidade;
	private Date data_fabricacao;
	private Date data_validade;
	private double preco;
	private String dataFabricacaoFormatada;
	private String dataValidadeFormatada;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
		
	public Date getData_fabricacao() {
		return data_fabricacao;
	}
	public String getDataFabricacaoFormatada() {
		return dataFabricacaoFormatada;
	}
	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dataFabricacaoFormatada = sdf.format(data_fabricacao);
	}
	public Date getData_validade() {
		return data_validade;
	}
	public String getDataValidadeFormatada() {
		return dataValidadeFormatada;
	}
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dataValidadeFormatada = sdf.format(data_validade);
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
