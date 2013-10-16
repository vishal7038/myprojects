/**
 * 
 */
package edu.pr.config;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author Devika Bhatt
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/**/*-config.xml")
//@ContextConfiguration("file:/edu/pr/config/*-config.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public abstract class AbstractAppTestEnvironment extends AbstractTransactionalJUnit4SpringContextTests
{
} 
