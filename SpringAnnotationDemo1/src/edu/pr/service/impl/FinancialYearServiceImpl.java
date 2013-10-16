package edu.pr.service.impl;

import edu.pr.dao.FinancialYearDao;
import edu.pr.model.FinancialYear;
import edu.pr.service.FinancialYearService;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
public class FinancialYearServiceImpl implements FinancialYearService
{
	private FinancialYearDao financialYearDao;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(FinancialYear financialYear) throws Exception 
	{
		financialYearDao.save(financialYear);
	}
	
	public FinancialYear get(long id) throws Exception 
	{
		return financialYearDao.get(id);
	}

	public FinancialYear getCurrentFinancialYear() throws Exception 
	{
		return financialYearDao.getCurrentFinancialYear();
	}

	public List<FinancialYear> getAllFinancialYears() throws Exception 
	{
		return financialYearDao.getAllFinancialYears();
	}

	public void setFinancialYearDao(FinancialYearDao financialYearDao) 
	{
		this.financialYearDao=financialYearDao;
		
	}
	
			
}
