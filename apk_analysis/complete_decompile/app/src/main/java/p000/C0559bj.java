package p000;

import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* renamed from: bj */
/* loaded from: classes.dex */
public final class C0559bj {

    /* renamed from: a */
    public final Queue f8031a;

    public C0559bj() {
        this.f8031a = Util.createQueue(0);
    }

    /* renamed from: a */
    public synchronized void m2102a(GifHeaderParser gifHeaderParser) {
        gifHeaderParser.clear();
        this.f8031a.offer(gifHeaderParser);
    }

    public C0559bj(int i) {
        this.f8031a = Util.createQueue(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f8031a.offer(new Object());
        }
    }
}
