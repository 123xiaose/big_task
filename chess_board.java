package my_big_task_01;

public class chess_board {

	public char[][] board;
	int sz = -1;
	chess_board(int x)
	{
		sz = x;
		board = new char [x][x];
		for(int i = 0;i < x;i++)
		{
			for(int j = 0;j < x;j++)
			{
				board[i][j] = '*';
			}
		}
	}
	
	public void show()
	{
		for(int i = 0;i < sz;i++)
		{
			for(int j = 0;j < sz;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void set(int x,int y,int z)
	{
		if(z == 0)board[x][y] = 'b';
		else board[x][y] = 'w';
		
	}
	public void restore(int x,int y)
	{
		board[x][y] = '*';
	}
	
	public int test(int x,int y)
	{
		if(x < 0 || x >= sz || y < 0 || y >= sz)
		{
			System.out.println("位置越界，请重新输入");
			return 1;
		}
		
		if(board[x][y] != '*')
		{
			System.out.println("该位置已有棋子,请重新输入");
			return 1;
		}

		return 0;
	}


}
