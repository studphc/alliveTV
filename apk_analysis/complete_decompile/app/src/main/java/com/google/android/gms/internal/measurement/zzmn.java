package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public enum zzmn {
    VOID(Void.class),
    INT(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class),
    BOOLEAN(Boolean.class),
    STRING(String.class),
    BYTE_STRING(zzld.class),
    ENUM(Integer.class),
    MESSAGE(Object.class);


    /* renamed from: a */
    public final Class f13889a;

    static {
        zzld zzldVar = zzld.zzb;
    }

    zzmn(Class cls) {
        this.f13889a = cls;
    }

    public final Class zza() {
        return this.f13889a;
    }
}
