package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import p000.u83;

/* renamed from: com.google.android.gms.common.api.internal.h */
/* loaded from: classes.dex */
public final class RunnableC0750h implements Runnable {

    /* renamed from: a */
    public final u83 f13186a;

    /* renamed from: b */
    public final /* synthetic */ zap f13187b;

    public RunnableC0750h(zap zapVar, u83 u83Var) {
        this.f13187b = zapVar;
        this.f13186a = u83Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f13187b.zaa) {
            return;
        }
        ConnectionResult connectionResult = this.f13186a.f27151b;
        if (connectionResult.hasResolution()) {
            zap zapVar = this.f13187b;
            zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResult.getResolution()), this.f13186a.f27150a, false), 1);
            return;
        }
        zap zapVar2 = this.f13187b;
        if (zapVar2.zac.getErrorResolutionIntent(zapVar2.getActivity(), connectionResult.getErrorCode(), null) != null) {
            zap zapVar3 = this.f13187b;
            zapVar3.zac.zag(zapVar3.getActivity(), zapVar3.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.f13187b);
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            zap zapVar4 = this.f13187b;
            Dialog zab = zapVar4.zac.zab(zapVar4.getActivity(), zapVar4);
            zap zapVar5 = this.f13187b;
            zapVar5.zac.zac(zapVar5.getActivity().getApplicationContext(), new C0749g(this, zab));
            return;
        }
        zap zapVar6 = this.f13187b;
        int i = this.f13186a.f27150a;
        zapVar6.zab.set(null);
        zapVar6.zab(connectionResult, i);
    }
}
