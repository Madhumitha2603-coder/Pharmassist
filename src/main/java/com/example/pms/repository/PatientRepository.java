package com.example.pms.repository;


	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.example.pms.entity.Patient;
	import com.example.pms.entity.Pharmacy;

	public interface PatientRepository extends JpaRepository<Patient , String> {
		
		List<Patient> findByPharmacy(Pharmacy pharmacy);

}
