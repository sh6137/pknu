package sontest;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Lotto720Test {

	public static void main(String[] args) {
		
		// 로또 회차
		String turn = "5";
		URL result;
		
		try {
			
			// 로또 추첨 결과 조회 URL
			result = new URL("https://www.dhlottery.co.kr/common.do?method=get720Number&drwNo=" + turn);
			
			InputStreamReader isr = new InputStreamReader(result.openConnection().getInputStream(), "UTF-8");
			
			// JSON 형식 읽기
			JSONObject object = (JSONObject)JSONValue.parse(isr);
			
			System.out.println("읽기 결과 : " + object.toJSONString());
			System.out.println("------------------");
			System.out.println(object.get("rankNo"));
			
			// 성공인 경우
			if (turn.equals(object.get("round"))) {
				System.out.print("연금복권720 :");
				System.out.print(" " + object.get("rankClass"));
			} else {
				System.out.println(turn + "회차 로또 정보 읽기를 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Lotto720Test [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}