package ycsyxt;
/**
 * 使用递归拷贝文件夹
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilesCopy {
public static void main(String[] args) throws IOException {
	//3，开始拷贝
	File src = new File("C:\\Users\\yxt\\Desktop\\Python");//源文件夹
	String dest = "C:\\Users\\yxt\\Desktop\\test";//目的文件夹绝对路径
	new File(dest).mkdir();//创建文件夹
	CopyFiles(src, dest);
}
public static void copy(String src,String dest) throws IOException {
	//1,文件拷贝
	//创建源
	File f = new File(src);
	File bak = new File(dest);
	
	//选择流
	InputStream is = new FileInputStream(f);
	OutputStream os = new FileOutputStream(bak);
	
	//进行IO操作
	byte[] by = new byte[(int)f.length()];
	is.read(by);//读
	
	os.write(by);//写
	os.flush();
	
	//释放资源
	os.close();
	is.close();//先打开的后关闭	
}

public static void CopyFiles(File src,String dest) throws IOException {
	//2，递归拷贝文件
	File[] ff = src.listFiles();//列出文件夹中的所有文件
	
	for(File temp:ff) {//for循环+递归进行文件拷贝
		if(temp.isDirectory()) {
			
			CopyFiles(temp,dest);
		}
		else {
			
		copy(temp.getAbsolutePath(), dest+"\\"+temp.getName());
		}
		
	}
}
}
