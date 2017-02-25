package org.sesela.common.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.sesela.common.validator.LongRangeFormat;

/**
 * Long型範囲指定書式バリデーションクラスです。
 * 
 * @author sesela
 * 
 */
public class LongRangeFormatValidator implements
		ConstraintValidator<LongRangeFormat, String> {

	long min;
	long max;
	
	@Override
	public boolean isValid(final String obj, final ConstraintValidatorContext arg1) {
		if (StringUtils.isEmpty(obj)) {
			return true;
		}
		
		long val;
		try {
            val = Long.valueOf(obj);
        } catch (NumberFormatException e) {
            return true;
        }
		return GenericValidator.isInRange(val, min, max);
	}

	@Override
	public void initialize(final LongRangeFormat arg) {
		min = arg.min();
		max = arg.max();
	}

}