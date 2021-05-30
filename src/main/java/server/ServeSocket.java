package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServeSocket {

	public void executa() {
		try {
			// Instancia qual porta o socket vai trabalhar
			ServerSocket server = new ServerSocket(54321);
			
			System.out.println("Sala vazia, aguardando conexão com outro usuário ...");
			
			while (true) {
				Socket client = server.accept();
				System.out.println("Um novo usuário acabou de entrar!!!");

				new Thread(new MultiChat(client)).start();

			}

//			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
