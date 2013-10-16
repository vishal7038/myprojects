package edu.pr.dao;

import java.util.List;

import edu.pr.model.FinancialYear;

/**

 *
 */
public interface FinancialYearDao 
{
	public FinancialYear get(long id) throws Exception;
	public void save(FinancialYear financialYear) throws Exception;
	public List<FinancialYear> getAllFinancialYears() throws Exception;
	public FinancialYear getCurrentFinancialYear() throws Exception ;
}
