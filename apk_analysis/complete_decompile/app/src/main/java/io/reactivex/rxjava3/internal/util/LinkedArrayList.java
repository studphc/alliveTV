package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LinkedArrayList {

    /* renamed from: a */
    public final int f19953a;

    /* renamed from: b */
    public Object[] f19954b;

    /* renamed from: c */
    public Object[] f19955c;

    /* renamed from: d */
    public volatile int f19956d;

    /* renamed from: e */
    public int f19957e;

    public LinkedArrayList(int i) {
        this.f19953a = i;
    }

    public void add(Object obj) {
        if (this.f19956d == 0) {
            Object[] objArr = new Object[this.f19953a + 1];
            this.f19954b = objArr;
            this.f19955c = objArr;
            objArr[0] = obj;
            this.f19957e = 1;
            this.f19956d = 1;
            return;
        }
        int i = this.f19957e;
        int i2 = this.f19953a;
        if (i == i2) {
            Object[] objArr2 = new Object[i2 + 1];
            objArr2[0] = obj;
            this.f19955c[i2] = objArr2;
            this.f19955c = objArr2;
            this.f19957e = 1;
            this.f19956d++;
            return;
        }
        this.f19955c[i] = obj;
        this.f19957e = i + 1;
        this.f19956d++;
    }

    public Object[] head() {
        return this.f19954b;
    }

    public int size() {
        return this.f19956d;
    }

    public String toString() {
        int i = this.f19953a;
        int i2 = this.f19956d;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] head = head();
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(head[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                head = (Object[]) head[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
