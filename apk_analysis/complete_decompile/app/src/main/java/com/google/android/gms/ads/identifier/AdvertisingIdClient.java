package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import p000.ca3;

@KeepForSdk
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class AdvertisingIdClient {

    /* renamed from: a */
    public BlockingServiceConnection f12909a;

    /* renamed from: b */
    public zzf f12910b;

    /* renamed from: c */
    public boolean f12911c;

    /* renamed from: d */
    public final Object f12912d;

    /* renamed from: e */
    public ca3 f12913e;

    /* renamed from: f */
    public final Context f12914f;

    /* renamed from: g */
    public final long f12915g;

    @KeepForSdkWithMembers
    /* loaded from: classes.dex */
    public static final class Info {

        /* renamed from: a */
        public final String f12916a;

        /* renamed from: b */
        public final boolean f12917b;

        @Deprecated
        public Info(@Nullable String str, boolean z) {
            this.f12916a = str;
            this.f12917b = z;
        }

        @Nullable
        public String getId() {
            return this.f12916a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f12917b;
        }

        @NonNull
        public String toString() {
            String str = this.f12916a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(this.f12917b);
            return sb.toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(@NonNull Context context) {
        this(context, 30000L, false, false);
    }

    /* renamed from: a */
    public static void m3066a(Info info, long j, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap hashMap = new HashMap();
            String str = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
            hashMap.put("app_context", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            if (info != null) {
                if (true != info.isLimitAdTrackingEnabled()) {
                    str = "0";
                }
                hashMap.put("limit_ad_tracking", str);
                String id = info.getId();
                if (id != null) {
                    hashMap.put("ad_id_size", Integer.toString(id.length()));
                }
            }
            if (th != null) {
                hashMap.put("error", th.getClass().getName());
            }
            hashMap.put("tag", "AdvertisingIdClient");
            hashMap.put("time_spent", Long.toString(j));
            new C0741a(hashMap).start();
        }
    }

    @NonNull
    @KeepForSdk
    public static Info getAdvertisingIdInfo(@NonNull Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info m3067b = advertisingIdClient.m3067b();
            m3066a(m3067b, SystemClock.elapsedRealtime() - elapsedRealtime, null);
            return m3067b;
        } finally {
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(@NonNull Context context) {
        boolean zzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.zzb(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                try {
                    if (!advertisingIdClient.f12911c) {
                        synchronized (advertisingIdClient.f12912d) {
                            ca3 ca3Var = advertisingIdClient.f12913e;
                            if (ca3Var == null || !ca3Var.f8311d) {
                                throw new IOException("AdvertisingIdClient is not connected.");
                            }
                        }
                        try {
                            advertisingIdClient.zzb(false);
                            if (!advertisingIdClient.f12911c) {
                                throw new IOException("AdvertisingIdClient cannot reconnect.");
                            }
                        } catch (Exception e) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                        }
                    }
                    Preconditions.checkNotNull(advertisingIdClient.f12909a);
                    Preconditions.checkNotNull(advertisingIdClient.f12910b);
                    try {
                        zzd = advertisingIdClient.f12910b.zzd();
                    } catch (RemoteException e2) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                        throw new IOException("Remote exception");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            advertisingIdClient.m3068c();
            return zzd;
        } finally {
            advertisingIdClient.zza();
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    /* renamed from: b */
    public final Info m3067b() {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f12911c) {
                    synchronized (this.f12912d) {
                        ca3 ca3Var = this.f12913e;
                        if (ca3Var == null || !ca3Var.f8311d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        zzb(false);
                        if (!this.f12911c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                Preconditions.checkNotNull(this.f12909a);
                Preconditions.checkNotNull(this.f12910b);
                try {
                    info = new Info(this.f12910b.zzc(), this.f12910b.zze(true));
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        m3068c();
        return info;
    }

    /* renamed from: c */
    public final void m3068c() {
        synchronized (this.f12912d) {
            ca3 ca3Var = this.f12913e;
            if (ca3Var != null) {
                ca3Var.f8310c.countDown();
                try {
                    this.f12913e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.f12915g;
            if (j > 0) {
                this.f12913e = new ca3(this, j);
            }
        }
    }

    public final void finalize() {
        zza();
        super.finalize();
    }

    @NonNull
    @KeepForSdk
    public Info getInfo() {
        return m3067b();
    }

    @KeepForSdk
    public void start() {
        zzb(true);
    }

    public final void zza() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f12914f != null && this.f12909a != null) {
                    try {
                        if (this.f12911c) {
                            ConnectionTracker.getInstance().unbindService(this.f12914f, this.f12909a);
                        }
                    } catch (Throwable th) {
                        Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                    }
                    this.f12911c = false;
                    this.f12910b = null;
                    this.f12909a = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f12911c) {
                    zza();
                }
                Context context = this.f12914f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    if (isGooglePlayServicesAvailable != 0 && isGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                            this.f12909a = blockingServiceConnection;
                            try {
                                this.f12910b = zze.zza(blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                                this.f12911c = true;
                                if (z) {
                                    m3068c();
                                }
                            } catch (InterruptedException unused) {
                                throw new IOException("Interrupted exception");
                            } catch (Throwable th) {
                                throw new IOException(th);
                            }
                        } else {
                            throw new IOException("Connection failure");
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public AdvertisingIdClient(@NonNull Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.f12912d = new Object();
        Preconditions.checkNotNull(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f12914f = context;
        this.f12911c = false;
        this.f12915g = j;
    }
}
