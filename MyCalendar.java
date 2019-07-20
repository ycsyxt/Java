package ycsyxt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyCalendar {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入日期：如(2019-01-01)");
		
		String  str = scanner.nextLine();//接收日期字符串
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);//将字符串解析成固定的格式
		
		Calendar calendar  = new GregorianCalendar();
		calendar.setTime(date);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		calendar.set(Calendar.DAY_OF_MONTH,1);//设置日期为当月的1号
		
		for(int i = 0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++) {//将1号打印到对应的星期数
			System.out.print("\t");
		}
		
		int MaxDay = calendar.getActualMaximum(Calendar.DATE);//获取当月最大天数
		for(int i = 1;i <= MaxDay; i++) {
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");//打印天数
			
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {//若当天是周六，换行
				System.out.println();
			}
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);//将天数加1
		}
			
	}
}
