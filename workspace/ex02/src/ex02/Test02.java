package ex02;

import java.util.Scanner;

public class Test02 {
	public static double salecal(double quantity, double sale){
		if(quantity >=1000) {
			sale = 0.5;
		}
		else if(quantity >=500 && quantity <1000) {
			sale = 0.3;
		}
		else if(quantity >=100 && quantity <500) {
			sale = 0.2;
		}
		else
			sale =0.1;
		
		return sale;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/*
		 * 제품코드
		 * 수량:
		 * 단가:
		 * 제품명
		 * 금액
		 * 할인액
		 * 총액
		 * 
		 * 할인률 수량 ->100개일때 5% 500개일때 10% 1000개일때 20% 
		 */
		int code;
		double quantity, unitPrice; //코드 수량 단가
		String goods = null; //제품이름
		double price; //가격
		double sale = 0; //할인율
		double total = 0; //매장가격
		
		System.out.println("제품코드 입력 : 1-5");

		code = Integer.parseInt(in.nextLine());

		while(code >5) {
			System.out.println("다시입력");
			code = Integer.parseInt(in.nextLine());
			}
		
		switch (code) {
		case 1:
			goods = "새우깡";
			unitPrice=100;
			quantity = 200;
			price = 1000;
			
			sale = salecal(quantity, sale);
			
			total =(price+unitPrice)*((double)1-sale);
			
			System.out.println(goods+"의 총 가격은" + total);
			break;
		case 2:
			goods = "양파링";
			unitPrice=100;
			quantity = 600;
			price = 1100;
			
			sale = salecal(quantity, sale);
			
			total =(price+unitPrice)*((double)1-sale);
			
			System.out.println(goods+"의 총 가격은" + total);
			
			break;
		case 3:
			goods = "허니칩";
			unitPrice=100;
			quantity = 600;
			price = 1500;
			
			sale = salecal(quantity, sale);
			
			total =(price+unitPrice)*((double)1-sale);
			
			System.out.println(goods+"의 총 가격은" + total);
			break;
		case 4:
			goods = "맛동산";
			unitPrice=100;
			quantity = 1300;
			price = 800;
			
			sale = salecal(quantity, sale);
			
			total =(price+unitPrice)*((double)1-sale);
			
			System.out.println(goods+"의 총 가격은" + total);
			break;
		case 5:
			goods = "고래밥";
			unitPrice=100;
			quantity = 60;
			price = 1200;
			
			sale = salecal(quantity, sale);
			
			total =(price+unitPrice)*((double)1-sale);
			
			System.out.println(goods+"의 총 가격은" + total);
			break;
		
		default:
			break;
		}
		
		
	}
}
