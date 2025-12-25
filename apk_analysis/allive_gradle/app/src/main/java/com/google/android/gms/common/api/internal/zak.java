package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000.t83;
import p000.u83;
import p000.ye0;

/* loaded from: classes.dex */
public final class zak extends zap {

    /* renamed from: b */
    public final SparseArray f13299b;

    public zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.f13299b = new SparseArray();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zak zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.getCallbackOrNull("AutoManageHelper", zak.class);
        if (zakVar != null) {
            return zakVar;
        }
        return new zak(fragment);
    }

    /* renamed from: a */
    public final t83 m3128a(int i) {
        SparseArray sparseArray = this.f13299b;
        if (sparseArray.size() <= i) {
            return null;
        }
        return (t83) sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f13299b.size(); i++) {
            t83 m3128a = m3128a(i);
            if (m3128a != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(m3128a.f26721a);
                printWriter.println(":");
                m3128a.f26722b.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        SparseArray sparseArray = this.f13299b;
        Log.d("AutoManageHelper", "onStart " + this.zaa + " " + String.valueOf(sparseArray));
        if (this.zab.get() == null) {
            for (int i = 0; i < this.f13299b.size(); i++) {
                t83 m3128a = m3128a(i);
                if (m3128a != null) {
                    m3128a.f26722b.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.f13299b.size(); i++) {
            t83 m3128a = m3128a(i);
            if (m3128a != null) {
                m3128a.f26722b.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        t83 t83Var = (t83) this.f13299b.get(i);
        if (t83Var != null) {
            zae(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = t83Var.f26723c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        for (int i = 0; i < this.f13299b.size(); i++) {
            t83 m3128a = m3128a(i);
            if (m3128a != null) {
                m3128a.f26722b.connect();
            }
        }
    }

    public final void zad(int i, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean z;
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        int indexOfKey = this.f13299b.indexOfKey(i);
        String m8291k = ye0.m8291k(i, "Already managing a GoogleApiClient with id ");
        if (indexOfKey < 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, m8291k);
        u83 u83Var = (u83) this.zab.get();
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.zaa + " " + String.valueOf(u83Var));
        t83 t83Var = new t83(this, i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(t83Var);
        this.f13299b.put(i, t83Var);
        if (this.zaa && u83Var == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.connect();
        }
    }

    public final void zae(int i) {
        SparseArray sparseArray = this.f13299b;
        t83 t83Var = (t83) sparseArray.get(i);
        sparseArray.remove(i);
        if (t83Var != null) {
            GoogleApiClient googleApiClient = t83Var.f26722b;
            googleApiClient.unregisterConnectionFailedListener(t83Var);
            googleApiClient.disconnect();
        }
    }
}
