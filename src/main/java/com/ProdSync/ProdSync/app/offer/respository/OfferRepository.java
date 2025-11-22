package com.ProdSync.ProdSync.app.offer.respository;

import com.ProdSync.ProdSync.app.offer.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
	Optional<Offer> findByName(String name);
}