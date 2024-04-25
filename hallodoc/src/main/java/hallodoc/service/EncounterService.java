package hallodoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;

import hallodoc.dto.EncounterDto;
import hallodoc.model.EncounterForm;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.repo.EncounterDao;
import hallodoc.repo.RequestClientDao;
import hallodoc.repo.RequestDao;

@Service
public class EncounterService {

	@Autowired
	private RequestDao requestDao;
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private RequestClientDao requestClientDao;

	public void service(int rId, EncounterDto encounterDto) {
		List<Request> requests = requestDao.getRequests(rId);
		Request request = requests.get(0);
		/*
		 * List<RequestClient> requestClients = requestClientDao.getRequests(request);
		 */
		List<EncounterForm> encounterList = encounterDao.getformList(request);
		if (encounterList.size() > 0) {
			EncounterForm encounterForm = encounterList.get(0);
			encounterForm.setAbd(encounterDto.getAbd());
			encounterForm.setBloodPressureNeg(encounterDto.getBloodPressureNeg());
			encounterForm.setBloodPressurePlus(encounterDto.getBloodPressurePlus());
			encounterForm.setChest(encounterDto.getChest());
			encounterForm.setCv(encounterDto.getCv());
			encounterForm.setExtr(encounterDto.getExtr());
			encounterForm.setFollowUp(encounterDto.getFollowUp());
			encounterForm.setHeent(encounterForm.getHeent());
			encounterForm.setHistoryOfIllness(encounterDto.getHistory1());
			encounterForm.setHr(encounterDto.getHr());
			encounterForm.setMedicalHistory(encounterDto.getHistory2());
			encounterForm.setNeuro(encounterDto.getNeuro());
			encounterForm.setO2(encounterDto.getO2());
			encounterForm.setOther(encounterDto.getOther());
			encounterForm.setPain(encounterDto.getPain());
			encounterForm.setProcedures(encounterDto.getProcedures());
			encounterForm.setRr(encounterDto.getRr());
			encounterForm.setSkin(encounterDto.getSkin());
			encounterForm.setMedicationsDespensed(encounterDto.getMedicationsDespensed());
			encounterForm.setTemp(encounterDto.getTemp());
			
			encounterForm.setTreatmentPlan(encounterDto.getTreatmentPlan());
			encounterDao.encounterFormUpdate(encounterForm);

		} else {
			EncounterForm encounterForm = new EncounterForm();

			encounterForm.setAbd(encounterDto.getAbd());
			encounterForm.setBloodPressureNeg(encounterDto.getBloodPressureNeg());
			encounterForm.setBloodPressurePlus(encounterDto.getBloodPressurePlus());
			encounterForm.setChest(encounterDto.getChest());
			encounterForm.setCv(encounterDto.getCv());
			encounterForm.setExtr(encounterDto.getExtr());
			encounterForm.setFollowUp(encounterDto.getFollowUp());
			encounterForm.setHeent(encounterForm.getHeent());
			encounterForm.setHistoryOfIllness(encounterDto.getHistory1());
			encounterForm.setHr(encounterDto.getHr());
			encounterForm.setMedicalHistory(encounterDto.getHistory2());
			encounterForm.setNeuro(encounterDto.getNeuro());
			encounterForm.setO2(encounterDto.getO2());
			encounterForm.setOther(encounterDto.getOther());
			encounterForm.setPain(encounterDto.getPain());
			encounterForm.setPhysicianId(request.getPhysicianId());
			encounterForm.setProcedures(encounterDto.getProcedures());
			encounterForm.setMedicationsDespensed(encounterDto.getMedicationsDespensed());
			encounterForm.setRr(encounterDto.getRr());
			encounterForm.setSkin(encounterDto.getSkin());
			encounterForm.setTemp(encounterDto.getTemp());
			encounterForm.setTreatmentPlan(encounterDto.getTreatmentPlan());
			encounterForm.setRequestId(request);
			encounterDao.EncounterSave(encounterForm);

		}
	}

}
