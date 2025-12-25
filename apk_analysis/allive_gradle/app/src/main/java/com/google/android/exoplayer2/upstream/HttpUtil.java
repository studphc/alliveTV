package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class HttpUtil {

    /* renamed from: a */
    public static final Pattern f12509a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* renamed from: b */
    public static final Pattern f12510b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    @Nullable
    public static String buildRangeRequestHeader(long j, long j2) {
        if (j == 0 && j2 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder("bytes=");
        sb.append(j);
        sb.append("-");
        if (j2 != -1) {
            sb.append((j + j2) - 1);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getContentLength(@Nullable String str, @Nullable String str2) {
        long parseLong;
        if (!TextUtils.isEmpty(str)) {
            try {
                parseLong = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                Log.m3023e("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
            if (TextUtils.isEmpty(str2)) {
                Matcher matcher = f12509a.matcher(str2);
                if (matcher.matches()) {
                    try {
                        long parseLong2 = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) - Long.parseLong((String) Assertions.checkNotNull(matcher.group(1)))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            Log.m3027w("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        Log.m3023e("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        if (TextUtils.isEmpty(str2)) {
        }
    }

    public static long getDocumentSize(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f12510b.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        return Long.parseLong((String) Assertions.checkNotNull(matcher.group(1)));
    }
}
