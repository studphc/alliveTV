package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class FieldAttributes {

    /* renamed from: a */
    public final Field f15658a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f15658a = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f15658a.getAnnotation(cls);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.f15658a.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.f15658a.getType();
    }

    public Type getDeclaredType() {
        return this.f15658a.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.f15658a.getDeclaringClass();
    }

    public String getName() {
        return this.f15658a.getName();
    }

    public boolean hasModifier(int i) {
        if ((i & this.f15658a.getModifiers()) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f15658a.toString();
    }
}
