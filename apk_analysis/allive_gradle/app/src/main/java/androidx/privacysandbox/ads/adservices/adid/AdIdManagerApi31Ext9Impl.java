package androidx.privacysandbox.ads.adservices.adid;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManagerApi31Ext9Impl;", "Landroidx/privacysandbox/ads/adservices/adid/AdIdManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RequiresExtension(extension = 31, version = 9)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AdIdManagerApi31Ext9Impl extends AdIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdIdManagerApi31Ext9Impl(@NotNull Context context) {
        super(r2);
        android.adservices.adid.AdIdManager adIdManager;
        Intrinsics.checkNotNullParameter(context, "context");
        adIdManager = android.adservices.adid.AdIdManager.get(context);
        Intrinsics.checkNotNullExpressionValue(adIdManager, "get(context)");
    }
}
