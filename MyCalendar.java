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
		System.out.println("���������ڣ���(2019-01-01)");
		
		String  str = scanner.nextLine();//���������ַ���
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);//���ַ��������ɹ̶��ĸ�ʽ
		
		Calendar calendar  = new GregorianCalendar();
		calendar.setTime(date);
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		
		calendar.set(Calendar.DAY_OF_MONTH,1);//��������Ϊ���µ�1��
		
		for(int i = 0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++) {//��1�Ŵ�ӡ����Ӧ��������
			System.out.print("\t");
		}
		
		int MaxDay = calendar.getActualMaximum(Calendar.DATE);//��ȡ�����������
		for(int i = 1;i <= MaxDay; i++) {
			System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");//��ӡ����
			
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {//������������������
				System.out.println();
			}
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);//��������1
		}
			
	}
}
