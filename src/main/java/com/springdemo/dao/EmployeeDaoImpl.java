package com.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.dto.EmployeeDto;
import com.springdemo.model.Employee;

@Repository
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactoryRead;

	
	@Override
	public List<EmployeeDto> employeeList() {
		
		Session session = sessionFactoryRead.getCurrentSession();
		Criteria crt = session.createCriteria(Employee.class);
		
		// one to one mapping
		/*crt.createAlias("address", "address");
		//crt.createAlias("address", "address", JoinType.LEFT_OUTER_JOIN);	// Join type
		crt.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("email"),"email")
				.add(Projections.property("address.address"),"address"))
			.addOrder(Order.asc("name"))
			.setResultTransformer(new AliasToBeanResultTransformer(EmployeeDto.class));*/
		
		// one to many mapping
		//crt.createAlias("address", "address");
		//crt.createAlias("contacts", "contacts");
		/*crt.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("email"),"email")
				.add(Projections.property("address.address"),"address")
				.add(Projections.property("contacts"),"contacts"))
			.addOrder(Order.asc("name"))
			.setResultTransformer(new AliasToBeanResultTransformer(EmployeeDto.class));*/
		
		//crt.list().forEach(item -> System.out.println(item.toString()));
		crt.list().forEach(item -> System.out.println(item));
		//System.out.println(crt.list().size());
		//return crt.list();
		return new ArrayList<EmployeeDto>();
	}

}
