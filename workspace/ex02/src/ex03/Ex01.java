package ex03;

public class Ex01 {
	public static void main(String[] args) {
			//		bit 연산자
				/*
				 * ~:bit not
				 * &:bit and
				 * ^:bit xor
				 * |:bit or
				 * <<:bit shift left 들어오는 값 이 0
				 * >>:bit shift right 들어오는 값 이 부호비트값
				 * >>>: bit shift 들어오는 값 이 0
				 */
		//bit masking - 특정비트를추출
		int a = 91;
		int mask = 24;
		int result = a & mask;
		String msg="";
		switch (result) {
		case 0:
			msg = "mono, ssd X";
			break;
		case 8:
			msg = "mono, ssd O";
			break;
		case 16:
			msg = "color, ssd X";
			break;
		case 24:
			msg = "color, ssd O";
			break;
		default:
			break;
		}
		System.out.println(msg);
		
		result = result >> 3;
		
	}
}
