package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

/* loaded from: classes2.dex */
public class DataCollectionConfigStorage {

    @VisibleForTesting
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";

    /* renamed from: a */
    public final Context f15641a;

    /* renamed from: b */
    public final SharedPreferences f15642b;

    /* renamed from: c */
    public final Publisher f15643c;

    /* renamed from: d */
    public boolean f15644d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        boolean m4404a;
        context = Build.VERSION.SDK_INT >= 24 ? ContextCompat.createDeviceProtectedStorageContext(context) : context;
        this.f15641a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f15642b = sharedPreferences;
        this.f15643c = publisher;
        if (sharedPreferences.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            m4404a = sharedPreferences.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        } else {
            m4404a = m4404a();
        }
        this.f15644d = m4404a;
    }

    /* renamed from: a */
    public final boolean m4404a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.f15641a;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    /* renamed from: b */
    public final synchronized void m4405b(boolean z) {
        if (this.f15644d != z) {
            this.f15644d = z;
            this.f15643c.publish(new Event<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.f15644d;
    }

    public synchronized void setEnabled(Boolean bool) {
        try {
            if (bool == null) {
                this.f15642b.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
                m4405b(m4404a());
            } else {
                boolean equals = Boolean.TRUE.equals(bool);
                this.f15642b.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
                m4405b(equals);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
