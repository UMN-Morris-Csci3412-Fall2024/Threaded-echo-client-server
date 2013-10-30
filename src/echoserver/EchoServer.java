package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			int b;
			int numBytes = 0;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
				++numBytes;
			}
			outputStream.flush();
//            socket.shutdownOutput();
            System.err.println("The server processed " + numBytes + " bytes");
//            Thread.sleep(1000);
		}
	}
}