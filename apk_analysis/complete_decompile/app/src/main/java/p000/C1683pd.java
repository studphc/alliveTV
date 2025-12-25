package p000;

import android.media.AudioTrack;
import com.google.android.exoplayer2.util.Util;

/* renamed from: pd */
/* loaded from: classes.dex */
public final class C1683pd {

    /* renamed from: a */
    public final C1618od f25120a;

    /* renamed from: b */
    public int f25121b;

    /* renamed from: c */
    public long f25122c;

    /* renamed from: d */
    public long f25123d;

    /* renamed from: e */
    public long f25124e;

    /* renamed from: f */
    public long f25125f;

    public C1683pd(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.f25120a = new C1618od(audioTrack);
            m6909a();
        } else {
            this.f25120a = null;
            m6910b(3);
        }
    }

    /* renamed from: a */
    public final void m6909a() {
        if (this.f25120a != null) {
            m6910b(0);
        }
    }

    /* renamed from: b */
    public final void m6910b(int i) {
        this.f25121b = i;
        if (i != 0) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i == 4) {
                        this.f25123d = 500000L;
                        return;
                    }
                    throw new IllegalStateException();
                }
                this.f25123d = 10000000L;
                return;
            }
            this.f25123d = 10000L;
            return;
        }
        this.f25124e = 0L;
        this.f25125f = -1L;
        this.f25122c = System.nanoTime() / 1000;
        this.f25123d = 10000L;
    }
}
