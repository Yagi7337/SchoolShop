package com.school.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.components.entity.Seller;
import com.school.components.interface_i.ISeller;

@Service
public class SellerService {
	@Autowired
	private ISeller iSeller;

	public Seller searchByIdSeller(int id) {
		return iSeller.searchByIdSeller(id);
	}

	public Collection<Seller> infoAboutSeller(int page) {
		return iSeller.infoAboutSeller(page);
	}

	public void addSeller(Seller seller) {
		iSeller.addSeller(seller);
	}
}
