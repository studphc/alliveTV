package p000;

import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabw;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class q73 extends zabw {

    /* renamed from: a */
    public final WeakReference f25482a;

    public q73(zabe zabeVar) {
        this.f25482a = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.f25482a.get();
        if (zabeVar == null) {
            return;
        }
        zabe.m3106b(zabeVar);
    }
}
