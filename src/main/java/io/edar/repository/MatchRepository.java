package io.edar.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import io.edar.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
	
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName,String teamName2,Pageable pageable);
	
	default  List<Match> findLatestMatchesbyTeam(String teamName,int count){
		return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, 4));
	}
	
}
