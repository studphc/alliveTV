package okhttp3.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1326ip;
import p000.AbstractC1327iq;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001d\u001a\u0004\u0018\u00010\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b \u0010!\u001a\u001b\u0010#\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0004\b#\u0010$\u001a#\u0010%\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b%\u0010!\u001a\u001b\u0010&\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010(\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b(\u0010!\u001a\u001d\u0010)\u001a\u0004\u0018\u00010\u0003*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u00020\u0000*\u00020\u000fH\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010.\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b0\u00101\u001a#\u00103\u001a\u00020\u00002\u0012\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b\"\u00020\u0003H\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00106\u001a\u00020\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000305H\u0000¢\u0006\u0004\b6\u00107¨\u00068"}, m5569d2 = {"Lokhttp3/Headers;", "", FirebaseAnalytics.Param.INDEX, "", "commonName", "(Lokhttp3/Headers;I)Ljava/lang/String;", "commonValue", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "commonValues", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "", "Lkotlin/Pair;", "commonIterator", "(Lokhttp3/Headers;)Ljava/util/Iterator;", "Lokhttp3/Headers$Builder;", "commonNewBuilder", "(Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "", "other", "", "commonEquals", "(Lokhttp3/Headers;Ljava/lang/Object;)Z", "commonHashCode", "(Lokhttp3/Headers;)I", "commonToString", "(Lokhttp3/Headers;)Ljava/lang/String;", "", "namesAndValues", "commonHeadersGet", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "value", "commonAdd", "(Lokhttp3/Headers$Builder;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "headers", "commonAddAll", "(Lokhttp3/Headers$Builder;Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "commonAddLenient", "commonRemoveAll", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "commonSet", "commonGet", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Ljava/lang/String;", "commonBuild", "(Lokhttp3/Headers$Builder;)Lokhttp3/Headers;", "", "headersCheckName", "(Ljava/lang/String;)V", "headersCheckValue", "(Ljava/lang/String;Ljava/lang/String;)V", "inputNamesAndValues", "commonHeadersOf", "([Ljava/lang/String;)Lokhttp3/Headers;", "", "commonToHeaders", "(Ljava/util/Map;)Lokhttp3/Headers;", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _HeadersCommonKt {
    @NotNull
    public static final Headers.Builder commonAdd(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonAddAll(@NotNull Headers.Builder builder, @NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient(builder, headers.name(i), headers.value(i));
        }
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonAddLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getNamesAndValues$okhttp().add(name);
        builder.getNamesAndValues$okhttp().add(StringsKt__StringsKt.trim(value).toString());
        return builder;
    }

    @NotNull
    public static final Headers commonBuild(@NotNull Headers.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Object[] array = builder.getNamesAndValues$okhttp().toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean commonEquals(@NotNull Headers headers, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        if ((obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues(), ((Headers) obj).getNamesAndValues())) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final String commonGet(@NotNull Headers.Builder builder, @NotNull String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement <= size) {
            while (!ro2.equals(name, builder.getNamesAndValues$okhttp().get(size), true)) {
                if (size != progressionLastElement) {
                    size -= 2;
                } else {
                    return null;
                }
            }
            return builder.getNamesAndValues$okhttp().get(size + 1);
        }
        return null;
    }

    public static final int commonHashCode(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return Arrays.hashCode(headers.getNamesAndValues());
    }

    @Nullable
    public static final String commonHeadersGet(@NotNull String[] namesAndValues, @NotNull String name) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = namesAndValues.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= length) {
            while (!ro2.equals(name, namesAndValues[length], true)) {
                if (length != progressionLastElement) {
                    length -= 2;
                } else {
                    return null;
                }
            }
            return namesAndValues[length + 1];
        }
        return null;
    }

    @NotNull
    public static final Headers commonHeadersOf(@NotNull String... inputNamesAndValues) {
        Intrinsics.checkNotNullParameter(inputNamesAndValues, "inputNamesAndValues");
        if (inputNamesAndValues.length % 2 == 0) {
            String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
            int length = strArr.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (strArr[i2] != null) {
                    strArr[i2] = StringsKt__StringsKt.trim(inputNamesAndValues[i2]).toString();
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str = strArr[i];
                    String str2 = strArr[i + 1];
                    headersCheckName(str);
                    headersCheckValue(str2, str);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    @NotNull
    public static final Iterator<Pair<String, String>> commonIterator(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        int size = headers.size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.m5575to(headers.name(i), headers.value(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    @NotNull
    public static final String commonName(@NotNull Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt___ArraysKt.getOrNull(headers.getNamesAndValues(), i * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    @NotNull
    public static final Headers.Builder commonNewBuilder(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Headers.Builder builder = new Headers.Builder();
        AbstractC1327iq.addAll(builder.getNamesAndValues$okhttp(), headers.getNamesAndValues());
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonRemoveAll(@NotNull Headers.Builder builder, @NotNull String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        while (i < builder.getNamesAndValues$okhttp().size()) {
            if (ro2.equals(name, builder.getNamesAndValues$okhttp().get(i), true)) {
                builder.getNamesAndValues$okhttp().remove(i);
                builder.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonSet(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        builder.removeAll(name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    @NotNull
    public static final Headers commonToHeaders(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String obj = StringsKt__StringsKt.trim(key).toString();
            String obj2 = StringsKt__StringsKt.trim(value).toString();
            headersCheckName(obj);
            headersCheckValue(obj2, obj);
            strArr[i] = obj;
            strArr[i + 1] = obj2;
            i += 2;
        }
        return new Headers(strArr);
    }

    @NotNull
    public static final String commonToString(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            sb.append(name);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public static final String commonValue(@NotNull Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt___ArraysKt.getOrNull(headers.getNamesAndValues(), (i * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    @NotNull
    public static final List<String> commonValues(@NotNull Headers headers, @NotNull String name) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = headers.size();
        List<String> list = null;
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (ro2.equals(name, headers.name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i));
            }
        }
        if (arrayList != null) {
            list = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public static final void headersCheckName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() > 0) {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char charAt = name.charAt(i);
                if ('!' > charAt || charAt >= 127) {
                    StringBuilder sb = new StringBuilder("Unexpected char 0x");
                    String num = Integer.toString(charAt, AbstractC1326ip.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                    if (num.length() < 2) {
                        num = "0".concat(num);
                    }
                    sb.append(num);
                    sb.append(" at ");
                    sb.append(i);
                    sb.append(" in header name: ");
                    sb.append(name);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty");
    }

    public static final void headersCheckValue(@NotNull String value, @NotNull String name) {
        String concat;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char charAt = value.charAt(i);
            if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                String num = Integer.toString(charAt, AbstractC1326ip.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                if (num.length() < 2) {
                    num = "0".concat(num);
                }
                sb.append(num);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(name);
                sb.append(" value");
                if (_UtilCommonKt.isSensitiveHeader(name)) {
                    concat = "";
                } else {
                    concat = ": ".concat(value);
                }
                sb.append(concat);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
