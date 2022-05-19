package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Test;
import tn.esprit.spring.repository.TestRepository;

@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	TestRepository testRepository;

	

	@Override
	public Test ajouterTest(Test test) {
		return testRepository.save(test);
	}

}