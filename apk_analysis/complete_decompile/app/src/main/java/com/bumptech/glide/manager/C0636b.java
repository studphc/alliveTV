package com.bumptech.glide.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.manager.b */
/* loaded from: classes.dex */
public final class C0636b implements ConnectivityMonitor {

    /* renamed from: a */
    public final Context f8992a;

    /* renamed from: b */
    public final ConnectivityMonitor.ConnectivityListener f8993b;

    /* renamed from: c */
    public boolean f8994c;

    /* renamed from: d */
    public boolean f8995d;

    /* renamed from: e */
    public final C0635a f8996e = new C0635a(this);

    public C0636b(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f8992a = context.getApplicationContext();
        this.f8993b = connectivityListener;
    }

    /* renamed from: a */
    public static boolean m2375a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStart() {
        if (!this.f8995d) {
            Context context = this.f8992a;
            this.f8994c = m2375a(context);
            try {
                context.registerReceiver(this.f8996e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f8995d = true;
            } catch (SecurityException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e);
                }
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStop() {
        if (this.f8995d) {
            this.f8992a.unregisterReceiver(this.f8996e);
            this.f8995d = false;
        }
    }
}
