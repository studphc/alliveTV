package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001c"}, m5569d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "Ljava/security/MessageDigest;", "digest", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/Sink;Ljava/lang/String;)V", "Ljavax/crypto/Mac;", "mac", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "Lokio/ByteString;", "key", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "-deprecated_hash", "()Lokio/ByteString;", "hash", "Companion", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class HashingSink extends ForwardingSink implements Sink {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b */
    public final MessageDigest f24722b;

    /* renamed from: c */
    public final Mac f24723c;

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m5569d2 = {"Lokio/HashingSink$Companion;", "", "Lokio/Sink;", "sink", "Lokio/HashingSink;", "md5", "(Lokio/Sink;)Lokio/HashingSink;", "sha1", "sha256", "sha512", "Lokio/ByteString;", "key", "hmacSha1", "(Lokio/Sink;Lokio/ByteString;)Lokio/HashingSink;", "hmacSha256", "hmacSha512", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSink md5(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha1(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha256(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha512(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull MessageDigest digest) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.f24722b = digest;
        this.f24723c = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha1(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha256(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString byteString) {
        return INSTANCE.hmacSha512(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink md5(@NotNull Sink sink) {
        return INSTANCE.md5(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink) {
        return INSTANCE.sha1(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink) {
        return INSTANCE.sha256(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink) {
        return INSTANCE.sha512(sink);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    @NotNull
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m9075deprecated_hash() {
        return hash();
    }

    @JvmName(name = "hash")
    @NotNull
    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest = this.f24722b;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.f24723c;
            Intrinsics.checkNotNull(mac);
            result = mac.doFinal();
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return new ByteString(result);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
        Segment segment = source.head;
        Intrinsics.checkNotNull(segment);
        long j = 0;
        while (j < byteCount) {
            int min = (int) Math.min(byteCount - j, segment.limit - segment.pos);
            MessageDigest messageDigest = this.f24722b;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.f24723c;
                Intrinsics.checkNotNull(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j += min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        super.write(source, byteCount);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSink(@NotNull Sink sink, @NotNull String algorithm) {
        this(sink, r3);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(algorithm)");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.f24723c = mac;
        this.f24722b = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashingSink(@NotNull Sink sink, @NotNull ByteString key, @NotNull String algorithm) {
        this(sink, r0);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            Intrinsics.checkNotNullExpressionValue(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
