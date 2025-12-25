package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class cc2 {
    @DoNotInline
    /* renamed from: a */
    public static int m2224a(Resources resources, int i, Resources.Theme theme) {
        return resources.getColor(i, theme);
    }

    @NonNull
    @DoNotInline
    /* renamed from: b */
    public static ColorStateList m2225b(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        return resources.getColorStateList(i, theme);
    }
}
