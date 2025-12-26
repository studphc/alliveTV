package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import p000.AbstractC1726qj;

@KeepForSdk
/* loaded from: classes.dex */
public class Storage {

    /* renamed from: c */
    public static final ReentrantLock f12956c = new ReentrantLock();

    /* renamed from: d */
    public static Storage f12957d;

    /* renamed from: a */
    public final ReentrantLock f12958a = new ReentrantLock();

    /* renamed from: b */
    public final SharedPreferences f12959b;

    public Storage(Context context) {
        this.f12959b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: a */
    public static final String m3071a(String str, String str2) {
        return AbstractC1726qj.m7058n(str, ":", str2);
    }

    @NonNull
    @KeepForSdk
    public static Storage getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        ReentrantLock reentrantLock = f12956c;
        reentrantLock.lock();
        try {
            if (f12957d == null) {
                f12957d = new Storage(context.getApplicationContext());
            }
            Storage storage = f12957d;
            reentrantLock.unlock();
            return storage;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @KeepForSdk
    public void clear() {
        ReentrantLock reentrantLock = this.f12958a;
        reentrantLock.lock();
        try {
            this.f12959b.edit().clear().apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String zaa;
        String zaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa2) || (zaa = zaa(m3071a("googleSignInAccount", zaa2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(zaa);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String zaa;
        String zaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa2) || (zaa = zaa(m3071a("googleSignInOptions", zaa2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zab(zaa);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    @KeepForSdk
    public String getSavedRefreshToken() {
        return zaa("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zad("defaultGoogleSignInAccount", googleSignInAccount.zac());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zac = googleSignInAccount.zac();
        zad(m3071a("googleSignInAccount", zac), googleSignInAccount.zad());
        zad(m3071a("googleSignInOptions", zac), googleSignInOptions.zaf());
    }

    @Nullable
    public final String zaa(@NonNull String str) {
        ReentrantLock reentrantLock = this.f12958a;
        reentrantLock.lock();
        try {
            return this.f12959b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void zab(@NonNull String str) {
        ReentrantLock reentrantLock = this.f12958a;
        reentrantLock.lock();
        try {
            this.f12959b.edit().remove(str).apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void zac() {
        String zaa = zaa("defaultGoogleSignInAccount");
        zab("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(zaa)) {
            return;
        }
        zab(m3071a("googleSignInAccount", zaa));
        zab(m3071a("googleSignInOptions", zaa));
    }

    public final void zad(@NonNull String str, @NonNull String str2) {
        ReentrantLock reentrantLock = this.f12958a;
        reentrantLock.lock();
        try {
            this.f12959b.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
