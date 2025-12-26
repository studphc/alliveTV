package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import p000.wd2;

/* renamed from: androidx.arch.core.internal.a */
/* loaded from: classes.dex */
public abstract class AbstractC0110a extends SafeIterableMap.SupportRemove implements Iterator {

    /* renamed from: a */
    public wd2 f1646a;

    /* renamed from: b */
    public wd2 f1647b;

    @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
    /* renamed from: a */
    public final void mo324a(wd2 wd2Var) {
        wd2 wd2Var2 = null;
        if (this.f1646a == wd2Var && wd2Var == this.f1647b) {
            this.f1647b = null;
            this.f1646a = null;
        }
        wd2 wd2Var3 = this.f1646a;
        if (wd2Var3 == wd2Var) {
            this.f1646a = mo325b(wd2Var3);
        }
        wd2 wd2Var4 = this.f1647b;
        if (wd2Var4 == wd2Var) {
            wd2 wd2Var5 = this.f1646a;
            if (wd2Var4 != wd2Var5 && wd2Var5 != null) {
                wd2Var2 = mo326c(wd2Var4);
            }
            this.f1647b = wd2Var2;
        }
    }

    /* renamed from: b */
    public abstract wd2 mo325b(wd2 wd2Var);

    /* renamed from: c */
    public abstract wd2 mo326c(wd2 wd2Var);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1647b != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        wd2 wd2Var;
        wd2 wd2Var2 = this.f1647b;
        wd2 wd2Var3 = this.f1646a;
        if (wd2Var2 != wd2Var3 && wd2Var3 != null) {
            wd2Var = mo326c(wd2Var2);
        } else {
            wd2Var = null;
        }
        this.f1647b = wd2Var;
        return wd2Var2;
    }
}
