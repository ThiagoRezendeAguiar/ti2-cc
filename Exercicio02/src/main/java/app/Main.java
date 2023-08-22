package app;
import dao.FilmeDAO;
import model.Filme;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		FilmeDAO db = new FilmeDAO();
		 Filme filme = new Filme ();
		
		 if (db.conectar()) {
	            boolean status = true;

	            while (status) {
	                int op = menu();

	                switch (op) {
	                    case 1:
	                        System.out.println(db.listar());
	                        break;
	                    case 2:
	                    	System.out.println("\n\n==== Inserir filme ===\n\n");
	                    	
	                    	System.out.println("Digite as informações desse filme:");
	                    	
	                    	System.out.print("Código: ");
	                    	filme.setCodigo(scanner.nextInt());
	                    	
	                    	infos(filme);
	                    	
	                    	if(db.insert(filme) == true) 
	                    		System.out.println("\nInserção feita com sucesso -> " + filme.toString() + "\n\n");
	                        break;
	                    case 3:
	                    	System.out.println("\n\n==== Excluir filme ===\n\n");
	                        
	                    	System.out.print("Digite o código do filme: ");
	                        filme.setCodigo(scanner.nextInt());
	                        
	                        System.out.println("\n\n==== Excluir filme (código " + filme.getCodigo() + ") ===\n\n");
	                		
	                        if(db.delete(filme.getCodigo()) == true) 
	                			System.out.println("Filme excluido com sucesso\n\n");
	                		else
	                			System.out.println("ERRO -> Não foi pssível excluir esse Filme\n\n");
	                        break;
	                    case 4:
	                    	System.out.println("\n\n==== Atualizar filme ===\n\n");
	                    	
	                    	System.out.println("Digite as novas informações desse filme:");
	                    	
	                    	System.out.print("Código: ");
	                        filme.setCodigo(scanner.nextInt());
	                        
	                        infos(filme);
	                        
	                        if(db.update(filme) == true)
	                        	System.out.println("Filme atualizado com sucesso\n\n");
	                        else
	                			System.out.println("ERRO -> Não foi pssível atualizar esse Filme\n\n");
	                        break;
	                    case 5:
	                        status = db.desconectar();
	                        break;
	                    default:
	                        System.out.println("Opção inválida.");
	                }
	            }
	        } else {
	            System.out.println("Não foi possível conectar ao banco de dados.");
	        }
	}
	
    public static int menu() {
    	System.out.println("Selecione uma opção:");
        System.out.println("1. Listar");
        System.out.println("2. Inserir");
        System.out.println("3. Excluir");
        System.out.println("4. Atualizar");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        return opcao;
    }
    
    public static void infos(Filme filme) {
    	scanner.nextLine();
    	System.out.print("Nome: ");
    	filme.setNome(scanner.nextLine());
    	System.out.print("Genero: ");
    	filme.setGenero(scanner.nextLine());
    	System.out.print("Avaliação: ");
    	filme.setAvaliacao(scanner.nextFloat());
    }
}
