package p000;

import java.io.IOException;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.PushObserver;

/* loaded from: classes2.dex */
public final class i11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f18250b;

    /* renamed from: c */
    public final /* synthetic */ Http2Connection f18251c;

    /* renamed from: d */
    public final /* synthetic */ int f18252d;

    /* renamed from: e */
    public final /* synthetic */ ErrorCode f18253e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i11(Http2Connection http2Connection, int i, ErrorCode errorCode, int i2) {
        super(0);
        this.f18250b = i2;
        this.f18251c = http2Connection;
        this.f18252d = i;
        this.f18253e = errorCode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PushObserver pushObserver;
        Set set;
        switch (this.f18250b) {
            case 0:
                pushObserver = this.f18251c.f24445l;
                pushObserver.onReset(this.f18252d, this.f18253e);
                Http2Connection http2Connection = this.f18251c;
                int i = this.f18252d;
                synchronized (http2Connection) {
                    set = http2Connection.f24433C;
                    set.remove(Integer.valueOf(i));
                }
                return Unit.INSTANCE;
            default:
                Http2Connection http2Connection2 = this.f18251c;
                try {
                    http2Connection2.writeSynReset$okhttp(this.f18252d, this.f18253e);
                } catch (IOException e) {
                    Http2Connection.access$failConnection(http2Connection2, e);
                }
                return Unit.INSTANCE;
        }
    }
}
