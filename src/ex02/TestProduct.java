package ex02;

import java.util.Scanner;

// 입력:번호,제품코드,수량,단가
//      num, pcode, amount, price
// P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이
// 출력:번호,제품명,수량,단가,금액(수량*단가)
//      num, pname, amount, price, kum
/* csv format- comma  seperator variable
1,P01,10,1250.0
2,P02,15,2000.0
3,P03,30,1500.0
5,P04,25,2000.0
4,P05,28,1900.0
*/

interface  Ipo {
	void  input();
	void  process();
	void  output();
}

// data 중심의 class : DTO      - Data Transfer Object
//                     VO       - Value Object 
//                     Entity
class  ProductDto {
	// Fields
	// 입력:번호,제품코드,수량,단가
	//  num, pcode, amount, price
	private  int       num;
	private  String    pcode;
	private  int       amount;
	private  double    price; 
	
	// 출력:번호,제품명,수량,단가,금액(수량*단가)
	//  num, pname, amount, price, kum
	private  String    pname;
	private  double    kum;
	
	// Constructor
	public ProductDto() { }
	public ProductDto(int num, String pcode, int amount, double price) {
		this.num = num;
		this.pcode = pcode;
		this.amount = amount;
		this.price = price;
	}
	
	// Getter /Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getKum() {
		return kum;
	}
	public void setKum(double kum) {
		this.kum = kum;
	}
	
	// toString
	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", pcode=" + pcode + ", amount=" + amount + ", price=" + price + ", pname="
				+ pname + ", kum=" + kum + "]";
	}	
	
}

// 기능 중심의 class
class  Product  implements  Ipo  {
	
	// Fields
	private  ProductDto  p;  

	//  메소드
	@Override
	public void input() {
		// 키보드 준비
		Scanner     in     =  new Scanner(System.in);
		
		// num, pcode, amount, price
		System.out.println("입력:번호,제품코드,수량,단가");
		String      line   =  in.nextLine();  
		// line : "2, P02,15,2000.0"
		//        0   1     2     3   
		// li[] : "2"," P02","15","2000.0"   
		String  []  li      =  line.trim().split(",");
		int         num     =  Integer.parseInt( li[0].trim() );
		String      pcode   =  li[1].trim();
		int         amount  =  Integer.parseInt( li[2].trim() );
		double      price   =  Double.parseDouble( li[3].trim() ); 
		
		p  =   new ProductDto(num, pcode, amount, price);
	}

	@Override
	public void process() {
		// 제품명  
		// P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이
		
		String  pname = "";
		if( p.getPcode().equals("P01") ) 
			p.setPname( "새우깡" );
		else 
			if ( p.getPcode().equals("P02")  )
				p.setPname("빅파이");
			else 
				if( p.getPcode().equals("P03") )
					p.setPname("짱구");
				else 
					if( p.getPcode().equals("P04") )
						p.setPname("초코파이");
					else
						if( p.getPcode().equals("P05") )
							p.setPname("수박맛초코파이");
	
		// 금액 
		// 금액(수량*단가)
		double  kum = p.getAmount() * p.getPrice();
		p.setKum( kum );
		
	}
/*
1,P01,10,1250.0
2,P02,15,2000.0
3,P03,30,1500.0
5,P04,25,2000.0
4,P05,28,1900.0
 */
	@Override
	public void output() {
		
		// System.out.println( p );  // p.toString()
		System.out.println("번호   제품명  수량     단가      금액");
		String  fmt = "%05d  %s   %d   %.3f   %.3f";
		String  msg = String.format(fmt, 
				p.getNum(), p.getPname(), p.getAmount(), 
				p.getPrice(), p.getKum());
		System.out.println( msg );
	}
	
}


public class TestProduct {

	public static void main(String[] args) {
		
		Product  p1  =  new Product();
		p1.input();
		p1.process();
		p1.output();

	}

}











