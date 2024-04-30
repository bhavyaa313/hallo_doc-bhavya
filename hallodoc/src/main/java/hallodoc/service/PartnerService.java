package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.AddBusinessDto;
import hallodoc.enums.RegionEnum;
import hallodoc.model.HealthProfessionalType;
import hallodoc.model.HealthProfessionals;
import hallodoc.repo.HealthProfessionalsDao;

@Service
public class PartnerService {
	
	@Autowired
	private HealthProfessionalsDao healthProfessionalsDao;
	
	public List<HealthProfessionals>  Service(){
		List<HealthProfessionals> healthProfessionals = healthProfessionalsDao.getProfessionalsList2();
		
		return healthProfessionals;
		
	}
	

	
	public void addBusiness(AddBusinessDto addBusinessDto)
	{
		String state = addBusinessDto.getState();
		HealthProfessionals healthProfessionals = new HealthProfessionals();
		healthProfessionals.setBusinessContact(addBusinessDto.getBcontact());
		healthProfessionals.setCity(addBusinessDto.getCity());
		healthProfessionals.setCreatedDate(LocalDateTime.now());
		healthProfessionals.setEmail(addBusinessDto.getEmail());
		healthProfessionals.setFaxNumber(addBusinessDto.getFax());
		healthProfessionals.setPhoneNumber(addBusinessDto.getPhone());
		healthProfessionals.setVendorName(addBusinessDto.getName());
		int regionId = RegionEnum.valueOf(state).getid();
		healthProfessionals.setRegionId(regionId);
		/* healthProfessionals.setState(); */
		healthProfessionals.setZip(addBusinessDto.getZip());
		int pId = Integer.parseInt(addBusinessDto.getProfession());
		
		List<HealthProfessionalType> healthProfessionalTypes = healthProfessionalsDao.getProfessionalstype(pId);
		HealthProfessionalType healthProfessionalType = healthProfessionalTypes.get(0);
		healthProfessionals.setProfession(healthProfessionalType);
		healthProfessionalsDao.healthProfessionalsSave(healthProfessionals);
		
		
	}
	
	public void updateBusiness(AddBusinessDto addBusinessDto, int id) {
		
		List<HealthProfessionals> healthProfessionals = healthProfessionalsDao.getProfessionalsList1(id);
		HealthProfessionals healthProfessionals2 = healthProfessionals.get(0);
		String state = addBusinessDto.getState();
		healthProfessionals2.setBusinessContact(addBusinessDto.getBcontact());
		healthProfessionals2.setCity(addBusinessDto.getCity());
		healthProfessionals2.setModifiedDate(LocalDateTime.now());
		healthProfessionals2.setEmail(addBusinessDto.getEmail());
		healthProfessionals2.setFaxNumber(addBusinessDto.getFax());
		healthProfessionals2.setPhoneNumber(addBusinessDto.getPhone());
		healthProfessionals2.setVendorName(addBusinessDto.getName());
		healthProfessionals2.setState(addBusinessDto.getState());
		healthProfessionals2.setZip(addBusinessDto.getZip());
		
		int regionId = RegionEnum.valueOf(state).getid();
		healthProfessionals2.setRegionId(regionId);
		
		int pId = Integer.parseInt(addBusinessDto.getProfession());
		
		List<HealthProfessionalType> healthProfessionalTypes = healthProfessionalsDao.getProfessionalstype(pId);
		HealthProfessionalType healthProfessionalType = healthProfessionalTypes.get(0);
		healthProfessionals2.setProfession(healthProfessionalType);
		healthProfessionalsDao.healthProfessionalsUpdate(healthProfessionals2);
		
		
	}
	
	public List<HealthProfessionals>  Service1(int id){
		List<HealthProfessionals> healthProfessionals = healthProfessionalsDao.getProfessionalsList1(id);
		
		return healthProfessionals;
		
	}
	
	public void delete(int id)
	{
		List<HealthProfessionals> healthProfessionals = healthProfessionalsDao.getProfessionalsList1(id);
		HealthProfessionals healthProfessionals2 = healthProfessionals.get(0);
		healthProfessionals2.setDeleted(true);
		healthProfessionals2.setModifiedDate(LocalDateTime.now());
		healthProfessionalsDao.healthProfessionalsUpdate(healthProfessionals2);
	}
}
