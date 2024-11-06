package com.example.pms.service;

	import java.util.List;
	import org.springframework.stereotype.Service;
	import com.example.pms.entity.Patient;
	import com.example.pms.exception.NoPatientsFoundException;
	import com.example.pms.exception.PatientNotFoundByIdException;
	import com.example.pms.exception.PharmacyNotFoundByIdException;
	import com.example.pms.mapper.PatientMapper;
	import com.example.pms.repository.PatientRepository;
	import com.example.pms.repository.PharmacyRepository;
	import com.example.pms.requestdtos.PatientRequest;
	import com.example.pms.responsedtos.PatientResponse;

	@Service
	public class PatientService {
		
		private final PatientRepository patientRepository;
		private final PharmacyRepository pharmacyRepository;
		private final PatientMapper patientMapper;

		public PatientService(PatientRepository patientRepository, PharmacyRepository pharmacyRepository,
				PatientMapper patientMapper) {
			super();
			this.patientRepository = patientRepository;
			this.pharmacyRepository = pharmacyRepository;
			this.patientMapper = patientMapper;
		}

		public PatientResponse addPatient( PatientRequest patientRequest, String pharmacyId) {

			return pharmacyRepository.findById(pharmacyId)
					.map(pharmacy  ->{
						Patient patient=patientMapper.mapToPatient(patientRequest, new Patient());
						patient.setPharmacy(pharmacy);
						pharmacy.getPatients().add(patient);
						patientRepository.save(patient);
						return patientMapper.mapToPatientResponse(patient);
					})
					.orElseThrow(() ->new PharmacyNotFoundByIdException("Failed to find Pharmacy"));
	                        
		}


}
