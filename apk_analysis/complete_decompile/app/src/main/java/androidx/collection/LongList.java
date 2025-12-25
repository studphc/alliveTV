package androidx.collection;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.r82;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004JA\u0010\u0005\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0005\u0010\fJA\u0010\r\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u0014\u001a\u00020\u00132!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0014\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0017\u001a\u00020\u00072!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0017\u0010\u0019Jd\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u000026\u0010\u001e\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001f\u0010 Jy\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u00002K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00000!H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b#\u0010$Jd\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u000026\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b%\u0010 Jy\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u00002K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00028\u00000!H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b&\u0010$JA\u0010)\u001a\u00020'2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020'0\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b)\u0010*JV\u0010+\u001a\u00020'26\u0010(\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020'0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b+\u0010,JA\u0010-\u001a\u00020'2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020'0\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b-\u0010*JV\u0010.\u001a\u00020'26\u0010(\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020'0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b.\u0010,J\u001a\u0010/\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\u0013¢\u0006\u0004\b1\u00100J@\u00103\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\u00132!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b5\u00106JA\u00107\u001a\u00020\u00132!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b7\u0010\u0016JA\u00108\u001a\u00020\u00132!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b8\u0010\u0016J\r\u00109\u001a\u00020\u0002¢\u0006\u0004\b9\u0010\u0004J\r\u0010:\u001a\u00020\u0002¢\u0006\u0004\b:\u0010\u0004J\r\u0010;\u001a\u00020\u0007¢\u0006\u0004\b;\u0010\u0018JA\u0010;\u001a\u00020\u00072!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b;\u0010\u0019J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b<\u00106JA\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00132\b\b\u0002\u0010B\u001a\u00020=H\u0007¢\u0006\u0004\bD\u0010EJ[\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00132\b\b\u0002\u0010B\u001a\u00020=2\u0014\b\u0004\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020=0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\bD\u0010GJ\u000f\u0010H\u001a\u00020\u0013H\u0016¢\u0006\u0004\bH\u0010\u0015J\u001a\u0010J\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020CH\u0016¢\u0006\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bO\u0010P\u0012\u0004\bQ\u0010RR\u001c\u0010S\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bS\u0010T\u0012\u0004\bU\u0010RR\u0011\u0010W\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u0012\u0010Y\u001a\u00020\u00138Ç\u0002¢\u0006\u0006\u001a\u0004\bX\u0010\u0015R\u0012\u0010]\u001a\u00020Z8Æ\u0002¢\u0006\u0006\u001a\u0004\b[\u0010\\\u0082\u0001\u0001^\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, m5569d2 = {"Landroidx/collection/LongList;", "", "", SchedulerSupport.NONE, "()Z", "any", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "element", "predicate", "(Lkotlin/jvm/functions/Function1;)Z", "reversedAny", "contains", "(J)Z", "elements", "containsAll", "(Landroidx/collection/LongList;)Z", "", "count", "()I", "(Lkotlin/jvm/functions/Function1;)I", "first", "()J", "(Lkotlin/jvm/functions/Function1;)J", "R", "initial", "Lkotlin/Function2;", "acc", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/Function3;", FirebaseAnalytics.Param.INDEX, "foldIndexed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "", "block", "forEach", "(Lkotlin/jvm/functions/Function1;)V", "forEachIndexed", "(Lkotlin/jvm/functions/Function2;)V", "forEachReversed", "forEachReversedIndexed", "get", "(I)J", "elementAt", "defaultValue", "elementAtOrElse", "(ILkotlin/jvm/functions/Function1;)J", "indexOf", "(J)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", FirebaseAnalytics.Param.CONTENT, "[J", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "getSize", "size", "getLastIndex", "lastIndex", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "indices", "Landroidx/collection/MutableLongList;", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLongList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongList.kt\nandroidx/collection/LongList\n*L\n1#1,969:1\n253#1,6:970\n279#1,6:976\n253#1,6:982\n75#1:988\n253#1,6:989\n253#1,6:995\n253#1,6:1001\n266#1,6:1007\n279#1,6:1013\n293#1,6:1019\n70#1:1025\n70#1:1026\n266#1,6:1027\n266#1,6:1033\n293#1,6:1039\n70#1:1045\n279#1,6:1046\n293#1,6:1052\n266#1,6:1058\n266#1,6:1064\n253#1,6:1070\n75#1:1076\n467#1,10:1077\n266#1,4:1087\n477#1,9:1091\n271#1:1100\n486#1,2:1101\n467#1,10:1103\n266#1,4:1113\n477#1,9:1117\n271#1:1126\n486#1,2:1127\n467#1,10:1129\n266#1,4:1139\n477#1,9:1143\n271#1:1152\n486#1,2:1153\n467#1,10:1155\n266#1,4:1165\n477#1,9:1169\n271#1:1178\n486#1,2:1179\n467#1,10:1181\n266#1,4:1191\n477#1,9:1195\n271#1:1204\n486#1,2:1205\n*S KotlinDebug\n*F\n+ 1 LongList.kt\nandroidx/collection/LongList\n*L\n96#1:970,6\n110#1:976,6\n122#1:982,6\n135#1:988\n153#1:989,6\n175#1:995,6\n192#1:1001,6\n208#1:1007,6\n225#1:1013,6\n241#1:1019,6\n306#1:1025\n317#1:1026\n343#1:1027,6\n357#1:1033,6\n371#1:1039,6\n397#1:1045\n407#1:1046,6\n420#1:1052,6\n445#1:1058,6\n476#1:1064,6\n494#1:1070,6\n510#1:1076\n-1#1:1077,10\n-1#1:1087,4\n-1#1:1091,9\n-1#1:1100\n-1#1:1101,2\n-1#1:1103,10\n-1#1:1113,4\n-1#1:1117,9\n-1#1:1126\n-1#1:1127,2\n-1#1:1129,10\n-1#1:1139,4\n-1#1:1143,9\n-1#1:1152\n-1#1:1153,2\n-1#1:1155,10\n-1#1:1165,4\n-1#1:1169,9\n-1#1:1178\n-1#1:1179,2\n-1#1:1181,10\n-1#1:1191,4\n-1#1:1195,9\n-1#1:1204\n-1#1:1205,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class LongList {

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public long[] content;

    public LongList(int i, DefaultConstructorMarker defaultConstructorMarker) {
        long[] jArr;
        if (i == 0) {
            jArr = LongSetKt.getEmptyLongArray();
        } else {
            jArr = new long[i];
        }
        this.content = jArr;
    }

    @PublishedApi
    public static /* synthetic */ void getContent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        return longList.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(long element) {
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (jArr[i2] == element) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(@NotNull LongList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        IntRange until = r82.until(0, elements._size);
        int first = until.getFirst();
        int last = until.getLast();
        if (first <= last) {
            while (contains(elements.get(first))) {
                if (first != last) {
                    first++;
                } else {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final long elementAt(@androidx.annotation.IntRange(from = 0) int index) {
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size - 1);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final long elementAtOrElse(@androidx.annotation.IntRange(from = 0) int index, @NotNull Function1<? super Integer, Long> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        return defaultValue.invoke(Integer.valueOf(index)).longValue();
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof LongList) {
            LongList longList = (LongList) other;
            int i = longList._size;
            int i2 = this._size;
            if (i == i2) {
                long[] jArr = this.content;
                long[] jArr2 = longList.content;
                IntRange until = r82.until(0, i2);
                int first = until.getFirst();
                int last = until.getLast();
                if (first <= last) {
                    while (jArr[first] == jArr2[first]) {
                        if (first != last) {
                            first++;
                        } else {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final long first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public final <R> R fold(R initial, @NotNull Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            initial = operation.invoke(initial, Long.valueOf(jArr[i2]));
        }
        return initial;
    }

    public final <R> R foldIndexed(R initial, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            R r = initial;
            initial = operation.invoke(Integer.valueOf(i2), r, Long.valueOf(jArr[i2]));
        }
        return initial;
    }

    public final <R> R foldRight(R initial, @NotNull Function2<? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = operation.invoke(Long.valueOf(jArr[i]), initial);
        }
    }

    public final <R> R foldRightIndexed(R initial, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return initial;
            }
            initial = operation.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), initial);
        }
    }

    public final void forEach(@NotNull Function1<? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(Long.valueOf(jArr[i2]));
        }
    }

    public final void forEachIndexed(@NotNull Function2<? super Integer, ? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]));
        }
    }

    public final void forEachReversed(@NotNull Function1<? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(Long.valueOf(jArr[i]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(@NotNull Function2<? super Integer, ? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]));
            } else {
                return;
            }
        }
    }

    public final long get(@androidx.annotation.IntRange(from = 0) int index) {
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size - 1);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    @NotNull
    public final IntRange getIndices() {
        return r82.until(0, this._size);
    }

    @androidx.annotation.IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @androidx.annotation.IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j = jArr[i3];
            i2 += ((int) (j ^ (j >>> 32))) * 31;
        }
        return i2;
    }

    public final int indexOf(long element) {
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (element == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfFirst(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!predicate.invoke(Long.valueOf(jArr[i])).booleanValue());
        return i;
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final long last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public final int lastIndexOf(long element) {
        long[] jArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (jArr[i] != element);
        return i;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (predicate.invoke(Long.valueOf(jArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public final boolean any(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (predicate.invoke(Long.valueOf(jArr[i3])).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final long first(@NotNull Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence charSequence, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                separator = ", ";
            }
            if ((i2 & 2) != 0) {
                prefix = "";
            }
            if ((i2 & 4) != 0) {
                postfix = "";
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            if ((i2 & 16) != 0) {
                charSequence = "...";
            }
            Intrinsics.checkNotNullParameter(separator, "separator");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(postfix, "postfix");
            StringBuilder m8301u = ye0.m8301u(charSequence, "truncated", function1, "transform", prefix);
            long[] jArr = longList.content;
            int i3 = longList._size;
            int i4 = 0;
            while (true) {
                if (i4 < i3) {
                    long j = jArr[i4];
                    if (i4 == i) {
                        m8301u.append(charSequence);
                        break;
                    }
                    if (i4 != 0) {
                        m8301u.append(separator);
                    }
                    m8301u.append((CharSequence) function1.invoke(Long.valueOf(j)));
                    i4++;
                } else {
                    m8301u.append(postfix);
                    break;
                }
            }
            String sb = m8301u.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
            return sb;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final long last(@NotNull Function1<? super Long, Boolean> predicate) {
        long j;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 < i) {
                j = jArr[i];
            } else {
                throw new NoSuchElementException("LongList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(Long.valueOf(j)).booleanValue());
        return j;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder m8300t = ye0.m8300t(postfix, "postfix", truncated, "truncated", prefix);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == limit) {
                    m8300t.append(truncated);
                    break;
                }
                if (i2 != 0) {
                    m8300t.append(separator);
                }
                m8300t.append(j);
                i2++;
            } else {
                m8300t.append(postfix);
                break;
            }
        }
        String sb = m8300t.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @NotNull Function1<? super Long, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        StringBuilder m8301u = ye0.m8301u(truncated, "truncated", transform, "transform", prefix);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == limit) {
                    m8301u.append(truncated);
                    break;
                }
                if (i2 != 0) {
                    m8301u.append(separator);
                }
                m8301u.append(transform.invoke(Long.valueOf(j)));
                i2++;
            } else {
                m8301u.append(postfix);
                break;
            }
        }
        String sb = m8301u.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, int i, @NotNull Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder m8301u = ye0.m8301u(charSequence, "postfix", function1, "transform", prefix);
        long[] jArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                long j = jArr[i3];
                if (i3 == i) {
                    m8301u.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    m8301u.append(separator);
                }
                m8301u.append(function1.invoke(Long.valueOf(j)));
                i3++;
            } else {
                m8301u.append(charSequence);
                break;
            }
        }
        String sb = m8301u.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence charSequence, @NotNull Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder m8301u = ye0.m8301u(charSequence, "postfix", function1, "transform", prefix);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == -1) {
                    m8301u.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    m8301u.append(separator);
                }
                m8301u.append(function1.invoke(Long.valueOf(j)));
                i2++;
            } else {
                m8301u.append(charSequence);
                break;
            }
        }
        String sb = m8301u.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence charSequence, @NotNull Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        StringBuilder m8301u = ye0.m8301u(charSequence, "prefix", function1, "transform", charSequence);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == -1) {
                    m8301u.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    m8301u.append(separator);
                }
                m8301u.append(function1.invoke(Long.valueOf(j)));
                i2++;
            } else {
                m8301u.append((CharSequence) "");
                break;
            }
        }
        String sb = m8301u.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function1<? super Long, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Long.valueOf(j)));
                i2++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull Function1<? super Long, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                long j = jArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append(transform.invoke(Long.valueOf(j)));
                i2++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
