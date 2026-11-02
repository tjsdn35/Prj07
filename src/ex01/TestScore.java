package ex01;


/*  1번
num,name,kor,eng,mat
번호,이름,국어,영어,수학
1,사나,70,80,90
2,모모,0,70,100
3,쯔위,70,90,90
4,정연,80,90,70
5,원영,90,90,89
6,유진,100,100,100
*/

//입력:번호,이름,국어,영어,수학
//num, name, kor, eng, mat 
//출력:번호 이름 국어 영어 수학 총점 평균  등급
//num, name, kor, eng, mat, tot, avg, grade

class  Score {
	// fields
	//입력:번호,이름,국어,영어,수학
	private  int      num;
	private  String   name;
	private  int      kor;
	private  int      eng;
	private  int      mat;
	
	//출력: 총점 평균  등급
	private  int      tot;
	private  double   avg;
	private  char     grade;
	
	// Constructor : new 할때 초기화 - 입력
	public Score() {}	
	public Score(int num, String name, int kor, int eng, int mat ) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		/*
		this.tot = 0;
		this.avg = 0.0;
		this.grade = 'F';
		*/
	}
	
	// Getter / Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}	

	// toString : 값 중간확인용
	@Override
	public String toString() {
		return "Score [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}	
	
	// 메소드
	public int calcTot() {
		tot = kor + eng + mat;
		return tot;
	}
	
	// 평균
	public double calcAvg() {
		// avg  = tot / 3.0;  // X 총점을 계산하지 않았을때 0점
		avg  = calcTot() / 3.0; 
		//  == avg  = (kor + eng + mat) / 3.0;
		return  avg;
	}
	
	// grade 
	public char calcGrade() {
		// 평균이 90 ~ 100     : 'A'
		// 평균이 80 ~ 90 미만 : 'B'
		// 평균이 70 ~ 80 미만 : 'C'
		// 평균이 60 ~ 70 미만 : 'D'
		// 평균이  0 ~ 60 미만 : 'F'
		avg  = calcAvg();
		if( 90 <= avg && avg <= 100  ) grade = 'A';
		else if( 80 <= avg && avg <   90  ) grade = 'B';
		else if( 70 <= avg && avg <   80  ) grade = 'C';
		else if( 60 <= avg && avg <   70  ) grade = 'D';
		else if(  0 <= avg && avg <   60  ) grade = 'F';
		return grade;
	}
	
	
	
}

public class TestScore {

	public static void main(String[] args) {
		
		Score score1 = new Score(1,"사나",70,80,90);
		System.out.println( score1.toString() );
		// System.out.println( score1 );'
		int    tot    = score1.calcTot();
		String totStr = String.valueOf( tot );
		System.out.println( "총점:" +  totStr  );		
		System.out.println("평균:" + score1.calcAvg() );
		System.out.println("학점:" + score1.calcGrade() );

		// 5,원영,90,90,89
		Score score2 = new Score();
		score2.setNum(5);   // score2.num = 5
		score2.setName("원영");
		score2.setKor(90);
		score2.setEng(90);
		score2.setMat(89);
		score2.calcTot();
		score2.calcAvg();
		score2.calcGrade();
		
		System.out.println( score2 );
		
		//출력:번호 이름 국어 영어 수학 총점 평균  등급
		//num, name, kor, eng, mat, tot, avg, grade
		System.out.println("번호 이름 국어 영어 수학 총점 평균  등급");
		System.out.printf("%d  %s  %d  %d  %d  %d  %.3f %c",
				score2.getNum(), score2.getName(), 
				score2.getKor(), score2.getEng(), score2.getMat(),
				score2.getTot(), score2.getAvg(), score2.getGrade()	);
		
		
	}

}










