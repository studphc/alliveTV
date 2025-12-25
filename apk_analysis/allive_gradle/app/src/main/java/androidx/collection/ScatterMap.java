package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001UJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\u001a\u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJK\u0010\u001e\u001a\u00020\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00180\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ6\u0010 \u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00180\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010\u001bJ6\u0010!\u001a\u00020\u00182!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00180\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u001bJ-\u0010#\u001a\u00020\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$J-\u0010\u0005\u001a\u00020\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010$J\r\u0010%\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&J-\u0010%\u001a\u00020\u00142\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010'J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b*\u0010)J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0004\b+\u0010)J}\u00104\u001a\u0002032\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020\u00142\b\b\u0002\u00101\u001a\u00020,2:\b\u0002\u00102\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020,\u0018\u00010\u001cH\u0007¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0014H\u0016¢\u0006\u0004\b6\u0010&J\u001a\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b8\u0010)J\u000f\u00109\u001a\u000203H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u000203H\u0000¢\u0006\u0004\b;\u0010:J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\n\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b=\u0010>J\u0019\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010@¢\u0006\u0004\bA\u0010BR\u001c\u0010D\u001a\u00020C8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010GR$\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030H8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bI\u0010J\u0012\u0004\bK\u0010GR$\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030H8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bL\u0010J\u0012\u0004\bM\u0010GR\u0016\u0010N\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bP\u0010OR\u0011\u0010R\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bQ\u0010&R\u0011\u0010T\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bS\u0010&\u0082\u0001\u0001V\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006W"}, m5569d2 = {"Landroidx/collection/ScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "any", "()Z", SchedulerSupport.NONE, "isEmpty", "isNotEmpty", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, FirebaseAnalytics.Param.INDEX, "", "block", "forEachIndexed", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "value", "forEach", "(Lkotlin/jvm/functions/Function2;)V", "forEachKey", "forEachValue", "predicate", "all", "(Lkotlin/jvm/functions/Function2;)Z", "count", "()I", "(Lkotlin/jvm/functions/Function2;)I", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "", "separator", "prefix", "postfix", "limit", "truncated", "transform", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/String;", "hashCode", "other", "equals", "toString", "()Ljava/lang/String;", "asDebugString$collection", "asDebugString", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "findKeyIndex", "", "asMap", "()Ljava/util/Map;", "", "metadata", "[J", "getMetadata$annotations", "()V", "", "keys", "[Ljava/lang/Object;", "getKeys$annotations", "values", "getValues$annotations", "_capacity", "I", "_size", "getCapacity", "capacity", "getSize", "size", "MapWrapper", "Landroidx/collection/MutableScatterMap;", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n633#1:1851\n634#1:1855\n636#1,2:1857\n638#1,4:1860\n642#1:1867\n643#1:1871\n644#1:1873\n645#1,4:1876\n651#1:1881\n652#1,8:1883\n633#1:1891\n634#1:1895\n636#1,2:1897\n638#1,4:1900\n642#1:1907\n643#1:1911\n644#1:1913\n645#1,4:1916\n651#1:1921\n652#1,8:1923\n363#1,6:1933\n373#1,3:1940\n376#1,9:1944\n363#1,6:1953\n373#1,3:1960\n376#1,9:1964\n363#1,6:1973\n373#1,3:1980\n376#1,9:1984\n391#1,4:1993\n363#1,6:1997\n373#1,3:2004\n376#1,2:2008\n396#1,2:2010\n379#1,6:2012\n398#1:2018\n391#1,4:2019\n363#1,6:2023\n373#1,3:2030\n376#1,2:2034\n396#1,2:2036\n379#1,6:2038\n398#1:2044\n391#1,4:2045\n363#1,6:2049\n373#1,3:2056\n376#1,2:2060\n396#1,2:2062\n379#1,6:2064\n398#1:2070\n633#1:2071\n634#1:2075\n636#1,2:2077\n638#1,4:2080\n642#1:2087\n643#1:2091\n644#1:2093\n645#1,4:2096\n651#1:2101\n652#1,8:2103\n633#1:2111\n634#1:2115\n636#1,2:2117\n638#1,4:2120\n642#1:2127\n643#1:2131\n644#1:2133\n645#1,4:2136\n651#1:2141\n652#1,8:2143\n418#1,3:2151\n363#1,6:2154\n373#1,3:2161\n376#1,2:2165\n422#1,2:2167\n379#1,6:2169\n424#1:2175\n391#1,4:2176\n363#1,6:2180\n373#1,3:2187\n376#1,2:2191\n396#1,2:2193\n379#1,6:2195\n398#1:2201\n391#1,4:2202\n363#1,6:2206\n373#1,3:2213\n376#1,2:2217\n396#1,2:2219\n379#1,6:2221\n398#1:2227\n391#1,4:2228\n363#1,6:2232\n373#1,3:2239\n376#1,2:2243\n396#1,2:2245\n379#1,6:2247\n398#1:2253\n391#1,4:2254\n363#1,6:2258\n373#1,3:2265\n376#1,2:2269\n396#1,2:2271\n379#1,6:2273\n398#1:2279\n1605#2,3:1852\n1619#2:1856\n1615#2:1859\n1795#2,3:1864\n1809#2,3:1868\n1733#2:1872\n1721#2:1874\n1715#2:1875\n1728#2:1880\n1818#2:1882\n1605#2,3:1892\n1619#2:1896\n1615#2:1899\n1795#2,3:1904\n1809#2,3:1908\n1733#2:1912\n1721#2:1914\n1715#2:1915\n1728#2:1920\n1818#2:1922\n1826#2:1931\n1688#2:1932\n1826#2:1939\n1688#2:1943\n1826#2:1959\n1688#2:1963\n1826#2:1979\n1688#2:1983\n1826#2:2003\n1688#2:2007\n1826#2:2029\n1688#2:2033\n1826#2:2055\n1688#2:2059\n1605#2,3:2072\n1619#2:2076\n1615#2:2079\n1795#2,3:2084\n1809#2,3:2088\n1733#2:2092\n1721#2:2094\n1715#2:2095\n1728#2:2100\n1818#2:2102\n1605#2,3:2112\n1619#2:2116\n1615#2:2119\n1795#2,3:2124\n1809#2,3:2128\n1733#2:2132\n1721#2:2134\n1715#2:2135\n1728#2:2140\n1818#2:2142\n1826#2:2160\n1688#2:2164\n1826#2:2186\n1688#2:2190\n1826#2:2212\n1688#2:2216\n1826#2:2238\n1688#2:2242\n1826#2:2264\n1688#2:2268\n1661#2:2280\n1605#2,3:2281\n1619#2:2284\n1615#2:2285\n1795#2,3:2286\n1809#2,3:2289\n1733#2:2292\n1721#2:2293\n1715#2:2294\n1728#2:2295\n1818#2:2296\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap\n*L\n330#1:1851\n330#1:1855\n330#1:1857,2\n330#1:1860,4\n330#1:1867\n330#1:1871\n330#1:1873\n330#1:1876,4\n330#1:1881\n330#1:1883,8\n340#1:1891\n340#1:1895\n340#1:1897,2\n340#1:1900,4\n340#1:1907\n340#1:1911\n340#1:1913\n340#1:1916,4\n340#1:1921\n340#1:1923,8\n394#1:1933,6\n394#1:1940,3\n394#1:1944,9\n407#1:1953,6\n407#1:1960,3\n407#1:1964,9\n420#1:1973,6\n420#1:1980,3\n420#1:1984,9\n430#1:1993,4\n430#1:1997,6\n430#1:2004,3\n430#1:2008,2\n430#1:2010,2\n430#1:2012,6\n430#1:2018\n440#1:2019,4\n440#1:2023,6\n440#1:2030,3\n440#1:2034,2\n440#1:2036,2\n440#1:2038,6\n440#1:2044\n456#1:2045,4\n456#1:2049,6\n456#1:2056,3\n456#1:2060,2\n456#1:2062,2\n456#1:2064,6\n456#1:2070\n466#1:2071\n466#1:2075\n466#1:2077,2\n466#1:2080,4\n466#1:2087\n466#1:2091\n466#1:2093\n466#1:2096,4\n466#1:2101\n466#1:2103,8\n472#1:2111\n472#1:2115\n472#1:2117,2\n472#1:2120,4\n472#1:2127\n472#1:2131\n472#1:2133\n472#1:2136,4\n472#1:2141\n472#1:2143,8\n479#1:2151,3\n479#1:2154,6\n479#1:2161,3\n479#1:2165,2\n479#1:2167,2\n479#1:2169,6\n479#1:2175\n506#1:2176,4\n506#1:2180,6\n506#1:2187,3\n506#1:2191,2\n506#1:2193,2\n506#1:2195,6\n506#1:2201\n533#1:2202,4\n533#1:2206,6\n533#1:2213,3\n533#1:2217,2\n533#1:2219,2\n533#1:2221,6\n533#1:2227\n562#1:2228,4\n562#1:2232,6\n562#1:2239,3\n562#1:2243,2\n562#1:2245,2\n562#1:2247,6\n562#1:2253\n588#1:2254,4\n588#1:2258,6\n588#1:2265,3\n588#1:2269,2\n588#1:2271,2\n588#1:2273,6\n588#1:2279\n330#1:1852,3\n330#1:1856\n330#1:1859\n330#1:1864,3\n330#1:1868,3\n330#1:1872\n330#1:1874\n330#1:1875\n330#1:1880\n330#1:1882\n340#1:1892,3\n340#1:1896\n340#1:1899\n340#1:1904,3\n340#1:1908,3\n340#1:1912\n340#1:1914\n340#1:1915\n340#1:1920\n340#1:1922\n368#1:1931\n375#1:1932\n394#1:1939\n394#1:1943\n407#1:1959\n407#1:1963\n420#1:1979\n420#1:1983\n430#1:2003\n430#1:2007\n440#1:2029\n440#1:2033\n456#1:2055\n456#1:2059\n466#1:2072,3\n466#1:2076\n466#1:2079\n466#1:2084,3\n466#1:2088,3\n466#1:2092\n466#1:2094\n466#1:2095\n466#1:2100\n466#1:2102\n472#1:2112,3\n472#1:2116\n472#1:2119\n472#1:2124,3\n472#1:2128,3\n472#1:2132\n472#1:2134\n472#1:2135\n472#1:2140\n472#1:2142\n479#1:2160\n479#1:2164\n506#1:2186\n506#1:2190\n533#1:2212\n533#1:2216\n562#1:2238\n562#1:2242\n588#1:2264\n588#1:2268\n605#1:2280\n633#1:2281,3\n634#1:2284\n637#1:2285\n641#1:2286,3\n642#1:2289,3\n643#1:2292\n644#1:2293\n644#1:2294\n648#1:2295\n651#1:2296\n*E\n"})
/* loaded from: classes.dex */
public abstract class ScatterMap<K, V> {

