/**
 * ͼƬ��д�����������ص�ͼƬ�У�ͼƬ���˴�С�ı��⣬�����ط���û��ʲô������
 */
package ycsyxt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

public class MyFile_LSB {
	public static void main(String[] args) {
		//��ȡ����·��
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File home = fsv.getHomeDirectory();
		//System.out.println(home.getPath());
		
		//��ȡ.pngͼƬ·����.zip�ļ�·��
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ��.png��ʽͼƬ�ľ���·�����磺C:\\Users\\yxt\\Desktop\\test.png");
		String str1 = scanner.nextLine();
		System.out.println("������һ��.zip�ļ��ľ���·�����磺C:\\Users\\yxt\\Desktop\\d.zip");
		String str2 = scanner.nextLine();
		
		//����Դ
		File src1 = new File(str1);
		File src2 = new File(str2);
		File src3 = new File(home.getAbsolutePath()+"\\LSB.png");
		
		//������
		InputStream IS_0 = null;
		InputStream IS_1 = null;
		OutputStream OS = null;
		
		//��ȡԴ�����ٽ����ϲ�����д��Դ
		try {
			//��ȡ
			IS_0 = new FileInputStream(src1);
			byte[] car0 = new byte[(int)src1.length()];
			IS_0.read(car0, 0, car0.length);
			//��ȡ
			IS_1 = new FileInputStream(src2);
			byte[] car1 = new byte[(int)src2.length()];
			IS_1.read(car1,0,car1.length);
			//д��
			OS = new FileOutputStream(src3);
			OS.write(car0,0,car0.length);
			OS.write(car1,0,car1.length);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ͷ���Դ
		finally {
			try {
				IS_0.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				IS_1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				OS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("LSB��д�ɹ������ͼƬ��ΪLSB.png���뵽������в鿴��");
		}
	}
}
