import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            System.out.println("连接成功！");
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("向服务器发送了：请求连接！");
            pw.println("请求连接！");
            String msg;
            if ((msg = in.readLine()) != null) {
                System.out.println("服务器发送了："+msg);
            }
            String line = "已收到";
            if (line!= null) {
                pw.println(line);
            }
            System.out.println("向服务器发送了：已收到");
            if ((msg = in.readLine()) != null) {
                System.out.println("服务器发送了："+msg);
            }
            System.out.println("客户端结束连接！");
            pw.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
