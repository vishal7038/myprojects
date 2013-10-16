package edu.pr.test;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

import edu.pr.model.FinancialYear;
import edu.pr.service.FinancialYearService;
import edu.pr.config.AbstractAppTestEnvironment;
/**
 * @author Administrator
 *
 */
public class FinancialYearTestCase extends AbstractAppTestEnvironment
{
	public @Resource FinancialYearService financialYearService;
	
	/**
	 * Prepare Data of FinancialYear using setMethod
	 * @return FinancialYear
	 * @throws Exception
	 */
	public FinancialYear prepareFinancialYear() throws Exception
	{
		FinancialYear financialYear = new FinancialYear();
		financialYear.setLabel("13-14");
		String startDate="01 APR, 2013";
		String endDate="31 MAR, 2014";
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy");
		financialYear.setYearstartdate(sdf.parse(startDate));
		financialYear.setYearenddate(sdf.parse(endDate));
		return financialYear;
	}
	/**
	 * Save company using companyService.save()
	 * If company.getId()=0 test will be failed. 
	 * @throws Exception
	 */
	@Test
	public void saveFinancialYear() throws Exception
	{
		FinancialYear financialYear = prepareFinancialYear();
		financialYearService.save(financialYear);
			
		//logger.info("FinancialTearTestCase.saveFinancialYear() :: financialYear.getId()" + financialYear.getId());
		Assert.assertTrue(financialYear.getId()!=0);
	}
	
	/**
	 * Save null using financialYearService.save()
	 * If financialYearService.save() saves null value no exception will be thrown
	 * and test fail.
	 * @throws Exception
	 */
	@Test
	public void saveNullFinancialYear() throws Exception
	{
		try{
			financialYearService.save(null);
		}
		catch(Exception e){
			Assert.assertEquals(e.getMessage(), "FinancialYearDaoImpl.save():: Null financial year");
		}
	}

	/**
	 * Get FinancialYear object of specific id using financialYearService.get()   
	 * If financialYear == null test will be failed.
	 * @throws Exception
	 */
	@Test
	public void getFinancialYear() throws Exception
	{
		FinancialYear financialYear = prepareFinancialYear();
		financialYearService.save(financialYear);
		financialYear = financialYearService.get(financialYear.getId());
		//logger.info("FinancialYearTestCase.getFinancialYear() :: financialYear.getId()" + financialYear.getId());
		Assert.assertTrue(financialYear!=null);
	}
	
	/**
	 * Get FinancialYear object of specific id using financialYearService.get()   
	 * If financialYear == null test will be failed.
	 * @throws Exception
	 */
	@Test
	public void getCurrentFinancialYear() throws Exception
	{
		FinancialYear financialYear = prepareFinancialYear();
		financialYearService.save(financialYear);
		financialYear = financialYearService.getCurrentFinancialYear();
		Assert.assertTrue(financialYear!=null);
	}
	/**
	 * List all FinancialYear using financialYearService.getAllFinancialYears() 
	 * If lstFinancialYear.size()!= actual size
	 * and test will be failed 
	 * @throws Exception
	 */
	@Test
	public void getAllFinancialYears() throws Exception
	{
		FinancialYear financialYear = prepareFinancialYear();
		List<FinancialYear> lstFinancialYear = financialYearService.getAllFinancialYears();
		int result= simpleJdbcTemplate.queryForInt("select count(*) from financialYear");
		Assert.assertEquals(lstFinancialYear.size(), result);
	
	}	
	/**
	 * Get FinancialYear and update using financialYearService.updateFinancialYear()
	 * If financialYear.getId()=0 test will be failed
	 * @throws Exception
	 */
	@Test
	public void updateFinancialYear()throws Exception
	{
		FinancialYear financialYear = prepareFinancialYear();
		financialYearService.get(financialYear.getId());
		financialYear.setLabel("2012-2013");
		financialYearService.save(financialYear);
		Assert.assertTrue(financialYear.getId()!=0);
		
	}
}
