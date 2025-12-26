package p000;

import android.graphics.PointF;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class mm2 {

    /* renamed from: a */
    public static final Pattern f22985a = Pattern.compile("\\{([^}]*)\\}");

    /* renamed from: b */
    public static final Pattern f22986b = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

    /* renamed from: c */
    public static final Pattern f22987c = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

    /* renamed from: d */
    public static final Pattern f22988d = Pattern.compile("\\\\an(\\d+)");

    /* renamed from: a */
    public static PointF m6190a(String str) {
        String group;
        String group2;
        Matcher matcher = f22986b.matcher(str);
        Matcher matcher2 = f22987c.matcher(str);
        boolean find = matcher.find();
        boolean find2 = matcher2.find();
        if (find) {
            if (find2) {
                Log.m3025i("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
            }
            group = matcher.group(1);
            group2 = matcher.group(2);
        } else if (find2) {
            group = matcher2.group(1);
            group2 = matcher2.group(2);
        } else {
            return null;
        }
        return new PointF(Float.parseFloat(((String) Assertions.checkNotNull(group)).trim()), Float.parseFloat(((String) Assertions.checkNotNull(group2)).trim()));
    }
}
