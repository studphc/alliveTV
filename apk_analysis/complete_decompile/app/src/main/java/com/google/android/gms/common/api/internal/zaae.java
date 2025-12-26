package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zaae extends zap {

    /* renamed from: b */
    public final ArraySet f13190b;

    /* renamed from: c */
    public final GoogleApiManager f13191c;

    public zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.f13190b = new ArraySet();
        this.f13191c = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    @MainThread
    public static void zad(Activity activity, GoogleApiManager googleApiManager, ApiKey apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaaeVar = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            zaaeVar = new zaae(fragment, googleApiManager, GoogleApiAvailability.getInstance());
        }
        Preconditions.checkNotNull(apiKey, "ApiKey cannot be null");
        zaaeVar.f13190b.add(apiKey);
        googleApiManager.zaA(zaaeVar);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        super.onResume();
        if (!this.f13190b.isEmpty()) {
            this.f13191c.zaA(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        if (!this.f13190b.isEmpty()) {
            this.f13191c.zaA(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        GoogleApiManager googleApiManager = this.f13191c;
        googleApiManager.getClass();
        synchronized (GoogleApiManager.f13104q) {
            try {
                if (googleApiManager.f13116k == this) {
                    googleApiManager.f13116k = null;
                    googleApiManager.f13117l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        this.f13191c.zax(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        this.f13191c.zay();
    }
}
