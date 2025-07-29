package com.validate;
import com.model.Admission;

import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CustomValidator implements Validator {
    
    public boolean supports(Class<?> clazz) {
        return clazz == Admission.class;
    }
    
    public void validate(Object target, Errors errors) {
        Admission admission = (Admission) target;

        String name = admission.getChildName();
        if (name != null && !name.trim().isEmpty()) {
            if (!name.matches("[A-Za-z ]{2,}")) {
                errors.rejectValue("childName", "error.childName", 
                    "Name should contain only alphabets and spaces with a minimum of 2 characters");
            }
        }

        String contact = admission.getContactNumber();
        if (contact != null && !contact.trim().isEmpty()) {
            if (!contact.matches("^[6-9]\\d{9}$")) {
                errors.rejectValue("contactNumber", "error.contactNumber", 
                    "Contact Number should be of 10 digits and start with a number between 6 and 9");
            }
        }
    }

}
