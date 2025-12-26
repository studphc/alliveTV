package p000;

/* renamed from: xe */
/* loaded from: classes2.dex */
public final class C1980xe implements Appendable {

    /* renamed from: a */
    public int f28514a;

    /* renamed from: b */
    public final /* synthetic */ int f28515b;

    /* renamed from: c */
    public final /* synthetic */ Appendable f28516c;

    /* renamed from: d */
    public final /* synthetic */ String f28517d;

    public C1980xe(int i, Appendable appendable, String str) {
        this.f28515b = i;
        this.f28516c = appendable;
        this.f28517d = str;
        this.f28514a = i;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        int i = this.f28514a;
        Appendable appendable = this.f28516c;
        if (i == 0) {
            appendable.append(this.f28517d);
            this.f28514a = this.f28515b;
        }
        appendable.append(c);
        this.f28514a--;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }
}
