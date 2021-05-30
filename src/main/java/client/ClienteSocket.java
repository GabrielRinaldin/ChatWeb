package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {

	public void executa() {

		// Entrada de dados
		Scanner teclado = new Scanner(System.in);

		try {
			// cria uma nova socket no seguinte servidor e porta
			Socket cliente = new Socket("127.0.0.1", 54321);

			PrintStream output = new PrintStream(cliente.getOutputStream());
			Scanner input = new Scanner(cliente.getInputStream());
			String inputMsg = "";
			String getMsg = "";

			while (!getMsg.toUpperCase().equals("SAIR")) {
				getMsg = teclado.nextLine();
				output.println(teclado.nextLine());
				inputMsg = input.nextLine();
				System.out.println(inputMsg);
			}

			System.out.println("Um dos integrantes acabou de sair ( ͡❛ ︵ ͡❛)");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
