package p000;

import com.google.common.collect.AbstractSequentialIterator;
import java.util.AbstractQueue;

/* loaded from: classes.dex */
public final class fb1 extends AbstractSequentialIterator {

    /* renamed from: b */
    public final /* synthetic */ int f17199b;

    /* renamed from: c */
    public final /* synthetic */ AbstractQueue f17200c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fb1(AbstractQueue abstractQueue, j92 j92Var, int i) {
        super(j92Var);
        this.f17199b = i;
        this.f17200c = abstractQueue;
    }

    @Override // com.google.common.collect.AbstractSequentialIterator
    public final Object computeNext(Object obj) {
        switch (this.f17199b) {
            case 0:
                j92 mo59n = ((j92) obj).mo59n();
                if (mo59n == ((eb1) ((gb1) this.f17200c).f17631b)) {
                    return null;
                }
                return mo59n;
            default:
                j92 mo56k = ((j92) obj).mo56k();
                if (mo56k == ((eb1) ((gb1) this.f17200c).f17631b)) {
                    return null;
                }
                return mo56k;
        }
    }
}
