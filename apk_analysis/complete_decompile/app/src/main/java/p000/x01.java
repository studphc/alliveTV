package p000;

import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class x01 {
    @DoNotInline
    /* renamed from: a */
    public static Spanned m8084a(String str, int i) {
        return Html.fromHtml(str, i);
    }

    @DoNotInline
    /* renamed from: b */
    public static Spanned m8085b(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Html.fromHtml(str, i, imageGetter, tagHandler);
    }

    @DoNotInline
    /* renamed from: c */
    public static String m8086c(Spanned spanned, int i) {
        return Html.toHtml(spanned, i);
    }
}
