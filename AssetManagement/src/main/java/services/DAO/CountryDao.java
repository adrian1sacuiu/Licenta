package services.DAO;

import domain.Country;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

@Repository
public class CountryDao extends SessionController {
	private static final Logger logger = Logger.getLogger(CountryDao.class);

	public Country addCountry(Country country) {
		logger.info("Inside addCountry method.");

		try {
			getCurrentSession().save(country);

		} catch (Exception e) {
			logger.error("in addCountry method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return country;
	}

	public boolean updateCountry(Country country) {
		logger.info("Inside updateCountry method.");
		boolean result = false;

		try {
			getCurrentSession().update(country);
			result = true;

		} catch (Exception e) {
			logger.error("in updateCountry method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return result;
	}

	public Country deleteCountry(Country country) {
		logger.info("Inside deleteCountry method.");

		try {
			getCurrentSession().delete(country);

		} catch (Exception e) {
			logger.error("in deleteCountry method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return country;
	}

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		logger.info("Inside getAllCountries method.");
		List<Country> countries = null;

		try {
			countries = getCurrentSession().createCriteria(Country.class).list();

		} catch (Exception e) {
			logger.error("in getAllCountrys method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return countries;
	}

	public Country getCountryById(Long id) {
		logger.info("Inside getCountryById method.");
		Country country = null;

		try {
			country = (Country) getCurrentSession().get(Country.class, id);
		} catch (Exception e) {
			logger.error("in getCountryById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return country;
	}

	public Country getCountryByName(String name) {
		logger.info("Inside getCountryByName method.");
		Country country = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getCountryByName");
			query.setParameter("name", name);

			country = (Country) query.uniqueResult();

		} catch (Exception e) {
			logger.error("in getCountryByName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return country;
	}

	public Country getCountryByCountryCode(String countryCode) {
		logger.info("Inside getCountryByCountryCode method.");
		Country country = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getCountryByCountryCode");
			query.setParameter("countryCode", countryCode);

			country = (Country) query.uniqueResult();

		} catch (Exception e) {
			logger.error("in getCountryByCountryCode method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return country;
	}

}
