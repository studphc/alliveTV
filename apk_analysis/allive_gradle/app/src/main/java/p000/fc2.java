package p000;

import android.content.res.Resources;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public final class fc2 {

    /* renamed from: a */
    public final Resources f17210a;

    /* renamed from: b */
    public final Resources.Theme f17211b;

    public fc2(Resources resources, Resources.Theme theme) {
        this.f17210a = resources;
        this.f17211b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fc2.class != obj.getClass()) {
            return false;
        }
        fc2 fc2Var = (fc2) obj;
        if (this.f17210a.equals(fc2Var.f17210a) && ObjectsCompat.equals(this.f17211b, fc2Var.f17211b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ObjectsCompat.hash(this.f17210a, this.f17211b);
    }
}
