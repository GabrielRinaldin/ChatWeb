package server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiChat implements Runnable {

	private Socket cliente;

	public MultiChat(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		Scanner response = new Scanner(System.in);
		Scanner input;
		try {
			input = new Scanner(cliente.getInputStream());
			PrintStream output = new PrintStream(cliente.getOutputStream());

			String inputGetMessage = "";
			String sendResposse = "";
			while (!inputGetMessage.toUpperCase().equals("SAIR")) {
				inputGetMessage = input.nextLine();
				System.out.println(inputGetMessage);
				sendResposse = response.nextLine();
				output.println(sendResposse);
			}
			cliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
