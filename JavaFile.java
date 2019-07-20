package ycsyxt;

import java.io.File;

public class JavaFile {
	public static void main(String[] args) {
		File f = new File("C:/Users/yxt/Desktop/Python");  //Java中路径一般用 / 分隔
		printFile(f);   //调用递归函数打印文件下的目录名/文件名
	}
	static void printFile(File f) {
		                            //static修饰符使该函数可以通过函数名调用，否则需要使用
		                           //JavaFile实例来调用（JavaFile file = new JavaFile();file.printFile(f);）
		File[] f1 = f.listFiles();  //列出文件下的文件和目录
		
		for(File temp:f1) {         //对所有文件和目录进行遍历
			
			if(temp.isDirectory()) {//如果是目录，递归打印它下面的目录/文件
				System.out.println(temp.getName());
				printFile(temp);
				
			}
			else                    //如果是文件，打印文件名
				System.out.println(temp.getName());
		}
		
	}
}