package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000eJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m5569d2 = {"Lcom/google/firebase/analytics/ParametersBuilder;", "", "<init>", "()V", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "param", "", "key", "", "value", "", "", "", "(Ljava/lang/String;[Landroid/os/Bundle;)V", "java.com.google.android.gmscore.integ.client.measurement_api_measurement_api"}, m5570k = 1, m5571mv = {2, 1, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ParametersBuilder {

    /* renamed from: a */
    public final Bundle f15491a = new Bundle();

    @NotNull
    /* renamed from: getBundle, reason: from getter */
    public final Bundle getF15491a() {
        return this.f15491a;
    }

    public final void param(@NonNull String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f15491a.putDouble(key, value);
    }

    public final void param(@NonNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f15491a.putLong(key, value);
    }

    public final void param(@NonNull String key, @NonNull Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f15491a.putBundle(key, value);
    }

    public final void param(@NonNull String key, @NonNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f15491a.putString(key, value);
    }

    public final void param(@NonNull String key, @NonNull Bundle[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f15491a.putParcelableArray(key, value);
    }
}
