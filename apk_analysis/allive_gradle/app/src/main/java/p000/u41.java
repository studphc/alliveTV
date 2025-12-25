package p000;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class u41 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f27101a;

    /* renamed from: b */
    public final /* synthetic */ Object f27102b;

    public /* synthetic */ u41(int i, Object obj) {
        this.f27101a = i;
        this.f27102b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f27101a;
        return s62.m7334a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f27101a) {
            case 0:
                return s62.m7335b(this);
            case 1:
                return s62.m7335b(this);
            case 2:
                return s62.m7335b(this);
            default:
                return s62.m7335b(this);
        }
    }

    @Override // androidx.core.util.Predicate
    /* renamed from: or */
    public final /* synthetic */ Predicate mo897or(Predicate predicate) {
        int i = this.f27101a;
        return s62.m7336c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f27101a) {
            case 0:
                return ((ComponentName) this.f27102b).equals((ComponentName) obj);
            case 1:
                return this.f27102b.equals(obj);
            case 2:
                return !((Predicate) this.f27102b).test(obj);
            default:
                if (((UriMatcher) this.f27102b).match((Uri) obj) != -1) {
                    return true;
                }
                return false;
        }
    }
}
