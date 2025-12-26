package p000;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.PushObserver;

/* loaded from: classes2.dex */
public final class h11 extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f17916b = 1;

    /* renamed from: c */
    public final /* synthetic */ int f17917c;

    /* renamed from: d */
    public final /* synthetic */ Object f17918d;

    /* renamed from: e */
    public final /* synthetic */ Object f17919e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h11(Regex regex, CharSequence charSequence, int i) {
        super(0);
        this.f17918d = regex;
        this.f17919e = charSequence;
        this.f17917c = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        PushObserver pushObserver;
        Set set;
        switch (this.f17916b) {
            case 0:
                pushObserver = ((Http2Connection) this.f17918d).f24445l;
                boolean onRequest = pushObserver.onRequest(this.f17917c, (List) this.f17919e);
                Http2Connection http2Connection = (Http2Connection) this.f17918d;
                int i = this.f17917c;
                if (onRequest) {
                    try {
                        http2Connection.getWriter().rstStream(i, ErrorCode.CANCEL);
                        synchronized (http2Connection) {
                            set = http2Connection.f24433C;
                            set.remove(Integer.valueOf(i));
                        }
                    } catch (IOException unused) {
                    }
                }
                return Unit.INSTANCE;
            default:
                return ((Regex) this.f17918d).find((CharSequence) this.f17919e, this.f17917c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h11(Http2Connection http2Connection, int i, List list) {
        super(0);
        this.f17918d = http2Connection;
        this.f17917c = i;
        this.f17919e = list;
    }
}
