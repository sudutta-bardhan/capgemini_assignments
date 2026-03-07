package com.capgemini.spring_assignment_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
  public static void main(String[] args)
  {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

    Employee emp = (Employee) context.getBean("employee");

    System.out.println(emp);
  }
}