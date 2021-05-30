package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {

	public void executa() {
		Scanner teclado = new Scanner(System.in);

		try {
			//cria uma nova socket no seguinte servidor e porta
			Socket cliente = new Socket("127.0.0.1", 54321);
			
			
			PrintStream output = new PrintStream(cliente.getOutputStream());
			Scanner input = new Scanner(cliente.getInputStream());

			String getMsg = "";

			while (!getMsg.toUpperCase().equals("SAIR") && !getMsg.toUpperCase().equals("FECHAR")) {
				getMsg = teclado.nextLine();
				output.println(teclado.nextLine());
				System.out.println(input.nextLine());
			}

			System.out.println("saiu");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
