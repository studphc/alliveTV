package androidx.core.content;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.s03;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";

    /* renamed from: a */
    public final s03 f3568a = new s03(this);

    public abstract void isPermissionRevocationEnabled(@NonNull UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.f3568a;
    }
}
