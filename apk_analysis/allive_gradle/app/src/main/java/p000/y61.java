package p000;

import com.google.common.base.Joiner;

/* loaded from: classes.dex */
public final class y61 extends Joiner {

    /* renamed from: b */
    public final /* synthetic */ String f28847b;

    /* renamed from: c */
    public final /* synthetic */ Joiner f28848c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y61(Joiner joiner, Joiner joiner2, String str) {
        super(joiner2);
        this.f28848c = joiner;
        this.f28847b = str;
    }

    @Override // com.google.common.base.Joiner
    /* renamed from: a */
    public final CharSequence mo3767a(Object obj) {
        if (obj == null) {
            return this.f28847b;
        }
        return this.f28848c.mo3767a(obj);
    }

    @Override // com.google.common.base.Joiner
    public final Joiner skipNulls() {
        throw new UnsupportedOperationException("already specified useForNull");
    }

    @Override // com.google.common.base.Joiner
    public final Joiner useForNull(String str) {
        throw new UnsupportedOperationException("already specified useForNull");
    }
}
