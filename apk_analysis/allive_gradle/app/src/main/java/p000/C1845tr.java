package p000;

import com.google.common.collect.Table;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: tr */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1845tr implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f26941a;

    /* renamed from: b */
    public final /* synthetic */ Comparator f26942b;

    /* renamed from: c */
    public final /* synthetic */ Comparator f26943c;

    public /* synthetic */ C1845tr(Comparator comparator, Comparator comparator2, int i) {
        this.f26941a = i;
        this.f26942b = comparator;
        this.f26943c = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        switch (this.f26941a) {
            case 0:
                Comparator this_thenDescending = this.f26942b;
                Intrinsics.checkNotNullParameter(this_thenDescending, "$this_thenDescending");
                Comparator comparator = this.f26943c;
                Intrinsics.checkNotNullParameter(comparator, "$comparator");
                int compare2 = this_thenDescending.compare(obj, obj2);
                if (compare2 == 0) {
                    return comparator.compare(obj2, obj);
                }
                return compare2;
            case 1:
                Comparator this_then = this.f26942b;
                Intrinsics.checkNotNullParameter(this_then, "$this_then");
                Comparator comparator2 = this.f26943c;
                Intrinsics.checkNotNullParameter(comparator2, "$comparator");
                int compare3 = this_then.compare(obj, obj2);
                if (compare3 == 0) {
                    return comparator2.compare(obj, obj2);
                }
                return compare3;
            default:
                Table.Cell cell = (Table.Cell) obj;
                Table.Cell cell2 = (Table.Cell) obj2;
                Comparator comparator3 = this.f26942b;
                int i = 0;
                if (comparator3 == null) {
                    compare = 0;
                } else {
                    compare = comparator3.compare(cell.getRowKey(), cell2.getRowKey());
                }
                if (compare == 0) {
                    Comparator comparator4 = this.f26943c;
                    if (comparator4 != null) {
                        i = comparator4.compare(cell.getColumnKey(), cell2.getColumnKey());
                    }
                    return i;
                }
                return compare;
        }
    }
}
