package androidx.privacysandbox.ads.adservices.java.signals;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.c82;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/signals/ProtectedSignalsManagerFutures;", "", "<init>", "()V", "Landroidx/privacysandbox/ads/adservices/signals/UpdateSignalsRequest;", "request", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "updateSignalsAsync", "(Landroidx/privacysandbox/ads/adservices/signals/UpdateSignalsRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Companion", "c82", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class ProtectedSignalsManagerFutures {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/signals/ProtectedSignalsManagerFutures$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/java/signals/ProtectedSignalsManagerFutures;", TypedValues.TransitionType.S_FROM, "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/java/signals/ProtectedSignalsManagerFutures;", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nProtectedSignalsManagerFutures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtectedSignalsManagerFutures.kt\nandroidx/privacysandbox/ads/adservices/java/signals/ProtectedSignalsManagerFutures$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @Nullable
        public final ProtectedSignalsManagerFutures from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ProtectedSignalsManager obtain = ProtectedSignalsManager.INSTANCE.obtain(context);
            if (obtain != null) {
                return new c82(obtain);
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final ProtectedSignalsManagerFutures from(@NotNull Context context) {
        return INSTANCE.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @NotNull
    public abstract ListenableFuture<Unit> updateSignalsAsync(@NotNull UpdateSignalsRequest request);
}
