package p000;

import com.google.firebase.components.Qualified;

/* renamed from: ay */
/* loaded from: classes2.dex */
public final class C0537ay {

    /* renamed from: a */
    public final Qualified f7788a;

    /* renamed from: b */
    public final boolean f7789b;

    public C0537ay(Qualified qualified, boolean z) {
        this.f7788a = qualified;
        this.f7789b = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0537ay)) {
            return false;
        }
        C0537ay c0537ay = (C0537ay) obj;
        if (!c0537ay.f7788a.equals(this.f7788a) || c0537ay.f7789b != this.f7789b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f7788a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f7789b).hashCode();
    }
}
