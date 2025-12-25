package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConnectInterceptor implements Interceptor {

    @NotNull
    public static final ConnectInterceptor INSTANCE = new Object();

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, realInterceptorChain.getAndroidx.core.app.NotificationCompat.CATEGORY_CALL java.lang.String().initExchange$okhttp(realInterceptorChain), null, 0, 0, 0, 61, null).proceed(realInterceptorChain.getRequest());
    }
}
