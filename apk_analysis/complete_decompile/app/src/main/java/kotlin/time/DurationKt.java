package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import p000.f70;
import p000.g70;
import p000.r82;
import p000.rh1;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\"\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\t\"\u0014\u0010\n\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"!\u0010\u0013\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"!\u0010\u0013\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u000f\u0010\u0014\"!\u0010\u0013\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0016\"!\u0010\u001a\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0018\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014\"!\u0010\u001a\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016\"!\u0010\u001d\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001b\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014\"!\u0010\u001d\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016\"!\u0010 \u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001e\u0010\u0010\"!\u0010 \u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014\"!\u0010 \u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016\"!\u0010#\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b!\u0010\u0010\"!\u0010#\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u0014\"!\u0010#\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b!\u0010\u0016\"!\u0010&\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0012\u001a\u0004\b$\u0010\u0010\"!\u0010&\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0014\"!\u0010&\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b%\u0010\u0017\u001a\u0004\b$\u0010\u0016\"!\u0010)\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0012\u001a\u0004\b'\u0010\u0010\"!\u0010)\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0015\u001a\u0004\b'\u0010\u0014\"!\u0010)\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b(\u0010\u0017\u001a\u0004\b'\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m5569d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "NANOS_IN_MILLIS", "I", "MAX_NANOS", "J", "MAX_MILLIS", "getNanoseconds", "(I)J", "getNanoseconds$annotations", "(I)V", "nanoseconds", "(J)J", "(J)V", "(D)J", "(D)V", "getMicroseconds", "getMicroseconds$annotations", "microseconds", "getMilliseconds", "getMilliseconds$annotations", "milliseconds", "getSeconds", "getSeconds$annotations", "seconds", "getMinutes", "getMinutes$annotations", "minutes", "getHours", "getHours$annotations", "hours", "getDays", "getDays$annotations", "days", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1484:1\n1436#1,6:1486\n1439#1,3:1492\n1436#1,6:1495\n1436#1,6:1501\n1439#1,3:1510\n1#2:1485\n1726#3,3:1507\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1360#1:1486,6\n1394#1:1492,3\n1397#1:1495,6\n1400#1:1501,6\n1436#1:1510,3\n1425#1:1507,3\n*E\n"})
/* loaded from: classes2.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* renamed from: a */
    public static final long m5647a(long j) {
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j)) {
            return m5648b(j * 1000000);
        }
        return Duration.m8719constructorimpl((r82.coerceIn(j, -4611686018427387903L, MAX_MILLIS) << 1) + 1);
    }

    public static final long access$durationOfNanosNormalized(long j) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(j)) {
            return m5648b(j);
        }
        return Duration.m8719constructorimpl(((j / 1000000) << 1) + 1);
    }

    public static final long access$millisToNanos(long j) {
        return j * 1000000;
    }

    public static final long access$nanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long access$parseDuration(String str, boolean z) {
        boolean z2;
        long j;
        int i;
        boolean z3;
        int i2;
        String str2 = str;
        int length = str.length();
        if (length != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            long m8795getZEROUwyO8pc = companion.m8795getZEROUwyO8pc();
            char charAt = str2.charAt(0);
            boolean z4 = true;
            int i3 = (charAt == '+' || charAt == '-') ? 1 : 0;
            boolean z5 = i3 > 0;
            boolean z6 = z5 && StringsKt__StringsKt.startsWith$default((CharSequence) str2, '-', false, 2, (Object) null);
            if (length > i3) {
                char c = '9';
                char c2 = '0';
                String str3 = "this as java.lang.String…ing(startIndex, endIndex)";
                if (str2.charAt(i3) == 'P') {
                    int i4 = i3 + 1;
                    if (i4 == length) {
                        throw new IllegalArgumentException();
                    }
                    boolean z7 = false;
                    DurationUnit durationUnit = null;
                    while (i4 < length) {
                        if (str2.charAt(i4) != 'T') {
                            int i5 = i4;
                            while (true) {
                                if (i5 >= str.length()) {
                                    i2 = length;
                                    break;
                                }
                                char charAt2 = str2.charAt(i5);
                                if (!new CharRange(c2, c).contains(charAt2)) {
                                    i2 = length;
                                    if (!StringsKt__StringsKt.contains$default((CharSequence) "+-.", charAt2, false, 2, (Object) null)) {
                                        break;
                                    }
                                } else {
                                    i2 = length;
                                }
                                i5++;
                                length = i2;
                                c2 = '0';
                                c = '9';
                            }
                            Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                            String substring = str2.substring(i4, i5);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            if (substring.length() != 0) {
                                int length2 = substring.length() + i4;
                                if (length2 >= 0 && length2 <= StringsKt__StringsKt.getLastIndex(str)) {
                                    i4 = length2 + 1;
                                    DurationUnit durationUnitByIsoChar = g70.durationUnitByIsoChar(str2.charAt(length2), z7);
                                    if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                    }
                                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6, (Object) null);
                                    if (durationUnitByIsoChar == DurationUnit.SECONDS && indexOf$default > 0) {
                                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                        String substring2 = substring.substring(0, indexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                        long m8750plusLRDsOJo = Duration.m8750plusLRDsOJo(m8795getZEROUwyO8pc, toDuration(m5649c(substring2), durationUnitByIsoChar));
                                        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                        String substring3 = substring.substring(indexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                                        m8795getZEROUwyO8pc = Duration.m8750plusLRDsOJo(m8750plusLRDsOJo, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                                    } else {
                                        m8795getZEROUwyO8pc = Duration.m8750plusLRDsOJo(m8795getZEROUwyO8pc, toDuration(m5649c(substring), durationUnitByIsoChar));
                                    }
                                    durationUnit = durationUnitByIsoChar;
                                    length = i2;
                                    c2 = '0';
                                    c = '9';
                                    z4 = true;
                                    str2 = str;
                                } else {
                                    throw new IllegalArgumentException("Missing unit for value ".concat(substring));
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        } else {
                            if (z7 || (i4 = i4 + 1) == length) {
                                throw new IllegalArgumentException();
                            }
                            z7 = z4;
                        }
                    }
                } else if (!z) {
                    String str4 = "Unexpected order of duration components";
                    char c3 = '9';
                    if (ro2.regionMatches(str, i3, "Infinity", 0, Math.max(length - i3, 8), true)) {
                        m8795getZEROUwyO8pc = companion.m8793getINFINITEUwyO8pc();
                    } else {
                        boolean z8 = !z5;
                        if (z5 && str.charAt(i3) == '(' && StringsKt___StringsKt.last(str) == ')') {
                            i3++;
                            int i6 = length - 1;
                            if (i3 == i6) {
                                throw new IllegalArgumentException("No components");
                            }
                            i = i6;
                            j = m8795getZEROUwyO8pc;
                            z3 = false;
                            z2 = true;
                        } else {
                            z2 = z8;
                            j = m8795getZEROUwyO8pc;
                            i = length;
                            z3 = false;
                        }
                        DurationUnit durationUnit2 = null;
                        while (i3 < i) {
                            if (z3 && z2) {
                                while (i3 < str.length() && str.charAt(i3) == ' ') {
                                    i3++;
                                }
                            }
                            int i7 = i3;
                            while (i7 < str.length()) {
                                char charAt3 = str.charAt(i7);
                                if (!new CharRange('0', c3).contains(charAt3) && charAt3 != '.') {
                                    break;
                                }
                                i7++;
                            }
                            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                            String substring4 = str.substring(i3, i7);
                            Intrinsics.checkNotNullExpressionValue(substring4, str3);
                            if (substring4.length() != 0) {
                                int length3 = substring4.length() + i3;
                                int i8 = length3;
                                while (i8 < str.length()) {
                                    if (!new CharRange('a', 'z').contains(str.charAt(i8))) {
                                        break;
                                    }
                                    i8++;
                                }
                                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                                String substring5 = str.substring(length3, i8);
                                Intrinsics.checkNotNullExpressionValue(substring5, str3);
                                i3 = substring5.length() + length3;
                                DurationUnit durationUnitByShortName = g70.durationUnitByShortName(substring5);
                                if (durationUnit2 != null && durationUnit2.compareTo(durationUnitByShortName) <= 0) {
                                    throw new IllegalArgumentException(str4);
                                }
                                String str5 = str4;
                                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) substring4, '.', 0, false, 6, (Object) null);
                                if (indexOf$default2 > 0) {
                                    Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                                    String substring6 = substring4.substring(0, indexOf$default2);
                                    Intrinsics.checkNotNullExpressionValue(substring6, str3);
                                    String str6 = str3;
                                    long m8750plusLRDsOJo2 = Duration.m8750plusLRDsOJo(j, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                                    Intrinsics.checkNotNull(substring4, "null cannot be cast to non-null type java.lang.String");
                                    String substring7 = substring4.substring(indexOf$default2);
                                    Intrinsics.checkNotNullExpressionValue(substring7, "this as java.lang.String).substring(startIndex)");
                                    j = Duration.m8750plusLRDsOJo(m8750plusLRDsOJo2, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                                    if (i3 < i) {
                                        throw new IllegalArgumentException("Fractional component must be last");
                                    }
                                    str4 = str5;
                                    durationUnit2 = durationUnitByShortName;
                                    str3 = str6;
                                } else {
                                    j = Duration.m8750plusLRDsOJo(j, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                                    str4 = str5;
                                    durationUnit2 = durationUnitByShortName;
                                }
                                z3 = true;
                                c3 = '9';
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        m8795getZEROUwyO8pc = j;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                return z6 ? Duration.m8766unaryMinusUwyO8pc(m8795getZEROUwyO8pc) : m8795getZEROUwyO8pc;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    /* renamed from: b */
    public static final long m5648b(long j) {
        return Duration.m8719constructorimpl(j << 1);
    }

    /* renamed from: c */
    public static final long m5649c(String str) {
        int i;
        int length = str.length();
        if (length > 0 && StringsKt__StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) {
            i = 1;
        } else {
            i = 0;
        }
        if (length - i > 16) {
            Iterable intRange = new IntRange(i, StringsKt__StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (it.hasNext()) {
                    if (!new CharRange('0', '9').contains(str.charAt(((IntIterator) it).nextInt()))) {
                    }
                }
            }
            if (str.charAt(0) == '-') {
                return Long.MIN_VALUE;
            }
            return Long.MAX_VALUE;
        }
        if (ro2.startsWith$default(str, "+", false, 2, null)) {
            str = StringsKt___StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long getDays(int i) {
        return toDuration(i, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    public static final long getHours(int i) {
        return toDuration(i, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    public static final long getMicroseconds(int i) {
        return toDuration(i, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    public static final long getMilliseconds(int i) {
        return toDuration(i, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    public static final long getMinutes(int i) {
        return toDuration(i, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    public static final long getNanoseconds(int i) {
        return toDuration(i, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    public static final long getSeconds(int i) {
        return toDuration(i, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int i, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return m5648b(f70.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, unit);
    }

    public static final long getDays(long j) {
        return toDuration(j, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i) {
    }

    public static final long getHours(long j) {
        return toDuration(j, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i) {
    }

    public static final long getMicroseconds(long j) {
        return toDuration(j, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    public static final long getMilliseconds(long j) {
        return toDuration(j, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    public static final long getMinutes(long j) {
        return toDuration(j, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    public static final long getNanoseconds(long j) {
        return toDuration(j, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    public static final long getSeconds(long j) {
        return toDuration(j, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    public static final long getDays(double d) {
        return toDuration(d, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static final long getHours(double d) {
        return toDuration(d, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static final long getMicroseconds(double d) {
        return toDuration(d, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static final long getMilliseconds(double d) {
        return toDuration(d, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static final long getMinutes(double d) {
        return toDuration(d, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static final long getNanoseconds(double d) {
        return toDuration(d, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static final long getSeconds(double d) {
        return toDuration(d, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = f70.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if (new LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j)) {
            return m5648b(f70.convertDurationUnitOverflow(j, unit, durationUnit));
        }
        return Duration.m8719constructorimpl((r82.coerceIn(f70.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS) << 1) + 1);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double d, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = f70.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = rh1.roundToLong(convertDurationUnit);
            if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(roundToLong)) {
                return m5648b(roundToLong);
            }
            return m5647a(rh1.roundToLong(f70.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
