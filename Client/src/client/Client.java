package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seaso
 */
public class Client {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		int porta = 33334;
		String servidor = "127.0.0.1";

		byte[] conteudo = { 5 };

		try {
			try (Socket socket = new Socket(servidor, porta)) {
				OutputStream out = socket.getOutputStream();
				out.write(conteudo);
				System.out.printf("Dados transferidos para o servidor %s:%04d\n", servidor, porta);

				// recebe echo - byts ordenados
				InputStream in = socket.getInputStream();
				in.read(conteudo);
				System.out.append(Arrays.toString(conteudo));
			}

		} catch (UnknownHostException e1) {
			System.out.println("Host desconhecido");
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

		}

	}
}