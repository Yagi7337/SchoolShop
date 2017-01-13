package com.school.components.interface_i;

import java.util.Collection;

import com.school.components.entity.Seller;

public interface ISeller {
	public Seller searchByIdSeller(int id);
	
	Collection<Seller> infoAboutSeller(int page);

	public void addSeller(Seller seller);
}
