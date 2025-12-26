package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnit;
import okhttp3.internal._CacheControlCommonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b'\u0018\u0000 52\u00020\u0001:\u000265Bs\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u000b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0003\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b\u0004\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\u0006\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b'\u0010&\u001a\u0004\b\u0007\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b\b\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b\n\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b\u000b\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b\f\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b\r\u0010\u0015R\u0017\u0010\u000e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b\u000e\u0010\u0015R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b\u000f\u0010\u0015R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010!\"\u0004\b3\u00104¨\u00067"}, m5569d2 = {"Lokhttp3/CacheControl;", "", "", "noCache", "noStore", "", "maxAgeSeconds", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "", "headerValue", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "-deprecated_noCache", "()Z", "-deprecated_noStore", "-deprecated_maxAgeSeconds", "()I", "-deprecated_sMaxAgeSeconds", "-deprecated_mustRevalidate", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_onlyIfCached", "-deprecated_noTransform", "-deprecated_immutable", "toString", "()Ljava/lang/String;", "a", "Z", "b", "c", "I", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "Ljava/lang/String;", "getHeaderValue$okhttp", "setHeaderValue$okhttp", "(Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CacheControl {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE;

    @JvmField
    @NotNull
    public static final CacheControl FORCE_NETWORK;

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean noCache;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean noStore;

    /* renamed from: c, reason: from kotlin metadata */
    public final int maxAgeSeconds;

    /* renamed from: d, reason: from kotlin metadata */
    public final int sMaxAgeSeconds;

    /* renamed from: e, reason: from kotlin metadata */
    public final boolean isPrivate;

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean isPublic;

    /* renamed from: g, reason: from kotlin metadata */
    public final boolean mustRevalidate;

    /* renamed from: h, reason: from kotlin metadata */
    public final int maxStaleSeconds;

    /* renamed from: i, reason: from kotlin metadata */
    public final int minFreshSeconds;

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean onlyIfCached;

    /* renamed from: k, reason: from kotlin metadata */
    public final boolean noTransform;

    /* renamed from: l, reason: from kotlin metadata */
    public final boolean immutable;

    /* renamed from: m, reason: from kotlin metadata */
    public String headerValue;

    @Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\u0005J\r\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0013J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0006\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010*\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010.\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u00102\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\"\u0010\u0007\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\"\u0010\b\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\"\u0010\t\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001c\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 ¨\u0006<"}, m5569d2 = {"Lokhttp3/CacheControl$Builder;", "", "<init>", "()V", "noCache", "()Lokhttp3/CacheControl$Builder;", "noStore", "onlyIfCached", "noTransform", "immutable", "Lkotlin/time/DurationUnit;", "durationUnit", "Ljava/util/concurrent/TimeUnit;", "toJavaTimeUnit$okhttp", "(Lkotlin/time/DurationUnit;)Ljava/util/concurrent/TimeUnit;", "toJavaTimeUnit", "", "maxAge", "timeUnit", "(ILkotlin/time/DurationUnit;)Lokhttp3/CacheControl$Builder;", "maxStale", "minFresh", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/CacheControl$Builder;", "Lokhttp3/CacheControl;", "build", "()Lokhttp3/CacheControl;", "", "a", "Z", "getNoCache$okhttp", "()Z", "setNoCache$okhttp", "(Z)V", "b", "getNoStore$okhttp", "setNoStore$okhttp", "c", "I", "getMaxAgeSeconds$okhttp", "()I", "setMaxAgeSeconds$okhttp", "(I)V", "maxAgeSeconds", "d", "getMaxStaleSeconds$okhttp", "setMaxStaleSeconds$okhttp", "maxStaleSeconds", "e", "getMinFreshSeconds$okhttp", "setMinFreshSeconds$okhttp", "minFreshSeconds", "f", "getOnlyIfCached$okhttp", "setOnlyIfCached$okhttp", "g", "getNoTransform$okhttp", "setNoTransform$okhttp", "h", "getImmutable$okhttp", "setImmutable$okhttp", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        public boolean noCache;

        /* renamed from: b, reason: from kotlin metadata */
        public boolean noStore;

        /* renamed from: c, reason: from kotlin metadata */
        public int maxAgeSeconds = -1;

        /* renamed from: d, reason: from kotlin metadata */
        public int maxStaleSeconds = -1;

        /* renamed from: e, reason: from kotlin metadata */
        public int minFreshSeconds = -1;

        /* renamed from: f, reason: from kotlin metadata */
        public boolean onlyIfCached;

        /* renamed from: g, reason: from kotlin metadata */
        public boolean noTransform;

        /* renamed from: h, reason: from kotlin metadata */
        public boolean immutable;

        @NotNull
        public final CacheControl build() {
            return _CacheControlCommonKt.commonBuild(this);
        }

        /* renamed from: getImmutable$okhttp, reason: from getter */
        public final boolean getImmutable() {
            return this.immutable;
        }

        /* renamed from: getMaxAgeSeconds$okhttp, reason: from getter */
        public final int getMaxAgeSeconds() {
            return this.maxAgeSeconds;
        }

        /* renamed from: getMaxStaleSeconds$okhttp, reason: from getter */
        public final int getMaxStaleSeconds() {
            return this.maxStaleSeconds;
        }

        /* renamed from: getMinFreshSeconds$okhttp, reason: from getter */
        public final int getMinFreshSeconds() {
            return this.minFreshSeconds;
        }

        /* renamed from: getNoCache$okhttp, reason: from getter */
        public final boolean getNoCache() {
            return this.noCache;
        }

        /* renamed from: getNoStore$okhttp, reason: from getter */
        public final boolean getNoStore() {
            return this.noStore;
        }

        /* renamed from: getNoTransform$okhttp, reason: from getter */
        public final boolean getNoTransform() {
            return this.noTransform;
        }

        /* renamed from: getOnlyIfCached$okhttp, reason: from getter */
        public final boolean getOnlyIfCached() {
            return this.onlyIfCached;
        }

        @NotNull
        public final Builder immutable() {
            return _CacheControlCommonKt.commonImmutable(this);
        }

        @NotNull
        public final Builder maxAge(int maxAge, @NotNull DurationUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            return maxAge(maxAge, toJavaTimeUnit$okhttp(timeUnit));
        }

        @NotNull
        public final Builder maxStale(int maxStale, @NotNull DurationUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            return maxStale(maxStale, toJavaTimeUnit$okhttp(timeUnit));
        }

        @NotNull
        public final Builder minFresh(int minFresh, @NotNull DurationUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            return minFresh(minFresh, toJavaTimeUnit$okhttp(timeUnit));
        }

        @NotNull
        public final Builder noCache() {
            return _CacheControlCommonKt.commonNoCache(this);
        }

        @NotNull
        public final Builder noStore() {
            return _CacheControlCommonKt.commonNoStore(this);
        }

        @NotNull
        public final Builder noTransform() {
            return _CacheControlCommonKt.commonNoTransform(this);
        }

        @NotNull
        public final Builder onlyIfCached() {
            return _CacheControlCommonKt.commonOnlyIfCached(this);
        }

        public final void setImmutable$okhttp(boolean z) {
            this.immutable = z;
        }

        public final void setMaxAgeSeconds$okhttp(int i) {
            this.maxAgeSeconds = i;
        }

        public final void setMaxStaleSeconds$okhttp(int i) {
            this.maxStaleSeconds = i;
        }

        public final void setMinFreshSeconds$okhttp(int i) {
            this.minFreshSeconds = i;
        }

        public final void setNoCache$okhttp(boolean z) {
            this.noCache = z;
        }

        public final void setNoStore$okhttp(boolean z) {
            this.noStore = z;
        }

        public final void setNoTransform$okhttp(boolean z) {
            this.noTransform = z;
        }

        public final void setOnlyIfCached$okhttp(boolean z) {
            this.onlyIfCached = z;
        }

        @NotNull
        public final TimeUnit toJavaTimeUnit$okhttp(@NotNull DurationUnit durationUnit) {
            Intrinsics.checkNotNullParameter(durationUnit, "durationUnit");
            return TimeUnit.valueOf(durationUnit.name());
        }

        @NotNull
        public final Builder maxAge(int maxAge, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxAge >= 0) {
                this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(maxAge));
                return this;
            }
            throw new IllegalArgumentException(ye0.m8291k(maxAge, "maxAge < 0: ").toString());
        }

        @NotNull
        public final Builder maxStale(int maxStale, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxStale >= 0) {
                this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(maxStale));
                return this;
            }
            throw new IllegalArgumentException(ye0.m8291k(maxStale, "maxStale < 0: ").toString());
        }

        @NotNull
        public final Builder minFresh(int minFresh, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (minFresh >= 0) {
                this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(minFresh));
                return this;
            }
            throw new IllegalArgumentException(ye0.m8291k(minFresh, "minFresh < 0: ").toString());
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\n"}, m5569d2 = {"Lokhttp3/CacheControl$Companion;", "", "Lokhttp3/Headers;", "headers", "Lokhttp3/CacheControl;", "parse", "(Lokhttp3/Headers;)Lokhttp3/CacheControl;", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @NotNull
        public final CacheControl parse(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return _CacheControlCommonKt.commonParse(this, headers);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        FORCE_NETWORK = _CacheControlCommonKt.commonForceNetwork(companion);
        FORCE_CACHE = _CacheControlCommonKt.commonForceCache(companion);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return INSTANCE.parse(headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    @JvmName(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable, reason: not valid java name and from getter */
    public final boolean getImmutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name and from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name and from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    @JvmName(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name and from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    @JvmName(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name and from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    @JvmName(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache, reason: not valid java name and from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    @JvmName(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore, reason: not valid java name and from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    @JvmName(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform, reason: not valid java name and from getter */
    public final boolean getNoTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    @JvmName(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name and from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name and from getter */
    public final int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Nullable
    /* renamed from: getHeaderValue$okhttp, reason: from getter */
    public final String getHeaderValue() {
        return this.headerValue;
    }

    @JvmName(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    /* renamed from: isPrivate, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* renamed from: isPublic, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final void setHeaderValue$okhttp(@Nullable String str) {
        this.headerValue = str;
    }

    @NotNull
    public String toString() {
        return _CacheControlCommonKt.commonToString(this);
    }
}
