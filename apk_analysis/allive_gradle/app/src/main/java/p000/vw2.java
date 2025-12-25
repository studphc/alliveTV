package p000;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class vw2 {

    /* renamed from: a */
    public static final Joiner f27983a = Joiner.m3766on("");

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
    
        if (r3 != ',') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        if (r2 >= r0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
    
        r2 = r2 + m7944a(r12, r13, r2, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (r13.charAt(r2) == '?') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (r13.charAt(r2) != ',') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        r2 = r2 + 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m7944a(ArrayDeque arrayDeque, String str, int i, ImmutableMap.Builder builder) {
        int length = str.length();
        int i2 = i;
        char c = 0;
        while (i2 < length && (c = str.charAt(i2)) != '&' && c != '?' && c != '!' && c != ':' && c != ',') {
            i2++;
        }
        arrayDeque.push(new StringBuilder(str.subSequence(i, i2)).reverse());
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            String join = f27983a.join(arrayDeque);
            if (join.length() > 0) {
                for (PublicSuffixType publicSuffixType : PublicSuffixType.values()) {
                    if (publicSuffixType.f15795a == c || publicSuffixType.f15796b == c) {
                        builder.put(join, publicSuffixType);
                    }
                }
                StringBuilder sb = new StringBuilder(38);
                sb.append("No enum corresponding to given code: ");
                sb.append(c);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int i3 = i2 + 1;
        if (c != '?') {
        }
        arrayDeque.pop();
        return i3 - i;
    }

    /* renamed from: b */
    public static ImmutableMap m7945b(String str) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            i += m7944a(Queues.newArrayDeque(), str, i, builder);
        }
        return builder.buildOrThrow();
    }
}
