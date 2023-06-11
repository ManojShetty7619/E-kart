package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ShoppingApp;

@Repository
public interface ShoppingAppRepository extends JpaRepository<ShoppingApp, String> {
	ShoppingApp findByAppName(String appName);

}
