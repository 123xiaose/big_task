package my_big_task_01;

import java.util.Scanner;

public class MyMain {
	public static void main(String[] args) {
		while(true)
		{
			System.out.println("欢迎来到棋类游戏系统！");
			System.out.println("请选择游戏：0表示退出；1表示五子棋；2表示围棋");
			Scanner input = new Scanner(System.in);
			int tag = input.nextInt();
			if((tag < 0) ||(tag > 2))continue;
			if(tag==0)break;
			System.out.println("请输入棋盘大小,最小为8，最大为19");
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
