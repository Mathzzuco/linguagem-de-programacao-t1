package Telas;

import java.util.List;
import java.util.Scanner;

import Models.Publicacao;
import Models.Usuario;
import Persistencia.PublicacaoDAO;
import Persistencia.UsuarioDAO;

public class Tela {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcao = 0;
//		Usuario usuario = new Usuario(1, "c@g.com", "senha", "nome");
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		usuarioDAO.adicionar(usuario);
		
//		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
//		Usuario u = new Usuario();
//		u.setIdUsuario(1);
//		Publicacao publicacao = new Publicacao(0, "informacao", u);
//		publicacaoDAO.adicionar(publicacao);

//		List<Usuario> listaUsuarios = usuarioDAO.buscarTodos();
//		System.out.println(listaUsuarios.size());
		
//		usuarioDAO.editar(usuario);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
		
			System.out.println("Escolha uma opcao");
			System.out.println("(AVISO!) Use _ para espacos, ex: Cachorro_grande (AVISO!)");
			System.out.println("(1) Criar usuario");
			System.out.println("(2) Editar usuario");
			System.out.println("(3) Excluir usuario");
			System.out.println("(4) Buscar usuario por id");
			System.out.println("(5) Numero de usuarios");
			System.out.println("(6) Criar publicacao");
			System.out.println("(7) Editar publicacao");
			System.out.println("(8) Excluir publicacao");
			System.out.println("(9) Buscar publicacao por id");
			System.out.println("(10) Buscar publicacao por localizacao");
			System.out.println("(11) Numero de publicacoes");
			System.out.println("(12) Sair");
			opcao = teclado.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Escreva seu email");
				System.out.println("Escreva sua senha");
				System.out.println("Escreva seu nome");
				Usuario usuario = new Usuario(0, teclado.next(), teclado.next(), teclado.next());
				usuarioDAO.adicionar(usuario);
				break;
			case 2:
				System.out.println("Escreva seu id");
				System.out.println("Escreva seu novo email");
				System.out.println("Escreva sua nova senha");
				System.out.println("Escreva seu novo nome");
				Usuario usuario1 = new Usuario(teclado.nextInt(), teclado.next(), teclado.next(), teclado.next());
				usuarioDAO.editar(usuario1);
				break;
			case 3:
				System.out.println("Escreva seu id");
				usuarioDAO.excluir(teclado.nextInt());
				break;
			case 4:
				System.out.println("Escreva um id");
				Usuario usuario2 = usuarioDAO.buscarPorId(teclado.nextInt());
				System.out.println(usuario2);
				break;
			case 5:
				List<Usuario> listUsuarios = usuarioDAO.buscarTodos();
				System.out.println(listUsuarios.size());
				break;
			case 6:
				System.out.println("Escreva seu id de usuario");
				Usuario u = new Usuario();
				u.setIdUsuario(teclado.nextInt());
				System.out.println("Escreva as informacoes do animal desaparecido");
				System.out.println("Escreva a ultima localizacao vista");
				Publicacao publicacao = new Publicacao(0, teclado.next(), teclado.next(), u);
				publicacaoDAO.adicionar(publicacao);
				break;
			case 7:
				System.out.println("Escreva seu id de usuario");
				System.out.println("Escreva o id de sua publicacao");
				System.out.println("Escreva as novas informacoes sobre o animal");
				System.out.println("Escreva uma nova localizacao");
				Usuario u1 = new Usuario();
				u1.setIdUsuario(teclado.nextInt());
				Publicacao publicacao1 = new Publicacao(teclado.nextInt(), teclado.next(), teclado.next(), u1);
				publicacaoDAO.editar(publicacao1);
				break;
			case 8:
				System.out.println("Escreva o id da publicacao");
				publicacaoDAO.excluir(teclado.nextInt());
				break;
			case 9:
				System.out.println("Escreva o id da publicacao");
				Publicacao publicacao2 = publicacaoDAO.buscarPorId(teclado.nextInt());
				System.out.println(publicacao2);
				break;
			case 10:
				System.out.println("Escreva a localizacao que deseja pesquisar");
				Publicacao publicacao3 = publicacaoDAO.buscarPorLocal(teclado.next());
				System.out.println(publicacao3);
				break;
			case 11:
				List<Publicacao> listPublicacoes = publicacaoDAO.buscarTodos();
				System.out.println(listPublicacoes.size());
				break;
			default:
		}
	}

}
