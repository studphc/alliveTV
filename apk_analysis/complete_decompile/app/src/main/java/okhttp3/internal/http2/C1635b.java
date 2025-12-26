package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.platform.Platform;

/* renamed from: okhttp3.internal.http2.b */
/* loaded from: classes2.dex */
public final class C1635b extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f24528b;

    /* renamed from: c */
    public final /* synthetic */ Http2Stream f24529c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1635b(Http2Connection http2Connection, Http2Stream http2Stream) {
        super(0);
        this.f24528b = http2Connection;
        this.f24529c = http2Stream;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Http2Stream http2Stream = this.f24529c;
        Http2Connection http2Connection = this.f24528b;
        try {
            http2Connection.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String().onStream(http2Stream);
        } catch (IOException e) {
            Platform.INSTANCE.get().log("Http2Connection.Listener failure for " + http2Connection.getConnectionName(), 4, e);
            try {
                http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
            } catch (IOException unused) {
            }
        }
        return Unit.INSTANCE;
    }
}
