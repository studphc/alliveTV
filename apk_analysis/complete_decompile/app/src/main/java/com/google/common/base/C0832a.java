package com.google.common.base;

import com.google.common.base.Joiner;
import java.util.Iterator;

/* renamed from: com.google.common.base.a */
/* loaded from: classes.dex */
public final class C0832a extends Joiner {

    /* renamed from: b */
    public final /* synthetic */ Joiner f14504b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0832a(Joiner joiner, Joiner joiner2) {
        super(joiner2);
        this.f14504b = joiner;
    }

    @Override // com.google.common.base.Joiner
    public final Appendable appendTo(Appendable appendable, Iterator it) {
        Joiner joiner;
        Preconditions.checkNotNull(appendable, "appendable");
        Preconditions.checkNotNull(it, "parts");
        while (true) {
            boolean hasNext = it.hasNext();
            joiner = this.f14504b;
            if (!hasNext) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                appendable.append(joiner.mo3767a(next));
                break;
            }
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                appendable.append(joiner.f14481a);
                appendable.append(joiner.mo3767a(next2));
            }
        }
        return appendable;
    }

    @Override // com.google.common.base.Joiner
    public final Joiner useForNull(String str) {
        throw new UnsupportedOperationException("already specified skipNulls");
    }

    @Override // com.google.common.base.Joiner
    public final Joiner.MapJoiner withKeyValueSeparator(String str) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}
