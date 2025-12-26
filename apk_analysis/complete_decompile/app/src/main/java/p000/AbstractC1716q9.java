package p000;

import android.content.res.Resources;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;

/* renamed from: q9 */
/* loaded from: classes.dex */
public abstract class AbstractC1716q9 {
    @DoNotInline
    /* renamed from: a */
    public static void m7006a(@NonNull ThemedSpinnerAdapter themedSpinnerAdapter, @Nullable Resources.Theme theme) {
        if (!ObjectsCompat.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }
}
