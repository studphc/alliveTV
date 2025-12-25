package p000;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class po2 extends oo2 {
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (se2.f26395a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Double toDoubleOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!se2.f26395a.matches(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Float toFloatOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!se2.f26395a.matches(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractC1326ip.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (AbstractC1326ip.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        } else if (AbstractC1326ip.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, AbstractC1326ip.checkRadix(i));
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String str, @NotNull MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (se2.f26395a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
