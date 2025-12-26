package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;

/* loaded from: classes.dex */
public class PendingIntentActivityWrapper {

    /* renamed from: a */
    public final Context f3763a;

    /* renamed from: b */
    public final int f3764b;

    /* renamed from: c */
    public final Intent f3765c;

    /* renamed from: d */
    public final int f3766d;

    /* renamed from: e */
    public final Bundle f3767e;

    /* renamed from: f */
    public final PendingIntent f3768f;

    /* renamed from: g */
    public final boolean f3769g;

    public PendingIntentActivityWrapper(@NonNull Context context, int i, @NonNull Intent intent, int i2, boolean z) {
        this(context, i, intent, i2, null, z);
    }

    @NonNull
    public Context getContext() {
        return this.f3763a;
    }

    public int getFlags() {
        return this.f3766d;
    }

    @NonNull
    public Intent getIntent() {
        return this.f3765c;
    }

    @NonNull
    public Bundle getOptions() {
        return this.f3767e;
    }

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.f3768f;
    }

    public int getRequestCode() {
        return this.f3764b;
    }

    public boolean isMutable() {
        return this.f3769g;
    }

    public PendingIntentActivityWrapper(@NonNull Context context, int i, @NonNull Intent intent, int i2, @Nullable Bundle bundle, boolean z) {
        PendingIntent activity;
        this.f3763a = context;
        this.f3764b = i;
        this.f3765c = intent;
        this.f3766d = i2;
        this.f3767e = bundle;
        this.f3769g = z;
        if (bundle == null) {
            activity = PendingIntentCompat.getActivity(context, i, intent, i2, z);
        } else {
            activity = PendingIntentCompat.getActivity(context, i, intent, i2, bundle, z);
        }
        this.f3768f = activity;
    }
}
