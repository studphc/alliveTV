package p000;

import android.content.res.Configuration;
import androidx.annotation.DoNotInline;
import androidx.core.os.LocaleListCompat;

/* loaded from: classes.dex */
public abstract class pc1 {
    @DoNotInline
    /* renamed from: a */
    public static LocaleListCompat m6908a(Configuration configuration) {
        return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
    }
}
