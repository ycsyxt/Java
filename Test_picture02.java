package web;
/**
 * 图片接收生成方
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test_picture02 {
public static void main(String[] args) throws IOException {
	//1，使用DatagramSocket指定端口，创建接收端
	
	DatagramSocket ser = new DatagramSocket(8887);
	
	//2，准备容器，封装成DatagramSocket包裹
	
	byte[] by = new byte[1024*50];//图片大小48K,容器容量必须比它大

	DatagramPacket packet = new DatagramPacket(by, by.length);//打包
	
	//3，阻塞式接收包裹receive()
	ser.receive(packet);
	
	//4，分析数据getData,getLength
	byte[] datas = packet.getData();
	
	//5，通过文件输出流生成图片
	File f = new File("C:\\Users\\yxt\\Desktop\\kebiao.png");
	
	OutputStream os = new FileOutputStream(f);
	os.write(datas);
	//6，释放资源
	os.close();
	ser.close();
	System.out.println("接收成功");
	
}
}
