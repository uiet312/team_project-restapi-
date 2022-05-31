package dev.info.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.info.model.Info;

@RestController
public class InfoController {

	// insert
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("city") String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Info info = new Info();

			info.setName(name);
			info.setAge(age);
			info.setGender(gender);
			info.setCity(city);

			em.persist(info);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

	// read��� ��Ŭ���������� �۵� �Ʒ����� ����
//	@RequestMapping(value = "/read", method = RequestMethod.GET)
//	public void Read(@RequestParam("id") int id) {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//			tx.begin();
//
//			Info findinfo = em.find(Info.class, id); 
//			System.out.println("�̸� :" + findinfo.getName()  + "\n���� :" + findinfo.getAge() + "\n���� :" + findinfo.getGender()
//			+ "\n���� :" + findinfo.getCity());
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//			emf.close();
//		}
//	}

	// read ���� �۵�
	@RequestMapping(value = "/read", method=RequestMethod.GET)
	public Info read(@RequestParam("id") int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		
		Info info = em.find(Info.class, id);
		return info;
	}
	
	// update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("city") String city) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Info findinfo = em.find(Info.class,id);
			findinfo.setName(name);
			findinfo.setAge(age);
			findinfo.setCity(city);
			findinfo.setGender(gender);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	// delete
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam("id") int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("team3_project");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Info findinfo = em.find(Info.class, id);
			em.remove(findinfo);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

}
