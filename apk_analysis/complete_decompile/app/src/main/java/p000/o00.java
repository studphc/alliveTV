package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.drm.C0660b;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o00 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ DefaultDrmSessionManager f23549a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o00(DefaultDrmSessionManager defaultDrmSessionManager, Looper looper) {
        super(looper);
        this.f23549a = defaultDrmSessionManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null) {
            return;
        }
        Iterator it = this.f23549a.f9949l.iterator();
        while (it.hasNext()) {
            C0660b c0660b = (C0660b) it.next();
            if (Arrays.equals(c0660b.f10023u, bArr)) {
                if (message.what == 2 && c0660b.f10007e == 0 && c0660b.f10017o == 4) {
                    Util.castNonNull(c0660b.f10023u);
                    c0660b.m2522a(false);
                    return;
                }
                return;
            }
        }
    }
}
