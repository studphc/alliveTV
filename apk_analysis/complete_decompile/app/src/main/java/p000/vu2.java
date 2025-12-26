package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class vu2 extends TopicsManagerFutures {

    /* renamed from: a */
    public final TopicsManager f27975a;

    public vu2(TopicsManager mTopicsManager) {
        Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
        this.f27975a = mTopicsManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @DoNotInline
    @NotNull
    public ListenableFuture<GetTopicsResponse> getTopicsAsync(@NotNull GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return CoroutineAdapterKt.asListenableFuture$default(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new uu2(this, request, null), 3, null), null, 1, null);
    }
}
