package com.example.pms.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.example.pms.entity.Pharmacy;

	public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
