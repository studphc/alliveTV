package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* renamed from: com.google.android.gms.common.api.internal.g */
/* loaded from: classes.dex */
public final class C0749g extends zabw {

    /* renamed from: a */
    public final /* synthetic */ Dialog f13184a;

    /* renamed from: b */
    public final /* synthetic */ RunnableC0750h f13185b;

    public C0749g(RunnableC0750h runnableC0750h, Dialog dialog) {
        this.f13185b = runnableC0750h;
        this.f13184a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zap zapVar = this.f13185b.f13187b;
        zapVar.zab.set(null);
        zapVar.zac();
        Dialog dialog = this.f13184a;
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
