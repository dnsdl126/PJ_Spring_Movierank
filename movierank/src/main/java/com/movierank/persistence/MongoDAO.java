package com.movierank.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.movierank.domain.MovieDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoDAO {
	@Autowired
	private MongoOperations mongoOper;
	
	public void save(MovieDTO mDto) {
		log.info(">>>>>>>>>> 영화 랭킹 정보 MongoDB에 저장 ");
		mongoOper.save(mDto);
	}
	
	public void dropCol() {
		log.info(">>>>>>>>>>> Collection Drop");
		mongoOper.dropCollection("movie");
	}
	
	public List<MovieDTO > movieList(){
		log.info(">>>>> 영화 랭킹정보 MongoDB에 저장");
		Criteria cri = new Criteria();
		//Criteria cri = new Criteria(key);
		// cir.is(value);
		// -> SELECT * FROM movie WHERE key= value;
		Query query = new Query(cri);
		List<MovieDTO> list = mongoOper.find(query, MovieDTO.class, "movie" );
		                                           // resultType , 어떤 컬랙션인지 
		for (MovieDTO one : list ) {
			log.info(one.toString());
		}
		//List<MoveDTO> list= mongoOper.find(query, entityClass);
		
		return list;
	}
	
}
