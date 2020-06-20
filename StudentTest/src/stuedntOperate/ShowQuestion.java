package stuedntOperate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import vo.Answer;
import vo.Question;

public class ShowQuestion {
	public static List<Answer> answerList = new ArrayList<>();
	public static ArrayList<Question> questionList = new ArrayList<>();
	public static double score = 0;
	public static int answer[] = new int[100];
	public static StringBuilder buil = new StringBuilder();
	
	//获取题目的数量
	public static void getCount() {
		int count = 0;
		System.out.println("输入题目的数量");
		Scanner input = new Scanner(System.in);
		count = input.nextInt();
		getQuestion(count);
		List<Question> questionList = getQuestion(count);

		
	}
	
	//显示题目并作答
	public static void Display() {
		Scanner input = new Scanner(System.in);
		buil = Time();
		for(int i = 0 ; i < questionList.size() ; i ++) {
			System.out.println((i+1) + "." + questionList.get(i).toString());
			System.out.println("请输入答案");
			answer[i] = input.nextInt();
		}
		
		Check();
		
		
		
	}
	
	//计算时间
	public static StringBuilder Time() {
		 	StringBuilder builder = new StringBuilder();
		    DateFormat format = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
		    String[] timer = format.format(new Date()).split("/");
		    String[] names = {"年", "月", "日", "时", "分", "秒"};
		    for (int i = 0; i < timer.length; i++) {
		        builder.append(names[i]).append(":").append(timer[i]);
		        
		    }
		    
		    return builder;
		    
	}
	
	//判断题目正确与否
	public static void Check() {
		
		for(int i = 0; i < questionList.size() ; i ++) {
			if(answerList.get(i).getAnswer() == answer[i]) {
				score += (100 / questionList.size());
			}
		}
		
	}
	
	//输出所有的题目
	public static void DisplayAll() {
		System.out.println("题目" + "\t" + "作答" + "\t" + "标答");
		for(int i = 0 ; i < questionList.size() ; i ++) {
			System.out.println(questionList.get(i).toString() + "\t" + answer[i] + "\t" + answerList.get(i).getAnswer());
		}
		System.out.println("本次测验的分数为：" + score);
		//questionList.forEach(System.out :: println);
	}
	
	//获取算式
	public static List<Question> getQuestion(int count){
		int numberone, numbertwo;
		
		questionList = new ArrayList<>();
		answerList = new ArrayList<>();
		for(int i = 0; i < count; i ++) {
		//获得第一个随机数
		numberone = (int)(Math.random()*100);
		
		if(numberone == 0) {
			numberone = (int)(Math.random()*100);
		}
		
		//生成第二个随机数
		numbertwo = (int)(Math.random()*100);
		
		if(numbertwo == 0) {
			numbertwo = (int)(Math.random()*100);
		}
		
		//确保第一个数大于第二个数，便于减法和除法运算
			
			int m = 0;
			if(numberone < numbertwo) {
				
				m = numbertwo;
				numbertwo = numberone;
				numberone = m;
			}
		Question question = null;
		String operator = getOperator();
		switch(operator) {
		case "+" : 
			question = addCheck(numberone , numbertwo);
			if(question == null) {
				i = i - 1;
			}
			break;
			
		case "-" : 
			question = subCheck(numberone , numbertwo);
			break;
			
		case "*" : 
			question = multiCheck(numberone , numbertwo);
			if(question == null) {
				i = i - 1;
			}
			break;
			
		case "/" : 
			question = divideCheck(numberone , numbertwo);
			break;
		}
		if(question != null) {
			questionList.add(question);
		}
		}
		
		return questionList;
	}
	
	//获取随机的操作符
	public static String getOperator() {
		
		String operator = "";
		double flag = Math.random();

		if(flag > 0 && flag <= 0.25) {
			operator = "+";
		}
		
		if(flag > 0.25 && flag <= 0.5) {
			operator = "-";
		}

		if(flag > 0.5 && flag <= 0.75) {
			operator = "*";
		}

		if(flag > 0.75 && flag <= 1.0) {
			operator = "/";
		}
		
		return operator;
	}
	
	
	
	/*问号位置随机函数*/
    public static Question randomQuestionMark(int numberone,int numbertwo,int result,String operator){
        Question question = new Question();
        Random random = new Random();
        int index = random.nextInt(3);
        Answer answer = new Answer();
        switch (index){
            case 0:
                answer.setAnswer(result);
                question.setResult("?");
                question.setNumberone(String.valueOf(numberone));
                question.setNumbertwo(String.valueOf(numbertwo));
                question.setOperator(operator);
                break;
            case 1:
                answer.setAnswer(numbertwo);
                question.setNumbertwo("?");
                question.setNumberone(String.valueOf(numberone));
                question.setOperator(operator);
                question.setResult(String.valueOf(result));
                break;
            case 2:
                answer.setAnswer(numberone);
                question.setNumberone("?");
                question.setNumbertwo(String.valueOf(numbertwo));
                question.setOperator(operator);
                question.setResult(String.valueOf(result));
                break;
        }
        answerList.add(answer);
        return question;
    }
    
    //确保加运算的结果在两位数
	public static Question addCheck(int numberone , int numbertwo) {
		Question question = null;
		int result = numberone + numbertwo;
		if(result < 100) {
			question = randomQuestionMark(numberone , numbertwo , result , "+");
		}
		
		return question;
	}
	
	//确保乘运算的结果在两位数
	public static Question multiCheck(int numberone , int numbertwo) {
		Question question = null;
		int result = numberone * numbertwo;
		if(result < 100) {
			question = randomQuestionMark(numberone , numbertwo , result , "*");
		}
		
		return question;
	}
	
	//减运算
	public static Question subCheck(int numberone , int numbertwo) {
		int result = numberone - numbertwo;
		Question question = randomQuestionMark(numberone , numbertwo , result , "-");
		
		return question;
	}
	
	//除运算
	public static Question divideCheck(int numberone , int numbertwo) {
		Question question = null;
		int result = numberone / numbertwo;
		int rest = numberone % numbertwo;
        if (rest == 0){
            randomQuestionMark(numberone , numbertwo , result ,"/");
        }
        else{
            question = new Question();
            Answer answer = new Answer();
            question.setResult("?");
            question.setNumberone(String.valueOf(numberone));
            question.setNumbertwo(String.valueOf(numbertwo));
            question.setOperator("/");
            answer.setAnswer(result);
            answerList.add(answer);
        }
		
		return question;
	}
}
