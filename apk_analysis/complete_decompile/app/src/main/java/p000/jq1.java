package p000;

import com.google.common.collect.AbstractC0955y1;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class jq1 extends AbstractC0955y1 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f20586a;

    /* renamed from: b */
    public final int f20587b;

    public jq1(int i, Object obj) {
        this.f20586a = obj;
        this.f20587b = i;
        p63.m6869m(i, "count");
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final int getCount() {
        return this.f20587b;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public final Object getElement() {
        return this.f20586a;
    }
}
