package org.sesela.commons.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.sesela.commons.validator.impl.UrlFormatValidator;

/**
 * URL書式バリデーション用のアノテーションです。
 * 
 * @author sesela
 * 
 */
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UrlFormatValidator.class)
@Documented
public @interface UrlFormat {

	/**
	 * エラーメッセージコード。デフォルト"{org.sesela.commons.validation.UrlFormat.message}"です。
	 * @return エラーメッセージコード
	 */
	String message() default "{org.sesela.commons.validation.UrlFormat.message}";
	
	/**
	 * 制約に対するバリデーションが属するグループ。
	 * @return グループ
	 */
	Class<?>[] groups() default { };

	/**
	 * ペイロード
	 * @return ペイロード
	 */
	Class<? extends Payload>[] payload() default { };


}
