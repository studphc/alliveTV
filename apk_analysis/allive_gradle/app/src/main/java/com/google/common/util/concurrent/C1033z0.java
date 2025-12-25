package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ServiceManager;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.z0 */
/* loaded from: classes2.dex */
public final class C1033z0 implements v91 {
    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((ServiceManager.Listener) obj).healthy();
    }

    public final String toString() {
        return "healthy()";
    }
}
