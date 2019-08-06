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
	new Thread(new Ask(8888,9999,"localhost")).start();//����Ϣ
	new Thread(new Answer(6666,"��ʦ")).start(); //������ʦ������Ϣ
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
		try {//�������Ͷ�
			client = new DatagramSocket(this.port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		//�ɿ���̨���뻺����
		reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		String str;
		byte[] datas;
		try {
			str = reader.readLine();//����̨����
			datas = str.getBytes();//��������
			//���
			packet = new DatagramPacket(datas, datas.length,
					 new InetSocketAddress(this.To_IP,this.To_port));
			
			//����
			client.send(packet);
			if(datas.equals("bye")) {
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		//�ͷ���Դ
		client.close();
	}
	
}