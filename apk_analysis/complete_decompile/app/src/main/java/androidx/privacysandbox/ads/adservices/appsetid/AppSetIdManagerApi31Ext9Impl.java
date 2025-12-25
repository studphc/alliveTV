package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerApi31Ext9Impl;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManagerImplCommon;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RequiresExtension(extension = 31, version = 9)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AppSetIdManagerApi31Ext9Impl extends AppSetIdManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppSetIdManagerApi31Ext9Impl(@NotNull Context context) {
        super(r2);
        android.adservices.appsetid.AppSetIdManager appSetIdManager;
        Intrinsics.checkNotNullParameter(context, "context");
        appSetIdManager = android.adservices.appsetid.AppSetIdManager.get(context);
        Intrinsics.checkNotNullExpressionValue(appSetIdManager, "get(context)");
    }
}
