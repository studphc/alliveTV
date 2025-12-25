package p000;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class ic1 {

    /* renamed from: a */
    public static final Locale[] f18362a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    @DoNotInline
    /* renamed from: a */
    public static Locale m5208a(String str) {
        return Locale.forLanguageTag(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m5209b(@NonNull Locale locale, @NonNull Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f18362a;
        int length = localeArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (localeArr[i].equals(locale)) {
                    break;
                }
                i++;
            } else {
                for (Locale locale3 : localeArr) {
                    if (!locale3.equals(locale2)) {
                    }
                }
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript.isEmpty()) {
                    String country = locale.getCountry();
                    if (country.isEmpty() || country.equals(locale2.getCountry())) {
                        return true;
                    }
                    return false;
                }
                return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
            }
        }
        return false;
    }
}
