package my_big_task_01;

import java.util.Scanner;

public class wei_qi {
	private static wei_qi my_instance = null;
	
	
	
	chess_board my_board;
	
	int tag = 0;
	int sz = -1;
	String str_vec[] = {"����","����"};
	public int[][] mark; //mark���飬0��ʾδ���ʣ�1��ʾ�Ѿ�����
	public int[][]next = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
			};
		
	
	private wei_qi(int x)
	{
		sz = x;
		mark = new int [x][x];
		my_board = new chess_board(x);
		my_board.show();
	}
	
	public static wei_qi get_instance(int x)
	{
		if(my_instance == null)
		{
			my_instance = new wei_qi(x);
		}
		return my_instance;
		
	}
	
	public boolean test_surround_one(int i,int j,char ch)
	{
		
		boolean ans = false;
		if(mark[i][j] == 1)return false;
		mark[i][j] = 1; //��ʾ����ڵ��Ѿ����֣���ֹ���ݹ�
		for(int k = 0;k < 4;k++)
		{
			int x = i+next[k][0];
			int y = j+next[k][1];
			
			if(x < 0 || x >= sz)continue;
			if(y < 0 || y >= sz)continue;
			if(my_board.board[x][y] == '*')return true;
			else if(my_board.board[x][y] == ch)ans |= test_surround_one(x,y,ch);
				
		}
		if(ans == false)my_board.board[i][j] = '*';
		return ans;
	}
	public void test_surround_all(int tag)//����Χס�����
	{
		//mark��ʼ��
		for(int i = 0;i < sz;++i)
		{
			for(int j = 0;j < sz;++j)mark[i][j] = 0;
		}
		
		for(int i = 0;i < sz;++i)
		{
			for(int j = 0;j < sz;++j)
			{
				if(my_board.board[i][j] == '*')continue;
				else 
				{
					test_surround_one(i,j,'b');
					test_surround_one(i,j,'w');
				}
			}
		}
	}
	
	public void act()
	{
		while(true)
		{
			System.out.println("��"+str_vec[tag]+"�û���������λ��,����������-1");
			
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			if(x == -1)
			{
				System.out.println(str_vec[tag]+"����");
				System.out.println(str_vec[1-tag]+"��ʤ");
				System.out.printf("\n\n\n");
				break;
			}
			int y = input.nextInt();
			if(my_board.test(x,y)==0)
			{
				my_board.set(x, y, tag);
				test_surround_all(tag+1);  //����Χס�����
			}
			else continue;
			my_board.show();
			tag = 1-tag;	
		}
	}
}
