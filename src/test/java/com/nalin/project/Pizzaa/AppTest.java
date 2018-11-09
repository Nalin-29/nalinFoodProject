package com.nalin.project.Pizzaa;


import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ntl.pos.dao.AdministratorDaoImplTest;
import com.ntl.pos.dao.UserDaoImplTest;
import com.ntl.pos.dao.impl.UserDaoImpl;
import com.ntl.pos.service.AdministratorImplTest;
import com.ntl.pos.service.UserImplTest;
import com.ntl.pos.util.AuthenticationClassTest;
import com.ntl.pos.util.DbUtilClassTest;
import com.ntl.pos.util.UserClassTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AdministratorDaoImplTest.class,
    UserDaoImplTest.class,
    AdministratorImplTest.class,
    UserImplTest.class,
    AuthenticationClassTest.class,
    DbUtilClassTest.class,
    UserClassTest.class
})

public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
   
}
