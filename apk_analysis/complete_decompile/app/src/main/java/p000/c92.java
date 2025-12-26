package p000;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class c92 extends Task {

    /* renamed from: e */
    public final /* synthetic */ RealWebSocket f8299e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c92(RealWebSocket realWebSocket) {
        super(r0.toString(), false, 2, null);
        String str;
        this.f8299e = realWebSocket;
        StringBuilder sb = new StringBuilder();
        str = realWebSocket.f24606m;
        sb.append(str);
        sb.append(" writer");
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        RealWebSocket realWebSocket = this.f8299e;
        try {
            if (realWebSocket.writeOneFrame$okhttp()) {
                return 0L;
            }
            return -1L;
        } catch (IOException e) {
            realWebSocket.failWebSocket(e, null);
            return -1L;
        }
    }
}
