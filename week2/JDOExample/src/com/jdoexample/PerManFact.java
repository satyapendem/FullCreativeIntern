package com.jdoexample;

import javax.jdo.JDOHelper;

import javax.jdo.PersistenceManagerFactory;

public final class PerManFact
{
	
  private static final PersistenceManagerFactory pmf=JDOHelper.getPersistenceManagerFactory("transactions-optional");

  private PerManFact()
  {

  }
  public static PersistenceManagerFactory get(){
   return pmf;
  }

}