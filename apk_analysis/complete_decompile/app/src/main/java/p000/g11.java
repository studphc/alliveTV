package p000;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.PushObserver;

/* loaded from: classes2.dex */
public final class g11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ Http2Connection f17521b;

    /* renamed from: c */
    public final /* synthetic */ int f17522c;

    /* renamed from: d */
    public final /* synthetic */ List f17523d;

    /* renamed from: e */
    public final /* synthetic */ boolean f17524e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g11(Http2Connection http2Connection, int i, List list, boolean z) {
        super(0);
        this.f17521b = http2Connection;
        this.f17522c = i;
        this.f17523d = list;
        this.f17524e = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PushObserver pushObserver;
        Set set;
        pushObserver = this.f17521b.f24445l;
        boolean onHeaders = pushObserver.onHeaders(this.f17522c, this.f17523d, this.f17524e);
        Http2Connection http2Connection = this.f17521b;
        int i = this.f17522c;
        boolean z = this.f17524e;
        if (onHeaders) {
            try {
                http2Connection.getWriter().rstStream(i, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (onHeaders || z) {
            synchronized (http2Connection) {
                set = http2Connection.f24433C;
                set.remove(Integer.valueOf(i));
            }
        }
        return Unit.INSTANCE;
    }
}
