package p000;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.service.zaa;

/* loaded from: classes.dex */
public final class f83 extends zaa {

    /* renamed from: a */
    public final y73 f17178a;

    public f83(y73 y73Var) {
        this.f17178a = y73Var;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void zab(int i) {
        this.f17178a.setResult((y73) new Status(i));
    }
}
