package uti.ro.java.tutorials.employees;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "name", "required.name","Field name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "lastname", "required.lastname","Field last name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "salary", "required.salary","Field salary is required.");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }
}
