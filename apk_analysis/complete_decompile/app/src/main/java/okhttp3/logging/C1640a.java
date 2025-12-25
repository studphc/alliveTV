package okhttp3.logging;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

/* renamed from: okhttp3.logging.a */
/* loaded from: classes2.dex */
public final class C1640a implements HttpLoggingInterceptor.Logger {
    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
    }
}
