import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args){
        try {
            System.out.println("准备启动服务器");
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接，IP为：" + socket.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            String line;
            if ((line = in.readLine()) != null) {
                System.out.println("客户端发送了：" + line);
            }
            pw.println("Welcome to Server!");
            System.out.println("向客户端发送了：Welcome to Server！");
            if ((line = in.readLine()) != null) {
                System.out.println("客户端发送了：" + line);
            }
            pw.println("已收到你的收到!");
            System.out.println("向客户端发送了：已收到你的收到！");
            in.close();
            pw.close();
            socket.close();
            System.out.println("服务端已关闭连接！");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
