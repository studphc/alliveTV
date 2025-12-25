package p000;

import androidx.constraintlayout.core.SolverVariable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class x30 implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f28432a;

    public /* synthetic */ x30(int i) {
        this.f28432a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
    
        if (r0 != false) goto L26;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(Object obj, Object obj2) {
        boolean z;
        boolean z2;
        switch (this.f28432a) {
            case 0:
                return ((y30) obj).f28817a - ((y30) obj2).f28817a;
            case 1:
                nw0 nw0Var = (nw0) obj;
                nw0 nw0Var2 = (nw0) obj2;
                RecyclerView recyclerView = nw0Var.f23511d;
                if (recyclerView == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (nw0Var2.f23511d == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z == z2) {
                    boolean z3 = nw0Var.f23508a;
                    if (z3 == nw0Var2.f23508a) {
                        int i = nw0Var2.f23509b - nw0Var.f23509b;
                        if (i != 0) {
                            return i;
                        }
                        int i2 = nw0Var.f23510c - nw0Var2.f23510c;
                        if (i2 == 0) {
                            return 0;
                        }
                        return i2;
                    }
                }
                break;
            case 2:
                return Integer.compare(((g71) obj).f17567a, ((g71) obj2).f17567a);
            case 3:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 4:
                return ((SolverVariable) obj).f1863id - ((SolverVariable) obj2).f1863id;
            case 5:
                return ((q33) obj).f25423b - ((q33) obj2).f25423b;
            default:
                return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
        }
    }
}
