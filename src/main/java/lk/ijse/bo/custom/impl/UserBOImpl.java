package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    @Override
    public boolean save(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUser_id(),dto.getUsername(),dto.getAddress(),dto.getUser_phone(),dto.getUser_email(),dto.getPosition(),dto.getPassword()));
    }

    @Override
    public boolean update(UserDTO dto) throws Exception {
        return userDAO.update(new User(dto.getUser_id(),dto.getUsername(),dto.getAddress(),dto.getUser_phone(),dto.getUser_email(),dto.getPosition(),dto.getPassword()));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return userDAO.delete(ID);
    }

    @Override
    public List<UserDTO> getAll() throws SQLException, ClassNotFoundException {
        List<User> users = userDAO.getAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserDTO(user.getUser_id(),user.getUsername(),user.getAddress(),user.getUser_phone(),user.getUser_email(),user.getPosition(),user.getPassword()));
        }
        return dtos;
    }

    @Override
    public User searchByIdUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.searchByID(id);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return userDAO.generateNextId();
    }

    @Override
    public List<String> getUserIds() {
        return userDAO.getUserIds();
    }
}

