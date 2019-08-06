package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Test_picture01 {
public static void main(String[] args) throws IOException {
	//7，使用DatagramSocket指定端口，创建发送端
	DatagramSocket client = new DatagramSocket(6665);
	
	//8，读取图片字符流，放入准备好的容器
	File f = new File("C:\\Users\\yxt\\Desktop\\课表.png");
	InputStream is = new FileInputStream(f);
	byte[] by = new byte[(int)f.length()];
	is.read(by);
	is.close();
	
	//9，封装包裹，指定目的地
	DatagramPacket packet = new DatagramPacket(by,0,by.length,
			new InetSocketAddress("localhost",8887));//本机
	
	//10，发送包裹
	client.send(packet);
	
	//5,释放资源
	client.close();
}
}
