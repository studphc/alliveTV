package p000;

import android.text.Html;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class yl2 {

    /* renamed from: a */
    public static final Pattern f29015a = Pattern.compile("(&#13;)?&#10;");

    /* renamed from: a */
    public static String m8310a(CharSequence charSequence) {
        return f29015a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
