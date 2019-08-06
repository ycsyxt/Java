package web;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Teacher_answer {
public static void main(String[] args) {
	new Thread(new Answer(9999,"学生")).start();//接收学生发送的信息
	new Thread(new Ask(5555,6666,"localhost")).start();//发信息
}
}
class Answer implements Runnable{

	private DatagramSocket ser;
	private DatagramPacket packet;
	private int port;
	String from;
	public Answer(int port,String from) {
		this.port = port;
		this.from = from;
	}
	@Override
	public void run() {
		try {
			ser = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		while(true) {
		byte[] by = new byte[1024];
		packet = new DatagramPacket(by, by.length);
		
		try {
			ser.receive(packet);
			
			String datas;
			datas = new String(packet.getData(),0,packet.getLength());
			System.out.println(from+":"+datas);
			if(datas.equals("bye")) {
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		ser.close();
	}
	
}