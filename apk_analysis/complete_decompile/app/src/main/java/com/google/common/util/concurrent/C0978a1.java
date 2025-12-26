package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ServiceManager;
import p000.v91;

/* renamed from: com.google.common.util.concurrent.a1 */
/* loaded from: classes2.dex */
public final class C0978a1 implements v91 {
    @Override // p000.v91
    /* renamed from: a */
    public final void mo4346a(Object obj) {
        ((ServiceManager.Listener) obj).stopped();
    }

    public final String toString() {
        return "stopped()";
    }
}
