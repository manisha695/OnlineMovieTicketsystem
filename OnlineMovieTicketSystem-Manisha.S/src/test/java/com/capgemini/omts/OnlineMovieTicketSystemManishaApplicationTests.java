package com.capgemini.omts;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.omts.entity.ShowBean;
import com.capgemini.omts.service.ShowServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineMovieTicketSystemManishaApplicationTests {
@Autowired
ShowServiceImpl showserviceimpl;
	
  @Test
  void getAllShows() {
	  List<ShowBean> bean=showserviceimpl.getAllShows();
	  assertEquals(bean.size(),3);
}
  
  }