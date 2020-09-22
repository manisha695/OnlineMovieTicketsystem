package com.capgemini.omts.service;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.omts.dao.ShowRepository;
import com.capgemini.omts.entity.ShowBean;
import com.capgemini.omts.service.ShowServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineMovieTicketSystemManishaApplicationTests {
@Autowired
private ShowServiceImpl showserviceimpl;
@MockBean
private ShowRepository repo;
@Test
public void testAddShows() {
	ShowBean bean=new ShowBean();
	
	
	  bean.setShowId(10);
	  bean.setShowTime("6.00"); 
	  bean.setShowName("First Show");
	  bean.setMovieName("bahuballi");
	  bean.setScreenId(1);
	  Mockito.when(repo.save(bean)).thenReturn(bean);
	  assertEquals(bean,showserviceimpl.addShow(bean));
	 
}
@Test
public void getAllShowsTest() {
	showserviceimpl.getAllShows();
	verify(repo).findAll();
}


}
