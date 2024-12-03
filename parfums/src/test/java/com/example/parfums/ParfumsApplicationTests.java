package com.example.parfums;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.parfums.entities.Marque;
import com.example.parfums.entities.Parfum;
import com.example.parfums.repos.ParfumRepository;

@SpringBootTest
class ParfumsApplicationTests {
	
		@Autowired
		private ParfumRepository parfumRepository;
		
		@Test
		public void testCreateParfum() {
		Parfum parfum = new Parfum("dolice vita",2200.500,200);
		parfumRepository.save(parfum);
		Parfum parfum2 = new Parfum("dolice vita 2",2200.500,200);
		parfumRepository.save(parfum2);
		}
		
		@Test
		public void testFindParfum()
		{
		Parfum p = parfumRepository.findById(2L).get();
		System.out.println(p);
		}
		
		@Test
		public void testUpdateParfum()
		{
		Parfum p = parfumRepository.findById(2L).get();
		p.setPrixParfum(1000.0);
		parfumRepository.save(p);
		}
		
		@Test
		public void testDeleteParfum()
		{
		parfumRepository.deleteById(1L);;
		}
		
		@Test
		public void testListerTousParfums()
		{
		List<Parfum> parfums = parfumRepository.findAll();
		for (Parfum p : parfums)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void testFindParfumByNom()
		{
		List<Parfum> parfums = parfumRepository.findByNomParfum("dolcie vita");
		for (Parfum p:parfums) {
			System.out.println(p);
		}
		
		}
		@Test
		public void testFindParfumByNomContains()
		{
		List<Parfum> parfums = parfumRepository.findByNomParfumContains("dolcie");
		for (Parfum p:parfums) {
			System.out.println(p);
		}
		
		}
		@Test
		public void testfindByNomPrix()
		{
		List<Parfum> parfums = parfumRepository.findByNomPrix("dolice vita", 1000.0);
		for (Parfum p : parfums)
		{
			System.out.println(p);
		}
		}
		@Test
		public void testfindByMarque()
		{
			Marque marque = new Marque();
			marque.setId(1L);
			List<Parfum> parfums = parfumRepository.findByMarque(marque);
			for (Parfum p : parfums)
			{
				System.out.println(p);
			}
		}
		@Test
		public void findByMarqueId()
		{
		List<Parfum> parfums = parfumRepository.findByMarqueId(1L);
		for (Parfum p : parfums)
		{
		System.out.println(p);
		}
		 }
		@Test
		public void testfindByOrderByNomParfumAsc()
		{
		List<Parfum> parfums =
		parfumRepository.findByOrderByNomParfumAsc();
		for (Parfum p : parfums)
		{
		System.out.println(p);
		}
		}
		@Test
		public void testTrierParfumsNomsPrix()
		{
		List<Parfum> parfums = parfumRepository.trierParfumsNomsPrix();
		for (Parfum p : parfums)
		{
		System.out.println(p);
		}
		}




		
		

}
