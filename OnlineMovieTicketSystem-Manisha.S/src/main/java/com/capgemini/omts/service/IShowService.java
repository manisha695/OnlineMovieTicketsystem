package com.capgemini.omts.service;

import java.util.List;

import com.capgemini.omts.entity.ShowBean;

public interface IShowService {

	public ShowBean addShow(ShowBean Bean);

	public boolean removeShow(int showid);

	public List<ShowBean> getAllShows();

	public ShowBean getShows(int showId);
}
