package com.ce.springboot;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {

		@Autowired
		private OrderDao orderDao;
		@Autowired
		private OrderGoodDao orderGoodDao;
		@Autowired
		private GoodDao goodDao;
		@Autowired
		private ClientDao clientDao;
		@Autowired
		private ContactmanDao contactmanDao;

		private List<OrderResult> orderres = new ArrayList<>();



		@Test
		public void CC(){
			List<Contactman> contactman = contactmanDao.getContactman();
			for (Contactman contactman1 : contactman) {
				System.out.println("contactman1 = " + contactman1);
			}
		}



		@Test
	public void OO(){
			List<Good> goods = goodDao.selectAllGood();
			for (Good good : goods) {
				System.out.println("good = " + good);
			}
		}
		@Test
		public void OOO(){
			List<Client> clients = clientDao.selectClient();
			for (Client client : clients) {
				System.out.println("client = " + client);
			}
		}
}


