package androidx.privacysandbox.ads.adservices.signals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/signals/ProtectedSignalsManager;", "", "()V", "updateSignals", "", "request", "Landroidx/privacysandbox/ads/adservices/signals/UpdateSignalsRequest;", "(Landroidx/privacysandbox/ads/adservices/signals/UpdateSignalsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class ProtectedSignalsManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/signals/ProtectedSignalsManager$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/signals/ProtectedSignalsManager;", "obtain", "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/signals/ProtectedSignalsManager;", "", "TAG", "Ljava/lang/String;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @SuppressLint({"NewApi"})
        @ExperimentalFeatures.Ext12OptIn
        @Nullable
        public final ProtectedSignalsManager obtain(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AdServicesInfo.INSTANCE.adServicesVersion() >= 12) {
                Log.d("ProtectedSignalsManager", "Adservices version 12 detected, obtaining ProtectedSignalsManagerImpl.");
                android.adservices.signals.ProtectedSignalsManager protectedSignalsManager = android.adservices.signals.ProtectedSignalsManager.get(context);
                Intrinsics.checkNotNullExpressionValue(protectedSignalsManager, "get(context)");
                return new ProtectedSignalsManagerImpl(protectedSignalsManager);
            }
            Log.d("ProtectedSignalsManager", "Adservices less than 12, returning null for ProtectedSignalsManager.obtain.");
            return null;
        }
    }

    @JvmStatic
    @SuppressLint({"NewApi"})
    @ExperimentalFeatures.Ext12OptIn
    @Nullable
    public static final ProtectedSignalsManager obtain(@NotNull Context context) {
        return INSTANCE.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @ExperimentalFeatures.Ext12OptIn
    @Nullable
    public abstract Object updateSignals(@NotNull UpdateSignalsRequest updateSignalsRequest, @NotNull Continuation<? super Unit> continuation);
}
