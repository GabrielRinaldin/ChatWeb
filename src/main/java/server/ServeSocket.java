package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeSocket {

	public void executa() {
		try {
			ServerSocket server = new ServerSocket(54321);

			String inputGetMessage = "";

			while (!inputGetMessage.toUpperCase().equals("FECHAR")) {

				System.out.println("Awaiting");
				Socket client = server.accept();
				System.out.println("Connected");

				Scanner input = new Scanner(client.getInputStream());

				inputGetMessage = "";

				while (!inputGetMessage.toUpperCase().equals("SAIR")
						&& !inputGetMessage.toUpperCase().equals("FECHAR")) {
					inputGetMessage = input.nextLine();
					System.out.println(inputGetMessage);
				}
				client.close();
			}

			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Server down");
	}

}
