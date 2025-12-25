package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;
import p000.u83;

/* loaded from: classes.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    public final com.google.android.gms.internal.base.zau f13305a;
    protected volatile boolean zaa;
    protected final AtomicReference zab;
    protected final GoogleApiAvailability zac;

    public zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zab = new AtomicReference(null);
        this.f13305a = new com.google.android.gms.internal.base.zau(Looper.getMainLooper());
        this.zac = googleApiAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i2, Intent intent) {
        u83 u83Var = (u83) this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    this.zab.set(null);
                    zac();
                    return;
                } else if (u83Var != null) {
                    if (u83Var.f27151b.getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 == -1) {
            this.zab.set(null);
            zac();
            return;
        } else if (i2 == 0) {
            if (u83Var != null) {
                int i3 = 13;
                if (intent != null) {
                    i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                ConnectionResult connectionResult = new ConnectionResult(i3, null, u83Var.f27151b.toString());
                this.zab.set(null);
                zab(connectionResult, u83Var.f27150a);
                return;
            }
            return;
        }
        if (u83Var != null) {
            this.zab.set(null);
            zab(u83Var.f27151b, u83Var.f27150a);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        int i;
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        u83 u83Var = (u83) this.zab.get();
        if (u83Var == null) {
            i = -1;
        } else {
            i = u83Var.f27150a;
        }
        this.zab.set(null);
        zab(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(@Nullable Bundle bundle) {
        u83 u83Var;
        super.onCreate(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.zab;
            if (bundle.getBoolean("resolving_error", false)) {
                u83Var = new u83(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                u83Var = null;
            }
            atomicReference.set(u83Var);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        u83 u83Var = (u83) this.zab.get();
        if (u83Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", u83Var.f27150a);
        ConnectionResult connectionResult = u83Var.f27151b;
        bundle.putInt("failed_status", connectionResult.getErrorCode());
        bundle.putParcelable("failed_resolution", connectionResult.getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    public abstract void zab(ConnectionResult connectionResult, int i);

    public abstract void zac();

    public final void zah(ConnectionResult connectionResult, int i) {
        AtomicReference atomicReference;
        u83 u83Var = new u83(connectionResult, i);
        do {
            atomicReference = this.zab;
            while (!atomicReference.compareAndSet(null, u83Var)) {
                if (atomicReference.get() != null) {
                }
            }
            this.f13305a.post(new RunnableC0750h(this, u83Var));
            return;
        } while (atomicReference.get() == null);
    }
}
