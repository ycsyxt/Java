package ycsyxt;

import java.io.File;

public class JavaFile {
	public static void main(String[] args) {
		File f = new File("C:/Users/yxt/Desktop/Python");  //Java��·��һ���� / �ָ�
		printFile(f);   //���õݹ麯����ӡ�ļ��µ�Ŀ¼��/�ļ���
	}
	static void printFile(File f) {
		                            //static���η�ʹ�ú�������ͨ�����������ã�������Ҫʹ��
		                           //JavaFileʵ�������ã�JavaFile file = new JavaFile();file.printFile(f);��
		File[] f1 = f.listFiles();  //�г��ļ��µ��ļ���Ŀ¼
		
		for(File temp:f1) {         //�������ļ���Ŀ¼���б���
			
			if(temp.isDirectory()) {//�����Ŀ¼���ݹ��ӡ�������Ŀ¼/�ļ�
				System.out.println(temp.getName());
				printFile(temp);
				
			}
			else                    //������ļ�����ӡ�ļ���
				System.out.println(temp.getName());
		}
		
	}
}