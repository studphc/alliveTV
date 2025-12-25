package p000;

/* renamed from: i0 */
/* loaded from: classes2.dex */
public final class C1289i0 extends Throwable {

    /* renamed from: a */
    public final /* synthetic */ int f18233a;

    /* renamed from: a */
    private final synchronized Throwable m5142a() {
        return this;
    }

    /* renamed from: b */
    private final synchronized Throwable m5143b() {
        return this;
    }

    /* renamed from: c */
    private final synchronized Throwable m5144c() {
        return this;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        switch (this.f18233a) {
            case 0:
                m5142a();
                return this;
            case 1:
                m5143b();
                return this;
            case 2:
                m5144c();
                return this;
            default:
                return super.fillInStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1289i0(String str, int i) {
        super(str);
        this.f18233a = i;
    }
}
