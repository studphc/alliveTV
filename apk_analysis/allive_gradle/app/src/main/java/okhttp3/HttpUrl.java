package okhttp3;

import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.CardPresenter;
import com.hisona.allive.HttpRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.Typography;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._HostnamesJvmKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.AbstractC1726qj;
import p000.r82;
import p000.ro2;
import p000.sh2;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\"\n\u0002\b\u0017\u0018\u0000 _2\u00020\u0001:\u0002`_Bc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\r\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0017\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b&\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010!J\u000f\u00100\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u0010!J\u000f\u0010\r\u001a\u00020\u0010H\u0007¢\u0006\u0004\b1\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b2\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b3\u0010!J\u000f\u00105\u001a\u00020\u0002H\u0007¢\u0006\u0004\b4\u0010!J\u000f\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b6\u0010!J\u000f\u00108\u001a\u00020\u0002H\u0007¢\u0006\u0004\b7\u0010!J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b9\u0010!J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b:\u0010!J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b;\u0010.J\u000f\u0010=\u001a\u00020\u0007H\u0007¢\u0006\u0004\b<\u0010.J\u000f\u0010?\u001a\u00020\u0002H\u0007¢\u0006\u0004\b>\u0010!J\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0007¢\u0006\u0004\b@\u0010AJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0007¢\u0006\u0004\bC\u0010AJ\u0011\u0010E\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bD\u0010!J\u0011\u0010G\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bF\u0010!J\u000f\u0010I\u001a\u00020\u0007H\u0007¢\u0006\u0004\bH\u0010.J\u0015\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020JH\u0007¢\u0006\u0004\bK\u0010LJ\u0011\u0010O\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bN\u0010!J\u0011\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\bP\u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\b\u0003\u0010!R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\bS\u0010R\u001a\u0004\b\u0004\u0010!R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\bT\u0010R\u001a\u0004\b\u0005\u0010!R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\bU\u0010R\u001a\u0004\b\u0006\u0010!R\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\b\b\u0010.R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\b\n\u0010AR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\bZ\u0010R\u001a\u0004\b\f\u0010!R\u0017\u0010]\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0011\u00105\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b5\u0010!R\u0011\u00108\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010!R\u0011\u0010=\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b=\u0010.R\u0011\u0010?\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b?\u0010!R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\t8G¢\u0006\u0006\u001a\u0004\bB\u0010AR\u0013\u0010E\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\bE\u0010!R\u0013\u0010G\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\bG\u0010!R\u0011\u0010I\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bI\u0010.R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020J8G¢\u0006\u0006\u001a\u0004\bM\u0010LR\u0013\u0010O\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\bO\u0010!¨\u0006a"}, m5569d2 = {"Lokhttp3/HttpUrl;", "", "", "scheme", "username", "password", "host", "", "port", "", "pathSegments", "queryNamesAndValues", "fragment", ImagesContract.URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "()Ljava/net/URL;", "toUrl", "Ljava/net/URI;", "uri", "()Ljava/net/URI;", "toUri", AppMeasurementSdk.ConditionalUserProperty.NAME, "queryParameter", "(Ljava/lang/String;)Ljava/lang/String;", "queryParameterValues", "(Ljava/lang/String;)Ljava/util/List;", FirebaseAnalytics.Param.INDEX, "queryParameterName", "(I)Ljava/lang/String;", "queryParameterValue", "redact", "()Ljava/lang/String;", "link", "resolve", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl$Builder;", "newBuilder", "()Lokhttp3/HttpUrl$Builder;", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "-deprecated_encodedUsername", "encodedUsername", "-deprecated_username", "-deprecated_encodedPassword", "encodedPassword", "-deprecated_password", "-deprecated_host", "-deprecated_port", "-deprecated_pathSize", "pathSize", "-deprecated_encodedPath", "encodedPath", "-deprecated_encodedPathSegments", "()Ljava/util/List;", "encodedPathSegments", "-deprecated_pathSegments", "-deprecated_encodedQuery", "encodedQuery", "-deprecated_query", SearchIntents.EXTRA_QUERY, "-deprecated_querySize", "querySize", "", "-deprecated_queryParameterNames", "()Ljava/util/Set;", "queryParameterNames", "-deprecated_encodedFragment", "encodedFragment", "-deprecated_fragment", "a", "Ljava/lang/String;", "b", "c", "d", "e", "I", "f", "Ljava/util/List;", "h", "j", "Z", "isHttps", "()Z", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class HttpUrl {

    @NotNull
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: a, reason: from kotlin metadata */
    public final String scheme;

    /* renamed from: b, reason: from kotlin metadata */
    public final String username;

    /* renamed from: c, reason: from kotlin metadata */
    public final String password;

    /* renamed from: d, reason: from kotlin metadata */
    public final String host;

    /* renamed from: e, reason: from kotlin metadata */
    public final int port;

    /* renamed from: f, reason: from kotlin metadata */
    public final List pathSegments;

    /* renamed from: g */
    public final List f23966g;

    /* renamed from: h, reason: from kotlin metadata */
    public final String fragment;

    /* renamed from: i */
    public final String f23968i;

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean isHttps;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k */
    public static final char[] f23959k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0006J\u001d\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u000eJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u0006J\u001f\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010\"J\u001f\u0010&\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b&\u0010\"J\u001f\u0010'\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b'\u0010\"J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u0006J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b*\u0010\u0006J\u0017\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010\u0006J\u000f\u0010.\u001a\u00020\u0000H\u0000¢\u0006\u0004\b,\u0010-J\r\u00100\u001a\u00020/¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u00103J!\u00108\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0004\b6\u00107R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u00103\"\u0004\b<\u0010=R\"\u0010\b\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010:\u001a\u0004\b?\u00103\"\u0004\b@\u0010=R\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010:\u001a\u0004\bB\u00103\"\u0004\bC\u0010=R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u00103\"\u0004\bF\u0010=R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR,\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010M8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010O\u001a\u0004\bS\u0010Q\"\u0004\bT\u0010UR$\u0010+\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010:\u001a\u0004\bX\u00103\"\u0004\bY\u0010=¨\u0006["}, m5569d2 = {"Lokhttp3/HttpUrl$Builder;", "", "<init>", "()V", "", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "username", "encodedUsername", "password", "encodedPassword", "host", "", "port", "(I)Lokhttp3/HttpUrl$Builder;", "pathSegment", "addPathSegment", "pathSegments", "addPathSegments", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", FirebaseAnalytics.Param.INDEX, "setPathSegment", "(ILjava/lang/String;)Lokhttp3/HttpUrl$Builder;", "setEncodedPathSegment", "removePathSegment", "encodedPath", SearchIntents.EXTRA_QUERY, "encodedQuery", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "input", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "a", "Ljava/lang/String;", "getScheme$okhttp", "setScheme$okhttp", "(Ljava/lang/String;)V", "b", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "c", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "d", "getHost$okhttp", "setHost$okhttp", "e", "I", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "", "f", "Ljava/util/List;", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "g", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "h", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";

        /* renamed from: a, reason: from kotlin metadata */
        public String scheme;

        /* renamed from: d, reason: from kotlin metadata */
        public String host;

        /* renamed from: f */
        public final ArrayList f23975f;

        /* renamed from: g, reason: from kotlin metadata */
        public List encodedQueryNamesAndValues;

        /* renamed from: h, reason: from kotlin metadata */
        public String encodedFragment;

        /* renamed from: b, reason: from kotlin metadata */
        public String encodedUsername = "";

        /* renamed from: c, reason: from kotlin metadata */
        public String encodedPassword = "";

        /* renamed from: e, reason: from kotlin metadata */
        public int port = -1;

        @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m5569d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "", "INVALID_HOST", "Ljava/lang/String;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public static final int access$parsePort(Companion companion, String str, int i, int i2) {
                companion.getClass();
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 > parseInt || parseInt >= 65536) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public static final int access$portColonOffset(Companion companion, String str, int i, int i2) {
                companion.getClass();
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '[') {
                        if (charAt == ':') {
                            return i;
                        }
                        i++;
                    }
                    do {
                        i++;
                        if (i < i2) {
                        }
                        i++;
                    } while (str.charAt(i) != ']');
                    i++;
                }
                return i2;
            }

            public static final int access$schemeDelimiterOffset(Companion companion, String str, int i, int i2) {
                companion.getClass();
                if (i2 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((Intrinsics.compare((int) charAt, 97) < 0 || Intrinsics.compare((int) charAt, 122) > 0) && (Intrinsics.compare((int) charAt, 65) < 0 || Intrinsics.compare((int) charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || charAt2 >= '{') {
                        if ('A' > charAt2 || charAt2 >= '[') {
                            if ('0' > charAt2 || charAt2 >= ':') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 != ':') {
                                        return -1;
                                    }
                                    return i;
                                }
                            }
                        }
                    }
                }
            }

            public static final int access$slashCount(Companion companion, String str, int i, int i2) {
                companion.getClass();
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f23975f = arrayList;
            arrayList.add("");
        }

        /* renamed from: b */
        public static boolean m6592b(String str) {
            if (Intrinsics.areEqual(str, ".") || ro2.equals(str, "%2e", true)) {
                return true;
            }
            return false;
        }

        /* renamed from: c */
        public static boolean m6593c(String str) {
            if (Intrinsics.areEqual(str, "..") || ro2.equals(str, "%2e.", true) || ro2.equals(str, ".%2e", true) || ro2.equals(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final void m6594a(String str, boolean z) {
            boolean z2;
            int i = 0;
            do {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i, str.length());
                if (delimiterOffset < str.length()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m6595d(str, i, delimiterOffset, z2, z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            m6595d(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String encodedPathSegments) {
            Intrinsics.checkNotNullParameter(encodedPathSegments, "encodedPathSegments");
            m6594a(encodedPathSegments, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            String str;
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = HttpUrl.INSTANCE;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            if (encodedValue != null) {
                str = Companion.canonicalize$okhttp$default(companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            } else {
                str = null;
            }
            list2.add(str);
            return this;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            m6595d(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String pathSegments) {
            Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
            m6594a(pathSegments, false);
            return this;
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String name, @Nullable String value) {
            String str;
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = HttpUrl.INSTANCE;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            if (value != null) {
                str = Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
            } else {
                str = null;
            }
            list2.add(str);
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            int defaultPort;
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.scheme;
            if (str3 != null) {
                Companion companion = HttpUrl.INSTANCE;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str4 = this.host;
                if (str4 != null) {
                    int i = this.port;
                    if (i != -1) {
                        defaultPort = i;
                    } else {
                        String str5 = this.scheme;
                        Intrinsics.checkNotNull(str5);
                        defaultPort = companion.defaultPort(str5);
                    }
                    ArrayList arrayList2 = this.f23975f;
                    ArrayList arrayList3 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
                    }
                    List<String> list = this.encodedQueryNamesAndValues;
                    if (list != null) {
                        arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(list, 10));
                        for (String str6 : list) {
                            if (str6 != null) {
                                str2 = Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str6, 0, 0, true, 3, null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str7 = this.encodedFragment;
                    if (str7 != null) {
                        str = Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str7, 0, 0, false, 7, null);
                    } else {
                        str = null;
                    }
                    return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, defaultPort, arrayList3, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* renamed from: d */
        public final void m6595d(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
            if (m6592b(canonicalize$okhttp$default)) {
                return;
            }
            boolean m6593c = m6593c(canonicalize$okhttp$default);
            ArrayList arrayList = this.f23975f;
            if (m6593c) {
                if (((String) arrayList.remove(arrayList.size() - 1)).length() == 0 && !arrayList.isEmpty()) {
                    arrayList.set(arrayList.size() - 1, "");
                    return;
                } else {
                    arrayList.add("");
                    return;
                }
            }
            if (((CharSequence) AbstractC1726qj.m7053i(arrayList, 1)).length() == 0) {
                arrayList.set(arrayList.size() - 1, canonicalize$okhttp$default);
            } else {
                arrayList.add(canonicalize$okhttp$default);
            }
            if (z) {
                arrayList.add("");
            }
        }

        /* renamed from: e */
        public final void m6596e(String str) {
            List list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            int size = list.size() - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return;
            }
            while (true) {
                List list2 = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list2);
                if (Intrinsics.areEqual(str, list2.get(size))) {
                    List list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list3);
                    list3.remove(size + 1);
                    List list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list4);
                    list4.remove(size);
                    List list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size != progressionLastElement) {
                    size -= 2;
                } else {
                    return;
                }
            }
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String encodedFragment) {
            String str;
            if (encodedFragment != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedFragment, 0, 0, "", true, false, false, true, null, 179, null);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String encodedPassword) {
            Intrinsics.checkNotNullParameter(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String encodedPath) {
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            if (ro2.startsWith$default(encodedPath, "/", false, 2, null)) {
                m6597f(0, encodedPath.length(), encodedPath);
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected encodedPath: ", encodedPath).toString());
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String encodedQuery) {
            List<String> list;
            if (encodedQuery != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, encodedQuery, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String encodedUsername) {
            Intrinsics.checkNotNullParameter(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        /* renamed from: f */
        public final void m6597f(int i, int i2, String str) {
            boolean z;
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            ArrayList arrayList = this.f23975f;
            if (charAt != '/' && charAt != '\\') {
                arrayList.set(arrayList.size() - 1, "");
            } else {
                arrayList.clear();
                arrayList.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                while (i3 < i2) {
                    i = _UtilCommonKt.delimiterOffset(str, "/\\", i3, i2);
                    if (i < i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m6595d(str, i3, i, z, true);
                    if (z) {
                        i3 = i + 1;
                    }
                }
                return;
            }
        }

        @NotNull
        public final Builder fragment(@Nullable String fragment) {
            String str;
            if (fragment != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, fragment, 0, 0, "", false, false, false, true, null, 187, null);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        @Nullable
        /* renamed from: getEncodedFragment$okhttp, reason: from getter */
        public final String getEncodedFragment() {
            return this.encodedFragment;
        }

        @NotNull
        /* renamed from: getEncodedPassword$okhttp, reason: from getter */
        public final String getEncodedPassword() {
            return this.encodedPassword;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.f23975f;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        /* renamed from: getEncodedUsername$okhttp, reason: from getter */
        public final String getEncodedUsername() {
            return this.encodedUsername;
        }

        @Nullable
        /* renamed from: getHost$okhttp, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        /* renamed from: getPort$okhttp, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        @Nullable
        /* renamed from: getScheme$okhttp, reason: from getter */
        public final String getScheme() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String canonicalHost = _HostnamesJvmKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected host: ", host));
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl base, @NotNull String input) {
            int delimiterOffset;
            int i;
            boolean z;
            int i2;
            boolean z2;
            char c;
            int i3;
            char c2;
            int i4;
            String input2 = input;
            Intrinsics.checkNotNullParameter(input2, "input");
            int indexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(input2, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(input2, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = INSTANCE;
            int access$schemeDelimiterOffset = Companion.access$schemeDelimiterOffset(companion, input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            boolean z3 = true;
            char c3 = 65535;
            if (access$schemeDelimiterOffset != -1) {
                if (ro2.startsWith(input2, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (ro2.startsWith(input2, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                    String substring = input2.substring(0, access$schemeDelimiterOffset);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append('\'');
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (base != null) {
                this.scheme = base.scheme();
            } else {
                if (input.length() > 6) {
                    input2 = StringsKt___StringsKt.take(input2, 6) + "...";
                }
                throw new IllegalArgumentException(AbstractC1726qj.m7038C("Expected URL scheme 'http' or 'https' but no scheme was found for ", input2));
            }
            int access$slashCount = Companion.access$slashCount(companion, input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            if (access$slashCount < 2 && base != null && Intrinsics.areEqual(base.scheme(), this.scheme)) {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.host();
                this.port = base.port();
                ArrayList arrayList = this.f23975f;
                arrayList.clear();
                arrayList.addAll(base.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input2.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(base.encodedQuery());
                }
                i3 = indexOfLastNonAsciiWhitespace$default;
            } else {
                boolean z4 = false;
                boolean z5 = false;
                int i5 = indexOfFirstNonAsciiWhitespace$default + access$slashCount;
                while (true) {
                    delimiterOffset = _UtilCommonKt.delimiterOffset(input2, "@/\\?#", i5, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input2.charAt(delimiterOffset) : c3;
                    if (charAt == '@') {
                        if (!z4) {
                            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(input2, ':', i5, delimiterOffset);
                            Companion companion2 = HttpUrl.INSTANCE;
                            z = z3;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i5, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                            if (z5) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i = delimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null);
                                z2 = z;
                            } else {
                                i = delimiterOffset;
                                z2 = z4;
                            }
                            z4 = z2;
                            i2 = indexOfLastNonAsciiWhitespace$default;
                            z5 = z;
                        } else {
                            i = delimiterOffset;
                            z = z3;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            i2 = indexOfLastNonAsciiWhitespace$default;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, i5, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, PsExtractor.VIDEO_STREAM_MASK, null));
                            this.encodedPassword = sb2.toString();
                        }
                        i5 = i + 1;
                        indexOfLastNonAsciiWhitespace$default = i2;
                        z3 = z;
                        c3 = 65535;
                    } else {
                        c = c3;
                        boolean z6 = z3;
                        i3 = indexOfLastNonAsciiWhitespace$default;
                        if (charAt != c && charAt != '/' && charAt != '\\') {
                            if (charAt == '?') {
                                break;
                            }
                            if (charAt == '#') {
                                break;
                            }
                            indexOfLastNonAsciiWhitespace$default = i3;
                            z3 = z6;
                            c3 = c;
                        }
                    }
                }
                Companion companion3 = INSTANCE;
                int access$portColonOffset = Companion.access$portColonOffset(companion3, input2, i5, delimiterOffset);
                int i6 = access$portColonOffset + 1;
                if (i6 < delimiterOffset) {
                    c2 = '\"';
                    i4 = access$portColonOffset;
                    this.host = _HostnamesJvmKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, input, i5, access$portColonOffset, false, 4, null));
                    int access$parsePort = Companion.access$parsePort(companion3, input2, i6, delimiterOffset);
                    this.port = access$parsePort;
                    if (access$parsePort == c) {
                        StringBuilder sb3 = new StringBuilder("Invalid URL port: \"");
                        String substring2 = input2.substring(i6, delimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb3.append(substring2);
                        sb3.append(Typography.quote);
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    c2 = '\"';
                    i4 = access$portColonOffset;
                    Companion companion4 = HttpUrl.INSTANCE;
                    this.host = _HostnamesJvmKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i5, i4, false, 4, null));
                    String str = this.scheme;
                    Intrinsics.checkNotNull(str);
                    this.port = companion4.defaultPort(str);
                }
                if (this.host == null) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL host: \"");
                    String substring3 = input2.substring(i5, i4);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb4.append(substring3);
                    sb4.append(c2);
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            }
            int i7 = i3;
            int delimiterOffset3 = _UtilCommonKt.delimiterOffset(input2, "?#", indexOfFirstNonAsciiWhitespace$default, i7);
            m6597f(indexOfFirstNonAsciiWhitespace$default, delimiterOffset3, input2);
            if (delimiterOffset3 < i7 && input2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = _UtilCommonKt.delimiterOffset(input2, '#', delimiterOffset3, i7);
                Companion companion5 = HttpUrl.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, HttpStatusCodesKt.HTTP_ALREADY_REPORTED, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i7 && input2.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, delimiterOffset3 + 1, i7, "", true, false, false, true, null, CardPresenter.CARD_HEIGHT, null);
            }
            return this;
        }

        @NotNull
        public final Builder password(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @NotNull
        public final Builder port(int port) {
            if (1 <= port && port < 65536) {
                this.port = port;
                return this;
            }
            throw new IllegalArgumentException(ye0.m8291k(port, "unexpected port: ").toString());
        }

        @NotNull
        public final Builder query(@Nullable String query) {
            List<String> list;
            if (query != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, query, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2;
            String str3 = this.host;
            String str4 = null;
            if (str3 != null) {
                str = new Regex("[\"<>^`{|}]").replace(str3, "");
            } else {
                str = null;
            }
            this.host = str;
            ArrayList arrayList = this.f23975f;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.set(i, Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, (String) arrayList.get(i), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str5 = (String) list.get(i2);
                    if (str5 != null) {
                        str2 = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str5, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
                    } else {
                        str2 = null;
                    }
                    list.set(i2, str2);
                }
            }
            String str6 = this.encodedFragment;
            if (str6 != null) {
                str4 = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str6, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
            }
            this.encodedFragment = str4;
            return this;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String encodedName) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            m6596e(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            m6596e(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int index) {
            ArrayList arrayList = this.f23975f;
            arrayList.remove(index);
            if (arrayList.isEmpty()) {
                arrayList.add("");
            }
            return this;
        }

        @NotNull
        public final Builder scheme(@NotNull String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (ro2.equals(scheme, "http", true)) {
                this.scheme = "http";
            } else if (ro2.equals(scheme, "https", true)) {
                this.scheme = "https";
            } else {
                throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected scheme: ", scheme));
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(@Nullable String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int index, @NotNull String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.f23975f.set(index, canonicalize$okhttp$default);
            if (!m6592b(canonicalize$okhttp$default) && !m6593c(canonicalize$okhttp$default)) {
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected path segment: ", encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, encodedValue);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@Nullable String str) {
            this.host = str;
        }

        @NotNull
        public final Builder setPathSegment(int index, @NotNull String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!m6592b(canonicalize$okhttp$default) && !m6593c(canonicalize$okhttp$default)) {
                this.f23975f.set(index, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("unexpected path segment: ", pathSegment).toString());
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String name, @Nullable String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, value);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
        
            if (r1 != r4.defaultPort(r3)) goto L32;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, ':', false, 2, (Object) null)) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            int i = this.port;
            if (i != -1 || this.scheme != null) {
                if (i == -1) {
                    Companion companion = HttpUrl.INSTANCE;
                    String str3 = this.scheme;
                    Intrinsics.checkNotNull(str3);
                    i = companion.defaultPort(str3);
                }
                String str4 = this.scheme;
                if (str4 != null) {
                    Companion companion2 = HttpUrl.INSTANCE;
                    Intrinsics.checkNotNull(str4);
                }
                sb.append(':');
                sb.append(i);
            }
            Companion companion3 = HttpUrl.INSTANCE;
            companion3.toPathString$okhttp(this.f23975f, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                companion3.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        @NotNull
        public final Builder username(@NotNull String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    @Metadata(m5568d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000e\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00020\u00072\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0000¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011*\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u0015*\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\u001bH\u0007¢\u0006\u0004\b\u0016\u0010\u001cJ\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\u001dH\u0007¢\u0006\u0004\b\u0016\u0010\u001eJ\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b!\u0010\u0017J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u001bH\u0007¢\u0006\u0004\b \u0010\u001cJ\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\"\u001a\u00020\u001dH\u0007¢\u0006\u0004\b \u0010\u001eJ1\u0010)\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b'\u0010(Jc\u00102\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020%2\b\b\u0002\u0010,\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u00104¨\u0006B"}, m5569d2 = {"Lokhttp3/HttpUrl$Companion;", "", "", "scheme", "", "defaultPort", "(Ljava/lang/String;)I", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", ImagesContract.URL, "-deprecated_get", "-deprecated_parse", "uri", "pos", "limit", "", "plusIsSpace", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static boolean m6598a(int i, int i2, String str) {
            int i3 = i + 2;
            if (i3 < i2 && str.charAt(i) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i3)) != -1) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return companion.canonicalize$okhttp(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return companion.percentDecode$okhttp(str, i, i2, z);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m8985deprecated_get(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m8988deprecated_parse(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return parse(url);
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String str, int i, int i2, @NotNull String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i3 = i;
            while (i3 < i2) {
                int codePointAt = str.codePointAt(i3);
                int i4 = 43;
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z4) && !StringsKt__StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt, false, 2, (Object) null) && ((codePointAt != 37 || (z && (!z2 || m6598a(i3, i2, str)))) && (codePointAt != 43 || !z3)))) {
                    i3 += Character.charCount(codePointAt);
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, i3);
                    Buffer buffer2 = null;
                    while (i3 < i2) {
                        int codePointAt2 = str.codePointAt(i3);
                        if (!z || (codePointAt2 != 9 && codePointAt2 != 10 && codePointAt2 != 12 && codePointAt2 != 13)) {
                            String str2 = "+";
                            if (codePointAt2 == 32 && encodeSet == HttpUrl.FORM_ENCODE_SET) {
                                buffer.writeUtf8("+");
                            } else if (codePointAt2 == i4 && z3) {
                                if (!z) {
                                    str2 = "%2B";
                                }
                                buffer.writeUtf8(str2);
                            } else {
                                if (codePointAt2 >= 32 && codePointAt2 != 127 && (codePointAt2 < 128 || z4)) {
                                    if (!StringsKt__StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt2, false, 2, (Object) null) && (codePointAt2 != 37 || (z && (!z2 || m6598a(i3, i2, str))))) {
                                        buffer.writeUtf8CodePoint(codePointAt2);
                                    }
                                }
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                if (charset != null && !Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                                    buffer2.writeString(str, i3, Character.charCount(codePointAt2) + i3, charset);
                                } else {
                                    buffer2.writeUtf8CodePoint(codePointAt2);
                                }
                                while (!buffer2.exhausted()) {
                                    byte readByte = buffer2.readByte();
                                    buffer.writeByte(37);
                                    buffer.writeByte((int) HttpUrl.f23959k[((readByte & 255) >> 4) & 15]);
                                    buffer.writeByte((int) HttpUrl.f23959k[readByte & Ascii.f14464SI]);
                                }
                            }
                        }
                        i3 += Character.charCount(codePointAt2);
                        i4 = 43;
                    }
                    return buffer.readUtf8();
                }
            }
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        @JvmStatic
        public final int defaultPort(@NotNull String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            if (Intrinsics.areEqual(scheme, "https")) {
                return 443;
            }
            return -1;
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        public final HttpUrl get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final HttpUrl parse(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String str, int i, int i2, boolean z) {
            int i3;
            Intrinsics.checkNotNullParameter(str, "<this>");
            int i4 = i;
            while (i4 < i2) {
                char charAt = str.charAt(i4);
                if (charAt != '%' && (charAt != '+' || !z)) {
                    i4++;
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, i4);
                    while (i4 < i2) {
                        int codePointAt = str.codePointAt(i4);
                        if (codePointAt == 37 && (i3 = i4 + 2) < i2) {
                            int parseHexDigit = _UtilCommonKt.parseHexDigit(str.charAt(i4 + 1));
                            int parseHexDigit2 = _UtilCommonKt.parseHexDigit(str.charAt(i3));
                            if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                                buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                                i4 = Character.charCount(codePointAt) + i3;
                            }
                            buffer.writeUtf8CodePoint(codePointAt);
                            i4 += Character.charCount(codePointAt);
                        } else {
                            if (codePointAt == 43 && z) {
                                buffer.writeByte(32);
                                i4++;
                            }
                            buffer.writeUtf8CodePoint(codePointAt);
                            i4 += Character.charCount(codePointAt);
                        }
                    }
                    return buffer.readUtf8();
                }
            }
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(@NotNull List<String> list, @NotNull StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append(list.get(i));
            }
        }

        @NotNull
        public final List<String> toQueryNamesAndValues$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, Typography.amp, i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int i2 = indexOf$default;
                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (indexOf$default2 != -1 && indexOf$default2 <= i2) {
                    String substring = str.substring(i, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = str.substring(indexOf$default2 + 1, i2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@NotNull List<String> list, @NotNull StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression step = r82.step(r82.until(0, list.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    out.append(Typography.amp);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m8987deprecated_get(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @JvmStatic
        @JvmName(name = "get")
        @Nullable
        public final HttpUrl get(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString()");
            return parse(url2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m8986deprecated_get(@NotNull URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return get(uri);
        }

        @JvmStatic
        @JvmName(name = "get")
        @Nullable
        public final HttpUrl get(@NotNull URI uri) {
            Intrinsics.checkNotNullParameter(uri, "<this>");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString()");
            return parse(uri2);
        }
    }

    public HttpUrl(@NotNull String scheme, @NotNull String username, @NotNull String password, @NotNull String host, int i, @NotNull List<String> pathSegments, @Nullable List<String> list, @Nullable String str, @NotNull String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i;
        this.pathSegments = pathSegments;
        this.f23966g = list;
        this.fragment = str;
        this.f23968i = url;
        this.isHttps = Intrinsics.areEqual(scheme, "https");
    }

    @JvmStatic
    public static final int defaultPort(@NotNull String str) {
        return INSTANCE.defaultPort(str);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    public static final HttpUrl get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final HttpUrl parse(@NotNull String str) {
        return INSTANCE.parse(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    @JvmName(name = "-deprecated_encodedFragment")
    @Nullable
    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m8966deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    @JvmName(name = "-deprecated_encodedPassword")
    @NotNull
    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m8967deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    @JvmName(name = "-deprecated_encodedPath")
    @NotNull
    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m8968deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    @JvmName(name = "-deprecated_encodedPathSegments")
    @NotNull
    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m8969deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    @JvmName(name = "-deprecated_encodedQuery")
    @Nullable
    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m8970deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    @JvmName(name = "-deprecated_encodedUsername")
    @NotNull
    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m8971deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    @JvmName(name = "-deprecated_fragment")
    @Nullable
    /* renamed from: -deprecated_fragment, reason: not valid java name and from getter */
    public final String getFragment() {
        return this.fragment;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    @JvmName(name = "-deprecated_host")
    @NotNull
    /* renamed from: -deprecated_host, reason: not valid java name and from getter */
    public final String getHost() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))
    @JvmName(name = "-deprecated_password")
    @NotNull
    /* renamed from: -deprecated_password, reason: not valid java name and from getter */
    public final String getPassword() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    @JvmName(name = "-deprecated_pathSegments")
    @NotNull
    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m8975deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    @JvmName(name = "-deprecated_pathSize")
    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m8976deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    @JvmName(name = "-deprecated_port")
    /* renamed from: -deprecated_port, reason: not valid java name and from getter */
    public final int getPort() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SearchIntents.EXTRA_QUERY, imports = {}))
    @JvmName(name = "-deprecated_query")
    @Nullable
    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m8978deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    @JvmName(name = "-deprecated_queryParameterNames")
    @NotNull
    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m8979deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    @JvmName(name = "-deprecated_querySize")
    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m8980deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme, reason: not valid java name and from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    @JvmName(name = "-deprecated_uri")
    @NotNull
    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m8982deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m8983deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    @JvmName(name = "-deprecated_username")
    @NotNull
    /* renamed from: -deprecated_username, reason: not valid java name and from getter */
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "encodedFragment")
    @Nullable
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.f23968i.substring(StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @JvmName(name = "encodedPassword")
    @NotNull
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String substring = this.f23968i.substring(StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "encodedPath")
    @NotNull
    public final String encodedPath() {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.f23968i;
        String substring = str.substring(indexOf$default, _UtilCommonKt.delimiterOffset(str, "?#", indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "encodedPathSegments")
    @NotNull
    public final List<String> encodedPathSegments() {
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.f23968i;
        int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < delimiterOffset) {
            int i = indexOf$default + 1;
            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(str, '/', i, delimiterOffset);
            String substring = str.substring(i, delimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            indexOf$default = delimiterOffset2;
        }
        return arrayList;
    }

    @JvmName(name = "encodedQuery")
    @Nullable
    public final String encodedQuery() {
        if (this.f23966g == null) {
            return null;
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.f23968i, '?', 0, false, 6, (Object) null) + 1;
        String str = this.f23968i;
        String substring = str.substring(indexOf$default, _UtilCommonKt.delimiterOffset(str, '#', indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @JvmName(name = "encodedUsername")
    @NotNull
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.f23968i;
        String substring = str.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) other).f23968i, this.f23968i)) {
            return true;
        }
        return false;
    }

    @JvmName(name = "fragment")
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.f23968i.hashCode();
    }

    @JvmName(name = "host")
    @NotNull
    public final String host() {
        return this.host;
    }

    /* renamed from: isHttps, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        String str = this.scheme;
        builder.setScheme$okhttp(str);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        int defaultPort = INSTANCE.defaultPort(str);
        int i = this.port;
        if (i == defaultPort) {
            i = -1;
        }
        builder.setPort$okhttp(i);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @JvmName(name = "password")
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName(name = "pathSegments")
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName(name = "port")
    public final int port() {
        return this.port;
    }

    @JvmName(name = SearchIntents.EXTRA_QUERY)
    @Nullable
    public final String query() {
        List<String> list = this.f23966g;
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.toQueryString$okhttp(list, sb);
        return sb.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.f23966g;
        if (list == null) {
            return null;
        }
        IntProgression step = r82.step(r82.until(0, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual(name, list.get(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            return (String) list.get(first + 1);
        }
        return null;
    }

    @NotNull
    public final String queryParameterName(int index) {
        List list = this.f23966g;
        if (list != null) {
            Object obj = list.get(index * 2);
            Intrinsics.checkNotNull(obj);
            return (String) obj;
        }
        throw new IndexOutOfBoundsException();
    }

    @JvmName(name = "queryParameterNames")
    @NotNull
    public final Set<String> queryParameterNames() {
        List list = this.f23966g;
        if (list == null) {
            return sh2.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        IntProgression step = r82.step(r82.until(0, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                Object obj = list.get(first);
                Intrinsics.checkNotNull(obj);
                linkedHashSet.add(obj);
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @Nullable
    public final String queryParameterValue(int index) {
        List list = this.f23966g;
        if (list != null) {
            return (String) list.get((index * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.f23966g;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        IntProgression step = r82.step(r82.until(0, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (Intrinsics.areEqual(name, list.get(first))) {
                    arrayList.add(list.get(first + 1));
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(result)");
        return unmodifiableList;
    }

    @JvmName(name = "querySize")
    public final int querySize() {
        List list = this.f23966g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @NotNull
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder.username("").password("").build().getF23968i();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    /* renamed from: toString, reason: from getter */
    public String getF23968i() {
        return this.f23968i;
    }

    @Nullable
    public final String topPrivateDomain() {
        String str = this.host;
        if (_HostnamesCommonKt.canParseAsIpAddress(str)) {
            return null;
        }
        return PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(str);
    }

    @JvmName(name = "uri")
    @NotNull
    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                Intrinsics.checkNotNullExpressionValue(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @JvmName(name = ImagesContract.URL)
    @NotNull
    public final URL url() {
        try {
            return new URL(this.f23968i);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @JvmName(name = "username")
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmStatic
    @JvmName(name = "get")
    @Nullable
    public static final HttpUrl get(@NotNull URI uri) {
        return INSTANCE.get(uri);
    }

    @JvmStatic
    @JvmName(name = "get")
    @Nullable
    public static final HttpUrl get(@NotNull URL url) {
        return INSTANCE.get(url);
    }

    @Nullable
    public final Builder newBuilder(@NotNull String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
