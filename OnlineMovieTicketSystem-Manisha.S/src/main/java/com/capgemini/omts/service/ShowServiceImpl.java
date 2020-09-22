package com.capgemini.omts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.omts.Exception.ShowException;
import com.capgemini.omts.dao.ShowRepository;
import com.capgemini.omts.entity.ShowBean;

@Service
public class ShowServiceImpl implements IShowService {
	@Autowired
	ShowRepository repo;

	@Override
	public ShowBean addShow(ShowBean bean) {
		ShowBean showbean = repo.save(bean);
		return showbean;
	}

	@Override
	public boolean removeShow(int showId) {

		if (repo.existsById(showId)) {

			repo.deleteById(showId);
		}

		return true;

	}

	@Override
	public List<ShowBean> getAllShows() {
		return repo.findAll();

	}

	@Override
	public ShowBean getShows(int showId) {
		if (repo.findById(showId).isPresent()) {
			System.out.println("showId");
		} else {
			throw new ShowException("id not found");
		}
		return repo.findById(showId).get();
	}

}
