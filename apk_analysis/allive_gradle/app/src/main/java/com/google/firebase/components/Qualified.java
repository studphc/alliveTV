package com.google.firebase.components;

import androidx.annotation.NonNull;
import java.lang.annotation.Annotation;
import p000.l82;

/* loaded from: classes2.dex */
public final class Qualified<T> {

    /* renamed from: a */
    public final Class f15547a;

    /* renamed from: b */
    public final Class f15548b;

    public Qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f15547a = cls;
        this.f15548b = cls2;
    }

    @NonNull
    public static <T> Qualified<T> qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        return new Qualified<>(cls, cls2);
    }

    @NonNull
    public static <T> Qualified<T> unqualified(Class<T> cls) {
        return new Qualified<>(l82.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (!this.f15548b.equals(qualified.f15548b)) {
            return false;
        }
        return this.f15547a.equals(qualified.f15547a);
    }

    public int hashCode() {
        return this.f15547a.hashCode() + (this.f15548b.hashCode() * 31);
    }

    public String toString() {
        Class cls = this.f15548b;
        Class cls2 = this.f15547a;
        if (cls2 == l82.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
