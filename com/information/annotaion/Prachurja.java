package com.information.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // This means this annotation is only be used in class level we can provide multiple type \
// using comma i.e. -> @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME) // means this annotation is applicable upto runtime
// if it is compiler level means once annotation is compiled that annotation is no longer be used
public @interface Prachurja {

}
