package my_big_task_01;

import java.util.Scanner;


public class wu_zi_qi {
	private static wu_zi_qi my_instance = null;
	chess_board my_board;
	int tag = 0;
	int sz = -1;
	String str_vec[] = {"黑棋","白棋"};
	
	private wu_zi_qi(int x)
	{
		sz = x;
		my_board = new chess_board(x);
		my_board.show();
	}
	
	public static wu_zi_qi get_instance(int x)
	{
		if(my_instance == null)
		{
			my_instance = new wu_zi_qi(x);
		}
		return my_instance;
		
	}
	
	

	public int test_heng(int i,int j)
	{
		int ans = 1;
		for(int k = 0;k < 5;++k)
		{
			if(j+k >= sz)return 0;
			if(my_board.board[i][j] != my_board.board[i][j+k])ans = 0;
		}
		return ans;
	}
	
	public int test_zong(int i,int j)
	{
		int ans = 1;
		for(int k = 0;k < 5;++k)
		{
			if(i+k >= sz)return 0;
			if(my_board.board[i][j] != my_board.board[i+k][j])ans = 0;
		}
		return ans;
		
	}
	
	public int test_you_xie(int i,int j)
	{
		int ans = 1;
		for(int k = 0;k < 5;++k)
		{
			if((i+k >= sz) ||( j+k >= sz))return 0;
			if(my_board.board[i][j] != my_board.board[i+k][j+k])ans = 0;
		}
		return ans;
	}
	
	public int test_zuo_xie(int i,int j)
	{
		int ans = 1;
		for(int k = 0;k < 5;++k)
		{
			if((i+k >= sz) ||( j-k < 0))return 0;
			if(my_board.board[i][j] != my_board.board[i+k][j-k])ans = 0;
		}
		return ans;
		
	}
	public int test_final()
	{
		for(int i  = 0;i < sz;++i)
		{
			for(int j = 0;j < sz;++j)
			{
				if(my_board.board[i][j] == '*')continue;
				if(test_zong(i,j) == 1)
				{
					if(my_board.board[i][j] == 'b')System.out.println("黑棋获得胜利\n\n\n");
					else System.out.printf("白棋获得胜利\n\n\n");
					return 1;
				}
				if(test_heng(i,j) == 1)
				{
					if(my_board.board[i][j] == 'b')System.out.println("黑棋获得胜利\n\n\n");
					else System.out.printf("白棋获得胜利\n\n\n");
					return 1;
				}
				if(test_you_xie(i,j) == 1)
				{
					if(my_board.board[i][j] == 'b')System.out.println("黑棋获得胜利\n\n\n");
					else System.out.printf("白棋获得胜利\n\n\n");
					return 1;
				}
				if(test_zuo_xie(i,j) == 1)
				{
					if(my_board.board[i][j] == 'b')System.out.println("黑棋获得胜利\n\n\n");
					else System.out.printf("白棋获得胜利\n\n\n");
					return 1;
				}
			}
		}
		return 0;
	}
	
	public void act()
	{
		while(true)
		{
			System.out.println("请"+str_vec[tag]+"用户输入落子位置,认输请输入-1");
			
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			if(x == -1)
			{
				System.out.println(str_vec[tag]+"认输");
				System.out.println(str_vec[1-tag]+"获胜");
				System.out.printf("\n\n\n");
				break;
			}
			int y = input.nextInt();
			System.out.println(x);
			System.out.println(y);
			if(my_board.test(x,y)==0)my_board.set(x, y, tag);
			else continue;
			
			my_board.show();
			if(test_final()==1)break;
	
			tag = 1-tag;	
		}
	}
}
