package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class Student_ask {
public static void main(String[] args) {
	new Thread(new Ask(8888,9999,"localhost")).start();//发信息
	new Thread(new Answer(6666,"老师")).start(); //接收老师发的信息
}
}
class Ask implements Runnable {
	private DatagramSocket client; 
	private int port;
	private BufferedReader reader; 
	private DatagramPacket packet;
	private int To_port;
	private String  To_IP;
	
	public Ask (int port,int To_port,String To_IP) {
		this.port = port;
		this.To_port = To_port;
		this.To_IP = To_IP;
	}
	@Override
	public void run() {
		try {//创建发送端
			client = new DatagramSocket(this.port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		//由控制台输入缓冲区
		reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		String str;
		byte[] datas;
		try {
			str = reader.readLine();//控制台输入
			datas = str.getBytes();//创建容器
			//打包
			packet = new DatagramPacket(datas, datas.length,
					 new InetSocketAddress(this.To_IP,this.To_port));
			
			//发送
			client.send(packet);
			if(datas.equals("bye")) {
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		//释放资源
		client.close();
	}
	
}