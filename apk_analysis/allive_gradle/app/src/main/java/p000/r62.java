package p000;

import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class r62 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f25882a;

    /* renamed from: b */
    public final /* synthetic */ Predicate f25883b;

    /* renamed from: c */
    public final /* synthetic */ Object f25884c;

    public /* synthetic */ r62(Predicate predicate, Predicate predicate2, int i) {
        this.f25882a = i;
        this.f25883b = predicate;
        this.f25884c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f25882a;
        return s62.m7334a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f25882a) {
            case 0:
                return s62.m7335b(this);
            case 1:
                return s62.m7335b(this);
            default:
                return s62.m7335b(this);
        }
    }

    @Override // androidx.core.util.Predicate
    /* renamed from: or */
    public final /* synthetic */ Predicate mo897or(Predicate predicate) {
        int i = this.f25882a;
        return s62.m7336c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f25882a) {
            case 0:
                if (!this.f25883b.test(obj) && !((Predicate) this.f25884c).test(obj)) {
                    return false;
                }
                return true;
            case 1:
                if (this.f25883b.test(obj) && ((Predicate) this.f25884c).test(obj)) {
                    return true;
                }
                return false;
            default:
                Class cls = (Class) this.f25884c;
                if (cls.isInstance(obj)) {
                    if (this.f25883b.test(cls.cast(obj))) {
                        return true;
                    }
                }
                return false;
        }
    }

    public /* synthetic */ r62(Class cls, Predicate predicate) {
        this.f25882a = 2;
        this.f25884c = cls;
        this.f25883b = predicate;
    }
}
