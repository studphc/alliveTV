package p000;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

/* loaded from: classes.dex */
public final /* synthetic */ class pb2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f25106a;

    /* renamed from: b */
    public final /* synthetic */ qb2 f25107b;

    public /* synthetic */ pb2(qb2 qb2Var, int i) {
        this.f25106a = i;
        this.f25107b = qb2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f25106a) {
            case 0:
                RequirementsWatcher requirementsWatcher = this.f25107b.f25509c;
                if (requirementsWatcher.f10898g != null) {
                    requirementsWatcher.m2725a();
                    return;
                }
                return;
            default:
                RequirementsWatcher requirementsWatcher2 = this.f25107b.f25509c;
                if (requirementsWatcher2.f10898g != null && (requirementsWatcher2.f10897f & 3) != 0) {
                    requirementsWatcher2.m2725a();
                    return;
                }
                return;
        }
    }
}
