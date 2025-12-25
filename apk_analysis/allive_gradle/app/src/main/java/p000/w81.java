package p000;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class w81 extends rv2 implements ListIterator {

    /* renamed from: b */
    public final /* synthetic */ int f28098b;

    /* renamed from: c */
    public final /* synthetic */ Object f28099c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w81(AbstractList abstractList, ListIterator listIterator, int i) {
        super(listIterator);
        this.f28098b = i;
        this.f28099c = abstractList;
    }

    @Override // p000.rv2
    /* renamed from: a */
    public final Object mo4106a(Object obj) {
        switch (this.f28098b) {
            case 0:
                return ((Map.Entry) obj).getValue();
            case 1:
                return ((ka1) this.f28099c).f20803b.apply(obj);
            default:
                return ((la1) this.f28099c).f22426b.apply(obj);
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public final void m8009b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f26165a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f26165a).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return mo4106a(((ListIterator) this.f26165a).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f26165a).previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        boolean z;
        switch (this.f28098b) {
            case 0:
                a91 a91Var = (a91) this.f28099c;
                if (a91Var.f93c != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                a91Var.f93c.f29270b = obj;
                return;
            default:
                m8009b(obj);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w81(a91 a91Var, a91 a91Var2) {
        super(a91Var);
        this.f28098b = 0;
        this.f28099c = a91Var2;
    }
}
