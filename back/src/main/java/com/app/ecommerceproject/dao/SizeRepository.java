package com.app.ecommerceproject.dao;

import com.app.ecommerceproject.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
