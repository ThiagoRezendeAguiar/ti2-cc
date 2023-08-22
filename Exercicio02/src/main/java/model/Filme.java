package model;

public class Filme {
	   private int codigo;
	   private String nome;
	   private String genero;
	   private float avaliacao;
	   
	   public Filme() {
		   this.codigo = -1;
		   this.nome = " ";
		   this.genero = " ";
		   this.avaliacao = -1;
	   }
	   
	   public Filme(int codigo, String nome, String genero, float avaliacao) {
		   this.codigo = codigo;
		   this.nome = nome;
		   this.genero = genero;
		   this.avaliacao = avaliacao;
	   }
	   
	   public int getCodigo() {
		   return codigo;
	   }
	   
	   public void setCodigo(int codigo) {
		   this.codigo = codigo;
	   }
	   
	   public String getNome() {
		   return nome;
	   }
	   
	   public void setNome(String nome) {
		   this.nome = nome;
	   }
	   
	   public String getGenero() {
		   return genero;
	   }
	   
	   public void setGenero(String genero) {
		   this.genero = genero;
	   }
	   
	   public float getAvaliacao() {
		   return avaliacao;
	   }
	   
	   public void setAvaliacao(float avaliacao) {
		   this.avaliacao = avaliacao;
	   }
	   
	   public String toString() {
			return "\nFilme [codigo = " + codigo + ", nome = " + nome + ", avaliacao = " + avaliacao + ", genero = " + genero + "]\n";
		}	
	}


