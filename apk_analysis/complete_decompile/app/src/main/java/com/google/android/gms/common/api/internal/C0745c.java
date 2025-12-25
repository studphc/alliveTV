package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* renamed from: com.google.android.gms.common.api.internal.c */
/* loaded from: classes.dex */
public final class C0745c implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a */
    public final /* synthetic */ GoogleApiManager f13180a;

    public C0745c(GoogleApiManager googleApiManager) {
        this.f13180a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        com.google.android.gms.internal.base.zau zauVar = this.f13180a.f13119n;
        zauVar.sendMessage(zauVar.obtainMessage(1, Boolean.valueOf(z)));
    }
}
