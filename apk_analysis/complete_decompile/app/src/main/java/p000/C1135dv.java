package p000;

import java.util.ArrayList;

/* renamed from: dv */
/* loaded from: classes.dex */
public final class C1135dv extends Exception {

    /* renamed from: a */
    public final ArrayList f16556a;

    public C1135dv(ArrayList arrayList) {
        this.f16556a = arrayList;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "IncorrectConstraintException: " + this.f16556a.toString();
    }
}
