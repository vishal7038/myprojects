package edu.pr.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.pr.api.commons.DateUtils;
import edu.pr.dao.FinancialYearDao;
import edu.pr.model.FinancialYear;

public class FinancialYearDaoImpl extends HibernateDaoSupport implements FinancialYearDao
{
	static final Logger logger = Logger.getLogger(FinancialYearDaoImpl.class);
	
	public void save(FinancialYear financialYear) throws Exception 
	{
		if(financialYear==null) throw new Exception("FinancialYearDaoImpl.save():: Null financial year");
		getHibernateTemplate().saveOrUpdate(financialYear);
		getHibernateTemplate().flush();
		logger.info("financialYear.getId() = " + financialYear.getId());
	}
	
	public FinancialYear get(long id) throws Exception 
	{
		return getHibernateTemplate().get(FinancialYear.class, id);
	}
	
	public FinancialYear getCurrentFinancialYear() throws Exception 
	{
		Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(FinancialYear.class);
		c.add(Restrictions.ge("yearenddate",DateUtils.getSystemDate()));
		c.add(Restrictions.le("yearstartdate",DateUtils.getSystemDate()));
		return (FinancialYear)c.uniqueResult();
	}

	public List<FinancialYear> getAllFinancialYears() throws Exception 
	{
		return getHibernateTemplate().loadAll(FinancialYear.class);
	}
	
	
	
}
