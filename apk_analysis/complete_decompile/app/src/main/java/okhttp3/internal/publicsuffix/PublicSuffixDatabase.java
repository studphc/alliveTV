package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;
import p000.AbstractC1726qj;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "", "domain", "getEffectiveTldPlusOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "", "setListBytes", "([B[B)V", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "PublicSuffixDatabase.gz";

    /* renamed from: e */
    public static final byte[] f24575e = {(byte) 42};

    /* renamed from: f */
    public static final List f24576f = AbstractC1167eq.listOf("*");

    /* renamed from: g */
    public static final PublicSuffixDatabase f24577g = new PublicSuffixDatabase();

    /* renamed from: a */
    public final AtomicBoolean f24578a = new AtomicBoolean(false);

    /* renamed from: b */
    public final CountDownLatch f24579b = new CountDownLatch(1);

    /* renamed from: c */
    public byte[] f24580c;

    /* renamed from: d */
    public byte[] f24581d;

    @Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5569d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "()Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "EXCEPTION_MARKER", "C", "", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "", "WILDCARD_LABEL", "[B", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final String access$binarySearch(Companion companion, byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int and;
            boolean z;
            int and2;
            companion.getClass();
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != ((byte) 10)) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        and = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        and = _UtilCommonKt.and(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    and2 = and - _UtilCommonKt.and(bArr[i5 + i10], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length == i9) {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    } else {
                        z2 = z;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                return new String(bArr, i5, i7, Charsets.UTF_8);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.f24577g;
        }
    }

    /* renamed from: b */
    public static List m6640b(String str) {
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.areEqual(CollectionsKt___CollectionsKt.last(split$default), "")) {
            return CollectionsKt___CollectionsKt.dropLast(split$default, 1);
        }
        return split$default;
    }

    /* renamed from: a */
    public final void m6641a() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] readByteArray = buffer.readByteArray(buffer.readInt());
            byte[] readByteArray2 = buffer.readByteArray(buffer.readInt());
            CloseableKt.closeFinally(buffer, null);
            synchronized (this) {
                Intrinsics.checkNotNull(readByteArray);
                this.f24580c = readByteArray;
                Intrinsics.checkNotNull(readByteArray2);
                this.f24581d = readByteArray2;
            }
            this.f24579b.countDown();
        } finally {
        }
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        String str;
        String str2;
        String str3;
        List emptyList;
        List emptyList2;
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List m6640b = m6640b(unicodeDomain);
        AtomicBoolean atomicBoolean = this.f24578a;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            boolean z = false;
            while (true) {
                try {
                    try {
                        m6641a();
                        break;
                    } finally {
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.INSTANCE.get().log("Failed to read public suffix list", 5, e);
                    if (z) {
                    }
                }
            }
        } else {
            try {
                this.f24579b.await();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f24580c != null) {
            int size3 = m6640b.size();
            byte[][] bArr = new byte[size3];
            for (int i = 0; i < size3; i++) {
                byte[] bytes = ((String) m6640b.get(i)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i] = bytes;
            }
            int i2 = 0;
            while (true) {
                if (i2 < size3) {
                    Companion companion = INSTANCE;
                    byte[] bArr2 = this.f24580c;
                    if (bArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                        bArr2 = null;
                    }
                    str = Companion.access$binarySearch(companion, bArr2, bArr, i2);
                    if (str != null) {
                        break;
                    }
                    i2++;
                } else {
                    str = null;
                    break;
                }
            }
            if (size3 > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    bArr3[i3] = f24575e;
                    Companion companion2 = INSTANCE;
                    byte[] bArr4 = this.f24580c;
                    if (bArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String access$binarySearch = Companion.access$binarySearch(companion2, bArr4, bArr3, i3);
                    if (access$binarySearch != null) {
                        str2 = access$binarySearch;
                        break;
                    }
                }
            }
            str2 = null;
            if (str2 != null) {
                int i4 = size3 - 1;
                for (int i5 = 0; i5 < i4; i5++) {
                    Companion companion3 = INSTANCE;
                    byte[] bArr5 = this.f24581d;
                    if (bArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    str3 = Companion.access$binarySearch(companion3, bArr5, bArr, i5);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                emptyList2 = StringsKt__StringsKt.split$default((CharSequence) "!".concat(str3), new char[]{'.'}, false, 0, 6, (Object) null);
            } else if (str == null && str2 == null) {
                emptyList2 = f24576f;
            } else {
                if (str == null || (emptyList = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                if (str2 == null || (emptyList2 = StringsKt__StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                }
                if (emptyList.size() > emptyList2.size()) {
                    emptyList2 = emptyList;
                }
            }
            if (m6640b.size() == emptyList2.size() && ((String) emptyList2.get(0)).charAt(0) != '!') {
                return null;
            }
            if (((String) emptyList2.get(0)).charAt(0) == '!') {
                size = m6640b.size();
                size2 = emptyList2.size();
            } else {
                size = m6640b.size();
                size2 = emptyList2.size() + 1;
            }
            return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.drop(CollectionsKt___CollectionsKt.asSequence(m6640b(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
        }
        throw new IllegalStateException(AbstractC1726qj.m7061q(new StringBuilder("Unable to load "), PUBLIC_SUFFIX_RESOURCE, " resource from the classpath.").toString());
    }

    public final void setListBytes(@NotNull byte[] publicSuffixListBytes, @NotNull byte[] publicSuffixExceptionListBytes) {
        Intrinsics.checkNotNullParameter(publicSuffixListBytes, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.f24580c = publicSuffixListBytes;
        this.f24581d = publicSuffixExceptionListBytes;
        this.f24578a.set(true);
        this.f24579b.countDown();
    }
}
