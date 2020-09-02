import cn.centuryw.BeginToLearn.FilesUpload.UploadFile;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),7777);
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);
//        bufferedOutputStream.write("你好".getBytes());
//        bufferedOutputStream.flush();
//        PrintStream ps = new PrintStream(os);
//        ps.println("你好.jpg");
//        ps.flush();
        File file = new File("E:\\SteamLibrary\\steamapps\\workshop\\content\\431960\\2005436556\\preview.png");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(file);
        objectOutputStream.flush();

    }
}
