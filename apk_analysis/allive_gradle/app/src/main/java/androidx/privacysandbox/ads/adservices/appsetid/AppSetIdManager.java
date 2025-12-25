package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "", "()V", "getAppSetId", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class AppSetIdManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "obtain", "(Landroid/content/Context;)Landroidx/privacysandbox/ads/adservices/appsetid/AppSetIdManager;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @Nullable
        public final AppSetIdManager obtain(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            if (adServicesInfo.adServicesVersion() >= 4) {
                return new AppSetIdManagerApi33Ext4Impl(context);
            }
            if (adServicesInfo.extServicesVersionS() >= 9) {
                return (AppSetIdManager) BackCompatManager.INSTANCE.getManager(context, "AppSetIdManager", new C0448a(context));
            }
            return null;
        }
    }

    @JvmStatic
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @Nullable
    public static final AppSetIdManager obtain(@NotNull Context context) {
        return INSTANCE.obtain(context);
    }

    @Nullable
    public abstract Object getAppSetId(@NotNull Continuation<? super AppSetId> continuation);
}
