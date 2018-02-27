package com.ucan.userservice.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user", types = User.class)
public interface UserProjection {

	String getId();

	String getName();

	int getAge();

	String getEmail();
}
