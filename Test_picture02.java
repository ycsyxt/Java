package web;
/**
 * ͼƬ�������ɷ�
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test_picture02 {
public static void main(String[] args) throws IOException {
	//1��ʹ��DatagramSocketָ���˿ڣ��������ն�
	
	DatagramSocket ser = new DatagramSocket(8887);
	
	//2��׼����������װ��DatagramSocket����
	
	byte[] by = new byte[1024*50];//ͼƬ��С48K,�����������������

	DatagramPacket packet = new DatagramPacket(by, by.length);//���
	
	//3������ʽ���հ���receive()
	ser.receive(packet);
	
	//4����������getData,getLength
	byte[] datas = packet.getData();
	
	//5��ͨ���ļ����������ͼƬ
	File f = new File("C:\\Users\\yxt\\Desktop\\kebiao.png");
	
	OutputStream os = new FileOutputStream(f);
	os.write(datas);
	//6���ͷ���Դ
	os.close();
	ser.close();
	System.out.println("���ճɹ�");
	
}
}
