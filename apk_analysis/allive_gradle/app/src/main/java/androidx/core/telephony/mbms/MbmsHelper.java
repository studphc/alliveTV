package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.k10;

/* loaded from: classes.dex */
public final class MbmsHelper {
    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return k10.m5478d(context, serviceInfo);
        }
        return null;
    }
}
