package ex03;

import java.time.LocalDate;
import java.util.Scanner;


//모든기능은 class에 구현한다.
//입력data
//사번,이름,입사일,월급,부서번호 
/*
100,사나,20110101,300.0,10      
200,모모,20120301,270.0,20      
300,정연,20091003,250.0,30      
400,나연,20110105,220.0,40      
500,미나,20180401,170.0,60      
600,쯔위,20150801,200.0,50      
*/

interface  Ipo {
	void  input();
	void  process();
	void  output();
}


// data 중심의 class
class   EmpVo  {
	// fields
	// 입력
	private   int      num;
	private   String   name;
	private   String   hiredate;
	private   double   salary;
	private   int      deptno;
	// 출력
	private   double   bonus;
	private   double   pay;
	private   String   deptname;
	
	// Constructor
	public EmpVo() {}
	public EmpVo( int num, String name, String hiredate,
			double salary, int deptno ) {
		this.num       = num;
		this.name      = name;
		this.hiredate  = hiredate;
		this.salary    = salary;
		this.deptno    = deptno;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	// toString
	@Override
	public String toString() {
		return "EmpVo [num=" + num + ", name=" + name + ", hiredate=" + hiredate + ", salary=" + salary + ", deptno="
				+ deptno + ", bonus=" + bonus + ", pay=" + pay + ", deptname=" + deptname + "]";
	}
	
}

//입력 1줄 -> 결과 1줄
//입력data : 사번,이름,입사일,월급,부서번호
//       num, name, hiredate,salary,deptno
//출력     : 사번,이름,입사일,월급,보너스,수령액,부서명
//       num, name, hiredate, salary, bonus, pay, deptname


// 기능담당 클래스 
// class Emp
class  Emp   implements  Ipo {
	
	// Fields
	private  EmpVo   empVo;

	@Override
	public void input() {
		Scanner    in    =  new Scanner(System.in);
		
		System.out.println("입력:사번,이름,입사일,월급,부서번호");
		// line "   100 , 사나 ,20110101 , 300.0 , 10   "
		String     line       =  in.nextLine().trim();
		// line "100 , 사나 , 20110101 , 300.0 , 10"
		String  [] li         =  line.split(",");
		// li   "100 "," 사나 "," 20110101 "," 300.0 "," 10"
		int        num        =  Integer.parseInt( li[0].trim() );
		String     name       =  li[1].trim();
		String     hiredate   =  li[2].trim();
		double     salary     =  Double.parseDouble( li[3].trim() ); 
		int        deptno     =  Integer.parseInt( li[4].trim() );
		
		empVo   =  new EmpVo(num, name, hiredate, salary, deptno);
		
	}


	//금액은 소수이하 두자리로 반올림
	@Override
	public void process() {
		
		//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
		int     thisYear  =  LocalDate.now().getYear();  // 올해연도
		String  hiredate  =  empVo.getHiredate();        // 입사일
		int     hireYear  =  Integer.parseInt( hiredate.substring(0, 3+1) );
		                     // 입사일의 연도부분
		int     hireYears =  thisYear - hireYear;  
		double  salary    =  empVo.getSalary();
		double  bonus     =  hireYears * salary * 0.005;  // 0.5% : 0.005
		System.out.println("hireYear:" + hireYear);
		System.out.println("bonus:"  + bonus);
		
		//수령액          =  월급 + 보너스 
		double  pay       =  salary + bonus;
		
		//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
		String  deptname  = "";
		int     deptno    = empVo.getDeptno();
		switch( deptno  ) {
		case 10:  deptname = "인사"; break;
		case 20:  deptname = "자재"; break;
		case 30:  deptname = "총무"; break;
		case 40:  deptname = "연구개발"; break;
		case 50:  deptname = "생산"; break;
		case 60:  deptname = "서비스"; break;		
		}
		
		empVo.setBonus(bonus);
		empVo.setPay(pay);
		empVo.setDeptname(deptname);		
		
	}

	@Override
	public void output() {
		
		int      num         = empVo.getNum();
		String   name        = empVo.getName();
		String   hiredate    = empVo.getHiredate();
		double   salary      = empVo.getSalary();
		double   bonus       = empVo.getBonus();
		double   pay         = empVo.getPay();
		String   deptname    = empVo.getDeptname();
		
		System.out.println("사번 이름 입사일 월급 보너스 수령액 부서명");
		System.out.printf("%d  %s  %s %.2f %.2f %.2f %s",
				num, name, hiredate, salary, bonus, pay, deptname);
		
	}
	
}


// TestEmp : main()
public class TestEmp {

	public static void main(String[] args) {
		
		Emp  emp  =  new Emp();
		emp.input();
		emp.process();
		emp.output();

	}

}










