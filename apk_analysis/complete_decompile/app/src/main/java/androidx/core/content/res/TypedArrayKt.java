package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.jy2;

@Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0007\u001a\u001d\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000f\u0010\u0007\u001a\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u000b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\r\u001a\u001d\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0007\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0007\u001a\u001d\u0010\u0019\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0019\u0010\u0007\u001a\u001b\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0 *\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a.\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010#*\u00020\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000$H\u0086\b¢\u0006\u0004\b&\u0010'¨\u0006("}, m5569d2 = {"Landroid/content/res/TypedArray;", "", FirebaseAnalytics.Param.INDEX, "", "getBooleanOrThrow", "(Landroid/content/res/TypedArray;I)Z", "getColorOrThrow", "(Landroid/content/res/TypedArray;I)I", "Landroid/content/res/ColorStateList;", "getColorStateListOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;", "", "getDimensionOrThrow", "(Landroid/content/res/TypedArray;I)F", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "Landroid/graphics/drawable/Drawable;", "getDrawableOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "Landroid/graphics/Typeface;", "getFontOrThrow", "(Landroid/content/res/TypedArray;I)Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "", "getStringOrThrow", "(Landroid/content/res/TypedArray;I)Ljava/lang/String;", "", "getTextOrThrow", "(Landroid/content/res/TypedArray;I)Ljava/lang/CharSequence;", "", "getTextArrayOrThrow", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "R", "Lkotlin/Function1;", "block", "use", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class TypedArrayKt {
    /* renamed from: a */
    public static final void m822a(TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
        } else {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        ColorStateList colorStateList = typedArray.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getDimension(i, RecyclerView.f7068F0);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getDimensionPixelSize(i, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        Drawable drawable = typedArray.getDrawable(i);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getFloat(i, RecyclerView.f7068F0);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return jy2.m5467a(typedArray, i);
    }

    public static final int getIntOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        String string = typedArray.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        return typedArray.getTextArray(i);
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i) {
        m822a(typedArray, i);
        CharSequence text = typedArray.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(@NotNull TypedArray typedArray, @NotNull Function1<? super TypedArray, ? extends R> function1) {
        R invoke = function1.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
