package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CourseBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CourseDAO;
import lk.ijse.dto.CourseDTO;
import lk.ijse.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    CourseDAO courseDAO = (CourseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean save(CourseDTO dto) throws Exception {
        return courseDAO.save(new Course(dto.getCourse_id(),dto.getCourse_name(),dto.getDuration(),dto.getCourse_fee()));
    }

    @Override
    public boolean update(CourseDTO dto) throws Exception {
        return courseDAO.update(new Course(dto.getCourse_id(),dto.getCourse_name(),dto.getDuration(),dto.getCourse_fee()));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return courseDAO.delete(ID);
    }
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return courseDAO.generateNextId();
    }

    @Override
    public List<CourseDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Course> courses = courseDAO.getAll();
        List<CourseDTO> dto = new ArrayList<>();
        for (Course course : courses) {
            dto.add(new CourseDTO(course.getCourse_id(),course.getCourse_name(),course.getDuration(),course.getCourse_fee()));
        }
        return dto;
    }

    @Override
    public List<String> getIds() {
        return courseDAO.getIds();
    }

    @Override
    public Course searchById(String id) throws SQLException, ClassNotFoundException {
        return courseDAO.searchByID(id);
    }

    @Override
    public Course searchByName(String courseName) throws SQLException, ClassNotFoundException {
        return courseDAO.searchByName(courseName);
    }
}
