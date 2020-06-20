package stuedntOperate;


import java.util.Scanner;

import file.FileOperate;


public class Driver {
	
	private static ShowQuestion showquestion = new ShowQuestion();
	private static No no = new No();
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		String name = "";
		System.out.println("请输入你的姓名");
		name = input.nextLine();
		
		while(!name.equals("")) {
			
			int choice = menu(name);
			
		}
		
		System.out.println("请先输入姓名");
		
		
}
	
	public static int menu(String name) throws Exception {
		int choice = 0;
		System.out.println("简单算术运算测试系统");
		System.out.println("1.出题");
		System.out.println("2.答题");
		System.out.println("3.查看成绩");
		System.out.println("4.排行榜");
		System.out.println("5.退出");
		System.out.println("请选择（1-5）");
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		while(choice != 5) {
		switch(choice) {
			case 1 : showquestion.getCount();
			
			break;
			case 2 :  showquestion.Display();
						no.writeFile(name,ShowQuestion.buil,ShowQuestion.score);
			break;
			case 3 : showquestion.DisplayAll();
			break;
			case 4 : no.getList().forEach(System.out :: println);
			break;
			default : System.out.println("输入的选择有误");
		}
		choice = menu(name);
		}
		
		System.out.println("感谢使用");
		System.exit(0);
			
		return choice;
	}
	
	
}
