package p000;

/* loaded from: classes.dex */
public final /* synthetic */ class kd1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f20825a;

    /* renamed from: b */
    public final /* synthetic */ md1 f20826b;

    /* renamed from: c */
    public final /* synthetic */ String f20827c;

    public /* synthetic */ kd1(md1 md1Var, String str, int i) {
        this.f20825a = i;
        this.f20826b = md1Var;
        this.f20827c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20825a) {
            case 0:
                md1 md1Var = this.f20826b;
                String str = this.f20827c;
                jd1 jd1Var = md1Var.f22897a;
                if (jd1Var != null) {
                    jd1Var.f20469b.onProviderEnabled(str);
                    return;
                }
                return;
            default:
                md1 md1Var2 = this.f20826b;
                String str2 = this.f20827c;
                jd1 jd1Var2 = md1Var2.f22897a;
                if (jd1Var2 != null) {
                    jd1Var2.f20469b.onProviderDisabled(str2);
                    return;
                }
                return;
        }
    }
}