    @JvmField
    public int _capacity;

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public Object[] keys;

    @JvmField
    @NotNull
    public long[] metadata = ScatterMapKt.EmptyGroup;

    @JvmField
    @NotNull
    public Object[] values;

    @Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0090\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H\u0016R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, m5569d2 = {"Landroidx/collection/ScatterMap$MapWrapper;", "", "(Landroidx/collection/ScatterMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public class MapWrapper implements Map<K, V>, KMappedMarker {
        public MapWrapper() {
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return ScatterMap.this.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return ScatterMap.this.containsValue(value);
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        @Override // java.util.Map
        @Nullable
        public V get(Object key) {
            return (V) ScatterMap.this.get(key);
        }

        @NotNull
        public Set<Map.Entry<K, V>> getEntries() {
            return new ScatterMap$MapWrapper$entries$1(ScatterMap.this);
        }

        @NotNull
        public Set<K> getKeys() {
            return new ScatterMap$MapWrapper$keys$1(ScatterMap.this);
        }

        public int getSize() {
            return ScatterMap.this._size;
        }

        @NotNull
        public Collection<V> getValues() {
            return new ScatterMap$MapWrapper$values$1(ScatterMap.this);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return ScatterMap.this.isEmpty();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V putIfAbsent(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V replace(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean replace(K k, V v, V v2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ScatterMap(DefaultConstructorMarker defaultConstructorMarker) {
        Object[] objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = objArr;
        this.values = objArr;
    }

    @PublishedApi
    public static /* synthetic */ void getKeys$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterMap scatterMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
        CharSequence charSequence5;
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence6 = "";
            if ((i2 & 2) != 0) {
                charSequence5 = "";
            } else {
                charSequence5 = charSequence2;
            }
            if ((i2 & 4) == 0) {
                charSequence6 = charSequence3;
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            CharSequence charSequence7 = charSequence4;
            if ((i2 & 32) != 0) {
                function2 = null;
            }
            return scatterMap.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence7, function2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(@NotNull Function2<? super K, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!predicate.invoke(objArr[i4], objArr2[i4]).booleanValue()) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return true;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    @NotNull
    public final String asDebugString$collection() {
        StringBuilder sb = new StringBuilder("{metadata=[");
        int i = get_capacity();
        for (int i2 = 0; i2 < i; i2++) {
            long j = (this.metadata[i2 >> 3] >> ((i2 & 7) << 3)) & 255;
            if (j == 128) {
                sb.append("Empty");
            } else if (j == 254) {
                sb.append("Deleted");
            } else {
                sb.append(j);
            }
            sb.append(", ");
        }
        sb.append("], keys=[");
        int length = this.keys.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(this.keys[i3]);
            sb.append(", ");
        }
        sb.append("], values=[");
        int length2 = this.values.length;
        for (int i4 = 0; i4 < length2; i4++) {
            sb.append(this.values[i4]);
            sb.append(", ");
        }
        sb.append("]}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final Map<K, V> asMap() {
        return new MapWrapper();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(K key) {
        int i;
        int i2;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * ScatterMapKt.MurmurHashC1;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 & 127;
        int i6 = this._capacity;
        int i7 = (i4 >>> 7) & i6;
        int i8 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (i5 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i2 = ((Long.numberOfTrailingZeros(j3) >> 3) + i7) & i6;
                if (Intrinsics.areEqual(this.keys[i2], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
        }
        if (i2 < 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsKey(K key) {
        int i;
        int i2;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * ScatterMapKt.MurmurHashC1;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 & 127;
        int i6 = this._capacity;
        int i7 = (i4 >>> 7) & i6;
        int i8 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (i5 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i2 = ((Long.numberOfTrailingZeros(j3) >> 3) + i7) & i6;
                if (Intrinsics.areEqual(this.keys[i2], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
        }
        if (i2 < 0) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(V value) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && Intrinsics.areEqual(value, objArr[(i << 3) + i3])) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count() {
        return get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ScatterMap)) {
            return false;
        }
        ScatterMap scatterMap = (ScatterMap) other;
        if (scatterMap.get_size() != get_size()) {
            return false;
        }
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            if (obj2 == null) {
                                if (scatterMap.get(obj) != null || !scatterMap.containsKey(obj)) {
                                    break loop0;
                                }
                            } else if (!Intrinsics.areEqual(obj2, scatterMap.get(obj))) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
            return false;
        }
        return true;
    }

    public final int findKeyIndex$collection(K key) {
        int i;
        int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * ScatterMapKt.MurmurHashC1;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 & 127;
        int i6 = this._capacity;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.metadata;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (i5 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i8) & i6;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], key)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i2 += 8;
            i7 = i8 + i2;
        }
    }

    public final void forEach(@NotNull Function2<? super K, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            block.invoke(objArr[i4], objArr2[i4]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @PublishedApi
    public final void forEachIndexed(@NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            AbstractC1726qj.m7069y(i << 3, i3, block);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachKey(@NotNull Function1<? super K, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachValue(@NotNull Function1<? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(K key) {
        int i;
        int i2;
        int i3 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * ScatterMapKt.MurmurHashC1;
        int i5 = i4 ^ (i4 << 16);
        int i6 = i5 & 127;
        int i7 = this._capacity;
        int i8 = i5 >>> 7;
        loop0: while (true) {
            int i9 = i8 & i7;
            long[] jArr = this.metadata;
            int i10 = i9 >> 3;
            int i11 = (i9 & 7) << 3;
            long j = ((jArr[i10 + 1] << (64 - i11)) & ((-i11) >> 63)) | (jArr[i10] >>> i11);
            long j2 = (i6 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i2 = ((Long.numberOfTrailingZeros(j3) >> 3) + i9) & i7;
                if (Intrinsics.areEqual(this.keys[i2], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i3 += 8;
            i8 = i9 + i3;
        }
        if (i2 >= 0) {
            return (V) this.values[i2];
        }
        return null;
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V getOrDefault(K key, V defaultValue) {
        int i;
        int i2;
        int i3 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * ScatterMapKt.MurmurHashC1;
        int i5 = i4 ^ (i4 << 16);
        int i6 = i5 & 127;
        int i7 = this._capacity;
        int i8 = i5 >>> 7;
        loop0: while (true) {
            int i9 = i8 & i7;
            long[] jArr = this.metadata;
            int i10 = i9 >> 3;
            int i11 = (i9 & 7) << 3;
            long j = ((jArr[i10 + 1] << (64 - i11)) & ((-i11) >> 63)) | (jArr[i10] >>> i11);
            long j2 = (i6 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i2 = ((Long.numberOfTrailingZeros(j3) >> 3) + i9) & i7;
                if (Intrinsics.areEqual(this.keys[i2], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i3 += 8;
            i8 = i9 + i3;
        }
        if (i2 >= 0) {
            return (V) this.values[i2];
        }
        return defaultValue;
    }

    public final V getOrElse(K key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        if (v == null) {
            return defaultValue.invoke();
        }
        return v;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int i;
        int i2;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                long j = jArr[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j) < 128) {
                            int i8 = (i4 << 3) + i7;
                            Object obj = objArr[i8];
                            Object obj2 = objArr2[i8];
                            if (obj != null) {
                                i = obj.hashCode();
                            } else {
                                i = 0;
                            }
                            if (obj2 != null) {
                                i2 = obj2.hashCode();
                            } else {
                                i2 = 0;
                            }
                            i5 += i2 ^ i;
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        return i5;
                    }
                }
                if (i4 != length) {
                    i4++;
                } else {
                    i3 = i5;
                    break;
                }
            }
        }
        return i3;
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
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final boolean none() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            Object obj2 = objArr2[i5];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            if (obj2 == this) {
                                obj2 = "(this)";
                            }
                            sb.append(obj2);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return AbstractC1726qj.m7060p(sb, '}', "s.append('}').toString()");
    }

    public final boolean any(@NotNull Function2<? super K, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (predicate.invoke(objArr[i4], objArr2[i4]).booleanValue()) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count(@NotNull Function2<? super K, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            if (predicate.invoke(objArr[i6], objArr2[i6]).booleanValue()) {
                                i3++;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i, @NotNull CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int limit, @NotNull CharSequence truncated, @Nullable Function2<? super K, ? super V, ? extends CharSequence> transform) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder m8300t = ye0.m8300t(postfix, "postfix", truncated, "truncated", prefix);
        Object[] objArr5 = this.keys;
        Object[] objArr6 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr5[i6];
                            objArr3 = objArr5;
                            Object obj2 = objArr6[i6];
                            objArr4 = objArr6;
                            if (i2 == limit) {
                                m8300t.append(truncated);
                                break loop0;
                            }
                            if (i2 != 0) {
                                m8300t.append(separator);
                            }
                            if (transform == null) {
                                m8300t.append(obj);
                                m8300t.append('=');
                                m8300t.append(obj2);
                            } else {
                                m8300t.append(transform.invoke(obj, obj2));
                            }
                            i2++;
                        } else {
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                        }
                        j >>= 8;
                        i5++;
                        objArr6 = objArr4;
                        objArr5 = objArr3;
                    }
                    objArr = objArr5;
                    objArr2 = objArr6;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr5;
                    objArr2 = objArr6;
                }
                if (i3 == length) {
                    break;
                }
                i = i3 + 1;
                objArr6 = objArr2;
                objArr5 = objArr;
            }
        }
        m8300t.append(postfix);
        String sb = m8300t.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
