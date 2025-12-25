package p000;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.StyleableRes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class jy2 {
    @JvmStatic
    @DoNotInline
    @NotNull
    /* renamed from: a */
    public static final Typeface m5467a(@NotNull TypedArray typedArray, @StyleableRes int i) {
        Typeface font = typedArray.getFont(i);
        Intrinsics.checkNotNull(font);
        return font;
    }
}
