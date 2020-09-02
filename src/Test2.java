import cn.centuryw.BeginToLearn.FilesUpload.UploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * Server
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
//        Reader reader = new InputStreamReader(is);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        System.out.println(bufferedReader.readLine());
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len=bufferedInputStream.read(buffer))!=-1){
//            System.out.println(new String(buffer,0,len));
//
//        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        File file = (File) objectInputStream.readObject();
        System.out.println(file.getName());

    }
}
