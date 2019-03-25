package com.training.sanity.tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class NewTest1 {
	/*
  @Test(priority=1)
  public void A() {
	  System.out.println("In 1");
	  assertEquals("A2", "A1");
  }
  @Test
  public void B() {
	  System.out.println("In 2");
  }
  @Test(dependsOnMethods="A",alwaysRun=true)
  public void C() {
	  System.out.println("In 3");
  }
  @Test(dependsOnMethods="B", alwaysRun=true)
  public void D() {
	  System.out.println("In 4");
  }
  @Test
  public void E() {
	  System.out.println("In 5");
  }
  @Test
  public void F() {
	  System.out.println("In 6");
  }*/
	
	
	  @Test
	  public void B() {
		  System.out.println("In 2");
	  }
	  @Test(dependsOnMethods="D",alwaysRun=true)
	  public void C() {
		  System.out.println("In 3");
	  }
	  @Test
	  public void D() {
		  System.out.println("In 4");
		 // assertEquals("A2", "A1");
	  }
	
}
