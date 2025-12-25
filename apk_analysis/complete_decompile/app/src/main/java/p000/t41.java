package p000;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class t41 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f26690a;

    /* renamed from: b */
    public final /* synthetic */ String f26691b;

    public /* synthetic */ t41(String str, int i) {
        this.f26690a = i;
        this.f26691b = str;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f26690a;
        return s62.m7334a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f26690a) {
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
            default:
                return s62.m7335b(this);
        }
    }

    @Override // androidx.core.util.Predicate
    /* renamed from: or */
    public final /* synthetic */ Predicate mo897or(Predicate predicate) {
        int i = this.f26690a;
        return s62.m7336c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f26690a) {
            case 0:
                return this.f26691b.equals(((Uri) obj).getAuthority());
            case 1:
                return this.f26691b.equals(((Uri) obj).getAuthority());
            case 2:
                return this.f26691b.equals(((Uri) obj).getAuthority());
            case 3:
                return this.f26691b.equals((String) obj);
            case 4:
                return this.f26691b.equals(((ComponentName) obj).getPackageName());
            default:
                return this.f26691b.equals(((Uri) obj).getAuthority());
        }
    }
}
