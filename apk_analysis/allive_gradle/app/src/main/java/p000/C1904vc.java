package p000;

import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.tasks.Task;
import com.google.common.io.LineReader;
import java.util.ArrayDeque;

/* renamed from: vc */
/* loaded from: classes.dex */
public final class C1904vc {

    /* renamed from: a */
    public boolean f27734a;

    /* renamed from: b */
    public Object f27735b;

    /* renamed from: c */
    public Object f27736c;

    /* renamed from: a */
    public void m7899a(boolean z) {
        ((LineReader) this.f27736c).f15089e.add(((StringBuilder) this.f27735b).toString());
        this.f27735b = new StringBuilder();
        this.f27734a = false;
    }

    /* renamed from: b */
    public void m7900b(boolean z) {
        RunnableC1867uc runnableC1867uc = (RunnableC1867uc) this.f27736c;
        Context context = (Context) this.f27735b;
        if (z && !this.f27734a) {
            context.registerReceiver(runnableC1867uc, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f27734a = true;
        } else if (!z && this.f27734a) {
            context.unregisterReceiver(runnableC1867uc);
            this.f27734a = false;
        }
    }

    /* renamed from: c */
    public void m7901c(xe3 xe3Var) {
        synchronized (this.f27735b) {
            try {
                if (((ArrayDeque) this.f27736c) == null) {
                    this.f27736c = new ArrayDeque();
                }
                ((ArrayDeque) this.f27736c).add(xe3Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: d */
    public void m7902d(Task task) {
        xe3 xe3Var;
        synchronized (this.f27735b) {
            if (((ArrayDeque) this.f27736c) != null && !this.f27734a) {
                this.f27734a = true;
                while (true) {
                    synchronized (this.f27735b) {
                        try {
                            xe3Var = (xe3) ((ArrayDeque) this.f27736c).poll();
                            if (xe3Var == null) {
                                this.f27734a = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    xe3Var.mo5912a(task);
                }
            }
        }
    }
}
