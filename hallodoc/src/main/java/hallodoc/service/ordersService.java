package hallodoc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hallodoc.dto.AssignCaseDto;
import hallodoc.dto.ordersDto;
import hallodoc.model.HealthProfessionals;
import hallodoc.model.OrderDetails;
import hallodoc.repo.HealthProfessionalsDao;
import hallodoc.repo.OrderDetailsDao;

@Service
public class ordersService {

	@Autowired
	private HealthProfessionalsDao healthProfessionalsDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	public List<ordersDto> serviceOrder(int typeId)
	{
		
		List<ordersDto> ordersDtos = healthProfessionalsDao.getProfessionalsList(typeId);
		return ordersDtos;
		}
	
	public void sendOrders(ordersDto ordersDto) {
		
		
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setBusinessContact(ordersDto.getBusinessContact());
		orderDetails.setCreatedBy(751);
		orderDetails.setCreatedDate(LocalDateTime.now());
		orderDetails.setEmail(ordersDto.getEmail());
		orderDetails.setFaxNumber(ordersDto.getFaxNumber());
		orderDetails.setNoOfRefill(ordersDto.getNumberOfrefill());
		orderDetails.setPrescription(ordersDto.getPrescription());
		orderDetails.setRequestId(ordersDto.getReqId());
		orderDetails.setVendorId(ordersDto.getVendorId1());
		orderDetailsDao.orderDetailsSave(orderDetails);
		
		int x = ordersDto.getVendorId1();
		
		List<HealthProfessionals> healthProfessionals = healthProfessionalsDao.getProfessionalsList1(x);
		HealthProfessionals healthProfessionals2 = healthProfessionals.get(0);
		healthProfessionals2.setBusinessContact(ordersDto.getBusinessContact());
		healthProfessionals2.setEmail(ordersDto.getEmail());
		healthProfessionals2.setFaxNumber(ordersDto.getFaxNumber());
		healthProfessionals2.setModifiedDate(LocalDateTime.now());
		healthProfessionalsDao.healthProfessionalsUpdate(healthProfessionals2);
		
		
	}
	
	
}
