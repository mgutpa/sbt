package com.sbt.dao;

import org.springframework.data.repository.CrudRepository;

import com.sbt.model.LocationTimeOutVO;

public interface LocationTimeOutDao extends CrudRepository<LocationTimeOutVO, String> {

}
