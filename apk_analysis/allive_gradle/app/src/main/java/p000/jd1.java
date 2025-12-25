package p000;

import androidx.core.location.LocationListenerCompat;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public final class jd1 {

    /* renamed from: a */
    public final String f20468a;

    /* renamed from: b */
    public final LocationListenerCompat f20469b;

    public jd1(LocationListenerCompat locationListenerCompat, String str) {
        this.f20468a = (String) ObjectsCompat.requireNonNull(str, "invalid null provider");
        this.f20469b = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jd1)) {
            return false;
        }
        jd1 jd1Var = (jd1) obj;
        if (!this.f20468a.equals(jd1Var.f20468a) || !this.f20469b.equals(jd1Var.f20469b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ObjectsCompat.hash(this.f20468a, this.f20469b);
    }
}
