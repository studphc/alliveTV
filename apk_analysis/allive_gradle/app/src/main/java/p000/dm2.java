package p000;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class dm2 extends AbstractC0541b1 {

    /* renamed from: c */
    public final CharSequence f16427c;

    /* renamed from: d */
    public final CharMatcher f16428d;

    /* renamed from: e */
    public final boolean f16429e;

    /* renamed from: f */
    public int f16430f;

    /* renamed from: g */
    public int f16431g;

    /* renamed from: h */
    public final /* synthetic */ int f16432h;

    /* renamed from: i */
    public final /* synthetic */ Object f16433i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dm2(em2 em2Var, Splitter splitter, CharSequence charSequence, int i) {
        this(splitter, charSequence);
        this.f16432h = i;
        this.f16433i = em2Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0059, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
    
        if (r1 < r10.f16427c.length()) goto L23;
     */
    @Override // p000.AbstractC0541b1
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo2003a() {
        int i;
        CharSequence charSequence;
        int i2;
        CharMatcher charMatcher;
        int i3 = this.f16430f;
        while (true) {
            i = this.f16430f;
            if (i != -1) {
                switch (this.f16432h) {
                    case 0:
                        i = ((CharMatcher) ((ai2) this.f16433i).f216b).indexIn(this.f16427c, i);
                        break;
                    case 1:
                        C1368jv c1368jv = (C1368jv) this.f16433i;
                        int length = c1368jv.f20643b.length();
                        CharSequence charSequence2 = this.f16427c;
                        int length2 = charSequence2.length() - length;
                        while (i <= length2) {
                            for (int i4 = 0; i4 < length; i4++) {
                                if (charSequence2.charAt(i4 + i) != c1368jv.f20643b.charAt(i4)) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    case 2:
                        b01 b01Var = (b01) this.f16433i;
                        if (((Matcher) b01Var.f7833b).find(i)) {
                            i = ((Matcher) b01Var.f7833b).start();
                            break;
                        }
                        break;
                    default:
                        i += ((tx0) this.f16433i).f27011a;
                        break;
                }
                i = -1;
                charSequence = this.f16427c;
                if (i == -1) {
                    i = charSequence.length();
                    this.f16430f = -1;
                } else {
                    switch (this.f16432h) {
                        case 0:
                            i2 = i + 1;
                            break;
                        case 1:
                            i2 = ((C1368jv) this.f16433i).f20643b.length() + i;
                            break;
                        case 2:
                            i2 = ((Matcher) ((b01) this.f16433i).f7833b).end();
                            break;
                        default:
                            i2 = i;
                            break;
                    }
                    this.f16430f = i2;
                }
                int i5 = this.f16430f;
                if (i5 == i3) {
                    int i6 = i5 + 1;
                    this.f16430f = i6;
                    if (i6 > charSequence.length()) {
                        this.f16430f = -1;
                    }
                } else {
                    while (true) {
                        charMatcher = this.f16428d;
                        if (i3 < i && charMatcher.matches(charSequence.charAt(i3))) {
                            i3++;
                        }
                    }
                    while (i > i3 && charMatcher.matches(charSequence.charAt(i - 1))) {
                        i--;
                    }
                    if (this.f16429e && i3 == i) {
                        i3 = this.f16430f;
                    }
                }
            } else {
                this.f7846a = 3;
                return null;
            }
        }
        int i7 = this.f16431g;
        if (i7 == 1) {
            i = charSequence.length();
            this.f16430f = -1;
            while (i > i3 && charMatcher.matches(charSequence.charAt(i - 1))) {
                i--;
            }
        } else {
            this.f16431g = i7 - 1;
        }
        return charSequence.subSequence(i3, i).toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dm2(Splitter splitter, CharSequence charSequence, b01 b01Var) {
        this(splitter, charSequence);
        this.f16432h = 2;
        this.f16433i = b01Var;
    }

    public dm2(Splitter splitter, CharSequence charSequence) {
        this.f16430f = 0;
        this.f16428d = splitter.f14488a;
        this.f16429e = splitter.f14489b;
        this.f16431g = splitter.f14491d;
        this.f16427c = charSequence;
    }
}
