package edu.pr.service;

import java.util.List;

import edu.pr.dao.FinancialYearDao;
import edu.pr.model.FinancialYear;

public interface FinancialYearService 
{
	public void save(FinancialYear financialYear) throws Exception;
	public FinancialYear get(long id) throws Exception;
	public List<FinancialYear> getAllFinancialYears() throws Exception;
	public FinancialYear getCurrentFinancialYear() throws Exception ;
	
	public void setFinancialYearDao(FinancialYearDao financialYearDao); 
	
}
