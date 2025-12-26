package p000;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.moduleinstall.internal.zag;

/* loaded from: classes.dex */
public final class x63 extends zag {

    /* renamed from: a */
    public final ListenerHolder f28450a;

    public x63(ListenerHolder listenerHolder) {
        this.f28450a = listenerHolder;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void zab(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.f28450a.notifyListener(new w63(moduleInstallStatusUpdate));
    }
}
