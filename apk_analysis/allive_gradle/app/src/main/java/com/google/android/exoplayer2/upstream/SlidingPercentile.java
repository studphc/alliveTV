package com.google.android.exoplayer2.upstream;

import java.util.ArrayList;
import java.util.Collections;
import p000.AbstractC1726qj;
import p000.C0556bg;
import p000.sk2;

/* loaded from: classes.dex */
public class SlidingPercentile {

    /* renamed from: h */
    public static final C0556bg f12540h = new C0556bg(15);

    /* renamed from: i */
    public static final C0556bg f12541i = new C0556bg(16);

    /* renamed from: a */
    public final int f12542a;

    /* renamed from: e */
    public int f12546e;

    /* renamed from: f */
    public int f12547f;

    /* renamed from: g */
    public int f12548g;

    /* renamed from: c */
    public final sk2[] f12544c = new sk2[5];

    /* renamed from: b */
    public final ArrayList f12543b = new ArrayList();

    /* renamed from: d */
    public int f12545d = -1;

    public SlidingPercentile(int i) {
        this.f12542a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addSample(int i, float f) {
        sk2 sk2Var;
        int i2 = this.f12545d;
        ArrayList arrayList = this.f12543b;
        if (i2 != 1) {
            Collections.sort(arrayList, f12540h);
            this.f12545d = 1;
        }
        int i3 = this.f12548g;
        sk2[] sk2VarArr = this.f12544c;
        if (i3 > 0) {
            int i4 = i3 - 1;
            this.f12548g = i4;
            sk2Var = sk2VarArr[i4];
        } else {
            sk2Var = new Object();
        }
        int i5 = this.f12546e;
        this.f12546e = i5 + 1;
        sk2Var.f26466a = i5;
        sk2Var.f26467b = i;
        sk2Var.f26468c = f;
        arrayList.add(sk2Var);
        this.f12547f += i;
        while (true) {
            int i6 = this.f12547f;
            int i7 = this.f12542a;
            if (i6 > i7) {
                int i8 = i6 - i7;
                sk2 sk2Var2 = (sk2) arrayList.get(0);
                int i9 = sk2Var2.f26467b;
                if (i9 <= i8) {
                    this.f12547f -= i9;
                    arrayList.remove(0);
                    int i10 = this.f12548g;
                    if (i10 < 5) {
                        this.f12548g = i10 + 1;
                        sk2VarArr[i10] = sk2Var2;
                    }
                } else {
                    sk2Var2.f26467b = i9 - i8;
                    this.f12547f -= i8;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f) {
        int i = this.f12545d;
        ArrayList arrayList = this.f12543b;
        if (i != 0) {
            Collections.sort(arrayList, f12541i);
            this.f12545d = 0;
        }
        float f2 = f * this.f12547f;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sk2 sk2Var = (sk2) arrayList.get(i3);
            i2 += sk2Var.f26467b;
            if (i2 >= f2) {
                return sk2Var.f26468c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((sk2) AbstractC1726qj.m7053i(arrayList, 1)).f26468c;
    }

    public void reset() {
        this.f12543b.clear();
        this.f12545d = -1;
        this.f12546e = 0;
        this.f12547f = 0;
    }
}
