package webtester.service;

import java.util.List;

import webtester.model.Test;

public interface StudentService {

	List<Test> findAll();
	
	List<Test> findAllforPassTest(Long id);
	
}
