package my_big_task_01;

import java.util.Scanner;

public class MyMain {
	public static void main(String[] args) {
		while(true)
		{
			System.out.println("��ӭ����������Ϸϵͳ��");
			System.out.println("��ѡ����Ϸ��0��ʾ�˳���1��ʾ�����壻2��ʾΧ��");
			Scanner input = new Scanner(System.in);
			int tag = input.nextInt();
			if((tag < 0) ||(tag > 2))continue;
			if(tag==0)break;
			System.out.println("���������̴�С,��СΪ8�����Ϊ19");
			int x = input.nextInt();
			if(tag == 1)
			{
				wu_zi_qi my_chess = wu_zi_qi.get_instance(x); 
				my_chess.act();
			}
			
			if(tag == 2)
			{
				wei_qi my_chess = wei_qi.get_instance(x);
				my_chess.act();
			}
		}


	}

}
