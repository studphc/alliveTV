package p000;

import android.text.Spannable;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class f91 {
    @DoNotInline
    /* renamed from: a */
    public static void m4781a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m4782b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
    }
}
