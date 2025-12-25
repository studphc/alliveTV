package p000;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public class km1 {

    /* renamed from: a */
    public final String f20897a;

    /* renamed from: b */
    public final int f20898b;

    /* renamed from: c */
    public final int f20899c;

    public km1(String str, int i, int i2) {
        this.f20897a = str;
        this.f20898b = i;
        this.f20899c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof km1)) {
            return false;
        }
        km1 km1Var = (km1) obj;
        int i = this.f20899c;
        String str = this.f20897a;
        int i2 = this.f20898b;
        if (i2 >= 0 && km1Var.f20898b >= 0) {
            if (TextUtils.equals(str, km1Var.f20897a) && i2 == km1Var.f20898b && i == km1Var.f20899c) {
                return true;
            }
            return false;
        }
        if (TextUtils.equals(str, km1Var.f20897a) && i == km1Var.f20899c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ObjectsCompat.hash(this.f20897a, Integer.valueOf(this.f20899c));
    }
}
