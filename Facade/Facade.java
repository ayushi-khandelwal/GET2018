package GET2018.EAD.EADSession4.Facade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import GET2018.EAD.EADSession4.DAO.DAOMethods;
import GET2018.EAD.EADSession4.Model.AuthenticatePojo;
import GET2018.EAD.EADSession4.Model.FriendInfoPojo;
import GET2018.EAD.EADSession4.Model.UserInfoPojo;

public class Facade {
	private static Facade singletonFacade = new Facade();
	private DAOMethods dao = DAOMethods.getInstance();

	public static Facade getInstance() {
		return singletonFacade;
	}

	public int authenticateUser(String email, String password) throws ClassNotFoundException, SQLException {
		AuthenticatePojo authenticateUser = dao.getPassword(email);
		if (authenticateUser.getPassword() == password) {
			return authenticateUser.getId();
		}
		return 0;
	}

	public boolean registerUser(String firstName, String lastName, Date dateOfBirth, int contactNo, String email,
			String password, String organization) throws ClassNotFoundException, SQLException {
		if (dao.addUser(firstName, lastName, dateOfBirth, contactNo, email, password, organization)) {
			return true;
		}
		return false;
	}

	public List<UserInfoPojo> getUserInfo(int id) throws ClassNotFoundException, SQLException {
		return dao.getUser(id);
	}

	public boolean updateUserInfo(String firstName, String lastName, Date dateOfBirth, int contactNo, int id)
			throws ClassNotFoundException, SQLException {
		dao.updateUser(firstName, lastName, dateOfBirth, contactNo, id);
		return true;
	}

	public List<FriendInfoPojo> getFriends(int id) throws ClassNotFoundException, SQLException {
		return dao.getFriends(id);
	}
}
