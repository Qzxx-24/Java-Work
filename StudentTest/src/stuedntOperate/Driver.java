package stuedntOperate;


import java.util.Scanner;

import file.FileOperate;


public class Driver {
	
	private static ShowQuestion showquestion = new ShowQuestion();
	private static No no = new No();
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		String name = "";
		System.out.println("�������������");
		name = input.nextLine();
		
		while(!name.equals("")) {
			
			int choice = menu(name);
			
		}
		
		System.out.println("������������");
		
		
}
	
	public static int menu(String name) throws Exception {
		int choice = 0;
		System.out.println("�������������ϵͳ");
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.�鿴�ɼ�");
		System.out.println("4.���а�");
		System.out.println("5.�˳�");
		System.out.println("��ѡ��1-5��");
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
			default : System.out.println("�����ѡ������");
		}
		choice = menu(name);
		}
		
		System.out.println("��лʹ��");
		System.exit(0);
			
		return choice;
	}
	
	
}
