package p000;

import com.google.common.base.Converter;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: xg */
/* loaded from: classes2.dex */
public final class C1982xg implements Iterator {

    /* renamed from: a */
    public final /* synthetic */ int f28540a;

    /* renamed from: b */
    public Object f28541b;

    /* renamed from: c */
    public final /* synthetic */ Object f28542c;

    public /* synthetic */ C1982xg(int i, Object obj) {
        this.f28540a = i;
        this.f28542c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f28540a) {
            case 0:
                this.f28541b = ((C2019yg) this.f28542c).f28943b;
                return !NotificationLite.isComplete(r0);
            case 1:
                this.f28541b = ((C1122dh) this.f28542c).f16374b;
                return !NotificationLite.isComplete(r0);
            case 2:
                return ((Iterator) this.f28541b).hasNext();
            case 3:
                if (!((Iterator) this.f28541b).hasNext() && !((Iterable) this.f28542c).iterator().hasNext()) {
                    return false;
                }
                return true;
            default:
                return ((Iterator) this.f28541b).hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f28540a) {
            case 0:
                try {
                    if (this.f28541b == null) {
                        this.f28541b = ((C2019yg) this.f28542c).f28943b;
                    }
                    if (!NotificationLite.isComplete(this.f28541b)) {
                        if (!NotificationLite.isError(this.f28541b)) {
                            Object value = NotificationLite.getValue(this.f28541b);
                            this.f28541b = null;
                            return value;
                        }
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.f28541b));
                    }
                    throw new NoSuchElementException();
                } catch (Throwable th) {
                    this.f28541b = null;
                    throw th;
                }
            case 1:
                try {
                    if (this.f28541b == null) {
                        this.f28541b = ((C1122dh) this.f28542c).f16374b;
                    }
                    if (!NotificationLite.isComplete(this.f28541b)) {
                        if (!NotificationLite.isError(this.f28541b)) {
                            Object value2 = NotificationLite.getValue(this.f28541b);
                            this.f28541b = null;
                            return value2;
                        }
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.f28541b));
                    }
                    throw new NoSuchElementException();
                } catch (Throwable th2) {
                    this.f28541b = null;
                    throw th2;
                }
            case 2:
                return ((Converter) ((C1369jw) this.f28542c).f20657c).convert(((Iterator) this.f28541b).next());
            case 3:
                if (!((Iterator) this.f28541b).hasNext()) {
                    Iterator it = ((Iterable) this.f28542c).iterator();
                    this.f28541b = it;
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return ((Iterator) this.f28541b).next();
            default:
                Map.Entry entry = (Map.Entry) ((Iterator) this.f28541b).next();
                ((en2) this.f28542c).getClass();
                return new pq1(entry, 2);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f28540a) {
            case 0:
                throw new UnsupportedOperationException("Read only iterator");
            case 1:
                throw new UnsupportedOperationException("Read only iterator");
            case 2:
                ((Iterator) this.f28541b).remove();
                return;
            case 3:
                ((Iterator) this.f28541b).remove();
                return;
            default:
                ((Iterator) this.f28541b).remove();
                ((en2) this.f28542c).mo4492e();
                return;
        }
    }

    public C1982xg(C1369jw c1369jw) {
        this.f28540a = 2;
        this.f28542c = c1369jw;
        this.f28541b = ((Iterable) c1369jw.f20656b).iterator();
    }

    public C1982xg(en2 en2Var, Iterator it) {
        this.f28540a = 4;
        this.f28542c = en2Var;
        this.f28541b = it;
    }

    public C1982xg(Iterable iterable) {
        this.f28540a = 3;
        this.f28542c = iterable;
        this.f28541b = b61.f7906a;
    }
}
