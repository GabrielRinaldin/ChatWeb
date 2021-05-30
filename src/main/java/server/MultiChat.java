package server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiChat implements Runnable {

	private Socket client;

	public MultiChat(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		int count = 0;
		Scanner input;
		try {
			input = new Scanner(client.getInputStream());
			PrintStream output = new PrintStream(client.getOutputStream());

			String inputGetMessage = "";

			while (!inputGetMessage.toUpperCase().equals("SAIR")) {
				inputGetMessage = input.nextLine();
				System.out.println(inputGetMessage);
				output.println(++count);
			}
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
