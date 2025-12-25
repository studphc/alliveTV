package p000;

import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class v41 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f27647a;

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f27647a;
        return s62.m7334a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f27647a) {
            case 0:
                return s62.m7335b(this);
            case 1:
                return s62.m7335b(this);
            case 2:
                return s62.m7335b(this);
            case 3:
                return s62.m7335b(this);
            case 4:
                return s62.m7335b(this);
            case 5:
                return s62.m7335b(this);
            case 6:
                return s62.m7335b(this);
            default:
                return s62.m7335b(this);
        }
    }

    @Override // androidx.core.util.Predicate
    /* renamed from: or */
    public final /* synthetic */ Predicate mo897or(Predicate predicate) {
        int i = this.f27647a;
        return s62.m7336c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f27647a) {
            case 0:
                return true;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return false;
            case 4:
                return false;
            case 5:
                return false;
            case 6:
                return true;
            default:
                return obj == null;
        }
    }
}
