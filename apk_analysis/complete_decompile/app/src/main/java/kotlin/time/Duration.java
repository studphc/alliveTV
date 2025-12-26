package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1956wr;
import p000.f70;
import p000.g70;
import p000.r82;
import p000.rh1;
import p000.ye0;

@SinceKotlin(version = "1.6")
@Metadata(m5568d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b8\b\u0087@\u0018\u0000 \u008a\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u008a\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\u001e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0013H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0014J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0013H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010\u001bJ\r\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\u001bJ\u001b\u0010%\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u009d\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2u\u0010/\u001aq\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u00000'H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00101J\u0088\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2`\u0010/\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000003H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00104Js\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000005H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00106J^\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&26\u0010/\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000007H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00108J\u0015\u0010=\u001a\u00020\u00132\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u0015\u0010@\u001a\u00020\u00022\u0006\u0010:\u001a\u000209¢\u0006\u0004\b>\u0010?J\u0015\u0010C\u001a\u00020\u000e2\u0006\u0010:\u001a\u000209¢\u0006\u0004\bA\u0010BJ\u000f\u0010E\u001a\u00020\u0002H\u0007¢\u0006\u0004\bD\u0010\u0005J\u000f\u0010G\u001a\u00020\u0002H\u0007¢\u0006\u0004\bF\u0010\u0005J\u000f\u0010K\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020H2\u0006\u0010:\u001a\u0002092\b\b\u0002\u0010L\u001a\u00020\u000e¢\u0006\u0004\bI\u0010MJ\r\u0010O\u001a\u00020H¢\u0006\u0004\bN\u0010JJ\u0010\u0010R\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bP\u0010QJ\u001a\u0010V\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bT\u0010UR\u0017\u0010X\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u001a\u0010\\\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\bY\u0010QR\u001a\u0010_\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\b^\u0010[\u001a\u0004\b]\u0010QR\u001a\u0010b\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\ba\u0010[\u001a\u0004\b`\u0010QR\u001a\u0010e\u001a\u00020\u000e8@X\u0081\u0004¢\u0006\f\u0012\u0004\bd\u0010[\u001a\u0004\bc\u0010QR\u001a\u0010i\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bh\u0010[\u001a\u0004\bf\u0010gR\u001a\u0010l\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bk\u0010[\u001a\u0004\bj\u0010gR\u001a\u0010o\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bn\u0010[\u001a\u0004\bm\u0010gR\u001a\u0010r\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bq\u0010[\u001a\u0004\bp\u0010gR\u001a\u0010u\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bt\u0010[\u001a\u0004\bs\u0010gR\u001a\u0010x\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bw\u0010[\u001a\u0004\bv\u0010gR\u001a\u0010{\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\bz\u0010[\u001a\u0004\by\u0010gR\u0011\u0010}\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b|\u0010\u0005R\u0011\u0010\u007f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b~\u0010\u0005R\u0013\u0010\u0081\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0005R\u0013\u0010\u0083\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0005R\u0013\u0010\u0085\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0005R\u0013\u0010\u0087\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u0005R\u0013\u0010\u0089\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u008b\u0001"}, m5569d2 = {"Lkotlin/time/Duration;", "", "", "rawValue", "constructor-impl", "(J)J", "unaryMinus-UwyO8pc", "unaryMinus", "other", "plus-LRDsOJo", "(JJ)J", "plus", "minus-LRDsOJo", "minus", "", "scale", "times-UwyO8pc", "(JI)J", "times", "", "(JD)J", "div-UwyO8pc", "div", "div-LRDsOJo", "(JJ)D", "", "isNegative-impl", "(J)Z", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(JJ)I", "compareTo", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toDouble", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toInt", "toLongNanoseconds-impl", "toLongNanoseconds", "toLongMilliseconds-impl", "toLongMilliseconds", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString-impl", "toIsoString", "hashCode-impl", "(J)I", "hashCode", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInDays-impl", "(J)D", "getInDays$annotations", "inDays", "getInHours-impl", "getInHours$annotations", "inHours", "getInMinutes-impl", "getInMinutes$annotations", "inMinutes", "getInSeconds-impl", "getInSeconds$annotations", "inSeconds", "getInMilliseconds-impl", "getInMilliseconds$annotations", "inMilliseconds", "getInMicroseconds-impl", "getInMicroseconds$annotations", "inMicroseconds", "getInNanoseconds-impl", "getInNanoseconds$annotations", "inNanoseconds", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "getInWholeMicroseconds-impl", "inWholeMicroseconds", "getInWholeNanoseconds-impl", "inWholeNanoseconds", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1484:1\n38#1:1485\n38#1:1486\n38#1:1487\n38#1:1488\n38#1:1489\n672#1,2:1490\n689#1,2:1499\n163#2,6:1492\n1#3:1498\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1485\n40#1:1486\n458#1:1487\n478#1:1488\n651#1:1489\n968#1:1490,2\n1059#1:1499,2\n1010#1:1492,6\n*E\n"})
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b */
    public static final long f21370b = m8719constructorimpl(0);

    /* renamed from: c */
    public static final long f21371c = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);

    /* renamed from: d */
    public static final long f21372d = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* renamed from: a */
    public final long f21373a;

    @Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b$\b\u0086\u0003\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\fJ\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u001d\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0010J\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\fJ\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000fJ\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u001d\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u000fJ\u001d\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0010J\u001b\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u001fJ\u001d\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$R\u001d\u0010(\u001a\u00020\n8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010,\u001a\u00020\n8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R \u0010.\u001a\u00020\n8\u0000X\u0080\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+R%\u0010\r\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00102\u001a\u0004\b0\u0010\fR%\u0010\r\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00103\u001a\u0004\b0\u0010\u000fR%\u0010\r\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00104\u001a\u0004\b0\u0010\u0010R%\u0010\u0012\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00102\u001a\u0004\b5\u0010\fR%\u0010\u0012\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00103\u001a\u0004\b5\u0010\u000fR%\u0010\u0012\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00104\u001a\u0004\b5\u0010\u0010R%\u0010\u0014\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00102\u001a\u0004\b7\u0010\fR%\u0010\u0014\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00103\u001a\u0004\b7\u0010\u000fR%\u0010\u0014\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00104\u001a\u0004\b7\u0010\u0010R%\u0010\u0016\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00102\u001a\u0004\b9\u0010\fR%\u0010\u0016\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00103\u001a\u0004\b9\u0010\u000fR%\u0010\u0016\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00104\u001a\u0004\b9\u0010\u0010R%\u0010\u0018\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00102\u001a\u0004\b;\u0010\fR%\u0010\u0018\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00103\u001a\u0004\b;\u0010\u000fR%\u0010\u0018\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00104\u001a\u0004\b;\u0010\u0010R%\u0010\u001a\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00102\u001a\u0004\b=\u0010\fR%\u0010\u001a\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00103\u001a\u0004\b=\u0010\u000fR%\u0010\u001a\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00104\u001a\u0004\b=\u0010\u0010R%\u0010\u001c\u001a\u00020\n*\u00020\t8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00102\u001a\u0004\b?\u0010\fR%\u0010\u001c\u001a\u00020\n*\u00020\u000e8Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00103\u001a\u0004\b?\u0010\u000fR%\u0010\u001c\u001a\u00020\n*\u00020\u00028Æ\u0002X\u0087\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00104\u001a\u0004\b?\u0010\u0010\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006A"}, m5569d2 = {"Lkotlin/time/Duration$Companion;", "", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "Lkotlin/time/Duration;", "nanoseconds-UwyO8pc", "(I)J", "nanoseconds", "", "(J)J", "(D)J", "microseconds-UwyO8pc", "microseconds", "milliseconds-UwyO8pc", "milliseconds", "seconds-UwyO8pc", "seconds", "minutes-UwyO8pc", "minutes", "hours-UwyO8pc", "hours", "days-UwyO8pc", "days", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parse", "parseIsoString-UwyO8pc", "parseIsoString", "parseOrNull-FghU774", "(Ljava/lang/String;)Lkotlin/time/Duration;", "parseOrNull", "parseIsoStringOrNull-FghU774", "parseIsoStringOrNull", "ZERO", "J", "getZERO-UwyO8pc", "()J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "getNanoseconds-UwyO8pc", "getNanoseconds-UwyO8pc$annotations", "(I)V", "(J)V", "(D)V", "getMicroseconds-UwyO8pc", "getMicroseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "getMilliseconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "getSeconds-UwyO8pc$annotations", "getMinutes-UwyO8pc", "getMinutes-UwyO8pc$annotations", "getHours-UwyO8pc", "getHours-UwyO8pc$annotations", "getDays-UwyO8pc", "getDays-UwyO8pc$annotations", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8769getDaysUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8772getHoursUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8775getMicrosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8778getMillisecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8781getMinutesUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8784getNanosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8787getSecondsUwyO8pc$annotations(double d) {
        }

        @ExperimentalTime
        public final double convert(double value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return f70.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m8791daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m8793getINFINITEUwyO8pc() {
            return Duration.f21371c;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m8794getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.f21372d;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m8795getZEROUwyO8pc() {
            return Duration.f21370b;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m8797hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m8800microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m8803millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m8806minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m8809nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m8811parseUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ye0.m8296p("Invalid duration string format: '", value, "'."), e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m8812parseIsoStringUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ye0.m8296p("Invalid ISO duration string format: '", value, "'."), e);
            }
        }

        @Nullable
        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m8813parseIsoStringOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m8717boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m8814parseOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m8717boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m8816secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8770getDaysUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8773getHoursUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8776getMicrosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8779getMillisecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8782getMinutesUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8785getNanosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8788getSecondsUwyO8pc$annotations(int i) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m8792daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m8798hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m8801microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m8804millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m8807minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m8810nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m8817secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8771getDaysUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8774getHoursUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8777getMicrosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8780getMillisecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8783getMinutesUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8786getNanosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m8789getSecondsUwyO8pc$annotations(long j) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m8790daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m8796hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m8799microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m8802millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m8805minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m8808nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m8815secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }
    }

    public /* synthetic */ Duration(long j) {
        this.f21373a = j;
    }

    /* renamed from: a */
    public static final long m5642a(long j, long j2) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j2);
        long j3 = j + access$nanosToMillis;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j3)) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j3) + (j2 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(r82.coerceIn(j3, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    /* renamed from: b */
    public static final void m5643b(StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m8717boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: c */
    public static final DurationUnit m5644c(long j) {
        if (m5645d(j)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m8719constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m5645d(j)) {
                long j2 = j >> 1;
                if (!new LongRange(-4611686018426999999L, DurationKt.MAX_NANOS).contains(j2)) {
                    throw new AssertionError(j2 + " ns is out of nanoseconds range");
                }
            } else {
                long j3 = j >> 1;
                if (new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS).contains(j3)) {
                    if (new LongRange(-4611686018426L, 4611686018426L).contains(j3)) {
                        throw new AssertionError(j3 + " ms is denormalized");
                    }
                } else {
                    throw new AssertionError(j3 + " ms is out of milliseconds range");
                }
            }
        }
        return j;
    }

    /* renamed from: d */
    public static final boolean m5645d(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m8720divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) AbstractC1956wr.maxOf(m5644c(j), m5644c(j2));
        return m8757toDoubleimpl(j, durationUnit) / m8757toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m8722divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m8748isPositiveimpl(j)) {
                return f21371c;
            }
            if (m8747isNegativeimpl(j)) {
                return f21372d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m5645d(j)) {
            return DurationKt.access$durationOfNanos((j >> 1) / i);
        }
        if (m8746isInfiniteimpl(j)) {
            return m8752timesUwyO8pc(j, rh1.getSign(i));
        }
        long j2 = j >> 1;
        long j3 = i;
        long j4 = j2 / j3;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j4)) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j4) + (DurationKt.access$millisToNanos(j2 - (j4 * j3)) / j3));
        }
        return DurationKt.access$durationOfMillis(j4);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8723equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getF21373a();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8724equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m8725getAbsoluteValueUwyO8pc(long j) {
        if (m8747isNegativeimpl(j)) {
            return m8766unaryMinusUwyO8pc(j);
        }
        return j;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m8726getHoursComponentimpl(long j) {
        if (m8746isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m8735getInWholeHoursimpl(j) % 24);
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* renamed from: getInDays-impl, reason: not valid java name */
    public static final double m8727getInDaysimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* renamed from: getInHours-impl, reason: not valid java name */
    public static final double m8728getInHoursimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final double m8729getInMicrosecondsimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final double m8730getInMillisecondsimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* renamed from: getInMinutes-impl, reason: not valid java name */
    public static final double m8731getInMinutesimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final double m8732getInNanosecondsimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* renamed from: getInSeconds-impl, reason: not valid java name */
    public static final double m8733getInSecondsimpl(long j) {
        return m8757toDoubleimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m8734getInWholeDaysimpl(long j) {
        return m8760toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m8735getInWholeHoursimpl(long j) {
        return m8760toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m8736getInWholeMicrosecondsimpl(long j) {
        return m8760toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m8737getInWholeMillisecondsimpl(long j) {
        if ((((int) j) & 1) == 1 && m8745isFiniteimpl(j)) {
            return j >> 1;
        }
        return m8760toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m8738getInWholeMinutesimpl(long j) {
        return m8760toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m8739getInWholeNanosecondsimpl(long j) {
        long j2 = j >> 1;
        if (!m5645d(j)) {
            if (j2 > 9223372036854L) {
                return Long.MAX_VALUE;
            }
            if (j2 < -9223372036854L) {
                return Long.MIN_VALUE;
            }
            return DurationKt.access$millisToNanos(j2);
        }
        return j2;
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m8740getInWholeSecondsimpl(long j) {
        return m8760toLongimpl(j, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m8741getMinutesComponentimpl(long j) {
        if (m8746isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m8738getInWholeMinutesimpl(j) % 60);
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m8742getNanosecondsComponentimpl(long j) {
        long j2;
        boolean z = false;
        if (m8746isInfiniteimpl(j)) {
            return 0;
        }
        if ((((int) j) & 1) == 1) {
            z = true;
        }
        if (z) {
            j2 = DurationKt.access$millisToNanos((j >> 1) % 1000);
        } else {
            j2 = (j >> 1) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
        }
        return (int) j2;
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m8743getSecondsComponentimpl(long j) {
        if (m8746isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m8740getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8744hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m8745isFiniteimpl(long j) {
        return !m8746isInfiniteimpl(j);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m8746isInfiniteimpl(long j) {
        if (j != f21371c && j != f21372d) {
            return false;
        }
        return true;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m8747isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m8748isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m8749minusLRDsOJo(long j, long j2) {
        return m8750plusLRDsOJo(j, m8766unaryMinusUwyO8pc(j2));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m8750plusLRDsOJo(long j, long j2) {
        if (m8746isInfiniteimpl(j)) {
            if (!m8745isFiniteimpl(j2) && (j2 ^ j) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j;
        }
        if (m8746isInfiniteimpl(j2)) {
            return j2;
        }
        int i = ((int) j) & 1;
        if (i == (((int) j2) & 1)) {
            long j3 = (j >> 1) + (j2 >> 1);
            if (m5645d(j)) {
                return DurationKt.access$durationOfNanosNormalized(j3);
            }
            return DurationKt.access$durationOfMillisNormalized(j3);
        }
        if (i == 1) {
            return m5642a(j >> 1, j2 >> 1);
        }
        return m5642a(j2 >> 1, j >> 1);
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m8752timesUwyO8pc(long j, int i) {
        if (m8746isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m8766unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return f21370b;
        }
        long j2 = j >> 1;
        long j3 = i;
        long j4 = j2 * j3;
        boolean m5645d = m5645d(j);
        long j5 = f21372d;
        long j6 = f21371c;
        if (m5645d) {
            if (new LongRange(-2147483647L, 2147483647L).contains(j2)) {
                return DurationKt.access$durationOfNanos(j4);
            }
            if (j4 / j3 == j2) {
                return DurationKt.access$durationOfNanosNormalized(j4);
            }
            long access$nanosToMillis = DurationKt.access$nanosToMillis(j2);
            long j7 = access$nanosToMillis * j3;
            long access$nanosToMillis2 = DurationKt.access$nanosToMillis((j2 - DurationKt.access$millisToNanos(access$nanosToMillis)) * j3) + j7;
            if (j7 / j3 == access$nanosToMillis && (access$nanosToMillis2 ^ j7) >= 0) {
                return DurationKt.access$durationOfMillis(r82.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            if (rh1.getSign(i) * rh1.getSign(j2) <= 0) {
                return j5;
            }
        } else {
            if (j4 / j3 == j2) {
                return DurationKt.access$durationOfMillis(r82.coerceIn(j4, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            if (rh1.getSign(i) * rh1.getSign(j2) <= 0) {
                return j5;
            }
        }
        return j6;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m8756toComponentsimpl(long j, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m8734getInWholeDaysimpl(j)), Integer.valueOf(m8726getHoursComponentimpl(j)), Integer.valueOf(m8741getMinutesComponentimpl(j)), Integer.valueOf(m8743getSecondsComponentimpl(j)), Integer.valueOf(m8742getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m8757toDoubleimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == f21371c) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == f21372d) {
            return Double.NEGATIVE_INFINITY;
        }
        return f70.convertDurationUnit(j >> 1, m5644c(j), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m8758toIntimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) r82.coerceIn(m8760toLongimpl(j, unit), -2147483648L, 2147483647L);
    }

    @NotNull
    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m8759toIsoStringimpl(long j) {
        boolean z;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        if (m8747isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m8725getAbsoluteValueUwyO8pc = m8725getAbsoluteValueUwyO8pc(j);
        long m8735getInWholeHoursimpl = m8735getInWholeHoursimpl(m8725getAbsoluteValueUwyO8pc);
        int m8741getMinutesComponentimpl = m8741getMinutesComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int m8743getSecondsComponentimpl = m8743getSecondsComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int m8742getNanosecondsComponentimpl = m8742getNanosecondsComponentimpl(m8725getAbsoluteValueUwyO8pc);
        if (m8746isInfiniteimpl(j)) {
            m8735getInWholeHoursimpl = 9999999999999L;
        }
        boolean z3 = false;
        if (m8735getInWholeHoursimpl != 0) {
            z = true;
        } else {
            z = false;
        }
        if (m8743getSecondsComponentimpl == 0 && m8742getNanosecondsComponentimpl == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (m8741getMinutesComponentimpl != 0 || (z2 && z)) {
            z3 = true;
        }
        if (z) {
            sb.append(m8735getInWholeHoursimpl);
            sb.append('H');
        }
        if (z3) {
            sb.append(m8741getMinutesComponentimpl);
            sb.append('M');
        }
        if (z2 || (!z && !z3)) {
            m5643b(sb, m8743getSecondsComponentimpl, m8742getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m8760toLongimpl(long j, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == f21371c) {
            return Long.MAX_VALUE;
        }
        if (j == f21372d) {
            return Long.MIN_VALUE;
        }
        return f70.convertDurationUnit(j >> 1, m5644c(j), unit);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    /* renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final long m8761toLongMillisecondsimpl(long j) {
        return m8737getInWholeMillisecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.8", warningSince = "1.5")
    @ExperimentalTime
    /* renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final long m8762toLongNanosecondsimpl(long j) {
        return m8739getInWholeNanosecondsimpl(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8763toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == f21371c) {
            return "Infinity";
        }
        if (j == f21372d) {
            return "-Infinity";
        }
        boolean m8747isNegativeimpl = m8747isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m8747isNegativeimpl) {
            sb.append('-');
        }
        long m8725getAbsoluteValueUwyO8pc = m8725getAbsoluteValueUwyO8pc(j);
        long m8734getInWholeDaysimpl = m8734getInWholeDaysimpl(m8725getAbsoluteValueUwyO8pc);
        int m8726getHoursComponentimpl = m8726getHoursComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int m8741getMinutesComponentimpl = m8741getMinutesComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int m8743getSecondsComponentimpl = m8743getSecondsComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int m8742getNanosecondsComponentimpl = m8742getNanosecondsComponentimpl(m8725getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m8734getInWholeDaysimpl != 0;
        boolean z2 = m8726getHoursComponentimpl != 0;
        boolean z3 = m8741getMinutesComponentimpl != 0;
        boolean z4 = (m8743getSecondsComponentimpl == 0 && m8742getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m8734getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m8726getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(m8741getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (m8743getSecondsComponentimpl != 0 || z || z2 || z3) {
                m5643b(sb, m8743getSecondsComponentimpl, m8742getNanosecondsComponentimpl, 9, "s", false);
            } else if (m8742getNanosecondsComponentimpl >= 1000000) {
                m5643b(sb, m8742getNanosecondsComponentimpl / 1000000, m8742getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m8742getNanosecondsComponentimpl >= 1000) {
                m5643b(sb, m8742getNanosecondsComponentimpl / 1000, m8742getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m8742getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (m8747isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m8765toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m8764toStringimpl(j, durationUnit, i);
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m8766unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-(j >> 1), ((int) j) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m8767compareToLRDsOJo(duration.getF21373a());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m8767compareToLRDsOJo(long j) {
        return m8718compareToLRDsOJo(this.f21373a, j);
    }

    public boolean equals(Object obj) {
        return m8723equalsimpl(this.f21373a, obj);
    }

    public int hashCode() {
        return m8744hashCodeimpl(this.f21373a);
    }

    @NotNull
    public String toString() {
        return m8763toStringimpl(this.f21373a);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getF21373a() {
        return this.f21373a;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m8718compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m8747isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m8755toComponentsimpl(long j, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m8735getInWholeHoursimpl(j)), Integer.valueOf(m8741getMinutesComponentimpl(j)), Integer.valueOf(m8743getSecondsComponentimpl(j)), Integer.valueOf(m8742getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m8754toComponentsimpl(long j, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m8738getInWholeMinutesimpl(j)), Integer.valueOf(m8743getSecondsComponentimpl(j)), Integer.valueOf(m8742getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m8753toComponentsimpl(long j, @NotNull Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m8740getInWholeSecondsimpl(j)), Integer.valueOf(m8742getNanosecondsComponentimpl(j)));
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m8721divUwyO8pc(long j, double d) {
        int roundToInt = rh1.roundToInt(d);
        if (roundToInt == d && roundToInt != 0) {
            return m8722divUwyO8pc(j, roundToInt);
        }
        DurationUnit m5644c = m5644c(j);
        return DurationKt.toDuration(m8757toDoubleimpl(j, m5644c) / d, m5644c);
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m8751timesUwyO8pc(long j, double d) {
        int roundToInt = rh1.roundToInt(d);
        if (roundToInt == d) {
            return m8752timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m5644c = m5644c(j);
        return DurationKt.toDuration(m8757toDoubleimpl(j, m5644c) * d, m5644c);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m8764toStringimpl(long j, @NotNull DurationUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i >= 0) {
            double m8757toDoubleimpl = m8757toDoubleimpl(j, unit);
            if (Double.isInfinite(m8757toDoubleimpl)) {
                return String.valueOf(m8757toDoubleimpl);
            }
            return DurationJvmKt.formatToExactDecimals(m8757toDoubleimpl, r82.coerceAtMost(i, 12)) + g70.shortName(unit);
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "decimals must be not negative, but was ").toString());
    }
}
