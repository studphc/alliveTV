package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public final class zzo {

    /* renamed from: e */
    public static final Uri f13531e = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();

    /* renamed from: a */
    public final String f13532a;

    /* renamed from: b */
    public final String f13533b;

    /* renamed from: c */
    public final ComponentName f13534c;

    /* renamed from: d */
    public final boolean f13535d;

    public zzo(ComponentName componentName, int i) {
        this.f13532a = null;
        this.f13533b = null;
        Preconditions.checkNotNull(componentName);
        this.f13534c = componentName;
        this.f13535d = false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        if (Objects.equal(this.f13532a, zzoVar.f13532a) && Objects.equal(this.f13533b, zzoVar.f13533b) && Objects.equal(this.f13534c, zzoVar.f13534c) && this.f13535d == zzoVar.f13535d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f13532a, this.f13533b, this.f13534c, 4225, Boolean.valueOf(this.f13535d));
    }

    public final String toString() {
        String str = this.f13532a;
        if (str == null) {
            ComponentName componentName = this.f13534c;
            Preconditions.checkNotNull(componentName);
            return componentName.flattenToString();
        }
        return str;
    }

    @Nullable
    public final ComponentName zza() {
        return this.f13534c;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Intent zzb(Context context) {
        Bundle bundle;
        PendingIntent pendingIntent;
        ContentProviderClient acquireUnstableContentProviderClient;
        String str = this.f13532a;
        if (str != null) {
            Intent intent = null;
            if (this.f13535d) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", str);
                try {
                    acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f13531e);
                } catch (RemoteException e) {
                    e = e;
                    bundle = null;
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    if (bundle == null) {
                    }
                    if (intent == null) {
                    }
                    if (intent == null) {
                    }
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    bundle = null;
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    if (bundle == null) {
                    }
                    if (intent == null) {
                    }
                    if (intent == null) {
                    }
                }
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        bundle = acquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle2);
                        try {
                        } catch (RemoteException e3) {
                            e = e3;
                            Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                            if (bundle == null) {
                            }
                            if (intent == null) {
                            }
                            if (intent == null) {
                            }
                        } catch (IllegalArgumentException e4) {
                            e = e4;
                            Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                            if (bundle == null) {
                            }
                            if (intent == null) {
                            }
                            if (intent == null) {
                            }
                        }
                        if (bundle == null && (intent = (Intent) bundle.getParcelable("serviceResponseIntentKey")) == null && (pendingIntent = (PendingIntent) bundle.getParcelable("serviceMissingResolutionIntentKey")) != null) {
                            Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action " + str + " but has possible resolution");
                            throw new zzaj(new ConnectionResult(25, pendingIntent));
                        }
                        if (intent == null) {
                            Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
                        }
                    } finally {
                        acquireUnstableContentProviderClient.release();
                    }
                } else {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
            }
            if (intent == null) {
                return new Intent(str).setPackage(this.f13533b);
            }
            return intent;
        }
        return new Intent().setComponent(this.f13534c);
    }

    @Nullable
    public final String zzc() {
        return this.f13533b;
    }

    public zzo(String str, int i, boolean z) {
        this(str, "com.google.android.gms", 4225, false);
    }

    public zzo(String str, String str2, int i, boolean z) {
        Preconditions.checkNotEmpty(str);
        this.f13532a = str;
        Preconditions.checkNotEmpty(str2);
        this.f13533b = str2;
        this.f13534c = null;
        this.f13535d = z;
    }
}
