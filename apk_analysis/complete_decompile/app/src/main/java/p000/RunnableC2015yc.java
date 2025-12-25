package p000;

import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.SurfaceHolderCallbackC0644a;
import com.google.android.exoplayer2.audio.AudioAttributes;

/* renamed from: yc */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC2015yc implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28892a;

    /* renamed from: b */
    public final /* synthetic */ int f28893b;

    /* renamed from: c */
    public final /* synthetic */ Object f28894c;

    public /* synthetic */ RunnableC2015yc(int i, int i2, Object obj) {
        this.f28892a = i2;
        this.f28894c = obj;
        this.f28893b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28892a) {
            case 0:
                C0014ad c0014ad = ((C2052zc) this.f28894c).f29307b;
                c0014ad.getClass();
                boolean z = true;
                int i = this.f28893b;
                if (i != -3 && i != -2) {
                    if (i != -1) {
                        if (i != 1) {
                            AbstractC1726qj.m7036A(i, "Unknown focus change type: ", "AudioFocusManager");
                            return;
                        }
                        c0014ad.m65c(1);
                        SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a = c0014ad.f128c;
                        if (surfaceHolderCallbackC0644a != null) {
                            surfaceHolderCallbackC0644a.executePlayerCommand(1);
                            return;
                        }
                        return;
                    }
                    SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a2 = c0014ad.f128c;
                    if (surfaceHolderCallbackC0644a2 != null) {
                        surfaceHolderCallbackC0644a2.executePlayerCommand(-1);
                    }
                    c0014ad.m63a();
                    return;
                }
                if (i != -2) {
                    AudioAttributes audioAttributes = c0014ad.f129d;
                    if (audioAttributes == null || audioAttributes.contentType != 1) {
                        z = false;
                    }
                    if (!z) {
                        c0014ad.m65c(3);
                        return;
                    }
                }
                SurfaceHolderCallbackC0644a surfaceHolderCallbackC0644a3 = c0014ad.f128c;
                if (surfaceHolderCallbackC0644a3 != null) {
                    surfaceHolderCallbackC0644a3.executePlayerCommand(0);
                }
                c0014ad.m65c(2);
                return;
            case 1:
                md1 md1Var = (md1) this.f28894c;
                int i2 = this.f28893b;
                jd1 jd1Var = md1Var.f22897a;
                if (jd1Var != null) {
                    jd1Var.f20469b.onFlushComplete(i2);
                    return;
                }
                return;
            default:
                ((ResourcesCompat.FontCallback) this.f28894c).onFontRetrievalFailed(this.f28893b);
                return;
        }
    }
}
