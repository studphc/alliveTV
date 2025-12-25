package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public enum zzkm implements zzmf {
    PURPOSE_RESTRICTION_NOT_ALLOWED(0),
    PURPOSE_RESTRICTION_REQUIRE_CONSENT(1),
    PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST(2),
    PURPOSE_RESTRICTION_UNDEFINED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a */
    public final int f13874a;

    zzkm(int i) {
        this.f13874a = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f13874a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
