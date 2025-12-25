package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00062"}, m5569d2 = {"Lkotlin/text/CharCategory;", "", "", "char", "", "contains", "(C)Z", "", "a", "I", "getValue", "()I", "value", "", "b", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "code", "Companion", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public enum CharCategory {
    UNASSIGNED("Cn", 0),
    UPPERCASE_LETTER("Lu", 1),
    LOWERCASE_LETTER("Ll", 2),
    TITLECASE_LETTER("Lt", 3),
    MODIFIER_LETTER("Lm", 4),
    OTHER_LETTER("Lo", 5),
    NON_SPACING_MARK("Mn", 6),
    ENCLOSING_MARK("Me", 7),
    COMBINING_SPACING_MARK("Mc", 8),
    DECIMAL_DIGIT_NUMBER("Nd", 9),
    LETTER_NUMBER("Nl", 10),
    OTHER_NUMBER("No", 11),
    SPACE_SEPARATOR("Zs", 12),
    LINE_SEPARATOR("Zl", 13),
    PARAGRAPH_SEPARATOR("Zp", 14),
    CONTROL("Cc", 15),
    FORMAT("Cf", 16),
    PRIVATE_USE("Co", 18),
    SURROGATE("Cs", 19),
    DASH_PUNCTUATION("Pd", 20),
    START_PUNCTUATION("Ps", 21),
    END_PUNCTUATION("Pe", 22),
    CONNECTOR_PUNCTUATION("Pc", 23),
    OTHER_PUNCTUATION("Po", 24),
    MATH_SYMBOL("Sm", 25),
    CURRENCY_SYMBOL("Sc", 26),
    MODIFIER_SYMBOL("Sk", 27),
    OTHER_SYMBOL("So", 28),
    INITIAL_QUOTE_PUNCTUATION("Pi", 29),
    FINAL_QUOTE_PUNCTUATION("Pf", 30);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final int value;

    /* renamed from: b, reason: from kotlin metadata */
    public final String code;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lkotlin/text/CharCategory$Companion;", "", "", "category", "Lkotlin/text/CharCategory;", "valueOf", "(I)Lkotlin/text/CharCategory;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final CharCategory valueOf(int category) {
            if (new IntRange(0, 16).contains(category)) {
                return CharCategory.values()[category];
            }
            if (new IntRange(18, 30).contains(category)) {
                return CharCategory.values()[category - 1];
            }
            throw new IllegalArgumentException(ye0.m8292l(category, "Category #", " is not defined."));
        }
    }

    CharCategory(String str, int i) {
        this.value = i;
        this.code = str;
    }

    public final boolean contains(char r2) {
        if (Character.getType(r2) == this.value) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
