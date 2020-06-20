package stuedntOperate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import file.FileOperate;
import vo.Student;

public class No {
	
	public static void writeFile(String name , StringBuilder buil , double score) throws Exception {
		int flag = -1;
		String time = "" + buil;
		List<Student> scoreList = getList();
		List<Object> objectList = new ArrayList<>();
		for(int i = 0 ; i < scoreList.size() ; i ++) {
			if(scoreList.get(i).getScore() < score && flag == -1) {
				flag = i + 1;
				Student student = new Student(flag , name , score , time);
				scoreList.add(student);
			}
			if(scoreList.get(i).getScore() < score) {
				
				scoreList.get(i).setCount(scoreList.get(i).getCount() + 1);
				
			}
		}
		
		if(flag == -1) {
			Student student = new Student(scoreList.size() + 1 , name , score , time);
			scoreList.add(student);
		}
		
		scoreList = scoreList.stream().sorted(Comparator.comparing(Student :: getCount)).collect(Collectors.toList());
		
		for(Student student : scoreList) {
			Object obj = (Object)student;
			objectList.add(obj);
		}
		FileOperate.arrayToTXT(objectList, "src/file/ttt.txt");
	}
	
	
	public static List<Student> getList() throws Exception{   //获取排行榜信息函数
	       List<Object> list1 = FileOperate.getTXTAsArray("src/file/ttt.txt", "vo.Student");
	       List<Student> studentList=new ArrayList<>();

	       for (Object object : list1){
	           Student student = (Student)object;
	           studentList.add(student);
	       }
	       return studentList;
	   }
}
