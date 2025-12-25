package okhttp3.internal.http2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;

/* renamed from: okhttp3.internal.http2.d */
/* loaded from: classes2.dex */
public final class C1637d extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection.ReaderRunnable f24533b;

    /* renamed from: c */
    public final /* synthetic */ boolean f24534c;

    /* renamed from: d */
    public final /* synthetic */ Settings f24535d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1637d(Http2Connection.ReaderRunnable readerRunnable, boolean z, Settings settings) {
        super(0);
        this.f24533b = readerRunnable;
        this.f24534c = z;
        this.f24535d = settings;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f24533b.applyAndAckSettings(this.f24534c, this.f24535d);
        return Unit.INSTANCE;
    }
}
