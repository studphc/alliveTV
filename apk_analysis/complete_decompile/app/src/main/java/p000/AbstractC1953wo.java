package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/* renamed from: wo */
/* loaded from: classes.dex */
public abstract class AbstractC1953wo extends CharMatcher {

    /* renamed from: a */
    public final String f28254a;

    /* renamed from: b */
    public final char[] f28255b;

    /* renamed from: c */
    public final char[] f28256c;

    public AbstractC1953wo(String str, char[] cArr, char[] cArr2) {
        boolean z;
        boolean z2;
        boolean z3;
        this.f28254a = str;
        this.f28255b = cArr;
        this.f28256c = cArr2;
        if (cArr.length == cArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = 0;
        while (i < cArr.length) {
            if (cArr[i] <= cArr2[i]) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            int i2 = i + 1;
            if (i2 < cArr.length) {
                if (cArr2[i] < cArr[i2]) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3);
            }
            i = i2;
        }
    }

    @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
    public final /* bridge */ /* synthetic */ boolean apply(Character ch) {
        return super.apply(ch);
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        int binarySearch = Arrays.binarySearch(this.f28255b, c);
        if (binarySearch >= 0) {
            return true;
        }
        int i = (~binarySearch) - 1;
        if (i >= 0 && c <= this.f28256c[i]) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public final String toString() {
        return this.f28254a;
    }
}
