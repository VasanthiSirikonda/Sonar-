package org.infinite.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infinite.dbutils.HibernateUtils;
import org.infinite.pojo.Student;

public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = null;
		Transaction tx = null;
		// Get the session object.
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {
			// Start hibernate session.
			tx = session.beginTransaction();
			// Insert a new student record in the database.
			// Commit hibernate transaction if no exception occurs.
			for (int i = 1; i <= 50; i++) {
				student = new Student();
				student.setFirstName("Vasanthi" + i);
				student.setLastName("Sirikonda" + i);
				student.setClassName("Btech");
				student.setRollNo("CVJHBK7456" + i);
				student.setAge(21);
				session.save(student);

			}
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				// Roll back if any exception occurs.
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close hibernate session.
			session.close();
		}
	}

}
