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
	//7��ʹ��DatagramSocketָ���˿ڣ��������Ͷ�
	DatagramSocket client = new DatagramSocket(6665);
	
	//8����ȡͼƬ�ַ���������׼���õ�����
	File f = new File("C:\\Users\\yxt\\Desktop\\�α�.png");
	InputStream is = new FileInputStream(f);
	byte[] by = new byte[(int)f.length()];
	is.read(by);
	is.close();
	
	//9����װ������ָ��Ŀ�ĵ�
	DatagramPacket packet = new DatagramPacket(by,0,by.length,
			new InetSocketAddress("localhost",8887));//����
	
	//10�����Ͱ���
	client.send(packet);
	
	//5,�ͷ���Դ
	client.close();
}
}
