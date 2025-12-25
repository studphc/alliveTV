package p000;

import android.icu.util.Calendar;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class sc1 {
    @DoNotInline
    /* renamed from: a */
    public static String m7357a(@NonNull Locale locale) {
        return Calendar.getInstance(locale).getType();
    }

    @DoNotInline
    /* renamed from: b */
    public static Locale m7358b() {
        return Locale.getDefault(Locale.Category.FORMAT);
    }
}
