package homework_client_server_5_2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        Handler handler = new Handler();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8358));

        try (SocketChannel socketChannel = serverSocketChannel.accept()){
            final ByteBuffer byteBuffer = ByteBuffer.allocate(2 << 8);

            while (socketChannel.isConnected()) {
                int bytesCount = socketChannel.read(byteBuffer);

                if(bytesCount == -1) {
                    break;
                }

                final String message = new String(byteBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                String newMessage = handler.replaceSpaces(message);
                byteBuffer.clear();

                socketChannel.write(ByteBuffer.wrap((newMessage).getBytes(StandardCharsets.UTF_8)));
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
