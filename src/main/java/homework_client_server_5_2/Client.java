package homework_client_server_5_2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // в этом примере выбрано неблокирующее взаимодействие, потому что мы вводим поток строк,
        // нам важен общий итоговый результат
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8358);
        final SocketChannel channel = SocketChannel.open();

        channel.connect(socketAddress);

        try (Scanner scanner = new Scanner(System.in)) {

            final ByteBuffer byteBuffer = ByteBuffer.allocate(2 << 8);

            String message;
            while (true) {
                System.out.println("Enter your message or enter \"end\": ");
                message = scanner.nextLine();
                if ("end".equals(message)) break;
                channel.write(ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8)));

                Thread.sleep(2000);

                int bytesCount = channel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8));
                byteBuffer.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            channel.close();
        }
    }
}
