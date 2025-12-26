package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import p000.a73;
import p000.p73;

/* loaded from: classes.dex */
public final class zaaj implements zabf {

    /* renamed from: a */
    public final zabi f13193a;

    /* renamed from: b */
    public boolean f13194b = false;

    public zaaj(zabi zabiVar) {
        this.f13193a = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = this.f13193a;
        try {
            zadc zadcVar = zabiVar.f13255n.f13241x;
            zadcVar.f13294a.add(apiMethodImpl);
            apiMethodImpl.zan(zadcVar.f13295b);
            zabe zabeVar = zabiVar.f13255n;
            Api.Client client = (Api.Client) zabeVar.f13232o.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && zabiVar.f13248g.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.setFailedResult(new Status(17));
            } else {
                apiMethodImpl.run(client);
            }
        } catch (DeadObjectException unused) {
            C0744b c0744b = new C0744b(this, this);
            p73 p73Var = zabiVar.f13246e;
            p73Var.sendMessage(p73Var.obtainMessage(1, c0744b));
        }
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        if (this.f13194b) {
            this.f13194b = false;
            a73 a73Var = new a73(this, this);
            p73 p73Var = this.f13193a.f13246e;
            p73Var.sendMessage(p73Var.obtainMessage(1, a73Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(@Nullable Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i) {
        zabi zabiVar = this.f13193a;
        zabiVar.m3111a(null);
        zabiVar.f13256o.zac(i, this.f13194b);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        if (!this.f13194b) {
            HashSet hashSet = this.f13193a.f13255n.f13240w;
            if (hashSet != null && !hashSet.isEmpty()) {
                this.f13194b = true;
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((zada) it.next()).f13287c = null;
                }
                return false;
            }
            this.f13193a.m3111a(null);
            return true;
        }
        return false;
    }
}
