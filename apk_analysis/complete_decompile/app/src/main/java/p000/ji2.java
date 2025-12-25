package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class ji2 extends CacheSpan {

    /* renamed from: a */
    public static final Pattern f20514a = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: b */
    public static final Pattern f20515b = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: c */
    public static final Pattern f20516c = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r16.renameTo(r1) == false) goto L12;
     */
    /* JADX WARN: Type inference failed for: r0v9, types: [ji2, com.google.android.exoplayer2.upstream.cache.CacheSpan] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ji2 m5442a(File file, long j, long j2, C1625ok c1625ok) {
        File file2;
        long j3;
        long j4;
        String str;
        File m5443b;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            String name2 = file.getName();
            Matcher matcher = f20515b.matcher(name2);
            if (matcher.matches()) {
                str = Util.unescapeFileName((String) Assertions.checkNotNull(matcher.group(1)));
            } else {
                matcher = f20514a.matcher(name2);
                if (matcher.matches()) {
                    str = (String) Assertions.checkNotNull(matcher.group(1));
                } else {
                    str = null;
                }
            }
            if (str != null) {
                m5443b = m5443b((File) Assertions.checkStateNotNull(file.getParentFile()), c1625ok.m6575d(str).f20877a, Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))), Long.parseLong((String) Assertions.checkNotNull(matcher.group(3))));
            }
            m5443b = null;
            if (m5443b == null) {
                return null;
            }
            file2 = m5443b;
            name = m5443b.getName();
        } else {
            file2 = file;
        }
        Matcher matcher2 = f20516c.matcher(name);
        if (!matcher2.matches()) {
            return null;
        }
        String str2 = (String) c1625ok.f23832b.get(Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1))));
        if (str2 == null) {
            return null;
        }
        if (j == -1) {
            j3 = file2.length();
        } else {
            j3 = j;
        }
        if (j3 == 0) {
            return null;
        }
        long parseLong = Long.parseLong((String) Assertions.checkNotNull(matcher2.group(2)));
        if (j2 == C0643C.TIME_UNSET) {
            j4 = Long.parseLong((String) Assertions.checkNotNull(matcher2.group(3)));
        } else {
            j4 = j2;
        }
        return new CacheSpan(str2, parseLong, j3, j4, file2);
    }

    /* renamed from: b */
    public static File m5443b(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        return new File(file, ye0.m8297q(sb, j2, ".v3.exo"));
    }
}
