package com.test.web.vo;

import lombok.Data;

@Data
public class BoardVO {
//롬복이 겟터 셋터 투스트링 다 만들어줌. 투스트링은 예의라서 만들어 줘야함. 오타 줄여줌. 틀리지 않는다. 장점 2. 코드가 간결해짐.
	//에러 많이 픽스되서 쓸만하다. 롬복
	private int biNum;
	private String biTitle;
	private String biBody;
	private String biAuthor;
	private String credat;
}
