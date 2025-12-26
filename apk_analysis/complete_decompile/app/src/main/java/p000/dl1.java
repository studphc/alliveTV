package p000;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class dl1 {

    /* renamed from: a */
    public final String f16408a;

    /* renamed from: b */
    public final boolean f16409b;

    /* renamed from: c */
    public final boolean f16410c;

    public dl1(String str, boolean z, boolean z2) {
        this.f16408a = str;
        this.f16409b = z;
        this.f16410c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != dl1.class) {
            return false;
        }
        dl1 dl1Var = (dl1) obj;
        if (TextUtils.equals(this.f16408a, dl1Var.f16408a) && this.f16409b == dl1Var.f16409b && this.f16410c == dl1Var.f16410c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int m8286f = ye0.m8286f(31, 31, this.f16408a);
        int i2 = 1237;
        if (this.f16409b) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i3 = (m8286f + i) * 31;
        if (this.f16410c) {
            i2 = 1231;
        }
        return i3 + i2;
    }
}
