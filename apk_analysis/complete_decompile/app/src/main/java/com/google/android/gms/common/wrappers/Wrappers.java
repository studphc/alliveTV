package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class Wrappers {

    /* renamed from: b */
    public static final Wrappers f13676b = new Wrappers();

    /* renamed from: a */
    public PackageManagerWrapper f13677a = null;

    @NonNull
    @KeepForSdk
    public static PackageManagerWrapper packageManager(@NonNull Context context) {
        return f13676b.zza(context);
    }

    @NonNull
    @VisibleForTesting
    public final synchronized PackageManagerWrapper zza(@NonNull Context context) {
        try {
            if (this.f13677a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f13677a = new PackageManagerWrapper(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13677a;
    }
}
