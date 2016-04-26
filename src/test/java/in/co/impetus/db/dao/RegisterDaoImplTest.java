/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.db.dao;

import static org.junit.Assert.assertTrue;
import in.co.impetus.db.model.Roles;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterDaoImplTest.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/java/resources/applicationContext.xml"})
public class RegisterDaoImplTest {


    /** The register dao impl. */
    @Autowired
    private RegisterDao registerDaoImpl;

    /**
     * Test insert row.
     */
    @Test
    public void testInsertRow() {
        try{

            Users user = new Users();

            user.setAddress("address");
            user.setCity("city");
            user.setEnabled(true);
            user.setFirstName("firstName");
            user.setLastName("lastName");
            user.setMobile("mobile");
            user.setPincode(10);
            user.setPlanId(10);
            user.setPrimaryLanguage("primaryLanguage");
            user.setSecondaryLanguage("secondaryLanguage");
            user.setState("state");
            user.setUserName("userName");
            user.setUserPassword("userPassword");

            registerDaoImpl.insertUser(user);	
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test get users list.
     */
    @Test
    public void testGetUsersList() {
        try{

            registerDaoImpl.getUsersList();
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test get user by id.
     */
    @Test
    public void testGetUserById() {
        try{
            registerDaoImpl.getUserById("kingkrypton20@gmail.com");
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }


    /**
     * Test delete row.
     */
    @Test
    public void testDeleteRow() {
        try{
            registerDaoImpl.deleteUser("as@as.com");
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test insert subscription.
     */
    @Test
    public void testInsertSubscription() {
        try{
            Date date = new Date(new java.util.Date().getTime());
            Subscription subscription = new Subscription("Test",2 ,date , date, true, 10, 10, 10, "Test");
            registerDaoImpl.insertSubscription(subscription);
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test get plan by id.
     */
    @Test
    public void testGetPlanById() {
        try{
            registerDaoImpl.getPlanById(1);
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test save search criteria.
     */
    @Test
    public void testSaveSearchCriteria() {
        try{
            registerDaoImpl.saveSearchCriteria("Test", "Test");
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test check availability.
     */
    @Test
    public void testCheckAvailability() {
        try{
            registerDaoImpl.checkAvailability("Test");
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

    /**
     * Test insert roles.
     */
    @Test
    public void testInsertRoles() {
        try{
            Roles roles = new Roles("Test","ROLE_USER");
            registerDaoImpl.insertRoles(roles);
            assertTrue(true);

        }catch(Exception e){
            assertTrue(false);

        }
    }

}
