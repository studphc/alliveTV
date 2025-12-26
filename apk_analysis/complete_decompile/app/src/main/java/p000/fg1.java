package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class fg1 extends rv2 {

    /* renamed from: b */
    public final /* synthetic */ int f17258b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fg1(Iterator it, int i) {
        super(it);
        this.f17258b = i;
    }

    @Override // p000.rv2
    /* renamed from: a */
    public final Object mo4106a(Object obj) {
        switch (this.f17258b) {
            case 0:
                return ((Map.Entry) obj).getKey();
            case 1:
                return ((Map.Entry) obj).getValue();
            default:
                return new pq1((Map.Entry) obj, 0);
        }
    }
}
