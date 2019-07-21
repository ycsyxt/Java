/**
 * 图片隐写：将数据隐藏到图片中，图片除了大小改变外，其他地方并没有什么异样！
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
		//获取桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File home = fsv.getHomeDirectory();
		//System.out.println(home.getPath());
		
		//获取.png图片路径和.zip文件路径
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一张.png格式图片的绝对路径，如：C:\\Users\\yxt\\Desktop\\test.png");
		String str1 = scanner.nextLine();
		System.out.println("请输入一个.zip文件的绝对路径，如：C:\\Users\\yxt\\Desktop\\d.zip");
		String str2 = scanner.nextLine();
		
		//创建源
		File src1 = new File(str1);
		File src2 = new File(str2);
		File src3 = new File(home.getAbsolutePath()+"\\LSB.png");
		
		//创建流
		InputStream IS_0 = null;
		InputStream IS_1 = null;
		OutputStream OS = null;
		
		//读取源到流再将流合并并且写到源
		try {
			//读取
			IS_0 = new FileInputStream(src1);
			byte[] car0 = new byte[(int)src1.length()];
			IS_0.read(car0, 0, car0.length);
			//读取
			IS_1 = new FileInputStream(src2);
			byte[] car1 = new byte[(int)src2.length()];
			IS_1.read(car1,0,car1.length);
			//写出
			OS = new FileOutputStream(src3);
			OS.write(car0,0,car0.length);
			OS.write(car1,0,car1.length);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//释放资源
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
			System.out.println("LSB隐写成功，输出图片名为LSB.png，请到桌面进行查看！");
		}
	}
}
