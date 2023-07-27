package board;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestBoardDAO {

	public List<BoardVO> getBoardList() throws JsonMappingException, JsonProcessingException {
		
		// 뉴스 정보 받아올 url 입력
		String url = "http://172.31.9.168:8080/api/news";
		
		//RestTemplate으로 JSON 결과값 받아오기
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url,  HttpMethod.GET, null, String.class);
		
		// 결과값 중 JSON 데이터만 가져와기
		String responseBody = null;
		if (response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
			System.out.println(responseBody);
		} else {
			System.out.println("fail : " + response.getStatusCode());
		}
		
		// JSON 데이터를 VO로 mapping하기 (상대방 JSON 데이터에 맞는 VO를 생성해야 함
		List<BoardVO> boardList = null;
		ObjectMapper mapper = new ObjectMapper();
		boardList = mapper.readValue(responseBody, new TypeReference<List<BoardVO>>() {});
		
		return boardList;
		}
	
}
