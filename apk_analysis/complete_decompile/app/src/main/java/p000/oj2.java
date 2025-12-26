package p000;

import com.google.android.gms.internal.measurement.zzmr;
import com.google.android.gms.measurement.internal.zzbf;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.operators.single.SingleToFlowable;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class oj2 implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f23829a;

    /* renamed from: b */
    public final Iterator f23830b;

    public /* synthetic */ oj2(Iterator it, int i) {
        this.f23829a = i;
        this.f23830b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f23829a) {
            case 0:
                return this.f23830b.hasNext();
            case 1:
                return this.f23830b.hasNext();
            default:
                return this.f23830b.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f23829a) {
            case 0:
                return new SingleToFlowable((SingleSource) this.f23830b.next());
            case 1:
                return (String) this.f23830b.next();
            default:
                Map.Entry entry = (Map.Entry) this.f23830b.next();
                if (entry.getValue() instanceof zzmr) {
                    return new jd3(entry);
                }
                return entry;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f23829a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException("Remove not supported");
            default:
                this.f23830b.remove();
                return;
        }
    }

    public oj2(zzbf zzbfVar) {
        this.f23829a = 1;
        this.f23830b = zzbfVar.f14148a.keySet().iterator();
    }
}
