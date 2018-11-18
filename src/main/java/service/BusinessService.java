package service;

import org.springframework.stereotype.Service;

import repository.BusinessRepo;

@Service
public class BusinessService {

	private BusinessRepo repo;

	public BusinessService(BusinessRepo repo) {
		super();
		this.repo = repo;
	}

	public int findTheGreatestFromAllData() {
		int[] data = repo.retrieveAllData();
		int greatest = Integer.MIN_VALUE;

		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}
