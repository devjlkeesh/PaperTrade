package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerCompanyCriteria;
import dev.jlkeesh.papertrade.domains.main.CustomerCompany;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface CustomerCompanyRepository extends GenericCrudRepository<CustomerCompany, Long, CustomerCompanyCriteria> {
}
