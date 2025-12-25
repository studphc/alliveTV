package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.graph.C0963b;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

/* renamed from: ap */
/* loaded from: classes2.dex */
public final class C0528ap extends AbstractIterator {

    /* renamed from: c */
    public final /* synthetic */ int f7689c;

    /* renamed from: d */
    public final Object f7690d;

    public /* synthetic */ C0528ap(Iterator it, int i) {
        this.f7689c = i;
        this.f7690d = it;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        Object value;
        j40 j40Var;
        j40 j40Var2;
        switch (this.f7689c) {
            case 0:
                Iterator it = (Iterator) this.f7690d;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    if (it.hasNext() || !str.isEmpty()) {
                        return str;
                    }
                }
                return (String) endOfData();
            case 1:
                do {
                    Iterator it2 = (Iterator) this.f7690d;
                    if (it2.hasNext()) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        value = entry.getValue();
                        if (value != C0963b.f15045e) {
                        }
                        return entry.getKey();
                    }
                    return endOfData();
                } while (!(value instanceof k40));
                return entry.getKey();
            case 2:
                do {
                    Iterator it3 = (Iterator) this.f7690d;
                    if (it3.hasNext()) {
                        j40Var = (j40) it3.next();
                    } else {
                        return endOfData();
                    }
                } while (!(j40Var instanceof h40));
                return j40Var.f20368a;
            case 3:
                while (true) {
                    Iterator it4 = (Iterator) this.f7690d;
                    if (it4.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it4.next();
                        Object value2 = entry2.getValue();
                        if (value2 != C0963b.f15045e && value2 != null) {
                            return entry2.getKey();
                        }
                    } else {
                        return endOfData();
                    }
                }
                break;
            case 4:
                do {
                    Iterator it5 = (Iterator) this.f7690d;
                    if (it5.hasNext()) {
                        j40Var2 = (j40) it5.next();
                    } else {
                        return endOfData();
                    }
                } while (!(j40Var2 instanceof i40));
                return j40Var2.f20368a;
            default:
                Queue queue = (Queue) this.f7690d;
                if (queue.isEmpty()) {
                    return endOfData();
                }
                return queue.remove();
        }
    }

    public C0528ap(Queue queue) {
        this.f7689c = 5;
        this.f7690d = (Queue) Preconditions.checkNotNull(queue);
    }

    public C0528ap(C0565bp c0565bp) {
        this.f7689c = 0;
        this.f7690d = C0565bp.f8118b.split(c0565bp.f8119a).iterator();
    }
}
