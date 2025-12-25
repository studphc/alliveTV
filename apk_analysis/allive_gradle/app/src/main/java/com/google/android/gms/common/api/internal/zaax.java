package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaax implements zabf {

    /* renamed from: a */
    public final zabi f13216a;

    public zaax(zabi zabiVar) {
        this.f13216a = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f13216a.f13255n.f13225h.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
        zabi zabiVar = this.f13216a;
        Iterator it = zabiVar.f13247f.values().iterator();
        while (it.hasNext()) {
            ((Api.Client) it.next()).disconnect();
        }
        zabiVar.f13255n.f13233p = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        zabi zabiVar = this.f13216a;
        zabiVar.f13242a.lock();
        try {
            zabiVar.f13252k = new zaaw(zabiVar, zabiVar.f13249h, zabiVar.f13250i, zabiVar.f13245d, zabiVar.f13251j, zabiVar.f13242a, zabiVar.f13244c);
            zabiVar.f13252k.zad();
            zabiVar.f13243b.signalAll();
        } finally {
            zabiVar.f13242a.unlock();
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
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        return true;
    }
}
