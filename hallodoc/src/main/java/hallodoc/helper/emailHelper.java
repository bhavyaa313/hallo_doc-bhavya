package hallodoc.helper;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hallodoc.model.VerificationToken;
import hallodoc.repo.VerificationTokenDao;
import hallodoc.service.mailService;

@Service
public class emailHelper {

	@Autowired
	private mailService mailService;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Autowired
	private TokenChecker tokenChecker;

	@Autowired
	private VerificationTokenDao verificationTokenDao;

	public void sendMailString(String mail) {
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setEmail(mail);
		verificationToken.setCreated_date(LocalDateTime.now());

		String token = new TokenGenerator().GenerateToken();
		verificationToken.setToken(token);

		String mailUrl = "http://localhost:8080/hallodoc/reset" + token;
		mailService.send(mail, "Validation", mailUrl);

		List<VerificationToken> tokenList = tokenChecker.checkMailStatusList(verificationToken.getEmail());

		if (tokenList.size() != 0) {
			VerificationToken lasVerificationToken = tokenList.get(tokenList.size() - 1);
			lasVerificationToken.setValidation(false);
			verificationToken.setValidation(true);
			verificationTokenDao.verificationTokenSave(verificationToken);
			verificationTokenDao.verificationTokenUpdate(lasVerificationToken);
		} else {
			verificationToken.setValidation(true);
			verificationTokenDao.verificationTokenSave(verificationToken);
		}

	}
}
