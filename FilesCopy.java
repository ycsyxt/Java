package ycsyxt;
/**
 * ʹ�õݹ鿽���ļ���
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilesCopy {
public static void main(String[] args) throws IOException {
	//3����ʼ����
	File src = new File("C:\\Users\\yxt\\Desktop\\Python");//Դ�ļ���
	String dest = "C:\\Users\\yxt\\Desktop\\test";//Ŀ���ļ��о���·��
	new File(dest).mkdir();//�����ļ���
	CopyFiles(src, dest);
}
public static void copy(String src,String dest) throws IOException {
	//1,�ļ�����
	//����Դ
	File f = new File(src);
	File bak = new File(dest);
	
	//ѡ����
	InputStream is = new FileInputStream(f);
	OutputStream os = new FileOutputStream(bak);
	
	//����IO����
	byte[] by = new byte[(int)f.length()];
	is.read(by);//��
	
	os.write(by);//д
	os.flush();
	
	//�ͷ���Դ
	os.close();
	is.close();//�ȴ򿪵ĺ�ر�	
}

public static void CopyFiles(File src,String dest) throws IOException {
	//2���ݹ鿽���ļ�
	File[] ff = src.listFiles();//�г��ļ����е������ļ�
	
	for(File temp:ff) {//forѭ��+�ݹ�����ļ�����
		if(temp.isDirectory()) {
			
			CopyFiles(temp,dest);
		}
		else {
			
		copy(temp.getAbsolutePath(), dest+"\\"+temp.getName());
		}
		
	}
}
}
