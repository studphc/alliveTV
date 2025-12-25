package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ro2;

@ExperimentalFeatures.Ext11OptIn
@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015¨\u0006\u001b"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "", "", "encryptedTopic", "", "keyIdentifier", "encapsulatedKey", "<init>", "([BLjava/lang/String;[B)V", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "[B", "getEncryptedTopic", "()[B", "b", "Ljava/lang/String;", "getKeyIdentifier", "c", "getEncapsulatedKey", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class EncryptedTopic {

    /* renamed from: a, reason: from kotlin metadata */
    public final byte[] encryptedTopic;

    /* renamed from: b, reason: from kotlin metadata */
    public final String keyIdentifier;

    /* renamed from: c, reason: from kotlin metadata */
    public final byte[] encapsulatedKey;

    public EncryptedTopic(@NotNull byte[] encryptedTopic, @NotNull String keyIdentifier, @NotNull byte[] encapsulatedKey) {
        Intrinsics.checkNotNullParameter(encryptedTopic, "encryptedTopic");
        Intrinsics.checkNotNullParameter(keyIdentifier, "keyIdentifier");
        Intrinsics.checkNotNullParameter(encapsulatedKey, "encapsulatedKey");
        this.encryptedTopic = encryptedTopic;
        this.keyIdentifier = keyIdentifier;
        this.encapsulatedKey = encapsulatedKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) other;
        if (Arrays.equals(this.encryptedTopic, encryptedTopic.encryptedTopic) && this.keyIdentifier.contentEquals(encryptedTopic.keyIdentifier) && Arrays.equals(this.encapsulatedKey, encryptedTopic.encapsulatedKey)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    @NotNull
    public final byte[] getEncryptedTopic() {
        return this.encryptedTopic;
    }

    @NotNull
    public final String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.encryptedTopic)), this.keyIdentifier, Integer.valueOf(Arrays.hashCode(this.encapsulatedKey)));
    }

    @NotNull
    public String toString() {
        return AbstractC1726qj.m7038C("EncryptedTopic { ", "EncryptedTopic=" + ro2.decodeToString(this.encryptedTopic) + ", KeyIdentifier=" + this.keyIdentifier + ", EncapsulatedKey=" + ro2.decodeToString(this.encapsulatedKey) + " }");
    }
}
