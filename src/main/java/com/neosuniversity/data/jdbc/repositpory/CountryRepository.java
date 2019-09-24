package com.neosuniversity.data.jdbc.repositpory;

import com.neosuniversity.data.jdbc.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Integer> {
}
