package p000;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class us2 extends ge3 {

    /* renamed from: b */
    public static final us2 f27430b = new ge3((Object) null);

    @Override // p000.ge3
    /* renamed from: a */
    public final boolean mo4941a() {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }
}
