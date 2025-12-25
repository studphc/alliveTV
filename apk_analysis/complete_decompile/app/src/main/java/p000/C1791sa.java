package p000;

import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* renamed from: sa */
/* loaded from: classes.dex */
public final class C1791sa extends AppSetIdManagerFutures {

    /* renamed from: a */
    public final AppSetIdManager f26341a;

    public C1791sa(AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.f26341a = mAppSetIdManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures
    @DoNotInline
    @NotNull
    public ListenableFuture<AppSetId> getAppSetIdAsync() {
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C1754ra(this, null), 3, null), null, 1, null);
    }
}
