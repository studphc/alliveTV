package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1702pw;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, m5569d2 = {"asListenableFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "tag", "", "ads-adservices-java_release"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class CoroutineAdapterKt {
    @NotNull
    public static final <T> ListenableFuture<T> asListenableFuture(@NotNull Deferred<? extends T> deferred, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new C1702pw(0, deferred, obj));
        Intrinsics.checkNotNullExpressionValue(future, "getFuture { completer ->…      }\n        tag\n    }");
        return future;
    }

    public static /* synthetic */ ListenableFuture asListenableFuture$default(Deferred deferred, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(deferred, obj);
    }
}
