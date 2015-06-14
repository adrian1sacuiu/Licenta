package services;

import domain.Country;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.CountryDao;

import java.util.List;

@Transactional
@Service
public class CountryService {
	private static final Logger logger = Logger.getLogger(CountryService.class);

	@Autowired
	CountryDao countryDao;

	public boolean addCountry(Country country) throws Exception {
		logger.info("in addCountry method.");

		return countryDao.addCountry(country);
	}

	public boolean updateCountry(Country country) throws Exception {
		logger.info("in updateCountry method.");

		return countryDao.updateCountry(country);
	}

	public boolean deleteCountry(Country country) throws Exception {
		logger.info("in deleteCountry method.");

		return countryDao.deleteCountry(country);
	}

	@Transactional(readOnly = true)
	public List<Country> getAllCountries() {
		logger.info("in getAllCountries method.");

		return countryDao.getAllCountries();
	}

	@Transactional(readOnly = true)
	public Country getCountryById(Long id) {
		logger.info("in getCountryById method.");

		return countryDao.getCountryById(id);
	}
	
	@Transactional(readOnly = true)
	public Country getCountryByName(String name){
		logger.info("in getCountryByName method.");

		return countryDao.getCountryByName(name);
	}
	
	@Transactional(readOnly = true)
	public Country getCountryByCountryCode(String countryCode){
		logger.info("in getCountryByCountryCode method.");

		return countryDao.getCountryByCountryCode(countryCode);
	}
}
