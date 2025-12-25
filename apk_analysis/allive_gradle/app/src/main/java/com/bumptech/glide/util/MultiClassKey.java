package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class MultiClassKey {

    /* renamed from: a */
    public Class f9177a;

    /* renamed from: b */
    public Class f9178b;

    /* renamed from: c */
    public Class f9179c;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        if (this.f9177a.equals(multiClassKey.f9177a) && this.f9178b.equals(multiClassKey.f9178b) && Util.bothNullOrEqual(this.f9179c, multiClassKey.f9179c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = (this.f9178b.hashCode() + (this.f9177a.hashCode() * 31)) * 31;
        Class cls = this.f9179c;
        if (cls != null) {
            i = cls.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2, null);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f9177a + ", second=" + this.f9178b + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        set(cls, cls2);
    }

    public void set(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f9177a = cls;
        this.f9178b = cls2;
        this.f9179c = cls3;
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        set(cls, cls2, cls3);
    }
}
