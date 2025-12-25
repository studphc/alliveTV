package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m5569d2 = {"okhttp3/internal/http2/Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1", "Lokhttp3/internal/http2/Http2Connection$Listener;", "onStream", "", "stream", "Lokhttp3/internal/http2/Http2Stream;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 extends Http2Connection.Listener {
    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@NotNull Http2Stream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }
}
