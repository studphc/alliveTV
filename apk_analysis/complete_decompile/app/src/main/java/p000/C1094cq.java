package p000;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: cq */
/* loaded from: classes.dex */
public final class C1094cq extends AbstractIterator {

    /* renamed from: c */
    public final ArrayList f16067c;

    /* renamed from: d */
    public final int[] f16068d;

    /* renamed from: e */
    public final int[] f16069e;

    /* renamed from: f */
    public int f16070f;

    public C1094cq(List list) {
        this.f16067c = new ArrayList(list);
        int size = list.size();
        int[] iArr = new int[size];
        this.f16068d = iArr;
        int[] iArr2 = new int[size];
        this.f16069e = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 1);
        this.f16070f = Integer.MAX_VALUE;
    }

    @Override // com.google.common.collect.AbstractIterator
    public final Object computeNext() {
        if (this.f16070f <= 0) {
            return (List) endOfData();
        }
        ArrayList arrayList = this.f16067c;
        ImmutableList copyOf = ImmutableList.copyOf((Collection) arrayList);
        int size = arrayList.size() - 1;
        this.f16070f = size;
        if (size != -1) {
            int i = 0;
            while (true) {
                int i2 = this.f16070f;
                int[] iArr = this.f16068d;
                int i3 = iArr[i2];
                int[] iArr2 = this.f16069e;
                int i4 = iArr2[i2];
                int i5 = i3 + i4;
                if (i5 < 0) {
                    iArr2[i2] = -i4;
                    this.f16070f = i2 - 1;
                } else if (i5 == i2 + 1) {
                    if (i2 == 0) {
                        break;
                    }
                    i++;
                    iArr2[i2] = -i4;
                    this.f16070f = i2 - 1;
                } else {
                    Collections.swap(arrayList, (i2 - i3) + i, (i2 - i5) + i);
                    iArr[this.f16070f] = i5;
                    break;
                }
            }
        }
        return copyOf;
    }
}
