package p000;

import android.os.PowerManager;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* renamed from: y8 */
/* loaded from: classes.dex */
public abstract class AbstractC2011y8 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m8255a(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }

    @DoNotInline
    /* renamed from: b */
    public static String m8256b(Locale locale) {
        return locale.toLanguageTag();
    }
}
