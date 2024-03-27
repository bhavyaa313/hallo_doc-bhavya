package hallodoc.helper;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

public class PasswordHash {
	public String encryptPassword(String password) {
		BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);

		Hash hash = Password.hash(password).with(bcrypt);

	

		return hash.getResult();
	}
}
