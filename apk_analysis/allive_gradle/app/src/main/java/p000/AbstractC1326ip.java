package p000;

import java.util.Locale;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharCategory;
import kotlin.text.CharDirectionality;
import org.jetbrains.annotations.NotNull;

/* renamed from: ip */
/* loaded from: classes2.dex */
public abstract class AbstractC1326ip {
    @PublishedApi
    public static int checkRadix(int i) {
        if (new IntRange(2, 36).contains(i)) {
            return i;
        }
        StringBuilder m8299s = ye0.m8299s(i, "radix ", " was not in valid range ");
        m8299s.append(new IntRange(2, 36));
        throw new IllegalArgumentException(m8299s.toString());
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    @NotNull
    public static final CharCategory getCategory(char c) {
        return CharCategory.INSTANCE.valueOf(Character.getType(c));
    }

    @NotNull
    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.INSTANCE.valueOf(Character.getDirectionality(c));
    }

    public static final boolean isWhitespace(char c) {
        if (!Character.isWhitespace(c) && !Character.isSpaceChar(c)) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String lowercase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String titlecase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String uppercase = uppercase(c, locale);
        if (uppercase.length() > 1) {
            if (c != 329) {
                char charAt = uppercase.charAt(0);
                Intrinsics.checkNotNull(uppercase, "null cannot be cast to non-null type java.lang.String");
                String substring = uppercase.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = substring.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                return charAt + lowerCase;
            }
            return uppercase;
        }
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (!Intrinsics.areEqual(uppercase, upperCase)) {
            return uppercase;
        }
        return String.valueOf(Character.toTitleCase(c));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String uppercase(char c, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
