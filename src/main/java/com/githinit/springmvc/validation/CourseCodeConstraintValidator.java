package com.githinit.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    public boolean isValid(String code, ConstraintValidatorContext context) {

        boolean result;

        if (code != null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;x
        }

        return result;

    }
}
