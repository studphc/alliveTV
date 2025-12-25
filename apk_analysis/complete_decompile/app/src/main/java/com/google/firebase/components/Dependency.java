package com.google.firebase.components;

import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes2.dex */
public final class Dependency {

    /* renamed from: a */
    public final Qualified f15540a;

    /* renamed from: b */
    public final int f15541b;

    /* renamed from: c */
    public final int f15542c;

    public Dependency(int i, int i2, Class cls) {
        this(Qualified.unqualified(cls), i, i2);
    }

    public static Dependency deferred(Class<?> cls) {
        return new Dependency(0, 2, cls);
    }

    @Deprecated
    public static Dependency optional(Class<?> cls) {
        return new Dependency(0, 0, cls);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(0, 1, cls);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(1, 0, cls);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(1, 1, cls);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(2, 0, cls);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(2, 1, cls);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (!this.f15540a.equals(dependency.f15540a) || this.f15541b != dependency.f15541b || this.f15542c != dependency.f15542c) {
            return false;
        }
        return true;
    }

    public Qualified<?> getInterface() {
        return this.f15540a;
    }

    public int hashCode() {
        return ((((this.f15540a.hashCode() ^ 1000003) * 1000003) ^ this.f15541b) * 1000003) ^ this.f15542c;
    }

    public boolean isDeferred() {
        if (this.f15542c == 2) {
            return true;
        }
        return false;
    }

    public boolean isDirectInjection() {
        if (this.f15542c == 0) {
            return true;
        }
        return false;
    }

    public boolean isRequired() {
        if (this.f15541b == 1) {
            return true;
        }
        return false;
    }

    public boolean isSet() {
        if (this.f15541b == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f15540a);
        sb.append(", type=");
        int i = this.f15541b;
        if (i == 1) {
            str = "required";
        } else if (i == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        int i2 = this.f15542c;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    str2 = "deferred";
                } else {
                    throw new AssertionError(ye0.m8291k(i2, "Unsupported injection: "));
                }
            } else {
                str2 = "provider";
            }
        } else {
            str2 = "direct";
        }
        return AbstractC1726qj.m7061q(sb, str2, "}");
    }

    public Dependency(Qualified qualified, int i, int i2) {
        this.f15540a = (Qualified) Preconditions.checkNotNull(qualified, "Null dependency anInterface.");
        this.f15541b = i;
        this.f15542c = i2;
    }

    public static Dependency deferred(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 2);
    }

    public static Dependency optionalProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 1);
    }

    public static Dependency required(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency requiredProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 1);
    }

    public static Dependency setOf(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 0);
    }

    public static Dependency setOfProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 1);
    }
}
