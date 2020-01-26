package controllers.servlets;

import controllers.errors.ValidationError;
import services.UserManagementService;
import services.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static controllers.utils.ServletsUtils.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"", "/login"})
public class LoginServlet extends HttpServlet {
    private UserManagementService service;
    private List<ValidationError> errors;


    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);
        boolean remember = (CHECKBOX_CHECKED).equals(req.getParameter(REMEMBER));
        errors = new ArrayList<>();

        if (!service.isUserLoginExists(login)) {
            errors.add(new ValidationError(LOGIN_ERROR_HEADER, LOGIN_NOT_EXIST_MESSAGE));
            req.setAttribute(ERRORS_ATTRIBUTE_NAME, errors);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        if (!service.isUserPasswordValid(login, password)) {
            errors.add(new ValidationError(PASSWORD_ERROR_HEADER, WRONG_PASSWORD_ERROR_MESSAGE));
            req.setAttribute(ERRORS_ATTRIBUTE_NAME, errors);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("users").forward(req, resp);
    }
}

