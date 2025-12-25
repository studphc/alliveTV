package okhttp3.internal.http2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* renamed from: okhttp3.internal.http2.f */
/* loaded from: classes2.dex */
public final class C1639f implements PushObserver {
    @Override // okhttp3.internal.http2.PushObserver
    public final boolean onData(int i, BufferedSource source, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(source, "source");
        source.skip(i2);
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public final boolean onHeaders(int i, List responseHeaders, boolean z) {
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public final boolean onRequest(int i, List requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return true;
    }

    @Override // okhttp3.internal.http2.PushObserver
    public final void onReset(int i, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
    }
}
