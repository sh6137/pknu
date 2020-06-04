package sontest;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class LottoTest {

	public static void main(String[] args) {
		
		// 로또 회차
		String turn = "913";
		URL result;
		
		try {
			
			// 로또 추첨 결과 조회 URL
			result = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + turn);
			
			InputStreamReader isr = new InputStreamReader(result.openConnection().getInputStream(), "UTF-8");
			
			// JSON 형식 읽기
			JSONObject object = (JSONObject)JSONValue.parse(isr);
			
			System.out.println("읽기 결과 : " + object.toJSONString());
			
			// 성공인 경우
			if ("success".equals(object.get("returnValue"))) {
				
				System.out.print("로또 번호 :");
				for (int i = 1; i <= 6; i++) {
					System.out.print(" " + object.get("drwtNo" + i));
				}
				System.out.println(" (보너스 : " + object.get("bnusNo") + ")");
			} else {
				System.out.println(turn + "회차 로또 정보 읽기를 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}