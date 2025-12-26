package okhttp3.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.Typography;
import okhttp3.MediaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0000*\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, m5569d2 = {"Lokhttp3/MediaType;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "commonParameter", "(Lokhttp3/MediaType;Ljava/lang/String;)Ljava/lang/String;", "", "other", "", "commonEquals", "(Lokhttp3/MediaType;Ljava/lang/Object;)Z", "commonToString", "(Lokhttp3/MediaType;)Ljava/lang/String;", "", "commonHashCode", "(Lokhttp3/MediaType;)I", "commonToMediaType", "(Ljava/lang/String;)Lokhttp3/MediaType;", "commonToMediaTypeOrNull", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _MediaTypeCommonKt {

    /* renamed from: a */
    public static final Regex f24145a = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    public static final Regex f24146b = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final boolean commonEquals(@NotNull MediaType mediaType, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(mediaType, "<this>");
        if ((obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).getMediaType(), mediaType.getMediaType())) {
            return true;
        }
        return false;
    }

    public static final int commonHashCode(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "<this>");
        return mediaType.getMediaType().hashCode();
    }

    @Nullable
    public static final String commonParameter(@NotNull MediaType mediaType, @NotNull String name) {
        Intrinsics.checkNotNullParameter(mediaType, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, mediaType.getParameterNamesAndValues().length - 1, 2);
        if (progressionLastElement >= 0) {
            while (!ro2.equals(mediaType.getParameterNamesAndValues()[i], name, true)) {
                if (i != progressionLastElement) {
                    i += 2;
                } else {
                    return null;
                }
            }
            return mediaType.getParameterNamesAndValues()[i + 1];
        }
        return null;
    }

    @NotNull
    public static final MediaType commonToMediaType(@NotNull String str) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        MatchResult matchAtPolyfill = _UtilCommonKt.matchAtPolyfill(f24145a, str, 0);
        if (matchAtPolyfill != null) {
            String str4 = matchAtPolyfill.getGroupValues().get(1);
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = str4.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String str5 = matchAtPolyfill.getGroupValues().get(2);
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase2 = str5.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            int last = matchAtPolyfill.getRange().getLast();
            while (true) {
                int i = last + 1;
                if (i < str.length()) {
                    MatchResult matchAtPolyfill2 = _UtilCommonKt.matchAtPolyfill(f24146b, str, i);
                    if (matchAtPolyfill2 != null) {
                        MatchGroup matchGroup = matchAtPolyfill2.getGroups().get(1);
                        if (matchGroup != null) {
                            str2 = matchGroup.getValue();
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            last = matchAtPolyfill2.getRange().getLast();
                        } else {
                            MatchGroup matchGroup2 = matchAtPolyfill2.getGroups().get(2);
                            if (matchGroup2 != null) {
                                str3 = matchGroup2.getValue();
                            } else {
                                str3 = null;
                            }
                            if (str3 == null) {
                                MatchGroup matchGroup3 = matchAtPolyfill2.getGroups().get(3);
                                Intrinsics.checkNotNull(matchGroup3);
                                str3 = matchGroup3.getValue();
                            } else if (ro2.startsWith$default(str3, "'", false, 2, null) && ro2.endsWith$default(str3, "'", false, 2, null) && str3.length() > 2) {
                                str3 = str3.substring(1, str3.length() - 1);
                                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            arrayList.add(str2);
                            arrayList.add(str3);
                            last = matchAtPolyfill2.getRange().getLast();
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                        String substring = str.substring(i);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        sb.append(substring);
                        sb.append("\" for: \"");
                        sb.append(str);
                        sb.append(Typography.quote);
                        throw new IllegalArgumentException(sb.toString().toString());
                    }
                } else {
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array != null) {
                        return new MediaType(str, lowerCase, lowerCase2, (String[]) array);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
        } else {
            throw new IllegalArgumentException("No subtype found for: \"" + str + Typography.quote);
        }
    }

    @Nullable
    public static final MediaType commonToMediaTypeOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return commonToMediaType(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @NotNull
    public static final String commonToString(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "<this>");
        return mediaType.getMediaType();
    }
}
