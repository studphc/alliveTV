package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1211fx;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0010B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", "", "<init>", "()V", "Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "request", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "joinCustomAudienceAsync", "(Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "fetchAndJoinCustomAudienceAsync", "(Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;", "leaveCustomAudienceAsync", "(Landroidx/privacysandbox/ads/adservices/customaudience/LeaveCustomAudienceRequest;)Lcom/google/common/util/concurrent/ListenableFuture;", "Companion", "fx", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class CustomAudienceManagerFutures {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", TypedValues.TransitionType.S_FROM, "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures;", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nCustomAudienceManagerFutures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomAudienceManagerFutures.kt\nandroidx/privacysandbox/ads/adservices/java/customaudience/CustomAudienceManagerFutures$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n1#2:185\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @Nullable
        public final CustomAudienceManagerFutures from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CustomAudienceManager obtain = CustomAudienceManager.INSTANCE.obtain(context);
            if (obtain != null) {
                return new C1211fx(obtain);
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final CustomAudienceManagerFutures from(@NotNull Context context) {
        return INSTANCE.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    @NotNull
    public abstract ListenableFuture<Unit> fetchAndJoinCustomAudienceAsync(@NotNull FetchAndJoinCustomAudienceRequest request);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract ListenableFuture<Unit> joinCustomAudienceAsync(@NotNull JoinCustomAudienceRequest request);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @NotNull
    public abstract ListenableFuture<Unit> leaveCustomAudienceAsync(@NotNull LeaveCustomAudienceRequest request);
}
