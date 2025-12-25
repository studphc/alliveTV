package androidx.privacysandbox.ads.adservices.java.appsetid;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1791sa;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \b2\u00020\u0001:\u0002\t\bB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/appsetid/AppSetIdManagerFutures;", "", "<init>", "()V", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "getAppSetIdAsync", "()Lcom/google/common/util/concurrent/ListenableFuture;", "Companion", "sa", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class AppSetIdManagerFutures {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/java/appsetid/AppSetIdManagerFutures$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/java/appsetid/AppSetIdManagerFutures;", TypedValues.TransitionType.S_FROM, "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/java/appsetid/AppSetIdManagerFutures;", "ads-adservices-java_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nAppSetIdManagerFutures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSetIdManagerFutures.kt\nandroidx/privacysandbox/ads/adservices/java/appsetid/AppSetIdManagerFutures$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @Nullable
        public final AppSetIdManagerFutures from(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppSetIdManager obtain = AppSetIdManager.INSTANCE.obtain(context);
            if (obtain != null) {
                return new C1791sa(obtain);
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final AppSetIdManagerFutures from(@NotNull Context context) {
        return INSTANCE.from(context);
    }

    @NotNull
    public abstract ListenableFuture<AppSetId> getAppSetIdAsync();
}
