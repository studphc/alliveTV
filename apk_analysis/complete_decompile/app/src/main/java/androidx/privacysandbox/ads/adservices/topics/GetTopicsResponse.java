package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "", "", "Landroidx/privacysandbox/ads/adservices/topics/Topic;", "topics", "Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "encryptedTopics", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "(Ljava/util/List;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Ljava/util/List;", "getTopics", "()Ljava/util/List;", "b", "getEncryptedTopics", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class GetTopicsResponse {

    /* renamed from: a, reason: from kotlin metadata */
    public final List topics;

    /* renamed from: b, reason: from kotlin metadata */
    public final List encryptedTopics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(@NotNull List<Topic> topics, @NotNull List<EncryptedTopic> encryptedTopics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        Intrinsics.checkNotNullParameter(encryptedTopics, "encryptedTopics");
        this.topics = topics;
        this.encryptedTopics = encryptedTopics;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetTopicsResponse)) {
            return false;
        }
        List list = this.topics;
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) other;
        if (list.size() == getTopicsResponse.topics.size()) {
            List list2 = this.encryptedTopics;
            if (list2.size() == getTopicsResponse.encryptedTopics.size()) {
                if (Intrinsics.areEqual(new HashSet(list), new HashSet(getTopicsResponse.topics)) && Intrinsics.areEqual(new HashSet(list2), new HashSet(getTopicsResponse.encryptedTopics))) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @NotNull
    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.encryptedTopics;
    }

    @NotNull
    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics, this.encryptedTopics);
    }

    @NotNull
    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.encryptedTopics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(@NotNull List<Topic> topics) {
        this(topics, CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(topics, "topics");
    }
}
