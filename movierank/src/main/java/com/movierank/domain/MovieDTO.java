package com.movierank.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 @Document(collection = "movie")

public class MovieDTO {

	// mongodb 는 _id값을 자동으로 생성 하여 PK역할을 한다 
	// 실제 Spring DTO = 10개변수 생성
	// MongoDB = _id+10개 컬럼 총 11개 컬럼이 생성 된다
	// 내가 _id를 사용하려면 @Id를 사용 한다
	
	@Id
	private int rank;            // 순위
	private String movie;        // 영화 제목
	private String imgsrc;       // 포스터 이미지
	private String type;         // 영화장르
	private String opendate;     // 개봉일
	private String bookingrate;  // 예매율
	private String runtime;      // 상영시간
	private String director;     // 감독
	private String actor;        // 출연자
	private String navercode;    // 네이버 영화코드
	private double naverscore;   // 네이버 평점
	private String daumcode;     // 다음 영화 코드
	private double daumscore;   // 다음 평점
	private double score;        // 네이버 + 다음 평점의 평균 
	
	

	
	
	
}
