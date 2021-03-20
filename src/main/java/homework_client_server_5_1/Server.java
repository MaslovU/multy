package homework_client_server_5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        Evaluation evaluation = new Evaluation();
        ServerSocket server = new ServerSocket(8583);
        while (true) {
            try (Socket client = server.accept();
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                String valueString;
                while ((valueString = reader.readLine()) != null) {
                    if(valueString.equals("no")) break;
                    int value = Integer.parseInt(valueString);
                    List<Long> res = evaluation.result(value);
                    out.println(res);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
